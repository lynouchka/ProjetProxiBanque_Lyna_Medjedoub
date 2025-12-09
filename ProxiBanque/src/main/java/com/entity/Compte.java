package com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    protected int numero;
    protected double solde;
    protected LocalDate date;

    //private List<Client> client = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter @Setter
    private Client client;

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
        if (argent > 0) {
            solde -= argent;
        }
    }
}
