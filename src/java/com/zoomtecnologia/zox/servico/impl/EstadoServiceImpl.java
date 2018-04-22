package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.EstadoPK;
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
public class EstadoServiceImpl implements EstadoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estado buscarPorId(EstadoPK estadoPK) {
        return entityManager.find(Estado.class, estadoPK);
    }

    @Override
    public void salvar(Estado estado) {
        if (buscarPorId(estado.getEstadoPK()) == null) {
            entityManager.persist(estado);
        } else {
            alterar(estado);
        }
    }

    @Override
    public void alterar(Estado estado) {
        entityManager.merge(estado);
    }

    @Override
    public void excluir(Estado estado) {
        entityManager.remove(buscarPorId(estado.getEstadoPK()));
    }

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
        if (StringUtils.isNotEmpty(filtro.getNome())) {
            criateria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public List<Estado> listarTodos() {
        return entityManager.createNamedQuery("Estado.listarTodos", Estado.class).getResultList();
    }

}
