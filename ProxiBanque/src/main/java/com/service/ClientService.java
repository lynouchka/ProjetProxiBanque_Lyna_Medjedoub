package com.service;

import com.entity.Client;
import com.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        Optional<Client> opt = clientRepository.findById(id);
        if (opt.isPresent()) {
            Client cli = opt.get();
            cli.getComptes().clear();
            clientRepository.delete(cli);
        }
    }

    public List<Client> findAllCli() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
