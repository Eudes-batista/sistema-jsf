
package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Embeddable
@Data
public class DocumentoPK implements Serializable{

    /**
     * CODIGO DO DOCUMENTO
     */
    @Id
    @Length(max = 20, message = "campo documento do pode receber {max} caracteres")
    @Column(name = "DONUMERO", length = 20, nullable = false)
    String Codigo;
    
    /**
     * CODIGO DA PESSOA
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "DOCODPES",nullable = false)        
    @ForeignKey(name = "documentoFKpessoa")
    Pessoa pessoa;
    
}
