package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compte {

    @Getter
    @Setter
    protected int numero;
    protected double solde;
    protected LocalDate date;

    //private List<Client> client = new ArrayList<>();

    public Compte() {}

    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
        this.date = LocalDate.now();
    }

    public void deposer(double argent) {
        if (argent > 0) {
            solde += argent;
        }
    }

    public void retirer (double argent) {
        if (argent < 0) {
            solde -= argent;
        }
    }
}
