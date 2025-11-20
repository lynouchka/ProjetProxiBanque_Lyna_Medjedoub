package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Compte> comptes = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Carte> cartes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    private Conseiller conseiller;

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
