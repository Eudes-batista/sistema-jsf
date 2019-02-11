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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "configuracao_empresa_nfce")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "ConfiguracaoEmpresaNFCe.buscarPorEmpresa", query = "select c from ConfiguracaoEmpresaNFCe c where c.configuracaoEmpresa.empresa.codigo = :codigo")
})
public class ConfiguracaoEmpresaNFCe extends Filtro implements EntidadeBase<ConfiguracaoEmpresa>,Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "configuracao_empresa", nullable = false)
    @ForeignKey(name = "configuracao_empresa_nfceFKconfiguracao_empresa")
    private ConfiguracaoEmpresa configuracaoEmpresa;

    /**
     * NUMERO DA ULTIMA NFCE
     */
    @Column(name = "ultima_nfce", length = 9, nullable = false)
    private Integer ultimaNfce;

    /**
     * SERIE DA NFCE
     */
    @Column(name = "serie_nfce", length = 3, nullable = false)
    private Integer serieNfce;

    @Override
    public ConfiguracaoEmpresa getId() {
        return this.configuracaoEmpresa;
    }

}
