package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.UsuarioEmpresa;
import com.zoomtecnologia.zox.servico.UsuarioEmpresaService;
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
@Service("usuarioEmpresaService")
@Transactional
public class UsuarioEmpresaServiceImpl extends GenericServiceImpl<UsuarioEmpresa> implements UsuarioEmpresaService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(UsuarioEmpresa filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(UsuarioEmpresa.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(UsuarioEmpresa filtro, Criteria criteria) {
        return null;
    }

}
