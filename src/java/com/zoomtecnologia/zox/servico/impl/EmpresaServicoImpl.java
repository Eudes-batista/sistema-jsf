package com.zoomtecnologia.zox.servico.impl;


import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.servico.EmpresaService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("empresaService")
@Transactional
public class EmpresaServicoImpl extends GenericServiceImpl<Empresa> implements EmpresaService,Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(Empresa filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Empresa.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nomePessoa = Restrictions.ilike("pessoa.nomePessoa", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion nomeFantasia = Restrictions.ilike("pessoa.nomeFantasia", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion cnpj = Restrictions.eq("pessoa.documentoPessoa", filtro.getPesquisa());
                Criterion codigo = Restrictions.eq("codigo", filtro.getPesquisa());
                criteria.add(Restrictions.or(nomePessoa,nomeFantasia,cnpj, codigo));
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
        Criterion nome = Restrictions.ilike("nomePessoa", filtro.getPessoa().getNomePessoa(), MatchMode.ANYWHERE);
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
