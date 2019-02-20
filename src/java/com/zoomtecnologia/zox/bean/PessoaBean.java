package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Pessoa;
import com.zoomtecnologia.zox.servico.PessoaService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("pessoaBean")
@ManagedBean
@Scope("view")
public class PessoaBean extends GenericoBean<Pessoa, PessoaService> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public PessoaService getGenericService() {
        return pessoaService;
    }
}
