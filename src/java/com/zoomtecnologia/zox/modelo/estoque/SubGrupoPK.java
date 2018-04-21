package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Embeddable
@Data
public class SubGrupoPK implements Serializable {

    @Column(name = "SGCODSUB", length = 20, nullable = false)
    @Length(max = 20, message = "Código do SubGrupo com até {max}.")
    private String codigo;

    /**
     * CÓDIGO DO GRUPO
     */
    @ManyToOne
    @JoinColumn(name = "SGCODGRU", referencedColumnName = "GPCODGRU", nullable = false)
    @ForeignKey(name = "zoxcadsubgrupFKzoxcadgrup")
    private Grupo grupo;

}
