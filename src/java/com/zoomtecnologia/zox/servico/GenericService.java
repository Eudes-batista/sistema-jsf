package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.filtros.FiltroGeneric;
import java.util.List;
import org.hibernate.Criteria;

public interface GenericService<E,F extends FiltroGeneric> {

    public void salvar(E entidade);

    public void alterar(E entidade);

    public void excluir(E entidade);
    
    public List<E> filtrados(F filtro);
    
    public int quantidadeFiltrados(F filtro);
    
    public Criteria criarCriteriaParaFiltro(F filtro);
    
}
