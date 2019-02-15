package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacao;
import com.zoomtecnologia.zox.servico.ModuloAplicacaoService;
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
@Service("moduloAplicacaoService")
@Transactional
public class ModuloAplicacaoServiceImpl extends GenericServiceImpl<ModuloAplicacao> implements ModuloAplicacaoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(ModuloAplicacao filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(ModuloAplicacao.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(ModuloAplicacao filtro, Criteria criteria) {
        return null;
    }

}
