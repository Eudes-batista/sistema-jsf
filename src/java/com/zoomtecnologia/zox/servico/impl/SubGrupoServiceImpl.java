/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import com.zoomtecnologia.zox.servico.SubGrupoService;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wagner
 */
@Service("subGrupoService")
@Transactional
public class SubGrupoServiceImpl extends GenericServiceImpl<SubGrupo> implements SubGrupoService,Serializable{

    private static final long serialVersionUID = 1L;

     @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<SubGrupo> listarPorGrupo(Grupo grupo) {
        return  entityManager.createNamedQuery("SubGrupo.buscarPorGrupo",SubGrupo.class).
                setParameter("grupo", grupo).getResultList();
    }


    @Override
    public Criteria criarCriteriaParaFiltro(SubGrupo filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(SubGrupo.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criateria.add(Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(SubGrupo filtro, Criteria criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
