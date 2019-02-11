/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.estoque;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author eudes
 */
@Entity
@Table(name = "informacoes_nutricionais")
@Getter @Setter
@EqualsAndHashCode(callSuper = false,of="codigo")
public class InformacoesNutricionais extends Filtro implements EntidadeBase<Integer> , Serializable {

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

    @Override
    public Integer getId() {
        return this.codigo;
    }

}
