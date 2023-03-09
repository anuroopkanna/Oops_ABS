package com.BridgeLabzABS;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBS {
    ArrayList<Contacts> cD =new ArrayList<>();
    Scanner sc =new Scanner(System.in);
    public void addDetails(){
        Contacts D=new Contacts();
        System.out.println("Anuroop ");
        D.setFirstname(D.getFirstname());

        System.out.println("Pulluru ");
        D.setLastname(D.getLastname());
        System.out.println("9848022669");
        D.setMobilenumber(D.getMobilenumber());
        System.out.println("KPHB");
        D.setAddress(D.getAddress());
        System.out.println("Hyderabad");
        D.setCity(D.getCity());
        System.out.println("Telangana");
        D.setState(D.getState());
        System.out.println("500089");
        D.setZip(D.getZip());
        System.out.println("abc@gmail.com");
        D.setEmail(D.getEmail());
        cD.add(D);
    }
    public void dispalyContacts(){
        System.out.println(cD);
    }


    public static void main(String[] args) {
        System.out.println("***** Welcome to the Address Based System *****");
        AddressBS person1=new AddressBS();
        person1.addDetails();
        person1.dispalyContacts();
    }
}
