package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Conseiller {

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    private List<Client> clients;

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
