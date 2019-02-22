package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilModuloAplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilUsuario;
import com.zoomtecnologia.zox.servico.PerfilModuloAplicacaoService;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("perfilModuloAplicacaoService")
@Transactional
public class PerfilModuloAplicacaoServiceImpl extends GenericServiceImpl<PerfilModuloAplicacao> implements PerfilModuloAplicacaoService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Criteria criarCriteriaParaFiltro(PerfilModuloAplicacao filtro) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(PerfilModuloAplicacao.class);
        return criteria;
    }

    @Override
    public Criteria criarFiltro(PerfilModuloAplicacao filtro, Criteria criteria) {
        return null;
    }

    @Override
    public List<PerfilModuloAplicacao> listarPerfilModuloAplicacaoPorPerfil(PerfilUsuario perfilUsuario,Modulo modulo) {
       return this.entityManager.createQuery("select pma from PerfilModuloAplicacao pma where pma.perfilModuloAplicacaoPK.modulo.codigo="+modulo.getCodigo()+" and pma.perfilModuloAplicacaoPK.perfilUsuario.codigo="+perfilUsuario.getCodigo()
               , PerfilModuloAplicacao.class).getResultList();
    }

    @Override
    public List<PerfilModuloAplicacao> pesquisarAplicacoes(PerfilUsuario perfilUsuario,Modulo modulo, String aplicacao) {
        return this.entityManager.createQuery("select pma from PerfilModuloAplicacao pma where pma.perfilModuloAplicacaoPK.modulo.codigo="+modulo.getCodigo()+" and pma.perfilModuloAplicacaoPK.aplicacao.nome like '"+aplicacao+"%' and pma.perfilModuloAplicacaoPK.perfilUsuario.codigo="+perfilUsuario.getCodigo()
               , PerfilModuloAplicacao.class).getResultList();
    }

}
