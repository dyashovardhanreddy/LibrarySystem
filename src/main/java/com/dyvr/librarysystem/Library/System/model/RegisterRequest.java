package com.dyvr.librarysystem.Library.System.model;

import java.util.Set;

public class RegisterRequest {

    private String username;
    private String password;
    private Set<RoleType> roles;

    public RegisterRequest(String username, String password, Set<RoleType> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleType> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleType> roles) {
        this.roles = roles;
    }
}
