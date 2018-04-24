package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.ModeloGenerico;
import com.zoomtecnologia.zox.servico.EntidadeService;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.primefaces.model.LazyDataModel;

@Getter
@Setter
public abstract class GenericoBean<E extends Filtro, D extends EntidadeService> implements Serializable {

    private static final long serialVersionUID = 1L;

    private E entidade;
    private LazyDataModel<E> model;

    public GenericoBean() {
    }

    public void novo() {
        this.entidade = null;
        this.entidade = createEntidade();
    }

    public void inicializar() {
        this.entidade = createEntidade();
        this.model = new ModeloGenerico<E, D>() {
            private static final long serialVersionUID = 1L;

            @Override
            public D getGenericServiceModel() {
                return getGenericService();
            }

            @Override
            public E getGenericFiltro() {
                return createEntidade();
            }

        };
    }

    public void salvar() {
        try {
            getGenericService().salvar(entidade.getClass(), entidade);
            Messages.addGlobalInfo("salvo com sucesso!!");
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao salvar o " + entidade.getClass().getSimpleName());
        }
    }

    public void alterar(E e) {
        this.entidade = e;
    }

    public void excluir(E e) {
        try {
            getGenericService().excluir(entidade.getClass(), e);
        } catch (Exception ex) {
            String erro = "Erro ao excluir o " + e.getClass().getSimpleName() + "\n";
            String[] search = {"ForeignKey".toLowerCase(), "Foreign Key".toLowerCase()};
            if (ex.getMessage().toLowerCase().contains(search[0])
                    || ex.getMessage().toLowerCase().contains(search[1])) {
                erro = "esse registro não pode ser excluido, já existe movimentação";
            }
            Messages.addGlobalError(erro);
        }
    }

    public void pesquisar() {
        model = new ModeloGenerico<E, D>() {
            private static final long serialVersionUID = 1L;

            @Override
            public D getGenericServiceModel() {
                return getGenericService();
            }

            @Override
            public E getGenericFiltro() {
                return entidade;
            }
        };
    }

    public abstract D getGenericService();

    public abstract E createEntidade();

}