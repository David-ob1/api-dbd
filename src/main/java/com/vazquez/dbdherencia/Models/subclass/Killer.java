package com.vazquez.dbdherencia.Models.subclass;

import com.vazquez.dbdherencia.Models.Character;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Killer extends Character {

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//
    private String power;

    private double speed;

    private String height;

    private int terrorRadius;


    public Killer() {
    }

    public Killer(String name, String perk, String power, double speed, String height, int terrorRadius) {
        super(name, perk);
        this.power = power;
        this.speed = speed;
        this.height = height;
        this.terrorRadius = terrorRadius;
    }


    //    public Killer(String name, String perk, String power, double speed) {
//        super(name, perk);
//        this.power = power;
//        this.speed = speed;
//    }
//
//    private String Skill;
//



}
