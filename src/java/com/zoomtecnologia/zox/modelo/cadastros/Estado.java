package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "estado")
@Data
@EqualsAndHashCode(callSuper = false,of={"sigla"})
@NamedQueries({
    @NamedQuery(name = "Estado.listarTodos", query = "select e from Estado e left outer join fetch e.estadoPK.pais order by e.nome")
    ,@NamedQuery(name = "Estado.buscarCodigo", query = "select e from Estado e where e.estadoPK.codigo=:codigo")
    ,@NamedQuery(name = "Estado.buscarPorPais", query = "select e from Estado e where e.estadoPK.pais=:pais")
})
public class Estado extends Filtro implements EntidadeBase<EstadoPK>, Serializable {

    public Estado(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public Estado() {
    }

    public Estado(String sigla) {
        this.sigla = sigla;
    }
    
    /**
     * CODIGO DO ESTADO
     */
    @EmbeddedId
    private EstadoPK estadoPK;
    
    /**
     * NOME DO ESTADO
     */
    @Column(length = 50, nullable = false)
    private String nome;

    /**
     * SIGLA DO ESTADO
     */
    @Column(length = 2, nullable = false)
    private String sigla;

    @Override
    public EstadoPK getId() {
        return this.estadoPK;
    }
    
}
