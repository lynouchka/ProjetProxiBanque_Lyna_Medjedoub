package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Gerant {
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    private List<Conseiller> conseillers =  new ArrayList<Conseiller>();

    public Gerant () {}

    public Gerant (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void addConseiller(Conseiller conseiller) {
        conseillers.add(conseiller);
    }

}
