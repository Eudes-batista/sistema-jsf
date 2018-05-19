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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "estado")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "Estado.listarTodos", query = "select e from Estado e order by e.nome")
    ,@NamedQuery(name = "Estado.buscarCodigo", query = "select e from Estado e where e.estadoPK.codigo=:codigo")
    ,@NamedQuery(name = "Estado.buscarPorPais", query = "select e from Estado e where e.estadoPK.pais=:pais")
})
public class Estado extends Filtro implements EntidadeBase<EstadoPK>, Serializable {

    private static final long serialVersionUID = 1L;

    public Estado(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public Estado() {
    }

    /**
     * CODIGO DO ESTADO
     */
    @EmbeddedId
    private EstadoPK estadoPK;

    
    /**
     * NOME DO ESTADO
     */
    @Column(name = "UFNOMEUF", length = 50, nullable = false)
    private String nome;

    /**
     * SIGLA DO ESTADO
     */
    @Column(name = "UFSIGLAUF", length = 2, nullable = false)
    private String sigla;

    public EstadoPK getId() {
        return this.estadoPK;
    }
    
}
