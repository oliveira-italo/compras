package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.input.ProdutoInput;
import com.udemy.compras.model.Produto;
import com.udemy.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    public Produto saveProduto(ProdutoInput input) {
        Produto produto = new ModelMapper().map(input, Produto.class);
        return service.save(produto);
    }

    public List<Produto> produtos() {
        return service.readAll();
    }

    public Produto produto(Long id) {
        return service.findById(id);
    }

    public boolean deleteProduto(Long id) {
        return service.delete(id);
    }

}
