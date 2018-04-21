package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
public class EnderecoPK implements Serializable {

    /**
     * CODIGO DO CEP APENAS NUMEROS
     */
    @Column(name = "ENCODCEP", length = 8, nullable = false)
    private Integer cep;

    /**
     * NUMERO DO ENDERECO
     */
    @Column(name = "ENNUMERO", length = 10, nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ENCODCID", referencedColumnName = "MUCODIGO", nullable = false)
        ,@JoinColumn(name = "ENCODEST", referencedColumnName = "MUCODIUF", nullable = false)
    })
    @ForeignKey(name = "enderecoFKcidade")
    private Cidade cidade;

}
