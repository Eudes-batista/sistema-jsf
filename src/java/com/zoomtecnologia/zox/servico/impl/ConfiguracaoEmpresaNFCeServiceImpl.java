
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresaNFCe;
import com.zoomtecnologia.zox.servico.ConfiguracaoEmpresaNFCeSevice;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("configuracaoEmpresaNFCeSevice")
@Transactional
public class ConfiguracaoEmpresaNFCeServiceImpl extends GenericServiceImpl<ConfiguracaoEmpresaNFCe> implements ConfiguracaoEmpresaNFCeSevice, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

 
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
