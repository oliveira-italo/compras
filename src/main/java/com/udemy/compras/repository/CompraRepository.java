package com.udemy.compras.repository;

import com.udemy.compras.dto.CompraResumo;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("compra-repository")
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);

    @Query("SELECT c FROM Compra c WHERE c.cliente = :cliente AND c.quantidade = :quantidade")
    List<Compra> findAllByClienteAndQuantidade(@Param("cliente") Cliente cliente, @Param("quantidade") int quantidade);

    @Query("SELECT new com.udemy.compras.dto.CompraResumo(cmp.id, cln.nome, prd.nome, cmp.quantidade) FROM Compra cmp INNER JOIN cmp.cliente cln INNER JOIN cmp.produto prd ORDER BY cmp.id DESC")
    List<CompraResumo> findAllComprasResumo();
}
