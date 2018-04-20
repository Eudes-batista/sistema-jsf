package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "funcao_funcionario")
@Data
@NamedQueries(@NamedQuery(name="FuncaoFuncionario.buscarPorFuncao",query = "select f from FuncaoFuncionario f where f.nome like :nome"))
public class FuncaoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FUCODFUN", length = 6, nullable = false)
    Integer codigo;

    @Column(name = "FUNOMFUN", length = 150, nullable = false)
    String nome;

}
