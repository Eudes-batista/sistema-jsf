package com.zoomtecnologia.zox.servico;

import java.util.List;
import org.hibernate.Criteria;

public interface EntidadeService<E> extends PadraoService<E> {

    public List<E> filtrados(E filtro);

    public int quantidadeFiltrados(E filtro);

    public Criteria criarCriteriaParaFiltro(E filtro);

}
