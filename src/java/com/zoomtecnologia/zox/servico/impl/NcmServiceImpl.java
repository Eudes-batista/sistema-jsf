package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.NcmService;
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

@Service("ncmService")
@Transactional
public class NcmServiceImpl extends GenericServiceImpl<Ncm> implements NcmService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

  
    @Override
    public Criteria criarCriteriaParaFiltro(Ncm filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Ncm.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            Criterion descricao = Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE);
            Criterion codigo = Restrictions.eq("codigo", filtro.getPesquisa());
            criateria.add(Restrictions.or(descricao, codigo));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Ncm filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
