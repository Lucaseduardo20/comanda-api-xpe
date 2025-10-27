package com.lucas.command.controller;

import com.lucas.command.dto.ItemRequest;
import com.lucas.command.model.Command;
import com.lucas.command.service.CommandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commands")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @PostMapping
    public Command createCommand(@RequestParam Long clientId, @RequestBody List<ItemRequest> itens) {
        return commandService.createCommand(clientId, itens);
    }

    @GetMapping
    public List<Command> listAll() {
        return commandService.listAll();
    }

    @GetMapping("/{id}")
    public Command findById(@PathVariable Long id) {
        return commandService.findById(id);
    }

    @PutMapping("/{id}")
    public Command updateCommand(@PathVariable Long id, @RequestBody List<ItemRequest> novosItens) {
        return commandService.updateCommand(id, novosItens);
    }

    @DeleteMapping("/{id}")
    public void deleteCommand(@PathVariable Long id) {
        commandService.deleteCommand(id);
    }
}
