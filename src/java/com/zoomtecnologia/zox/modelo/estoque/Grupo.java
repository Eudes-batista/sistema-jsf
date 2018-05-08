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
@Table(name = "grupo")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "Grupo.listarTodos", query = "select u from Grupo u")
    ,@NamedQuery(name = "Grupo.buscarDescricao", query = "select u from Grupo u where u.descricao like :descricao")
})
public class Grupo extends Filtro implements EntidadeBase<String>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GPCODGRU", length = 20, nullable = false)
    @Length(max = 20, message = "Código do Grupo com até {max}.")
    String codigo;

    @Column(name = "GPDESGRU", length = 50, nullable = false)
    @Length(max = 50, message = "Descrição do Grupo com até {max}.")
    String descricao;

    @Column(name = "GPITEESP", length = 1)
    String tipo;

    @Override
    public String getId() {
        return this.codigo;
    }
}
