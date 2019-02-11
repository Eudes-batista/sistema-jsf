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
@Table(name = "funcao_funcionario")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
@NamedQueries(
        @NamedQuery(name = "FuncaoFuncionario.buscarPorFuncao", query = "select f from FuncaoFuncionario f where f.nome like :nome"))
public class FuncaoFuncionario extends Filtro implements EntidadeBase<Integer>, Serializable {

    @Id
    @Column(name = "codigo", length = 6, nullable = false)
    private Integer codigo;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Override
    public Integer getId() {
        return this.codigo;
    }

}
