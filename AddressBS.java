package com.BridgeLabzABS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBS {
    private String AddressbookName;

    public String getAddressbookName() {
        return AddressbookName;
    }

    public void setAddressbookName(String addressbookName) {
        AddressbookName = addressbookName;
    }


    ArrayList<Contacts> cDetails = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Contacts addDetails() {
        Contacts Person = new Contacts();

        System.out.println("Enter First Name");
        Person.setFirstname(sc.nextLine());


        System.out.println("Enter Last name");
        Person.setLastname(sc.nextLine());


        System.out.println("MobileNumber");
        Person.setMobilenumber(sc.nextLine());


        System.out.println("Address");
        Person.setAddress(sc.nextLine());


        System.out.println("City");
        Person.setCity(sc.nextLine());


        System.out.println("State");
        Person.setState(sc.nextLine());


        System.out.println("Zip");
        Person.setZip(sc.nextLine());


        System.out.println("Email Id");
        Person.setEmail(sc.nextLine());

        System.out.println("Create new contact");
        return Person;
    }

    public void addContact() {
        Scanner sc = new Scanner(System.in);
        // ArrayList<Contacts> cDetails =new ArrayList<>();
        Contacts contactPerson = addDetails();
        cDetails.add(contactPerson);
        //System.out.println(contactPerson);
        System.out.println("Contact added successfully...");
    }


    public void edit() {
        //edit the person details
        boolean isContactFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of the person: ");
        int name = sc.nextInt();
        System.out.println("For update: ");
        System.out.println("a)First Name \n b)Last name \n c)MobileNumber \n d) Address \n e)City \n f)State \n g)Zip \n h)EmailId");
        char update = sc.next().charAt(0);
        switch (update) {
            case 'a': {
                String updated = sc.nextLine();
                String Firstname = updated;
                System.out.println("First Name updated...");
                break;
            }
            case 'b': {
                String updated = sc.nextLine();
                String LastName = updated;
                System.out.println("Last name updated...");
                break;
            }
            case 'c': {
                String updated = sc.nextLine();
                String MobileNumber = updated;
                System.out.println(" MobileNumber updated...");
                break;
            }
            case 'd': {
                String updated = sc.nextLine();
                String Address = updated;
                System.out.println("Address updated....");
                break;
            }
            case 'e': {
                String updated = sc.nextLine();
                String City = updated;
                System.out.println("City updated...");
                break;
            }
            case 'f': {
                String updated = sc.nextLine();
                String State = updated;
                System.out.println("State updated...");
                break;
            }
            case 'g': {
                String updated = sc.nextLine();
                String Zip = updated;
                System.out.println("Zip updated....");
                break;
            }
            case 'h': {
                String updated = sc.nextLine();
                String Emailid = updated;
                System.out.println("Emailid updated...");
                break;
            }
            default: {
                System.out.println("NO Changes");
            }
        }
        if (isContactFound) {
            System.out.println("Contacts uploaded successfully");
        } else {
            System.out.println("Contacts not found");
        }

    }

    //method that delete a user resource
    public void deleteContact() {
        Iterator<Contacts> contactD = cDetails.iterator();
        while (contactD.hasNext()) {
            Contacts contacts = contactD.next();
            contactD.remove();
        }
        System.out.println("Contacts removed");
        dispalyContacts();
    }

    void dispalyContacts() {
        ArrayList<Contacts> cDetails = new ArrayList<>();
        for (Contacts Person : cDetails) {
            System.out.println(Person);
        }
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "AddressbookName='" + AddressbookName + '\'' +
                ", contactBook=" + cDetails +
                '}';

    }
}