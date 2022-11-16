package com.gwe2b.mymovies.model;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String nom;
    private String prenom;
    private String naissance;
    private List<Movie> filmographie = new ArrayList<>();

    public Actor(String nom, String prenom, String naissance) {
        setNom(nom);
        setPrenom(prenom);
        setNaissance(naissance);
    }

    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public String getNaissance() { return this.naissance; }
    public List<Movie> getFilmographie() { return this.filmographie; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setNaissance(String naissance) { this.naissance = naissance; }
    public void setFilmographie(List<Movie> filmographie) { this.filmographie = filmographie; }
}
