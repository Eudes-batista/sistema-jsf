package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoSaida;
import com.zoomtecnologia.zox.servico.FormaPagamentoSaidaService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE);
                criteria.add(nome);
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(FormaPagamentoSaida filtro, Criteria criteria) {
        return null;
    }

}
