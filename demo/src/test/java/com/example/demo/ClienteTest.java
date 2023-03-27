package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.controller.ClienteController;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

import jakarta.persistence.EntityNotFoundException;

public class ClienteTest {

    private ClienteService clienteService;
    private ClienteController clienteController;
    
    @BeforeEach
    public void setup() {
        clienteService = Mockito.mock(ClienteService.class);
        clienteController = new ClienteController(clienteService);
    }
    
    @Test
    public void testBuscarTodos() {
        List<Cliente> clientes = Arrays.asList(new Cliente(), new Cliente());
        Mockito.when(clienteService.buscarTodos()).thenReturn(clientes);
        
        List<Cliente> result = clienteController.buscarTodos();
        
        assertThat(result).isEqualTo(clientes);
    }
    
    @Test
    public void testBuscarPorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        Mockito.when(clienteService.buscarPorId(1L)).thenReturn(cliente);
        
        Cliente result = clienteController.buscarPorId(1L);
        
        assertThat(result).isEqualTo(cliente);
    }
    
    @Test
    public void testBuscarPorIdInexistente() {
        Mockito.when(clienteService.buscarPorId(1L)).thenThrow(new EntityNotFoundException("Cliente não encontrado"));
        
        assertThrows(EntityNotFoundException.class, () -> {
            clienteController.buscarPorId(1L);
        });
    }
    
    @Test
    public void testSalvar() {
        Cliente cliente = new Cliente();
        Mockito.when(clienteService.salvar(cliente)).thenReturn(cliente);
        
        Cliente result = clienteService.salvar(cliente);
        
        assertThat(result).isEqualTo(cliente);
    }
    
    @Test
    public void testDeletar() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        Mockito.when(clienteService.buscarPorId(1L)).thenReturn(cliente);
        
        clienteController.deletar(1L);
        
        Mockito.verify(clienteService).deletar(1L);
    }
    
   
    
}
