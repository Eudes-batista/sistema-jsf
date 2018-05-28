package com.zoomtecnologia.zox.servico.impl;


import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.servico.EmpresaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

@Service("empresaService")
@Transactional
public class EmpresaServicoImpl extends GenericServiceImpl<Empresa> implements EmpresaService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Empresa> filtrados(Empresa filtro) {
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
    public int quantidadeFiltrados(Empresa filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(Empresa filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Empresa.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion razaoSocial = Restrictions.ilike("razaoSocial", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion nomeFantasia = Restrictions.ilike("nomeFantasia", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion cnpj = Restrictions.eq("documentoIndentificacao", filtro.getPesquisa());
                Criterion codigo = Restrictions.eq("codigo", filtro.getPesquisa());
                criteria.add(Restrictions.or(razaoSocial,nomeFantasia,cnpj, codigo));
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(Empresa filtro, Criteria criteria) {
        Criteria c = criteria;
        Criterion nome = Restrictions.ilike("razaoSocial", filtro.getRazaoSocial(), MatchMode.ANYWHERE);
        return c.add(nome);
    }
    
    @Override
    public Empresa buscarPorEmpresa(Empresa empresa){
        try{
            return entityManager.createNamedQuery("Empresa.buscarPorCodigo",Empresa.class).setParameter("codigo",empresa.getCodigo()).getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
        
    }

}
