/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "zoxcnae")
@Data
@NamedQueries(
        @NamedQuery(name = "Cnae.listarTodos", query = "select c from Cnae c order by c.codigoAtividade"))
public class Cnae implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DE ATIVIDADE
     */
    @Id
    @Column(name = "AECDCNAE", length = 7, nullable = false)
    private Integer codigoAtividade;

    /**
     * SESSAO DA ATIVIDADE
     */
    @Column(name = "AECSECAO", length = 1, nullable = false)
    private String sessaoAtividade;

    /**
     * DESCRICAO DA ATIVIDADE
     */
    @Column(name = "AEDSECAO", length = 100, nullable = false)
    private String descricaoSessao;

    /**
     * CODIGO DA DEVISAO
     */
    @Column(name = "AECODDIV", length = 2, nullable = false)
    private String codigoDivisao;

    /**
     * DESCRICAO DA DIVISAO
     */
    @Column(name = "AEDESDIV", length = 100, nullable = false)
    private String descricaoDivisao;

    /**
     * CODIGO DO GRUPO
     */
    @Column(name = "AECGRUPO", length = 3, nullable = false)
    private String codigoGrupo;

    /**
     * DESCRICAO DO GRUPO
     */
    @Column(name = "AEDGRUPO", length = 100, nullable = false)
    private String descricaoGrupo;

    /**
     * CODIGO DA CLASSIFICACAO
     */
    @Column(name = "AECCLASS", length = 5, nullable = false)
    private String codigoClassificao;

    /**
     * DESCRICAO DA CLASSE
     */
    @Column(name = "EADCLASS", length = 100, nullable = false)
    private String descricaoClasse;

}
