package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "documento")
@Data
public class Documento implements Serializable {

    /**
     * CODIGO DO DOCUMENTO
     */
    @EmbeddedId
    DocumentoPK documentoPK; 

    /**
     * TIPO DO DOCUMENTO
     */
    @Length(max = 30, message = "campo tipo do documento do pode receber {max} caracteres")
    @Column(name = "DOTIPODC", length = 30, nullable = false)
    String tipo;
    
    

}
