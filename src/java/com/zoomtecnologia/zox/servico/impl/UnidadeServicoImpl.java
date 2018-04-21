package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.filtros.FiltroUnidade;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("unidadeServico")
@Transactional
public class UnidadeServicoImpl implements UnidadeServico, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Unidade unidade) {
        if (buscarId(unidade.getCodigo()) == null) {
            entityManager.persist(unidade);
        } else {
            alterar(unidade);
        }
    }

    @Override
    public void alterar(Unidade unidade) {
        entityManager.merge(unidade);
    }

    @Override
    public Unidade buscarId(String codigo) {
        return entityManager.find(Unidade.class, codigo);
    }

    @Override
    public void excluir(Unidade unidade) {
        entityManager.remove(buscarId(unidade.getCodigo()));
    }

    @Override
    public List<Unidade> filtrados(FiltroUnidade filtro) {
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
    public int quantidadeFiltrados(FiltroUnidade filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(FiltroUnidade filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Unidade.class);
        Criterion nome = null, codigo = null;
        LogicalExpression expressao;
        if (StringUtils.isNotEmpty(filtro.getDescricao())) {
            nome = Restrictions.ilike("descricao",
                    filtro.getDescricao(), MatchMode.ANYWHERE);
        } else if (StringUtils.isNotEmpty(filtro.getCodigo())) {
            codigo = Restrictions.eq("codigo", filtro.getCodigo());
        }
        expressao = Restrictions.or(nome, codigo);
        criteria.add(expressao);
        return criteria;
    }
}
