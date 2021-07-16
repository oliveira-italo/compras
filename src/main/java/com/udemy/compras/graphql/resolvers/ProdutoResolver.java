package com.udemy.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto) {
        return "R$ " + produto.getValor();
    }
}
