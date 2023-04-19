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
    String[] getContactStrings() {
        return new String[] {getFirstName(), getLastName(), getCity(), getAddress(), getState(), getZip(), getPhoneNumber() + "", getEmail() + ""};
    }
    public String getFirstName() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
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
    public JSONObject getContactJSON() {
        JSONObject jsonPerson = new JSONObject();
        jsonPerson.put("firstName", getFirstName());
        jsonPerson.put("lastName", getLastName());
        jsonPerson.put("city", getCity());
        jsonPerson.put("address", getAddress());
        jsonPerson.put("state", getState());
        jsonPerson.put("zip", getZip());
        jsonPerson.put("phonenumber", getPhoneNumber());
        jsonPerson.put("email", getEmail());
        JSONObject jsonPersonObject = new JSONObject();
        jsonPersonObject.put("person", jsonPerson);
        return jsonPersonObject;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
