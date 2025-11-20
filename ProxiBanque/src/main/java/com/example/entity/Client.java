package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Client {

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    private String adresse;

    @Getter
    @Setter
    private String codePostal;

    @Getter
    @Setter
    private String ville;

    @Getter
    @Setter
    private String telephone;

    @Getter
    private List<Compte> comptes = new ArrayList<>();
    @Getter
    private List<Carte> cartes = new ArrayList<>();

    public Client() {};

    public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

    public void addCarte(Carte carte) {
        cartes.add(carte);
    }

    //public int size() {}

    public void desactiverCarte() {
        for (Carte carte : cartes) {
            carte.setActive(false);
        }
    }

}
