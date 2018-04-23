package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
public class ContatoPK implements Serializable {

    @Column(name = "CPCONTAT", length = 11, nullable = false)
    Integer contato;

    @ManyToOne
    @JoinColumn(name = "CPCODPES", referencedColumnName = "CUDOCIDE", nullable = false)
    @ForeignKey(name = "contadoFKpessoa")
    Pessoa pessoa;

    @Column(name = "CPTPCONT", length = 1, nullable = false)
    String tipoContato;

}
