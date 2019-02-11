
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresaNFCe;
import com.zoomtecnologia.zox.servico.ConfiguracaoEmpresaNFCeSevice;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("configuracaoEmpresaNFCeSevice")
@Transactional
public class ConfiguracaoEmpresaNFCeServiceImpl extends GenericServiceImpl<ConfiguracaoEmpresaNFCe> implements ConfiguracaoEmpresaNFCeSevice, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ConfiguracaoEmpresaNFCe> filtrados(ConfiguracaoEmpresaNFCe filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setFirstResult(filtro.getPrimeiroRegistro());
        criteria.setMaxResults(filtro.getQuantidadeRegistros());
        if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
        } else if (filtro.getPropriedadeOrdenacao() != null) {
            criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
        }
        return criteria.list();
    }

    @Override
    public int quantidadeFiltrados(ConfiguracaoEmpresaNFCe filtro) {
        Criteria criteria = criarCriteriaParaFiltro(filtro);
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).intValue();
    }

    @Override
    public Criteria criarCriteriaParaFiltro(ConfiguracaoEmpresaNFCe filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(ConfiguracaoEmpresaNFCe.class);        
        return criteria;
    }

    @Override
    public Criteria criarFiltro(ConfiguracaoEmpresaNFCe filtro, Criteria criteria) {
        return null;
    }

}
