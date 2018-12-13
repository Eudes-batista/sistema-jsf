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
public class CidadePK implements Serializable {

    /**
     * CODIGO CHAVE DO MUNICIPIO DE ACORDO COM O IBGE
     */
    @Column(length = 7, nullable = false)
    private Integer codigo;

    /**
     * CODIGO DO ESTADO
     */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="codigo_estado",referencedColumnName = "codigo",nullable = false)
       ,@JoinColumn(name="codigo_pais",referencedColumnName = "codigo_pais",nullable = false)     
    })        
    @ForeignKey(name="cidadeFKestado")        
    private Estado estado;
    
}
