package com.gwe2b.mymovies.model;

public class Movie {
    private String titre;
    private String realisateur;
    private Actor principalActor;
    private int sortie;

    public Movie(String titre, String realisateur, Actor actor, int sortie) {
        setTitre(titre);
        setRealisateur(realisateur);
        setPrincipalActor(actor);
        setSortie(sortie);
    }

    public String getTitre() { return this.titre; }
    public String getRealisateur() { return this.realisateur; }
    public Actor getPrincipalActor() { return this.principalActor; }
    public int getSortie() { return this.sortie; }

    public void setTitre(String titre) { this.titre = titre; }
    public void setRealisateur(String realisateur) { this.realisateur = realisateur; }
    public void setPrincipalActor(Actor actor) { this.principalActor = actor; }
    public void setSortie(int sortie) { this.sortie = sortie; }
}
