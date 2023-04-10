package com.BridgeLabzABS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                    addressBSMain.AddContacts();
                    break;
                case 2:
                    addressBSMain.Edit();
                    break;
                case 3:
                    addressBSMain.Display();
                    break;
                case 4:
                    addressBSMain.Delete();
                    break;
                case 9:
                    flag=false;
                    break;
                case 5:
                    addressBSMain.displayAllAddressbook();
                    break;
                case 6:
                    addressBSMain.AddAddressbook();
                    break;
                case 7:
                    addressBSMain.searchBycity();
                    break;
                case 8:
                    addressBSMain.searchByState();
                default:
                    System.out.println(option+"Enter s valid option");
                    break;
            }
        }
        System.out.println("exit");
    }
}
