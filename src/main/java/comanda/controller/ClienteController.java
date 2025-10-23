package com.lucas.comanda.controller;

import com.lucas.comanda.model.Cliente;
import com.lucas.comanda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listAll() {
        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Long id) {
        return clienteService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    public List<Cliente> findByName(@PathVariable String name) {
        return clienteService.findByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    public void delete(Long id) {
        return clienteService.delete(id).
    }
}