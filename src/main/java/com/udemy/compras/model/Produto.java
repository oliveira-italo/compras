package com.udemy.compras.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_prd_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "sq_prd_produto", initialValue = 1, sequenceName = "sq_prd_produto", allocationSize = 1)
    @GeneratedValue(generator = "sq_prd_produto", strategy = GenerationType.SEQUENCE)
    @Column(name = "prd_id")
    private Long id;

    @Column(name = "prd_nome")
    private String nome;

    @Column(name = "prd_valor", nullable = false)
    private BigDecimal valor;
}
