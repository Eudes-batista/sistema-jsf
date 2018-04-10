    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author zox
 */
@Entity
@Table(name = "zoxcadcfop")
@Data
@NamedQueries({
    @NamedQuery(name = "Zoxcadcfop.findAll", query = "SELECT z FROM Zoxcadcfop z")
    , @NamedQuery(name = "Zoxcadcfop.findByOpcdcfop", query = "SELECT z FROM Zoxcadcfop z WHERE z.opcdcfop = :opcdcfop")
    , @NamedQuery(name = "Zoxcadcfop.findByOpdscfop", query = "SELECT z FROM Zoxcadcfop z WHERE z.opdscfop = :opdscfop")
    , @NamedQuery(name = "Zoxcadcfop.findByOpcodcop", query = "SELECT z FROM Zoxcadcfop z WHERE z.opcodcop = :opcodcop")
    , @NamedQuery(name = "Zoxcadcfop.findByOpdescop", query = "SELECT z FROM Zoxcadcfop z WHERE z.opdescop = :opdescop")
    , @NamedQuery(name = "Zoxcadcfop.findByOpdescri", query = "SELECT z FROM Zoxcadcfop z WHERE z.opdescri = :opdescri")})
public class Zoxcadcfop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "OPCDCFOP", length = 04, nullable = false)
    private Integer opcdcfop;
    
    @NotNull
    @Column(name = "OPDSCFOP", length = 60, nullable = false)
    private String opdscfop;
    
    @NotNull
    @Column(name = "OPCODCOP", length = 04, nullable = false)
    private String opcodcop;
    
    @NotNull
    @Column(name = "OPDESCOP", length = 30, nullable = false)
    private String opdescop;
    
    @Column(name = "OPDESCRI", length = 255)
    private String opdescri;

//    @Column(name = "TESTE",precision = 12,scale = 2)
//    private Double teste;
//    
    
}
