package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.PaisService;
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

@Service("paisService")
@Transactional
public class PaisServicoImpl extends GenericServiceImpl<Pais> implements PaisService,Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(Pais filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pais.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criteria.add(Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(Pais filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

    @Override
    public List<Pais> pesquisarPorPais(String descricao) {
        return entityManager.createNamedQuery("Pais.buscarPorDescricao", Pais.class).setParameter("descricao", descricao).getResultList();
    }

}
