package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresa;
import com.zoomtecnologia.zox.servico.ConfiguracaoEmpresaService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("configuracaoEmpresaBean")
@ManagedBean
@Scope("view")
public class ConfiguracaoEmpresaBean extends GenericoBean<ConfiguracaoEmpresa, ConfiguracaoEmpresaService> implements Serializable{

    @Autowired
    private ConfiguracaoEmpresaService configuracaoEmpresaService;
    
    @Override
    public ConfiguracaoEmpresaService getGenericService() {
        return this.configuracaoEmpresaService;
    }
}
