/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Cnae;
import com.zoomtecnologia.zox.servico.CnaeService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service("cnaeService")
@Transactional
public class CnaeServiceImpl extends GenericServiceImpl<Cnae> implements CnaeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cnae> filtrados(Cnae filtro) {
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
    public int quantidadeFiltrados(Cnae filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Cnae filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cnae.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("descricaoSessao", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion codigo = Restrictions.eq("codigoAtividade", 0);
                if (StringUtils.isNumeric(filtro.getPesquisa())) {
                    codigo = Restrictions.eq("codigoAtividade", Integer.parseInt(filtro.getPesquisa()));
                }
                criteria.add(Restrictions.or(nome, codigo));
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(Cnae filtro, Criteria criteria) {
        return null;
    }
}
