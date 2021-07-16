package com.udemy.compras.service;

import com.udemy.compras.model.Produto;
import com.udemy.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("produto-service")
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> readAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public boolean delete(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
