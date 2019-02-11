package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.TipoPagamento;
import com.zoomtecnologia.zox.servico.TipoPagamentoService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tipoPagamentoService")
@Transactional
public class TipoPagamentoServiceImpl extends GenericServiceImpl<TipoPagamento> implements TipoPagamentoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;


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
