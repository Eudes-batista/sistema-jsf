package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "empresa")
@Data
@EqualsAndHashCode(callSuper = false,of={"codigo"})
@NamedQueries({
    @NamedQuery(name = "Empresa.buscarnomePessoa",
            query = "select e from Empresa e where  e.pessoa.nomePessoa like :nomePessoa or "
            + "e.pessoa.nomeFantasia like :nomeFantasia or "
            + "e.pessoa.documentoPessoa = :documentoPessoa or "
            + "e.pessoa.inscricaoEstadual = :inscricaoEstadual")
   ,@NamedQuery(name="Empresa.buscarPorCodigo",query="select e from Empresa e where e.codigo=:codigo")     
})
public class Empresa extends Filtro implements EntidadeBase<String>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DA EMPRESA
     */
    @Id
    @Column(name = "codigo", length = 3, nullable = false)
    private String codigo;

    @OneToOne
    @JoinColumn(name="codigo_pessoa",referencedColumnName = "documento_pessoa",nullable = false)
    private Pessoa pessoa;

    @Override
    public String getId() {
        return this.codigo;
    }

   

}
