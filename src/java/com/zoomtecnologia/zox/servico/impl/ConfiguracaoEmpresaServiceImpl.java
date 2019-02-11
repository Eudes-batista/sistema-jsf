package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresa;
import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.servico.ConfiguracaoEmpresaService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("configuracaoEmpresaService")
@Transactional
public class ConfiguracaoEmpresaServiceImpl extends GenericServiceImpl<ConfiguracaoEmpresa> implements ConfiguracaoEmpresaService {

    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public Criteria criarCriteriaParaFiltro(ConfiguracaoEmpresa filtro) {
        return null;
    }

    @Override
    public Criteria criarFiltro(ConfiguracaoEmpresa filtro, Criteria criteria) {
        return null;
    }

    @Override
    public ConfiguracaoEmpresa buscarConfiguracaoPorEmpresa(Empresa empresa) {
        try{
          return entitymanager.createNamedQuery("ConfiguracaoEmpresa.buscarPorEmpresa",ConfiguracaoEmpresa.class).setParameter("empresa", empresa.getCodigo()).getSingleResult(); 
        }catch(NoResultException ex){
            return null;
        }
    }
}
