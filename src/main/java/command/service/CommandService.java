package com.lucas.command.service;

import com.lucas.command.repository.ClientRepository;
import com.lucas.command.repository.ProductRepository;
import com.lucas.command.repository.CommandRepository;
import com.lucas.command.model.CommandItem;
import com.lucas.command.model.Product;
import com.lucas.command.model.Command;
import com.lucas.command.model.Client;
import com.lucas.command.dto.ItemRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommandService {

    @Autowired private ClientRepository clientRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private CommandRepository commandRepository;

    public Command createCommand(Long clientId, List<ItemRequest> itensRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Command command = new Command();
        command.setClient(client);

        List<CommandItem> itens = itensRequest.stream().map(req -> {
            Product product = productRepository.findById(req.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            CommandItem item = new CommandItem();
            item.setProduct(product);
            item.setAmount(req.getAmount());
            item.setCommand(command);

            return item;
        }).collect(Collectors.toList());

        command.setItens(itens);
        return commandRepository.save(command);
    }

        public List<Command> listAll() {
        return commandRepository.findAll();
    }

    public Command findById(Long id) {
        return commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));
    }

    public Command updateCommand(Long id, List<ItemRequest> novosItens) {
        Command command = findById(id);

        List<CommandItem> itensAtualizados = novosItens.stream().map(req -> {
            Product product = productRepository.findById(req.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            CommandItem item = new CommandItem();
            item.setProduct(product);
            item.setAmount(req.getAmount());
            item.setCommand(command);
            return item;
        }).collect(Collectors.toList());

        command.getItens().clear();
        command.getItens().addAll(itensAtualizados);

        return commandRepository.save(command);
    }

    public void deleteCommand(Long id) {
        Command command = findById(id);
        commandRepository.delete(command);
    }
}
