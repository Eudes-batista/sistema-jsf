package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.seguranca.Aplicacao;
import com.zoomtecnologia.zox.servico.AplicacaoService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("aplicacaoBean")
@ManagedBean
@Scope("view")
public class AplicacaoBean extends GenericoBean<Aplicacao, AplicacaoService> {

    @Autowired
    private AplicacaoService aplicacaoService;

    @Override
    public AplicacaoService getGenericService() {
        return this.aplicacaoService;
    }

    @Override
    public Aplicacao createEntidade() {
        return new Aplicacao();
    }
}
