package com.vazquez.dbdherencia.Models.subclass;

import com.vazquez.dbdherencia.Models.Character;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Survivor extends Character {

    public Survivor() {

    }

    public Survivor(String name, String perk) {
        super(name, perk);
    }


}


