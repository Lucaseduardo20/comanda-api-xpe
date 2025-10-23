package com.lucas.comanda.service;

import com.lucas.comanda.repository.ClienteRepository;
import com.lucas.comanda.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> find(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findByName(String name) {
        return clientRepository.findByName(name);
    }

    public Cliente save(Cliente cliente) {
        return clientRepository.save(cliente);
    }

    public void delete(Long id) {
        return clienteRepository.deleteById(id);
    }

    public long count() {
        return clienteRepository.count();
    }
}