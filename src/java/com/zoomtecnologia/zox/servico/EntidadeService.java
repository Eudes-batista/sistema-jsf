package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.filtros.Filtro;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EntidadeService<E> extends PadraoService<E> {

    default <T extends Filtro> List<T> filtrados(T filtro){
        Criteria criteria = criarCriteriaParaFiltro((E)filtro);
        criteria.setFirstResult(filtro.getPrimeiroRegistro());
        criteria.setMaxResults(filtro.getQuantidadeRegistros());
        if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
        } else if (filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
        }
        return criteria.list();
    }

    default int quantidadeFiltrados(E filtro){
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    public Criteria criarCriteriaParaFiltro(E filtro);

    public Criteria criarFiltro(E filtro, Criteria criterio);

}
