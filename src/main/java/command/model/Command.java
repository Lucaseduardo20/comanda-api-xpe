package com.lucas.command.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommandItem> itens;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<CommandItem> getItens() { return itens; }
    public void setItens(List<CommandItem> itens) { this.itens = itens; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
