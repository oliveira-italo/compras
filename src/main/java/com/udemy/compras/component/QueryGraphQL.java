package com.udemy.compras.component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.dto.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public ClienteDTO cliente() {
        return new ClienteDTO("Ricardo, o Terrível", "r@gmail.com");
    }

    public List<ClienteDTO> clientes() {
        return Arrays.asList(
                new ClienteDTO("Ricardo, o Terrível", "r@gmail.com"),
                new ClienteDTO("Casanova", "cn@gmail.com"),
                new ClienteDTO("Don Ruan", "dr@gmail.com"),
                new ClienteDTO("Eu", "e@gmail.com"),
                new ClienteDTO("James Bond", "jb@gmail.com")
        );
    }
}
