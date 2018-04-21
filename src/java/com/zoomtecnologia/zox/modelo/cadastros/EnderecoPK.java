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

    /**
     * CODIGO DA CIDADE
     */
    @JoinColumns({
        @JoinColumn(name = "ENCODCID", referencedColumnName = "MUCODIGO", nullable = false)
        ,@JoinColumn(name = "ENCODEST", referencedColumnName = "MUCODIUF", nullable = false)
        ,@JoinColumn(name = "ENCODPAI", referencedColumnName = "MUCDPAIS", nullable = false)
    })
    @ManyToOne
    @ForeignKey(name = "enderecoFKcidade")
    private Cidade cidade;

    /**
     * CODIGO DA PESSOA
     */
    @ManyToOne
    @JoinColumn(name = "ENPESSOA", nullable = false)
    @ForeignKey(name = "enderecoFKpessoa")
    Pessoa pessoa;

}
