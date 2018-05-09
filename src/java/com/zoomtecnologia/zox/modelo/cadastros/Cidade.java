package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.zoomtecnologia.zox.modelo.EntidadeBase;

@Entity
@Table(name = "cidade")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "Cidade.listarTodos", query = "select c from Cidade c order by c.nome")
    ,@NamedQuery(name = "Cidade.buscarDescricao", query = "select c from Cidade c where c.nome like :nome")
})
public class Cidade extends Filtro implements EntidadeBase<CidadePK>, Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    CidadePK cidadePK;

    /**
     * NOME DO MUNICIPIO DE ACORDO COM O IBGE
     */
    @Column(name = "MUNOMMUN", length = 60, nullable = false, columnDefinition = "varchar(60) not null default 'EXTERIOR'")
    private String nome;

    @Override
    public CidadePK getId() {
        return this.cidadePK;
    }

}
