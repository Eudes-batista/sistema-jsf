package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoEntrada;
import com.zoomtecnologia.zox.servico.FormaPagamentoEntradaService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("formaPagamentoEntradaService")
@Transactional
public class FormaPagamentoEntradaServiceImpl extends GenericServiceImpl<FormaPagamentoEntrada> implements FormaPagamentoEntradaService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;


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
