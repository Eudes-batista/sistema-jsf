package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.modelo.estoque.Produto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="referencia_auxiliar")
@Data
public class ReferenciaAuxiliar implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    @JoinColumn(name="RECODPRO",nullable = false)
    private Produto produto;
    
    @Id
    @Column(name="RECODREF",length = 20,nullable = false)
    private String codigoReferencia;
    
}
