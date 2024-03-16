package com.vazquez.dbdherencia.Models;

import jakarta.persistence.*;

//@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Character {

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;

    private String name;

    private String perk;

    public Character(String name, String perk) {
        this.name = name;
        this.perk = perk;
    }

    public Character() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerk() {
        return perk;
    }

    public void setPerk(String perk) {
        this.perk = perk;
    }
}
