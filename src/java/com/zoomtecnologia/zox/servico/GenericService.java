package com.zoomtecnologia.zox.servico;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;

public interface GenericService<E> extends Serializable {

    public void salvar(E entidade);

    public void alterar(E entidade);

    public void excluir(E entidade);
    
    public List<E> listarTodos();

    public List<E> filtrados(E filtro);

    public int quantidadeFiltrados(E filtro);

    public Criteria criarCriteriaParaFiltro(E filtro);

}
