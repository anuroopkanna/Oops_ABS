package com.BridgeLabzABS;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBS {
    ArrayList<Contacts> cDetails =new ArrayList<>();
    Scanner sc =new Scanner(System.in);
    public void addDetails(){
        Contacts Details =new Contacts();

        System.out.println("Enter First Name");
        Details.setFirstname(sc.nextLine());
        Details.setFirstname(Details.getFirstname());

        System.out.println("Enter Last name");
        Details.setLastname(sc.nextLine());
        Details.setLastname(Details.getLastname());

        System.out.println("MobileNumber");
        Details.setMobilenumber(sc.nextLine());
        Details.setMobilenumber(Details.getMobilenumber());

        System.out.println("Address");
        Details.setAddress(sc.nextLine());
        Details.setAddress(Details.getAddress());

        System.out.println("City");
        Details.setCity(sc.nextLine());
        Details.setCity(Details.getCity());

        System.out.println("State");
        Details.setState(sc.nextLine());
        Details.setState(Details.getState());

        System.out.println("Zip");
        Details.setZip(sc.nextLine());
        Details.setZip(Details.getZip());

        System.out.println("Email Id");
        Details.setEmail(sc.nextLine());
        Details.setEmail(Details.getEmail());

        cDetails.add(Details);
    }
    public void dispalyContacts(){
        System.out.println(cDetails);
    }

    public static void main(String[] args) {
        System.out.println("***** Welcome to the Address Based System *****");
        AddressBS person1=new AddressBS();
        person1.addDetails();
        person1.dispalyContacts();
        AddressBS person2=new AddressBS();
        person2.addDetails();
        person2.dispalyContacts();

    }
}
