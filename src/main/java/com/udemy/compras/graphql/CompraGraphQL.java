package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.input.CompraInput;
import com.udemy.compras.model.Compra;
import com.udemy.compras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    public List<Compra> compras() {
        return service.findAll();
    }

    public Compra compra(Long id) {
        return service.find(id);
    }

    public Compra saveCompra(CompraInput input) {
        return service.saveCompra(input.toEntity());
    }

    public Boolean deleteCompra(Long id) {
        return service.deleteCompra(id);
    }

}
