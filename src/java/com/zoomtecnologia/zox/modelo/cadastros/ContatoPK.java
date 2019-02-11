package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Pessoa;
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
@EqualsAndHashCode(of={"contato","pessoa","tipoContato"})
public class ContatoPK implements Serializable {

    @Column(name = "contato", length = 11, nullable = false)
    private Integer contato;

    @ManyToOne
    @JoinColumn(name = "codigo_pessoa", referencedColumnName = "documento_pessoa", nullable = false)
    @ForeignKey(name = "contadoFKpessoa")
    private Pessoa pessoa;

    @Column(name = "tipo", length = 1, nullable = false)
    private String tipoContato;

}
