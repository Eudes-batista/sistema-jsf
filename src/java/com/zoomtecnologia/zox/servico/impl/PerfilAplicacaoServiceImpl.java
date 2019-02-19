package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.PerfilAplicacao;
import com.zoomtecnologia.zox.servico.PerfilAplicacaoService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service("perfilAplicacaoService")
@Transactional
public class PerfilAplicacaoServiceImpl extends GenericServiceImpl<PerfilAplicacao> implements PerfilAplicacaoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(PerfilAplicacao filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(PerfilAplicacao.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(PerfilAplicacao filtro, Criteria criteria) {
        return null;
    }

}
