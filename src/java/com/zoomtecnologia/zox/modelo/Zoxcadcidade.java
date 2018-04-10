/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author zox
 */
@Data
@Entity
@Table(name = "zoxcadcidade")
@NamedQueries({
    @NamedQuery(name = "Zoxcadcidade.findAll", query = "SELECT z FROM Zoxcadcidade z")
    , @NamedQuery(name = "Zoxcadcidade.findByMucodigo", query = "SELECT z FROM Zoxcadcidade z WHERE z.zoxcadcidadePK.mucodigo = :mucodigo")
    , @NamedQuery(name = "Zoxcadcidade.findByMunommun", query = "SELECT z FROM Zoxcadcidade z WHERE z.munommun = :munommun")
    , @NamedQuery(name = "Zoxcadcidade.findByMucodiuf", query = "SELECT z FROM Zoxcadcidade z WHERE z.mucodiuf = :mucodiuf")
    , @NamedQuery(name = "Zoxcadcidade.findByMuestado", query = "SELECT z FROM Zoxcadcidade z WHERE z.muestado = :muestado")
    , @NamedQuery(name = "Zoxcadcidade.findByMucdpais", query = "SELECT z FROM Zoxcadcidade z WHERE z.zoxcadcidadePK.mucdpais = :mucdpais")
    , @NamedQuery(name = "Zoxcadcidade.findByMunmpais", query = "SELECT z FROM Zoxcadcidade z WHERE z.munmpais = :munmpais")
    , @NamedQuery(name = "Zoxcadcidade.findByMunmesta", query = "SELECT z FROM Zoxcadcidade z WHERE z.munmesta = :munmesta")})
public class Zoxcadcidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZoxcadcidadePK zoxcadcidadePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MUNOMMUN",length = 60,nullable = false)
    private String munommun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MUCODIUF", length = 02, nullable = false)
    private int mucodiuf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MUESTADO", length = 02, nullable = false)
    private String muestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MUNMPAIS", length = 50, nullable = false)
    private String munmpais;
    @Size(max = 50)
    @Column(name = "MUNMESTA", length = 50)
    private String munmesta;
    @JoinColumn(name = "MUCDPAIS", referencedColumnName = "NACODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zoxcadpaises zoxcadpaises;    
}
