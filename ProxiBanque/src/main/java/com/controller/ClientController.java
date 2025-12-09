package com.controller;

import com.entity.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAllCli();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping("/update")
    public Client createClient(@RequestBody Client client) {
        return clientService.create(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.delete(id);
    }

}
