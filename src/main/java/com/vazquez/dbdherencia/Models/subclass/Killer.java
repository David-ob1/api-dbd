package com.vazquez.dbdherencia.Models.subclass;

import com.vazquez.dbdherencia.Models.Character;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Killer extends Character {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String power;

    private double speed;

    private String height;

    private int terrorRadius;


    public Killer() {
    }

    public Killer(String name, String perk1, String perk2, String perk3, String power, double speed, String height, int terrorRadius) {
        super(name, perk1, perk2, perk3);
        this.power = power;
        this.speed = speed;
        this.height = height;
        this.terrorRadius = terrorRadius;
    }

    public String getId() {
        return id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getTerrorRadius() {
        return terrorRadius;
    }

    public void setTerrorRadius(int terrorRadius) {
        this.terrorRadius = terrorRadius;
    }



}
