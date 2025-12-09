package com.service;

import com.entity.Agence;
import com.entity.Conseiller;
import com.entity.Gerant;
import com.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    public Agence createAgence(String id, Gerant gerant) {
        Agence agence = new Agence(id,gerant);
        return agenceRepository.save(agence);
    }

    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    public void addConsToAgence(Long agenceId, Conseiller conseiller) {
        Agence agence = getAgenceById(agenceId);
        if (agence != null) {
            agence.addCons(conseiller);
            agenceRepository.save(agence);
        }
    }
}
