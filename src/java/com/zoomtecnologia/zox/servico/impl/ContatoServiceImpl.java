/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.Contato;
import com.zoomtecnologia.zox.servico.ContatoService;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service("contatoService")
@Transactional
public class ContatoServiceImpl extends GenericServiceImpl<Contato> implements ContatoService,Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Criteria criarCriteriaParaFiltro(Contato filtro) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criateria = session.createCriteria(Contato.class);
        if (StringUtils.isNotEmpty(filtro.getPesquisa())) {
            criateria.add(Restrictions.ilike("descricao", filtro.getPesquisa(), MatchMode.ANYWHERE));
        }
        return criateria;
    }

    @Override
    public Criteria criarFiltro(Contato filtro, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}
