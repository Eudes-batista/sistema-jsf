/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.servico.GrupoService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service("grupoService")
@Transactional
public class GrupoServiceImpl extends GenericServiceImpl<Grupo> implements GrupoService,Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(Grupo filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Grupo.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            Criterion descricao = Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE);
            SimpleExpression codigo = Restrictions.eq("codigo", filtro.getPesquisa());
            criateria.add(Restrictions.or(descricao,codigo));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Grupo filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
