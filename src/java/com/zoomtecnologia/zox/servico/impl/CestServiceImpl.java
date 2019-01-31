package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Cest;
import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.CestService;
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
@Service("cestService")
@Transactional
public class CestServiceImpl extends GenericServiceImpl<Cest> implements CestService {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cest> filtrados(Cest filtro) {
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
    public int quantidadeFiltrados(Cest filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Cest filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cest.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE);
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
    public Criteria criarFiltro(Cest filtro, Criteria criteria) {
        return null;
    }

    @Override
    public List<Cest> listarCestPorNcm(Ncm ncm) {
        return entityManager.createNamedQuery("Cest.listarCestPorNcm", Cest.class).setParameter("ncm", ncm).getResultList();
    }
    
}
