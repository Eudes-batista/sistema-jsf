package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.PaisService;
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

@Service("paisService")
@Transactional
public class PaisServicoImpl implements PaisService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pais bucarPorId(Integer codigo) {
        return entityManager.find(Pais.class, codigo);
    }

    @Override
    public void salvar(Pais entidade) {
        if (bucarPorId(entidade.getCodigo()) == null) {
            entityManager.persist(entidade);
        } else {
            alterar(entidade);
        }
    }

    @Override
    public void alterar(Pais entidade) {
        entityManager.merge(entidade);
    }

    @Override
    public void excluir(Pais entidade) {
        entityManager.remove(bucarPorId(entidade.getCodigo()));
    }

    @Override
    public List<Pais> filtrados(Pais filtro) {
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
    public int quantidadeFiltrados(Pais filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Pais filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pais.class);
        if (StringUtils.isNotEmpty(filtro.getDescricao())) {
            criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
        }
        return criteria;
    }

    @Override
    public List<Pais> listarTodos() {
        return entityManager.createNamedQuery("Pais.listarTodos",Pais.class).getResultList();
    }
}
