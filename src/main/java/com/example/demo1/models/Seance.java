package com.example.demo1.models;

import java.time.LocalDate;

public class Seance {
    private Formateur formateur;
    private Salle salle;
    private Groupe groupe;
    private Module module;

    private LocalDate date;
    private String debut;
    private String fin;

    public Seance() {
    }

    public Seance(Formateur formateur, Salle salle, Groupe groupe, Module module, LocalDate date, String debut, String fin) {
        this.formateur = formateur;
        this.salle = salle;
        this.groupe = groupe;
        this.module = module;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return (module != null ? module.toString() : "Module") + " - " + (date != null ? date : "Date");
    }
}

