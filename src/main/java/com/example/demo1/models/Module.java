package com.example.demo1.models;

public class Module {
    private Integer id;
    private String nom;
    private Integer duree;

    public Module() {
    }

    public Module(Integer id, String nom, Integer duree) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return nom != null ? nom : "Module";
    }
}

