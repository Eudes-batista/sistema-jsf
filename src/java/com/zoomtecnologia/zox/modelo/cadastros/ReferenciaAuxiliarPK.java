package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.modelo.estoque.Produto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode(of={"produto","codigoReferencia"})
public class ReferenciaAuxiliarPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "RECODPRO", nullable = false)
    private Produto produto;

    @Column(name = "RECODREF", length = 20, nullable = false)
    private String codigoReferencia;
}
