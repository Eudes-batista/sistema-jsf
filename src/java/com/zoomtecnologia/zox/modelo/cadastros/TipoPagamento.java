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
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tipo_pagamento")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class TipoPagamento extends Filtro implements EntidadeBase<Integer>, Serializable {

    @Id
    @Column(name = "codigo", nullable = false, length = 3)
    private Integer codigo;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Override
    public Integer getId() {
        return this.codigo;
    }

}
