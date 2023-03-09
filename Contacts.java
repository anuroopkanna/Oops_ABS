package com.BridgeLabzABS;

public class Contacts {
    private String firstname,lastname,mobilenumber,address,city,zip,state,email;
    public void Contacts(String firstname,String lastname,String mobilenumber,String address,String city,String zip,String state,String email){
        this.firstname=firstname;
        this.lastname=lastname;
        this.mobilenumber=mobilenumber;
        this.address=address;
        this.city=city;
        this.zip=zip;
        this.state=state;
        this.email=email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String Mobilenumber) {
        this.mobilenumber = Mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
