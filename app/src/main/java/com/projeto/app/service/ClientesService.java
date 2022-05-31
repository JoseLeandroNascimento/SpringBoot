package com.projeto.app.service;

import com.projeto.app.model.Cliente;
import com.projeto.app.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientesService {
    

    private ClienteRepository repository;

    @Autowired
    public ClientesService(ClienteRepository repository){

        this.repository = repository;
    }
    public void SalvarCliente(Cliente cliente){

        validarCliente(cliente);

        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){


        // Aplicar validações
    }
}
