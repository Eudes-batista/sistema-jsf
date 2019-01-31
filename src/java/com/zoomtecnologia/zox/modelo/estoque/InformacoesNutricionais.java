/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author eudes
 */
@Entity
@Table(name = "informacoes_nutricionais")
@Data
public class InformacoesNutricionais implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DA INFORMACAO NUTRICIONAL
     */
    @Id
    @Column(name = "codigo", length = 4, nullable = false)
    private Integer codigo;

    /**
     * DESCRICAO
     */
    @Column(name = "descricao", length = 20, nullable = false)
    private String descricao;

    /**
     * CODIGO DO PRODUTO
     */
    @OneToOne
    @JoinColumn(name = "produto", nullable = false)
    @ForeignKey(name = "informacoes_nutricionaisFKproduto")
    private Produto produto;

}
