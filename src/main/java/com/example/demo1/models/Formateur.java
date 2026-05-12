package com.example.demo1.models;

public class Formateur {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    public Formateur() {
    }

    public Formateur(Integer id, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        String p = prenom != null ? prenom : "";
        String n = nom != null ? nom : "";
        String full = (p + " " + n).trim();
        return full.isEmpty() ? "Formateur" : full;
    }
}

