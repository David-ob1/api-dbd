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

    private String perk1;

    private String perk2;

    private String perk3;

    public Character(String name, String perk1, String perk2, String perk3) {
        this.name = name;
        this.perk1 = perk1;
        this.perk2 = perk2;
        this.perk3 = perk3;
    }

    public Character() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerk1() {
        return perk1;
    }

    public void setPerk1(String perk1) {
        this.perk1 = perk1;
    }

    public String getPerk2() {
        return perk2;
    }

    public void setPerk2(String perk2) {
        this.perk2 = perk2;
    }

    public String getPerk3() {
        return perk3;
    }

    public void setPerk3(String perk3) {
        this.perk3 = perk3;
    }
}
