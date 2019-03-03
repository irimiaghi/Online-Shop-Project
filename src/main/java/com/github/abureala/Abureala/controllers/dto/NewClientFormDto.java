package com.github.abureala.Abureala.controllers.dto;

public class NewClientFormDto {

    public static final String NEW_CLIENT_FORM = "newClientForm";

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean admin;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        admin = false;
        this.admin = admin;
    }
}
