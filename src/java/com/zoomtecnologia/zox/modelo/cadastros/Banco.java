package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "banco")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"numeroBanco"})
public class Banco extends Filtro implements EntidadeBase<Integer>, Serializable {

    @Id
    @Column(name = "numero_banco", length = 10, nullable = false)
    private Integer numeroBanco;
   
    @Column(name = "nome", length = 120, nullable = false)
    private String nome;
    
    @Column(name = "site", length = 80, nullable = false)
    private String site;
    
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Override
    public Integer getId() {
        return this.numeroBanco;
    }
}
