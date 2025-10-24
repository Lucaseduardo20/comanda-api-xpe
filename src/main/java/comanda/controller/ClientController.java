package com.lucas.comanda.controller;

import com.lucas.comanda.model.Client;
import com.lucas.comanda.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> listAll() {
        return clientService.list();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> find(@PathVariable Long id) {
        return clientService.find(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public List<Client> findByName(@PathVariable String name) {
        return clientService.findByName(name);
    }
    @GetMapping("/count")
    public long count() {
        return clientService.count();
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}