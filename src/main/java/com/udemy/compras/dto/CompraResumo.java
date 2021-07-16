package com.udemy.compras.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraResumo {
    private Long compraId;
    private String cliente;
    private String produto;
    private Integer quantidade;
}
