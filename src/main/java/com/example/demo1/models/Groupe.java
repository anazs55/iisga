package com.example.demo1.models;

public class Groupe {
    private Integer id;
    private String nom;
    private String niveau;

    public Groupe() {
    }

    public Groupe(Integer id, String nom, String niveau) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return nom != null ? nom : "Groupe";
    }
}

