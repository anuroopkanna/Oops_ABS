package com.BridgeLabzABS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBS {
    ArrayList<Contacts> cDetails = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addDetails() {
        Contacts Details = new Contacts();

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

    public void dispalyContacts() {
        System.out.println(cDetails);
    }

    public void edit() {
        //edit the person details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of the person: ");
        int sr = sc.nextInt();
        System.out.println("For update: ");
        System.out.println("a)First Name \n b)LastName \n c)MobileNumber \n d) Address \n e)City \n f)State \n g)Zip \n h)EmailId");
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
                String Mobilenumber = updated;
                System.out.println(" Mobile No updated...");
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

    public static void main(String[] args) {
        System.out.println("***** Welcome to the Address Based System *****");
        AddressBS person1 = new AddressBS();
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
        person3.edit();

    }
}
