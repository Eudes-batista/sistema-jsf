package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Getter @Setter
@EqualsAndHashCode(of={"codigo","ncm"})
public class CestPK implements Serializable {

    /**
     * CODIGO DO CEST
     */
    @Column(name = "codigo", length = 7, nullable = false)
    private String codigo;

    /**
     * CODIGO DO NCM
     */
    @ManyToOne
    @JoinColumn(name = "ncm", nullable = false)
    @ForeignKey(name = "cestFKncm")
    private Ncm ncm;
}
