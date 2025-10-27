package com.lucas.command.model;

import jakarta.persistence.*;

@Entity
public class CommandItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Command command;

    @ManyToOne
    private Product product;

    private Integer amount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Command getCommand() { return command; }
    public void setCommand(Command command) { this.command = command; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}
