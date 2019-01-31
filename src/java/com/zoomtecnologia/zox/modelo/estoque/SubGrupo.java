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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author zox
 */
@Entity
@Table(name = "subgrupo")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
     @NamedQuery(name = "SubGrupo.listarTodos", query = "select u from SubGrupo u")
    ,@NamedQuery(name = "SubGrupo.buscarDescricao", query = "select u from SubGrupo u where u.descricao like :descricao")
    ,@NamedQuery(name = "SubGrupo.buscarPorGrupo", query = "select u from SubGrupo u where u.subGrupoPK.grupo=:grupo")
})
public class SubGrupo extends Filtro implements EntidadeBase<SubGrupoPK>, Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * CODIGO DO SUBGRUPO
     */
    @EmbeddedId
    private SubGrupoPK subGrupoPK;

    /**
     * DESCRIÇÃO DO SUBGRUPO
     */
    @Column(name = "descricao", length = 50, nullable = false)
    @Length(max = 50, message = "Descrição do SubGrupo com até {max}.")
    private String descricao;

    /**
     * CÓDIGO DO NCM PADRÃO DO SUBGRUPO
     */
    @Column(name = "ncm", length = 8, nullable = false)
    private Integer ncm;

    /**
     * CÓDIGO DO CEST PADRÃO DO SUBGRUPO
     */
    @Column(name = "cest", length = 7, nullable = true)
    private Integer cest;

    /**
     * IAT (ARREDONDAMENTO OU TRUNCAMENTO) PADRÃO DO SUBGRUPO
     */
    @Column(name = "iat", length = 1, nullable = true, columnDefinition = " enum('A','T') default 'A'")
    private String iat;

    /**
     * IPPT (MERCADORIA DE TERCEIROS OU PROPRIA) PADRÃO DO SUBGRUPO
     */
    @Column(name = "ippt", length = 1, nullable = true, columnDefinition = " enum('T','P') default 'T'")
    private String ippt;

    @Override
    public SubGrupoPK getId() {
        return this.subGrupoPK;
    }
}
