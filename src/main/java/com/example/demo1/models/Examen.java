package com.example.demo1.models;

import java.time.LocalDate;

public class Examen {
    private String type;
    private Module module;
    private Groupe groupe;
    private Salle salle;
    private LocalDate date;
    private String heure;

    public Examen() {
    }

    public Examen(String type, Module module, Groupe groupe, Salle salle, LocalDate date, String heure) {
        this.type = type;
        this.module = module;
        this.groupe = groupe;
        this.salle = salle;
        this.date = date;
        this.heure = heure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return (type != null ? type : "Examen") + " - " + (date != null ? date : "Date");
    }
}

