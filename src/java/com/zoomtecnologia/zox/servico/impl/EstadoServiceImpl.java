package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.EstadoService;
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
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("estadoService")
@Transactional
public class EstadoServiceImpl extends GenericServiceImpl<Estado> implements EstadoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> filtrados(Estado filtro) {
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
    public int quantidadeFiltrados(Estado filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Estado filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Estado.class);
        criateria.createAlias("estadoPK.pais", "p", JoinType.LEFT_OUTER_JOIN);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criateria.add(Restrictions.ilike("nome", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Estado filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

    @Override
    public List<Estado> listarPorPais(Pais pais) {
       return entityManager.createNamedQuery("Estado.buscarPorPais", Estado.class).setParameter("estadoPK.estado", pais).getResultList();
    }

}
