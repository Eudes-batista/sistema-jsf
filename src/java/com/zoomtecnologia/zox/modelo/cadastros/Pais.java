package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.FiltroGeneric;
import com.zoomtecnologia.zox.modelo.EntityBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pais")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "Pais.listarTodos", query = "select p from Pais p order by p.descricao")
    ,@NamedQuery(name = "Pais.buscarPorDescricao", query = "select p from Pais p where p.descricao like :descricao order by p.descricao")
})
public class Pais extends FiltroGeneric implements EntityBase<Integer>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NACODIGO", length = 4, nullable = false)
    Integer codigo;

    @Column(name = "NADESCRI", length = 50, nullable = false)
    String descricao;

    @Override
    public Integer getId() {
        return this.codigo;
    }

}
