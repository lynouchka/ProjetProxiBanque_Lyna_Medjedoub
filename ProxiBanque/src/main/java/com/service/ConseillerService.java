package com.service;

import com.entity.Client;
import com.entity.Conseiller;
import com.repository.ConseillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConseillerService {

    @Autowired
    private ConseillerRepository conseillerRepository;

    public Conseiller createCons(Conseiller c) {
        return conseillerRepository.save(c);
    }

    public List<Conseiller> getAllCons() {
        return conseillerRepository.findAll();
    }

    public Conseiller getConsById(Long id) {
        return conseillerRepository.findById(id).orElse(null);
    }

    public boolean addClientToCons(Long consId, Client client) {
        Conseiller conseiller = getConsById(consId);
        if (conseiller != null) {
            boolean added = conseiller.addClient(client);
            if (added) {
                conseillerRepository.save(conseiller);
                return true;
            }
        }
        return false;
    }

    public void removeClientFromCons(Long consId, Client client) {
        Conseiller conseiller = getConsById(consId);
        if (conseiller != null) {
            conseiller.deleteClient(client);
            conseillerRepository.save(conseiller);
        }
    }
}
