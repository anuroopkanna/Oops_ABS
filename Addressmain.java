package com.BridgeLabzABS;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.stream.Collectors;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException

public class Addressmain {
    HashMap<String ,AddressBS> hashMap = new HashMap<String,AddressBS>();
    public void AddAddressbook(){
        AddressBS addressBook = new AddressBS();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the AddressBook");
        String name=sc.next();
        if(hashMap.containsKey(name)){
            System.out.println("Enter different name for the AddressBook");
            AddAddressbook();
        }else {
            addressBook.setAddressbookName(name);
            hashMap.put(addressBook.getAddressbookName(), addressBook);
            System.out.println("Address book added!!");
        }
    }
    public void Addcontacts(){
        if(hashMap.isEmpty())
        {
            System.out.println("Your address book is empty first please add new Addressbook");
            AddAddressbook();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to add contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBS temp = hashMap.get(name);
            temp.AddContact();
        }
    }
    public void Display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to display contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBS temp = hashMap.get(name);
            temp.dispalyContacts();
        }
    }
    public void Delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to Delete contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBS temp = hashMap.get(name);
            temp.deleteContact();
        }
    }
    public void Edit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to Edit contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBS temp = hashMap.get(name);
            temp.edit();
        }
    }
    public void displayAllAddressbook(){
        System.out.println("Displaying all addressbook");
        if(hashMap.isEmpty()){
            System.out.println("Addressbook is empty");
        }else {
            System.out.println(hashMap);
        }
    }
    public void searchBycity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the city which you want to show");
        String cityname = sc.next();
        List<Contacts> citylist = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook ->{
            citylist.addAll(addressBook.getContactBook().
                    stream().filter(contact ->  contact.getCity().equalsIgnoreCase(cityname)).collect(Collectors.toList()));
        });
        int count = citylist.size();
        System.out.println(count+" Person Found!!! which belongs to " +cityname +" city");
        System.out.println(citylist);
    }
    public void sort(){
        List<Contacts> citylist = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook ->{
            citylist.addAll(addressBook.getContactBook().
                    stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList()));
        });
        System.out.println(citylist);
    }
    public void searchByState(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to search person by using name of the city ");
        System.out.println("Press 2 to search person by using name of the city ");
        int num =sc.nextInt();
        if(num==1){
            searchBycity();
        }else {
            System.out.println("Enter the name of the city which you want to show");
            String State = sc.next();
            List<Contacts> Statelist = new ArrayList<>();
            hashMap.values().stream().forEach(addressBook ->{
                Statelist.addAll(addressBook.getContactBook().
                        stream().filter(contact ->  contact.getCity().equalsIgnoreCase(State)).collect(Collectors.toList()));
            });
            int count = Statelist.size();
            System.out.println(count+" Person Found!!! which belongs to " +State +" city");
            System.out.println(Statelist);
        }
    }
    private void writeToFile() {
        String path = "C:\\Users\\anuro\\IdeaProjects\\ProjectAB\\src\\com\\BridgeLabzABS";
        StringBuffer addressBookBuffer = new StringBuffer();
        hashMap.values().stream().forEach(contact -> {
            String personDataString = contact.toString().concat("\n");
            addressBookBuffer.append(personDataString);
        });

        try {
            Files.write(Paths.get(path), addressBookBuffer.toString().getBytes());
        }
        catch (IOException e) {
            System.out.println("Catch block");
        }
    }
    private void readFromFile() {
        String path = "C:\\Users\\anuro\\IdeaProjects\\ProjectAB\\src\\com\\BridgeLabzABS\\addressbook.txt";
        System.out.println("Reading from : " + path + "\n");
        try {
            Files.lines(new File(path).toPath()).forEach(employeeDetails -> System.out.println(employeeDetails));
        }
        catch(IOException e){
            System.out.println("Catch block");
        }
    }
    private void writetocsv() {
        String csvPath = "C:\\Users\\anuro\\IdeaProjects\\ProjectAB\\src\\com\\BridgeLabzABS";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(csvPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> csvLines = new ArrayList<String[]>();
        CSVWriter writer = new CSVWriter(fileWriter);
        String[] header = {"FirstName","LastName","Address","City","State","zip code","phone number","Email"};
        writer.writeNext(header);
        hashMap.keySet().stream().forEach(bookName -> hashMap.get(bookName).getContactBook()
                .stream().forEach(person -> csvLines.add(person.getContactStrings())));
        writer.writeAll(csvLines);
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readfromcsv(){
        // Reading CSV
        String csvPath = "C:\\Users\\anuro\\IdeaProjects\\ProjectAB\\src\\com\\BridgeLabzABS";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(csvPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVReader reader = new CSVReaderBuilder(fileReader).build();
        List<String[]> linesOfData = null;
        try {
            linesOfData = reader.readAll();
        } catch (IOException | CsvException e) {

            e.printStackTrace();
        }
        System.out.println("\nReading data from csv file:");
        linesOfData.stream().forEach(csvs -> {
            for (String value : csvs)
                System.out.print(value + "\t");
            System.out.println();
        });
        try {
            reader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public <JSONParser> void writefromJson(){
        JSONArray jsonPersons = new JSONArray();
        hashMap.keySet().stream().forEach(bookname -> hashMap.get(bookname).getContactBook()
                .stream().forEach(prsn -> jsonPersons.put((prsn.getContactJSON()))));

        Path jsonPath = Paths.get("C:\\Users\\prajw\\IdeaProjects\\AddressBookMeven\\src\\main\\java\\com\\bridgelabz\\addressbook.json");
        try {
            Files.deleteIfExists(jsonPath);
            Files.writeString(jsonPath, jsonPersons.toString(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONParser jsonParser = new JSONParser();
        System.out.println("\nReading data from JSON file:");
        try {
            Object object = jsonParser.parse(Files.newBufferedReader(jsonPath));
            JSONArray personsList = (JSONArray) object;
            System.out.println(personsList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("***** Welcome to the Address Based System *****");
       /* AddressBS person1 = new AddressBS();
        person1.addDetails();
        person1.dispalyContacts();

        person1.edit();
        AddressBS person2 = new AddressBS();
        person2.addDetails();
        person2.dispalyContacts();
        person2.edit();
        person2.deleteContact();
        AddressBS person3 = new AddressBS();
        person3.addDetails();
        person3.dispalyContacts();
        person3.edit();*/
        AddressBS addressBSMain =new AddressBS();
        Scanner sc =new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("1.Add contact\n 2.Edit\n 3.Display\n 4.DeleteContact\n5.exit");
            int option= sc.nextInt();
            switch (option){
                case 1:
                    addressBSMain.AddContact();
                    addressBSMain.writeToFile();
                    break;
                case 2:
                    addressBSMain.edit();
                    break;
                case 3:
                    addressBSMain.dispalyContacts();
                    break;
                case 4:
                    addressBSMain.deleteContact();
                    break;
                case 10:
                    flag=false;
                    break;
                case 5:
                    addressBSMain.displayAllAddressbook();
                    break;
                case 6:
                    addressBSMain.AddAddressbook();
                    break;
                case 7:
                    addressBSMain.searchByCity();
                    break;
                case 8:
                    addressBSMain.searchByState();
                case 9:
                    addressBSMain.sort();
                case 10:
                    addressBSMain.readFromFile();
                default:
                    System.out.println(option+"Enter s valid option");
                    break;
            }
        }
        System.out.println("exit");
    }
}
