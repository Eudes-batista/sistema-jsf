/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tributacao")
@Data
@NamedQueries({
    @NamedQuery(name = "Tributacao.listarTodos", query = "select u from Tributacao u")
    ,@NamedQuery(name = "Tributacao.buscarEstado", query = "select u from Tributacao u where u.estado like :estado")
    ,@NamedQuery(name = "Tributacao.buscarCst", query = "select u from Tributacao u where u.cst like :cst")
})
public class Tributacao implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * CODIGO DA TRIBUTACAO
     */
    @EmbeddedId
    TributacaoPK tributacaoPK;

    /**
     * CST (CÓDIGO DA SITUAÇÃO TRIBUTÁRIA)
     */
    @Column(name = "CTCODCST", length = 03, nullable = false)
    @Length(max = 03, message = "CST da Tributação com até {max}.")
    String cst;

    /**
     * MODALIDADE DE DETERMINACAO DA BC DO ICMS: 0 - Margem Valor Agregado (%),
     * 1 - Pauta (valor), 2 - Preço Tabelado Máximo (valor) ou 3 - Valor da
     * Operação.
     */
    @Column(name = "CTMODBC", length = 01, nullable = false, columnDefinition = "enum(0,1,2,3) default '1'")
    String modalidadeBCIcms;

    /**
     * PERCENTUAL DE REDUÇÃO DA BASE DE CÁUCULO DO ICMS DA OPERAÇÃO PRÓPRIA
     */
    @Column(name = "CTPREDBC", precision = 6, scale = 3)
    private Double aliquotaReducaoBC;

    /**
     * ALÍQUOTA DE ICMS DENTRO DO ESTADO
     */
    @Column(name = "CTPICMSDUF", precision = 6, scale = 3)
    private Double aliquotaIcmsDentroEstado;

    /**
     * ALÍQUOTA DE ICMS FORA DO ESTADO
     */
    @Column(name = "CTPICMSFUF", precision = 6, scale = 3)
    private Double aliquotaIcmsForaEstado;

    /**
     * MODALIDADE DA BASE DE CÁLCULO DO ICMS ST
     */
    @Column(name = "CTMODBCST", length = 01, nullable = true, columnDefinition = "enum(0,1,2,3,4,5) default '4'")
    String modalidadeBCIcmsST;

    /**
     * PERCENTUAL DA MARGEM DE VALOR ADICIONADO ICMS ST
     */
    @Column(name = "CTPMVAST", precision = 6, scale = 3)
    private Double aliquotaMvaSt;

    /**
     * PERCENTUAL DE REDUÇÃO DA BASE DE CÁLCULO DO ICMS ST
     */
    @Column(name = "CTPREDBCST", precision = 6, scale = 3)
    private Double aliquotaReducaoBcSt;

    /**
     * ALÍQUOTA DE ICMS ST
     */
    @Column(name = "CTPICMSST", precision = 6, scale = 3)
    private Double aliquotaIcmsSt;

    /**
     * MOTIVO DA DESONERAÇÃO DO ICMS
     */
    @Column(name = "CTMOTDESICMS", length = 01, nullable = true, columnDefinition = "enum(1,2,3,4,5,6,7,8,9)")
    String motivoDesoneracaoIcms;

    /**
     * PERCENTUAL DA BASE DE CÁLCULO DA OPERAÇÃO PRÓPRIA
     */
    @Column(name = "CTPBCPO", precision = 6, scale = 3)
    private Double aliquotaBCOperacaoPropria;
}
