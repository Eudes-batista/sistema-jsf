/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;


/**
 *
 * @author zox
 */
@Data
@Entity
@Table(name = "zoxcadpaises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zoxcadpaises.findAll", query = "SELECT z FROM Zoxcadpaises z")
    , @NamedQuery(name = "Zoxcadpaises.findByNacodigo", query = "SELECT z FROM Zoxcadpaises z WHERE z.nacodigo = :nacodigo")
    , @NamedQuery(name = "Zoxcadpaises.findByNadescri", query = "SELECT z FROM Zoxcadpaises z WHERE z.nadescri = :nadescri")})
public class Zoxcadpaises implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoxcadpaises")
    private List<Zoxcadcidade> zoxcadcidadeList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NACODIGO", length = 04, nullable = false)
    private Integer nacodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NADESCRI", length = 50, nullable = false)
    private String nadescri;

    @XmlTransient
    public List<Zoxcadcidade> getZoxcadcidadeList() {
        return zoxcadcidadeList;
    }

    public void setZoxcadcidadeList(List<Zoxcadcidade> zoxcadcidadeList) {
        this.zoxcadcidadeList = zoxcadcidadeList;
    }

}
