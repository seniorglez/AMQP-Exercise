package com.seniorglez.server.domain.model;


public class User {

    private String username;

    private String email;

    private String passwordHash;

    private String firstName;

    private String lastName;

    private String telephone;

    public User(
            String username,
            String email,
            String passwordHash,
            String firstName,
            String lastName,
            String telephone
    ) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

}
