package com.zoomtecnologia.zox.modelo.estoque;

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
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "unidade")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "Unidade.listarTodos", query = "select u from Unidade u")
    ,@NamedQuery(name = "Unidade.buscarDescricao", query = "select u from Unidade u where u.descricao like :descricao")
})
public class Unidade extends Filtro implements EntidadeBase<String>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Codigo da unidade
     */
    @Id
    @Column(name = "codigo", length = 5, nullable = false)
    @Length(max = 5, message = "Código da Unidade com até {max}.")
    private String codigo;

    /**
     * Descrição da unidade
     */
    @Column(name = "descricao", length = 20, nullable = false)
    @Length(max = 20, message = "Descrição da Unidade com até {max}.")
    private String descricao;

    @Override
    public String getId() {
        return this.codigo;
    }
}
