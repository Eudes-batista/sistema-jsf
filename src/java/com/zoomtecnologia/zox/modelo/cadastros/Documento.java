package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "documento")
@Getter @Setter
public class Documento extends Filtro implements EntidadeBase<DocumentoPK>, Serializable {

    /**
     * CODIGO DO DOCUMENTO
     */
    @EmbeddedId
    private DocumentoPK documentoPK; 

    /**
     * TIPO DO DOCUMENTO
     */
    @Length(max = 30, message = "campo tipo do documento do pode receber {max} caracteres")
    @Column(name = "tipo", length = 30, nullable = false)
    private String tipo;

    @Override
    public DocumentoPK getId() {
        return this.documentoPK;
    }
    

}
