package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoEntrada;
import com.zoomtecnologia.zox.servico.FormaPagamentoEntradaService;
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

@Service("formaPagamentoEntradaService")
@Transactional
public class FormaPagamentoEntradaServiceImpl extends GenericServiceImpl<FormaPagamentoEntrada> implements FormaPagamentoEntradaService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FormaPagamentoEntrada> filtrados(FormaPagamentoEntrada filtro) {
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
    public int quantidadeFiltrados(FormaPagamentoEntrada filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(FormaPagamentoEntrada filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(FormaPagamentoEntrada.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(FormaPagamentoEntrada filtro, Criteria criteria) {
        return null;
    }

}
