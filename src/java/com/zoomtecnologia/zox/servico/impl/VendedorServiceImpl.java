package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Vendedor;
import com.zoomtecnologia.zox.servico.VendedorService;
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

@Service("vendedorService")
@Transactional
public class VendedorServiceImpl extends GenericServiceImpl<Vendedor> implements VendedorService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(Vendedor filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Vendedor.class);
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
    public Criteria criarFiltro(Vendedor filtro, Criteria criteria) {
        Criteria c = criteria;
        Criterion nome = Restrictions.ilike("nomePessoa", filtro.getPessoa().getNomePessoa(), MatchMode.ANYWHERE);
        return c.add(nome);
    }

}
