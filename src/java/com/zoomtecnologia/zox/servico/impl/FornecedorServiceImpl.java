package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Fornecedor;
import com.zoomtecnologia.zox.servico.FornecedorService;
import java.io.Serializable;
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

@Service("fornecedorService")
@Transactional
public class FornecedorServiceImpl extends GenericServiceImpl<Fornecedor> implements FornecedorService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Fornecedor> filtrados(Fornecedor filtro) {
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
    public int quantidadeFiltrados(Fornecedor filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Fornecedor filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Fornecedor.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nomePessoa = Restrictions.ilike("pessoa.nomePessoa", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion nomeFantasia = Restrictions.ilike("pessoa.nomeFantasia", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion cnpj = Restrictions.eq("pessoa.documentoPessoa", filtro.getPesquisa());
                criteria.add(Restrictions.or(nomePessoa, nomeFantasia, cnpj));
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(Fornecedor filtro, Criteria criteria) {
        Criteria c = criteria;
        Criterion nome = Restrictions.ilike("nomePessoa", filtro.getPessoa().getNomePessoa(), MatchMode.ANYWHERE);
        return c.add(nome);
    }

}
