package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Carte {
    public enum TypeCarte {
        ELECTRON,
        PREMIER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private TypeCarte typeCarte;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Getter @Setter
    private boolean active = true;

    public Carte() {}

    public Carte(TypeCarte typeCarte) {
        this.typeCarte = typeCarte;
    }
}
