package com.udemy.compras.service;

import com.udemy.compras.dto.CompraResumo;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Page<Compra> findAll(PageRequest pageable) {
        return repository.findAll(pageable);
    }

    public Compra find(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Compra saveCompra(Compra compra) {
        return repository.save(compra);
    }

    @Transactional
    public boolean deleteCompra(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return repository.findAllByCliente(cliente);
    }

    public List<Compra> findAllByClienteAndQuantidade(Cliente cliente, int quantidade) {
        return repository.findAllByClienteAndQuantidade(cliente, quantidade);
    }

    public List<CompraResumo> findAllComprasResumo() {
        return repository.findAllComprasResumo();
    }
}
