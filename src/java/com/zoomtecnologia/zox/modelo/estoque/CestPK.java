package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
public class CestPK implements Serializable {

    /**
     * CODIGO DO CEST
     */
    @Column(name = "CECODIGO", length = 7, nullable = false)
    private String codigo;

    /**
     * CODIGO DO NCM
     */
    @ManyToOne
    @JoinColumn(name = "CECODNCM", nullable = false)
    @ForeignKey(name = "cestFKncm")
    private Ncm ncm;
}
