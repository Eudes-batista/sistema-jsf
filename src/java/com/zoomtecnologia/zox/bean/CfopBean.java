package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cfop;
import com.zoomtecnologia.zox.servico.CfopService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author administrador
 */
@Service("cfopBean")
@ManagedBean
@Scope("view")
public class CfopBean extends GenericoBean<Cfop, CfopService> implements Serializable{

    @Autowired
    private CfopService cfopService;
    
    @Override
    public CfopService getGenericService() {
        return cfopService;
    }

    @Override
    public Cfop createEntidade() {
        return new Cfop();
    }
    
}
