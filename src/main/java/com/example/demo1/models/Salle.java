package com.example.demo1.models;

public class Salle {
    private Integer id;
    private String nom;
    private Integer capacite;

    public Salle() {
    }

    public Salle(Integer id, String nom, Integer capacite) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
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

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return nom != null ? nom : "Salle";
    }
}

