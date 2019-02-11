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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cesta_tributacao")
@NamedQueries({
    @NamedQuery(name = "CestaTributacao.listarTodos", query = "select u from CestaTributacao u")
    ,
    @NamedQuery(name = "CestaTributacao.buscarDescricao", query = "select u from CestaTributacao u where u.descricao like :descricao")
})
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class CestaTributacao extends Filtro implements EntidadeBase<String>, Serializable {

    /**
     * CÓDIGO DA CESTA DE TRIBUTACAO
     */
    @Id
    @Column(name = "codigo", length = 04, nullable = false)
    @Length(max = 04, message = "Código da Cesta de Tributação com até {max}.")
    private String codigo;

    /**
     * DESCRIÇÃO DA CESTA DE TRIBUTAÇÃO
     */
    @Column(name = "descricao", length = 50, nullable = false)
    @Length(max = 50, message = "Descrição da Cesta de Tributação com até {max}.")
    private String descricao;

    @Override
    public String getId() {
        return this.codigo;
    }

}
