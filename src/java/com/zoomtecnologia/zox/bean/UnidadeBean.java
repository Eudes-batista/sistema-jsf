package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("unidadeBean")
@ManagedBean
@Scope("view")
public class UnidadeBean extends GenericBean<Unidade, UnidadeServico> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UnidadeServico unidadeServico;
    
    @Override
    public UnidadeServico getGenericService() {
        return unidadeServico;
    }

    @Override
    public Unidade createEntidade() {
        return new Unidade();
    }
}
