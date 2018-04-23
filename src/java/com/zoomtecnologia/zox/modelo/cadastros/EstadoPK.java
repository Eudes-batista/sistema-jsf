
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
public class EstadoPK implements Serializable{

     /**
     * CODIGO DO ESTADO
     */
    @Column(name = "UFCODIGO", length = 2, nullable = false)
    Integer codigo;

    /**
     * CODIGO DO PAIS
     */
    @ManyToOne
    @JoinColumn(name = "UFCDPAIS", nullable = false)
    @ForeignKey(name = "estadoFKpais")
    Pais pais;
    
}
