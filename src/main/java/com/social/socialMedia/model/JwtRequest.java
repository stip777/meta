package com.social.socialMedia.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    // Properties
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;

    private String password;

    // Constructors
    public JwtRequest(){}

    public JwtRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Getters $ Setters
    public String getUsername(){
        return username;
    }

    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

}
