
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
import org.hibernate.validator.constraints.Length;

@Embeddable
@Getter @Setter
@EqualsAndHashCode(of = {"codigo","pessoa"})
public class DocumentoPK implements Serializable{

    /**
     * CODIGO DO DOCUMENTO
     */
    @Length(max = 20, message = "campo documento do pode receber {max} caracteres")
    @Column(name = "numero", length = 20, nullable = false)
    private String Codigo;
    
    /**
     * CODIGO DA PESSOA
     */
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa",nullable = false)        
    @ForeignKey(name = "documentoFKpessoa")
    private Pessoa pessoa;
    
}
