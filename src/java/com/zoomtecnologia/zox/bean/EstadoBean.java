
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.servico.EstadoService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("estadoBean")
@ManagedBean
@Scope("view")
public class EstadoBean extends GenericBean<Estado, EstadoService>{

    @Autowired
    EstadoService estadoService;
    
    @Override
    public EstadoService getGenericService() {
        return estadoService;
    }

    @Override
    public Estado createEntidade() {
        return new Estado();
    }

}
