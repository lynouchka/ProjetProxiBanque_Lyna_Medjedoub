package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agence {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private LocalDate date;

    @Getter
    @Setter
    private Gerant gerant;

    @Getter
    private List<Conseiller> conseillers = new ArrayList<>();

    public Agence() {}

    public Agence(String id, Gerant gerant) {
        this.id = id;
        this.gerant = gerant;
        this.date = LocalDate.now();
    }

    public void addCons(Conseiller conseiller) {
        conseillers.add(conseiller);
        gerant.addCons(conseiller);
    }
}
