package com.zoomtecnologia.zox.modelo.seguranca;

import java.io.Serializable;
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
@EqualsAndHashCode(of = {"modulo", "aplicacao"})
public class ModuloAplicacaoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_modulo", nullable = false)
    @ForeignKey(name = "modulo_aplicacaoPKmodulo")
    private Modulo modulo;

    @ManyToOne
    @JoinColumn(name = "codigo_aplicacao", nullable = false)
    @ForeignKey(name = "modulo_aplicacaoPKaplicacao")
    private Aplicacao aplicacao;
}
