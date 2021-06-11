package com.udemy.compras.model;

import com.udemy.compras.enuns.CompraStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cmp_compra")
public class Compra {

    @Id
    @SequenceGenerator(name = "sq_cmp_compra", initialValue = 1, sequenceName = "sq_cmp_compra", allocationSize = 1)
    @GeneratedValue(generator = "sq_cmp_compra", strategy = GenerationType.SEQUENCE)
    @Column(name = "cmp_id")
    private Long id;

    @Column(name = "cmp_data", nullable = false)
    private LocalDateTime data;

    @Column(name = "cmp_qtd", nullable = false)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "cmp_status", nullable = false)
    private CompraStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cmp_cli", referencedColumnName = "cli_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cmp_prd", referencedColumnName = "prd_id")
    private Produto produto;

}
