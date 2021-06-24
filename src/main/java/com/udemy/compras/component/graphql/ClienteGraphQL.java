package com.udemy.compras.component.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente cliente(Long id) {
        return service.find(id);
    }

    public List<Cliente> clientes() {
        return service.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email) {
        return service.save(new Cliente(id, nome, email));
    }

    public Boolean deleteCliente(Long id) {
        return service.delete(id);
    }
}
