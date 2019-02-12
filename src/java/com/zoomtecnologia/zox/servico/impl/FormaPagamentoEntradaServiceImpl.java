package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoEntrada;
import com.zoomtecnologia.zox.servico.FormaPagamentoEntradaService;
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

@Service("formaPagamentoEntradaService")
@Transactional
public class FormaPagamentoEntradaServiceImpl extends GenericServiceImpl<FormaPagamentoEntrada> implements FormaPagamentoEntradaService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(FormaPagamentoEntrada filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(FormaPagamentoEntrada.class);
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
    public Criteria criarFiltro(FormaPagamentoEntrada filtro, Criteria criteria) {
        return null;
    }

}
