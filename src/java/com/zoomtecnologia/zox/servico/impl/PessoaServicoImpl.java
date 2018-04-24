package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Pessoa;
import com.zoomtecnologia.zox.servico.PessoaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pessoaService")
@Transactional
public class PessoaServicoImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pessoa> filtrados(Pessoa filtro) {
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
    public int quantidadeFiltrados(Pessoa filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Pessoa filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            Criterion razaoSocial, nomeFantasia, documentoIndentificacao, inscricaoEstadual;
            razaoSocial = Restrictions.ilike("razaoSocial", filtro.getPesquisa(), MatchMode.ANYWHERE);
            nomeFantasia = Restrictions.eq("nomeFantasia", filtro.getPesquisa());
            documentoIndentificacao = Restrictions.eq("documentoIdentificacao", filtro.getPesquisa());
            inscricaoEstadual = Restrictions.eq("inscricaoEstadual", filtro.getPesquisa());
            Disjunction expressao = Restrictions.or(razaoSocial, nomeFantasia, documentoIndentificacao, inscricaoEstadual);
            criteria.add(expressao);
            return criteria;
        }

        return criteria;
    }

}
