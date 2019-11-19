package com.appsdeveloperblog.app.ws.ui.model.response;

// user interface layer

// this class is used to return back details to the client after his details are saved in the database
// so we don't pass back the user password. Only the request model contains password
// this contains user information that is being sent back as a confirmation that the users details have been
// stored in the database 
public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

}
