package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.PerfilModulo;
import com.zoomtecnologia.zox.servico.PerfilModuloService;
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
@Service("perfilModuloService")
@Transactional
public class PerfilModuloServiceImpl extends GenericServiceImpl<PerfilModulo> implements PerfilModuloService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(PerfilModulo filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(PerfilModulo.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(PerfilModulo filtro, Criteria criteria) {
        return null;
    }

}
