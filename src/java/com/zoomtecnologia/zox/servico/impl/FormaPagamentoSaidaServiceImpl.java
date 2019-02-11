package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoSaida;
import com.zoomtecnologia.zox.servico.FormaPagamentoSaidaService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("formaPagamentoSaidaService")
@Transactional
public class FormaPagamentoSaidaServiceImpl extends GenericServiceImpl<FormaPagamentoSaida> implements FormaPagamentoSaidaService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(FormaPagamentoSaida filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(FormaPagamentoSaida.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(FormaPagamentoSaida filtro, Criteria criteria) {
        return null;
    }

}
