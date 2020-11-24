package com.CS440.infoparksusa;

public class User {

    private String name;
    private String address;
    private String phone;
    private String email;
    private String password;
    Exception emptyField = new Exception("ERROR: empty field");

    public User(String name, String address, String phone, String email, String password) throws Exception {
        if (name.matches("") ||
                address.matches("") ||
                phone.matches("") ||
                email.matches("") ||
                password.matches("")
        ){
            throw emptyField;
        }
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public boolean changePassword(String newPassword){
        this.password = newPassword;
        return true;
    }
}
