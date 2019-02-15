package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.PerfilUsuario;
import com.zoomtecnologia.zox.servico.PerfilUsuarioService;
import java.io.Serializable;
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

/**
 *
 * @author Administrador
 */
@Service("perfilUsuarioService")
@Transactional
public class PerfilUsuarioServiceImpl extends GenericServiceImpl<PerfilUsuario> implements PerfilUsuarioService,Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(PerfilUsuario filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(PerfilUsuario.class);
        if (!filtro.isFiltrar()) {
            if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
                Criterion nome = Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE);
                Criterion codigo = Restrictions.eq("codigo", 0);
                if (StringUtils.isNumeric(filtro.getPesquisa())) {
                    codigo = Restrictions.eq("codigo", Integer.parseInt(filtro.getPesquisa()));
                }
                criteria.add(Restrictions.or(nome, codigo));
                return criteria;
            }
        } else {
            return criarFiltro(filtro, criteria);
        }
        return criteria;
    }

    @Override
    public Criteria criarFiltro(PerfilUsuario filtro, Criteria criteria) {
        return null;
    }


}
