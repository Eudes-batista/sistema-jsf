package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.PaisService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("paisBean")
@ManagedBean
@Scope("view")
public class PaisBean extends GenericBean<Pais, PaisService> {

    @Autowired
    private PaisService paisService;
    @Override
    public PaisService getGenericService() {
        return paisService;
    }
    @Override
    public Pais createEntidade() {
        return new Pais();
    }
}
