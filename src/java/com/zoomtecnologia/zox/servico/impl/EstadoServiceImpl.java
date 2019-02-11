package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.EstadoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("estadoService")
@Transactional
public class EstadoServiceImpl extends GenericServiceImpl<Estado> implements EstadoService {

    @PersistenceContext
    private EntityManager entityManager;

  
    @Override
    public Criteria criarCriteriaParaFiltro(Estado filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Estado.class);
        criateria.createAlias("estadoPK.pais", "p", JoinType.LEFT_OUTER_JOIN);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criateria.add(Restrictions.ilike("nome", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Estado filtro, Criteria criteria) {
        return null;
}

    @Override
    public List<Estado> listarPorPais(Pais pais) {
       return entityManager.createNamedQuery("Estado.buscarPorPais", Estado.class).setParameter("estadoPK.estado", pais).getResultList();
    }
    @Override
    public Estado listarPorCodigo(Integer codigo) {
       return entityManager.createNamedQuery("Estado.buscarCodigo", Estado.class).setParameter("codigo", codigo).getSingleResult();
    }

    @Override
    public List<Estado> listaTodos(Class<Estado> classe) {
        return entityManager.createNamedQuery("Estado.listarTodos", classe).getResultList();
    }

}
