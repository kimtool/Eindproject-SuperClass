package com.appsdeveloperblog.app.ws.ui.model.request;

public class UserLoginRequestModel {

    // for the users to be able to log in, they will need to provide their
    // user name and password

    private String email;
    private String password;


    // getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
