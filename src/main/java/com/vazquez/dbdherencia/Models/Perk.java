package com.vazquez.dbdherencia.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Perk {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Type type;

    private String name;

    private String text;

    private String url;


    public Perk() {
    }

    public Perk(Type type, String name, String text, String url) {
        this.type = type;
        this.name = name;
        this.text = text;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
