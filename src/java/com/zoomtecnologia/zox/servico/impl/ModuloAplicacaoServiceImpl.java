package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.seguranca.Aplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacao;
import com.zoomtecnologia.zox.servico.ModuloAplicacaoService;
import java.io.Serializable;
import java.util.List;
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

    @Override
    public List<ModuloAplicacao> listarModulosAplicacao(Aplicacao aplicacao) {        
        return this.entityManager.createQuery("select mp from ModuloAplicacao mp where mp.moduloAplicacaoPK.aplicacao.codigo ="+ 
                                                aplicacao.getCodigo(), ModuloAplicacao.class).getResultList();        
    }

    @Override
    public void excluirModulosPorAplicacao(Aplicacao aplicacao) {
        this.executarSql("delete from modulo_aplicacao where codigo_aplicacao = "+aplicacao.getCodigo());
    }

    @Override
    public List<ModuloAplicacao> listarAplicacaoPorModulo(Modulo modulo) {
        return this.entityManager.createQuery("select mp from ModuloAplicacao mp where mp.moduloAplicacaoPK.modulo.codigo ="+ 
                                                modulo.getCodigo(), ModuloAplicacao.class).getResultList();        
    }

}
