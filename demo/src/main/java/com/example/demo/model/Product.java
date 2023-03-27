package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        if(name == null){
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        return name;
    }
    public void setName(String name) {
        try {
            if(name == null){
                throw new IllegalArgumentException("Nome não pode ser nulo");
            }
            if(name.trim().isEmpty()){
                throw new IllegalArgumentException("Nome não pode ser vazio");
            }
            if (name.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("O nome do produto não pode conter apenas números");
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir o nome do produto: " + e.getMessage());
        }
        
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        if (price == null) {
            throw new IllegalArgumentException("O valor do produto não pode se null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("O valor do produto não pode ser negativo");
        }
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    

    
}
