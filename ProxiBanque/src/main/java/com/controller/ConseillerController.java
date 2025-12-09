package com.controller;

import com.entity.Client;
import com.entity.Conseiller;
import com.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conseiller")
public class ConseillerController {

    @Autowired
    private ConseillerService conseillerService;

    @GetMapping
    public List<Conseiller> findAll() {
        return conseillerService.getAllCons();
    }

    @GetMapping("/{id}")
    public Conseiller getConseiller(@PathVariable Long id) {
        return conseillerService.getConsById(id);
    }

    @PostMapping
    public Conseiller createConseiller(@RequestBody Conseiller cons) {
        return conseillerService.createCons(cons);
    }

    @PostMapping("/{id}/clients")
    public boolean addClient(@PathVariable Long id, @RequestBody Client client) {
        return conseillerService.addClientToCons(id, client);
    }

    @DeleteMapping("/{id}/clients")
    public void removeClient(@PathVariable Long id, @RequestBody Client client) {
        conseillerService.removeClientFromCons(id, client);
    }
}
