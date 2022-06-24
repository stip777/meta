package com.social.socialMedia.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    // Properties

    // JwtResponse create model for token response
    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwtToken;

    // Constructors
    public JwtResponse(String jwtToken){
        this.jwtToken = jwtToken;
    }

    // Getter
    public String getJwtToken(){
        return this.jwtToken;
    }

}
