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
    private clientService clientService;

    @GetMapping
    public List<Client> listAll() {
        return clientService.listAll();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Client> find(@PathVariable Long id) {
        return clientService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/${name}")
    public List<Client> findByName(@PathVariable String name) {
        return clientService.findByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    public long count() {
        return clientService
    }
    
    public void delete(Long id) {
        return clientService.delete(id).
    }
}