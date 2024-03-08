package com.vazquez.dbdherencia.DTO;

import com.vazquez.dbdherencia.Models.Person;

public class PersonDTO {

    private String id;

    private String name, email;


    public PersonDTO(Person person) {
        id = person.getId();
        name = person.getName();
        email = person.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
