package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.Permissao;
import com.zoomtecnologia.zox.servico.PermissaoService;
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

/**
 *
 * @author Administrador
 */
@Service("permissaoService")
@Transactional
public class PermissaoServiceImpl extends GenericServiceImpl<Permissao> implements PermissaoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(Permissao filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Permissao.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("permissaoPK.aplicacao.nome", filtro.getPesquisa(), MatchMode.ANYWHERE);
                criteria.add(nome);
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(Permissao filtro, Criteria criteria) {
        return null;
    }

}
