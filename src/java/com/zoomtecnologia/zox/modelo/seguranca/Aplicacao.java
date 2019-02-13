package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="aplicacao")
@Data
@EqualsAndHashCode(callSuper = false, of = "codigo")
public class Aplicacao extends Filtro implements EntidadeBase<Integer>, Serializable{

    @Id
    @Column(name="codigo", nullable = false, length = 4)
    private Integer codigo;
    
    @Column(name="nome", nullable = false, length = 25)
    private String nome;
    
    @Column(name="caminho", nullable = false, length = 100)
    private String caminho;

    @Override
    public Integer getId() {

        return this.codigo;
    }

   
    
}
