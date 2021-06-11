package com.udemy.compras.component.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository repository;

    public Cliente cliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return repository.findAll();
    }
}
