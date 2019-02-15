package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.Aplicacao;
import com.zoomtecnologia.zox.servico.AplicacaoService;
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
@Service("aplicacaoService")
@Transactional
public class AplicacaoServiceImpl extends GenericServiceImpl<Aplicacao> implements AplicacaoService,Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(Aplicacao filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Aplicacao.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("nome", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion codigo = Restrictions.eq("codigo", 0);
                if (StringUtils.isNumeric(filtro.getPesquisa())) {
                    codigo = Restrictions.eq("codigo", Integer.parseInt(filtro.getPesquisa()));
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
    public Criteria criarFiltro(Aplicacao filtro, Criteria criteria) {
        return null;
    }


}
