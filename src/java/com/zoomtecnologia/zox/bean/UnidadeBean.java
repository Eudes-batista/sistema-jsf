package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.ModelUnidade;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;
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
    @Getter
    @Setter
    String pesquisa;

    public void pesquisar() {

    }

    @Override
    public UnidadeServico getGenericService() {
        return unidadeServico;
    }

    @Override
    public Unidade createEntidade() {
        return new Unidade();
    }

    @Override
    public LazyDataModel<Unidade> createModel() {
        return new ModelUnidade();
    }
}
