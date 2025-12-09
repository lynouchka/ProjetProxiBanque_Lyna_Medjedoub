package com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Conseiller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    @Getter @Setter
    private Agence agence;

    @Getter
    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;

    public Conseiller() {}

    public Conseiller(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public boolean addClient(Client client) {
        if (clients.size() < 10) {
            clients.add(client);
            return true;
        }
        return false;
    }

    public void deleteClient(Client client) {
        client.getComptes().clear();
        clients.remove(client);
    }
}
