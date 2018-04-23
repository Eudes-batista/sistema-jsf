package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
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
public class UnidadeServicoImpl extends GenericServiceImpl<Unidade> implements UnidadeServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Unidade> filtrados(Unidade filtro) {
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
    public int quantidadeFiltrados(Unidade filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Unidade filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Unidade.class);
        Criterion nome = null, codigo = null;
        LogicalExpression expressao;
        if (StringUtils.isNotEmpty(filtro.getDescricao()) || StringUtils.isNotEmpty(filtro.getCodigo())) {
            nome = Restrictions.ilike("descricao",
                    filtro.getDescricao(), MatchMode.ANYWHERE);
            codigo = Restrictions.eq("codigo", filtro.getCodigo());
            expressao = Restrictions.or(nome, codigo);
            criteria.add(expressao);
            return criteria;
        }
        if (StringUtils.isNotEmpty(filtro.getCodigo())) {
            codigo = Restrictions.eq("codigo", filtro.getCodigo());
            criteria.add(codigo);
            return criteria;
        }
        if (StringUtils.isNotEmpty(filtro.getDescricao())) {
            criteria.add(nome);
            return criteria;
        }
        return criteria;
    }

}
