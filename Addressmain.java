package com.BridgeLabzABS;

import java.util.Scanner;

public class Addressmain {
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
        AddressBS addressBS =new AddressBS();
        Scanner sc =new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("1.Add contact\n 2.Edit\n 3.Display\n 4.DeleteContact\n5.exit");
            int option= sc.nextInt();
            switch (option){
                case 1:
                    addressBS.addContact();
                    break;
                case 2:
                    addressBS.edit();
                    break;
                case 3:
                    addressBS.dispalyContacts();
                    break;
                case 4:
                    addressBS.deleteContact();
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println(option+"Enter s valid option");
                    break;
            }
        }
        System.out.println("exit");
    }
}
