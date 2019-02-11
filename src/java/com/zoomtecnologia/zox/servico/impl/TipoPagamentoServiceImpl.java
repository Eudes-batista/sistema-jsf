package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.TipoPagamento;
import com.zoomtecnologia.zox.servico.TipoPagamentoService;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tipoPagamentoService")
@Transactional
public class TipoPagamentoServiceImpl extends GenericServiceImpl<TipoPagamento> implements TipoPagamentoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TipoPagamento> filtrados(TipoPagamento filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setFirstResult(filtro.getPrimeiroRegistro());
        criteria.setMaxResults(filtro.getQuantidadeRegistros());
        if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
        } else if (filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
        }
        return criteria.list();
    }

    @Override
    public int quantidadeFiltrados(TipoPagamento filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(TipoPagamento filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(TipoPagamento.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(TipoPagamento filtro, Criteria criteria) {
        return null;
    }
}
