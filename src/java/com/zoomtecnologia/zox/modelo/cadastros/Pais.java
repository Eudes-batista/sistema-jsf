package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
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
@EqualsAndHashCode(callSuper = false,of={"codigo"})
@NamedQueries({
    @NamedQuery(name = "Pais.listarTodos", query = "select p from Pais p order by p.descricao")
    ,@NamedQuery(name = "Pais.buscarPorDescricao", query = "select p from Pais p where p.descricao=:descricao")
})
public class Pais extends Filtro implements EntidadeBase<Integer>, Serializable {

    private static final long serialVersionUID = 1L;

    public Pais() {
    }

    public Pais(Integer codigo) {
        this.codigo = codigo;
    }

    @Id
    @Column(name = "NACODIGO", length = 4, nullable = false)
    private Integer codigo;

    @Column(name = "NADESCRI", length = 50, nullable = false)
    private String descricao;

    @Override
    public Integer getId() {
        return this.codigo;
    }

  
}
