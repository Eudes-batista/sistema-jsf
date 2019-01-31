package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Pessoa;
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
    @Column(length = 8, nullable = false)
    private Integer cep;

    /**
     * NUMERO DO ENDERECO
     */
    @Column(length = 10, nullable = false)
    private String numero;

    /**
     * CODIGO DA CIDADE
     */
    @JoinColumns({
        @JoinColumn(name = "codigo_cidade", referencedColumnName = "codigo", nullable = false)
        ,@JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado", nullable = false)
        ,@JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais", nullable = false)
    })
    @ManyToOne
    @ForeignKey(name = "enderecoFKcidade")
    private Cidade cidade;

    /**
     * CODIGO DA PESSOA
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "", nullable = false)
    @ForeignKey(name = "enderecoFKpessoa")
    Pessoa pessoa;

}
