package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Product;

public class ProductTest {
    
    @Test
    public void getName(){
        Product produto = new Product();
        produto.setName("Geladeira");
        Assertions.assertEquals("Geladeira",produto.getName());
    }
    @Test
    public void getPrice(){
        Product produto = new Product();
        produto.setPrice(700.00);
        Assertions.assertEquals(700.00, produto.getPrice());
    }
    @Test
    public void getDescription(){
        Product produto = new Product();
        produto.setDescription("Baixo consumo alta eficiencia");
        Assertions.assertEquals("Baixo consumo alta eficiencia", produto.getDescription());
    }
   
}
