package com.vazquez.dbdherencia.Models.subclass;

import com.vazquez.dbdherencia.Models.Character;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Survivor extends Character {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public Survivor() {

    }

    public Survivor(String name, String perk1, String perk2, String perk3) {
        super(name, perk1, perk2, perk3);
    }

    public String getId() {
        return id;
    }
}


