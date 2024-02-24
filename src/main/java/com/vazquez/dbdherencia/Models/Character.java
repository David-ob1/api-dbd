package com.vazquez.dbdherencia.Models;

import jakarta.persistence.*;

//@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String perk;

    public Character(String name, String perk) {
        this.name = name;
        this.perk = perk;
    }

    public Character() {
    }



}
