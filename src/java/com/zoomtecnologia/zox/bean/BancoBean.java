package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Banco;
import com.zoomtecnologia.zox.servico.BancoService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("bancoBean")
@ManagedBean
@Scope("view")
public class BancoBean extends GenericoBean<Banco, BancoService> implements Serializable {

    @Autowired
    private BancoService bancoService;

    @Override
    public void novo() {
        super.novo(); 
        this.getEntidade().setStatus(Boolean.TRUE);
    }

    @Override
    public BancoService getGenericService() {
        return this.bancoService;
    }

    @Override
    public Banco createEntidade() {
        return new Banco();
    }

}
