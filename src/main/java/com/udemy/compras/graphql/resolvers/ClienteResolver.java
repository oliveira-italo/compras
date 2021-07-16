package com.udemy.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }

    public List<Compra> comprasByQtd(Cliente cliente, int quantidade) {
        return compraService.findAllByClienteAndQuantidade(cliente, quantidade);
    }

}
