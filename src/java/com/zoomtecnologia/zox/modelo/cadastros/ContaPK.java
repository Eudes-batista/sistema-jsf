package com.zoomtecnologia.zox.modelo.cadastros;

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
@Getter
@Setter
@EqualsAndHashCode(of = {"codigo","empresa"})
public class ContaPK implements Serializable {

    @Column(name = "codigo", length =4,nullable = false)
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name="codigo_empresa",nullable = false)
    @ForeignKey(name="contaFKempresa")
    private Empresa empresa;

}
