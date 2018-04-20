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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "estado")
@Data
@NamedQueries({
    @NamedQuery(name = "Estado.buscarNome", query = "select e from Estado e where e.nome like :nome or e.sigla = :sigla")
})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DO ESTADO
     */
    @Id
    @Column(name = "UFCODIGO", length = 2, nullable = false)
    Integer codigo;

    /**
     * CODIGO DO PAIS
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "UFCDPAIS", nullable = false)
    @ForeignKey(name = "zoxcadestadoFKzoxcadpaises")
    Pais pais;

    /**
     * NOME DO ESTADO
     */
    @Column(name = "UFNOMEUF", length = 50, nullable = false)
    String nome;

    /**
     * SIGLA DO ESTADO
     */
    @Column(name = "UFSIGLAUF", length = 2, nullable = false)
    String sigla;

}
