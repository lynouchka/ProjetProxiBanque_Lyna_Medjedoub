package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gerant {

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
    @OneToMany(mappedBy = "gerant", cascade = CascadeType.ALL)
    private List<Conseiller> conseillers =  new ArrayList<Conseiller>();

    public Gerant () {}

    public Gerant (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void addCons(Conseiller conseiller) {
        conseillers.add(conseiller);
        //conseiller.setGerant(this);
    }

}
