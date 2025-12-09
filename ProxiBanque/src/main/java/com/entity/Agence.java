package com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Getter
    @Setter
    private LocalDate date;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;

    @Getter
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Conseiller> conseillers = new ArrayList<>();

    public Agence() {}

    public Agence(String id, Gerant gerant) {
        this.id = id;
        this.gerant = gerant;
        this.date = LocalDate.now();
    }

    public void addCons(Conseiller conseiller) {
        conseillers.add(conseiller);
        conseiller.setAgence(this);
        gerant.addCons(conseiller);
    }
}
