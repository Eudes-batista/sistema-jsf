package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Meta;
import com.zoomtecnologia.zox.servico.MetaService;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("metaService")
@Transactional
public class MetaServiceImpl extends GenericServiceImpl<Meta> implements MetaService, Serializable{

  
    @Override
    public Criteria criarCriteriaParaFiltro(Meta filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Criteria criarFiltro(Meta filtro, Criteria criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
