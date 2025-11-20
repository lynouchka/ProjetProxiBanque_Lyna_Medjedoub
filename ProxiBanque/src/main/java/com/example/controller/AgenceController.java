package com.example.controller;

import com.example.entity.Agence;
import com.example.entity.Conseiller;
import com.example.entity.Gerant;
import com.example.service.AgenceService;
import com.example.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/agence")
public class AgenceController {

    @Autowired
    public AgenceService agenceService;

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @GetMapping("/{id}")
    public Agence getAgence(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @PostMapping
    public Agence createAgence(@RequestParam String id, @RequestBody Gerant gerant) {
        return agenceService.createAgence(id, gerant);
    }

    @PostMapping("/{id}/conseiller")
    public void addCons(@PathVariable Long id, @RequestBody Conseiller conseiller) {
        agenceService.addConsToAgence(id, conseiller);
    }
}
