
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
    @Column(name="codigo",length = 2, nullable = false)
    private Integer codigo;

    /**
     * CODIGO DO PAIS
     */
    @ManyToOne
    @JoinColumn(name="codigo_pais",referencedColumnName = "codigo",nullable = false)
    @ForeignKey(name = "estadoFKpais")
    private Pais pais;

    public EstadoPK() {
    }

    public EstadoPK(Integer codigo, Pais pais) {
        this.codigo = codigo;
        this.pais = pais;
    }
   
    
}
