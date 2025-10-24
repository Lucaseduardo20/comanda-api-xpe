package com.lucas.comanda.service;

import com.lucas.comanda.repository.ClientRepository;
import com.lucas.comanda.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> list() {
        return clientRepository.findAll();
    }

    public Optional<Client> find(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public long count() {
        return clientRepository.count();
    }
}