package org.uAuto;

public class User {
    private final String name;
    private String email;
    private final String password;

    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail (String email) {
        this.email = email;
    }
}