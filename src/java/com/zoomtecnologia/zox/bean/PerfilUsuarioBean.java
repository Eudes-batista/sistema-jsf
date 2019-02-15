package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.seguranca.PerfilUsuario;
import com.zoomtecnologia.zox.servico.PerfilUsuarioService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("perfilUsuarioBean")
@ManagedBean
@Scope("view")
public class PerfilUsuarioBean extends GenericoBean<PerfilUsuario, PerfilUsuarioService> {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @Override
    public void novo() {
        super.novo();
        this.getEntidade().setStatus(true);
    }

    @Override
    public PerfilUsuarioService getGenericService() {
        return this.perfilUsuarioService;
    }

    @Override
    public PerfilUsuario createEntidade() {
        return new PerfilUsuario();
    }
}
