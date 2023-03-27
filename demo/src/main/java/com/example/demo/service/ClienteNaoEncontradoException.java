package com.example.demo.service;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(Long id) {
      super("Cliente não encontrado com o ID: " + id);
    }
  }
  
