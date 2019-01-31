package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author eudes
 */
@Entity
@Table(name = "local_estoque")
@Data
public class LocaEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * CODIGO DO LOCAL DO ESTOQUE
     */
    @EmbeddedId
    private LocalEstoquePK localEstoquePK;
    /**
     * ESTOQUE ATUAL
     */
    @Column(name = "estoque_atual", precision = 15, scale = 6, nullable = false)
    private Double estoqueAtual;
    /**
     * PRECO TOTAL DE CUSTO DO ESTOQUE
     */
    @Column(name = "preco_total_custo", precision = 15, scale = 6, nullable = false)
    private Double precoTotalCusto;

}
