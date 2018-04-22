package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.servico.GenericService;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;

@Getter
@Setter
public abstract class GenericBean<E, D extends GenericService> implements Serializable {

    private E entidade;
    private LazyDataModel<E> model;

    public GenericBean() {
    }

    public void novo() {
        this.entidade = null;
        this.entidade = createEntidade();
    }

    public void inicializar() {
        this.model=createModel();
        this.entidade = createEntidade();
    }

    public void salvar() {
        getGenericService().salvar(entidade);
    }
    
    public void alterar(E e) {
        this.entidade = e;
    }

    public void excluir(E e) {
        getGenericService().excluir(e);
    }

    public abstract D getGenericService();
    public abstract E createEntidade();
    public abstract LazyDataModel<E> createModel();

}
