/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Contato;
import com.zoomtecnologia.zox.servico.ContatoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
@Service("contatoService")
@Transactional
public class ContatoServiceImpl extends GenericServiceImpl<Contato> implements ContatoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contato> filtrados(Contato filtro) {
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
    public int quantidadeFiltrados(Contato filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Contato filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Contato.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criateria.add(Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Contato filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
