package com.lucas.comanda.service;

import com.lucas.comanda.repository.ClientRepository;
import com.lucas.comanda.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ClientService {
    @Autowired
    private ClientRepository ClientRepository;

    public List<Client> list() {
        return ClientRepository.findAll();
    }

    public Optional<Client> find(Long id) {
        return ClientRepository.findById(id);
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    public Client save(Client Client) {
        return clientRepository.save(Client);
    }

    public void delete(Long id) {
        return ClientRepository.deleteById(id);
    }

    public long count() {
        return ClientRepository.count();
    }
}