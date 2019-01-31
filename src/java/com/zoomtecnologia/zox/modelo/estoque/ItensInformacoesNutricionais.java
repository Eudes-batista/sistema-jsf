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
@Table(name = "itens_informacoes_nutricionais")
@Data
public class ItensInformacoesNutricionais implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DA INFORMACAO NUTRICIONAL
     */
    @Id
    @OneToOne
    @JoinColumn(name = "codigo_informacoes_nutricionais", nullable = false)
    @ForeignKey(name = "itens_informacoes_nutricionaisFKinformacoes_nutricionais")
    private InformacoesNutricionais informacoesNutricionais;

    /**
     * DESCRICAO DO ITEM
     */
    @Column(name = "descricao", length = 20, nullable = false)
    private String descricao;

    /**
     * QUANDIDADE
     */
    @Column(name = "quantidade", length = 20, nullable = false)
    private String quantidade;

    /**
     * VALORES DIARIOS
     */
    @Column(name = "valores_diarios", length = 255, nullable = false)
    private String valoresDiarios;

}
