package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.NcmService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("ncmBean")
@ManagedBean
@Scope("view")
public class NcmBean extends GenericBean<Ncm, NcmService> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    NcmService ncmService;

    @Override
    public NcmService getGenericService() {
        return ncmService;
    }

    @Override
    public Ncm createEntidade() {
        return new Ncm();
    }

}
