package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Cliente;
import com.zoomtecnologia.zox.servico.ClienteService;
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

@Service("clienteService")
@Transactional
public class ClienteServiceImpl extends GenericServiceImpl<Cliente> implements ClienteService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> filtrados(Cliente filtro) {
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
    public int quantidadeFiltrados(Cliente filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Cliente filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);
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
    public Criteria criarFiltro(Cliente filtro, Criteria criteria) {
        Criteria c = criteria;
        Criterion nome = Restrictions.ilike("nomePessoa", filtro.getPessoa().getNomePessoa(), MatchMode.ANYWHERE);
        return c.add(nome);
    }

}
