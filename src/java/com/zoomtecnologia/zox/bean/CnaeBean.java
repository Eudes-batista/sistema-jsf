package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cnae;
import com.zoomtecnologia.zox.servico.CnaeService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("cnaeBean")
@ManagedBean
@Scope("view")
public class CnaeBean extends GenericoBean<Cnae, CnaeService>{
    @Autowired
    private CnaeService cnaeService;

    @Override
    public CnaeService getGenericService() {
        return this.cnaeService;
    }
}
