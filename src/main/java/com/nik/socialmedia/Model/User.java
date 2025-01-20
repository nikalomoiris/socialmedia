package com.nik.socialmedia.Model;

import java.security.AuthProvider;

public class User {
    private String email;
    private AuthProvider provider;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

}
