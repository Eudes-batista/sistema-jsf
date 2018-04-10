/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author zox
 */
@Data
@Embeddable
public class ZoxcadcidadePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MUCODIGO", length = 07, nullable = false)
    private int mucodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MUCDPAIS", length = 04, nullable = false)
    private int mucdpais;

    
    
}
