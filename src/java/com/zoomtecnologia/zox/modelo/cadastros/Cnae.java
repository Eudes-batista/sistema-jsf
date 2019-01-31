/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cnae")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries(
        @NamedQuery(name = "Cnae.listarTodos", query = "select c from Cnae c order by c.codigoAtividade"))
public class Cnae extends Filtro implements EntidadeBase<Integer>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DE ATIVIDADE
     */
    @Id
    @Column(name = "codigo_cnae", length = 7, nullable = false)
    private Integer codigoAtividade;

    /**
     * DESCRICAO DA ATIVIDADE
     */
    @Column(name = "descricao_sessao", length = 100, nullable = false)
    private String descricaoSessao;


    /**
     * DESCRICAO DA DIVISAO
     */
    @Column(name = "descricao_divisao", length = 100, nullable = false)
    private String descricaoDivisao;

 
    /**
     * DESCRICAO DA CLASSE
     */
    @Column(name = "descricao_classificacao", length = 100, nullable = false)
    private String descricaoClassificacao;

    @Override
    public Integer getId() {
        return codigoAtividade;
    }

}
