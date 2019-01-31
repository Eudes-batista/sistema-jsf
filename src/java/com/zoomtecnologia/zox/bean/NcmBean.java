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
public class NcmBean extends GenericoBean<Ncm, NcmService> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private NcmService ncmService;
    
    @Autowired
    private CestBean cestBean;
   
    
    @Override
    public NcmService getGenericService() {
        return ncmService;
    }
    
    public void selecionarNcm(Ncm ncm){
        this.cestBean.novo();
        this.cestBean.setNcm(ncm);
        this.cestBean.setCests(this.cestBean.listarCestPorNcm(ncm));
    }

    @Override
    public Ncm createEntidade() {
        return new Ncm();
    }

}
