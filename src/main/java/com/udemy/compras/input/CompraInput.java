package com.udemy.compras.input;

import com.udemy.compras.config.SpringConfiguration;
import com.udemy.compras.enuns.CompraStatus;
import com.udemy.compras.model.Compra;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraInput {

    private Long id;
    //    private LocalDateTime data;
    private Integer quantidade;
    //    private CompraStatus status;
    private String status;
    private Long clienteId;
    private Long produtoId;

    public Compra toEntity() {

        ClienteService clienteService = (ClienteService) SpringConfiguration.contextProvider().getApplicationContext().getBean("cliente-service");
        ProdutoService produtoService = (ProdutoService) SpringConfiguration.contextProvider().getApplicationContext().getBean("produto-service");

        return Compra.builder()
                .id(this.id)
                .data(LocalDateTime.now())
                .quantidade(this.quantidade)
                .status(CompraStatus.fromString(this.status).orElseThrow(() -> new IllegalArgumentException("Status informado não existente")))
                .cliente(Optional.ofNullable(clienteService.findById(clienteId)).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")))
                .produto(Optional.ofNullable(produtoService.findById(produtoId)).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado")))
                .build();
    }
}
