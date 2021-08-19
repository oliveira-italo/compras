package com.udemy.compras.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.compras.exception.DomainException;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GraphQLHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getErrors).collect(Collectors.toList());
    }

    private GraphQLError getErrors(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            if (((ExceptionWhileDataFetching) error).getException() instanceof DomainException) {
                String message = ((ExceptionWhileDataFetching) error).getException().getMessage();
                return new SimpleError(message);
            }
            
        } else if (error instanceof ValidationError) {
            return new SimpleError(error.getMessage());
        }

        return error;
    }

    class SimpleError extends GenericGraphQLError {

        public SimpleError(String message) {
            super(message);
        }

        @Override
        @JsonIgnore
        public List<Object> getPath() {
            return null;
        }

        @Override
        @JsonIgnore
        public Map<String, Object> getExtensions() {
            return null;
        }
    }
}
