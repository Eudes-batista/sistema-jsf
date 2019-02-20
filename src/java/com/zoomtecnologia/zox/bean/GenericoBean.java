package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.ModeloGenerico;
import com.zoomtecnologia.zox.servico.EntidadeService;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.primefaces.model.LazyDataModel;

@Getter
@Setter
public abstract class GenericoBean<E extends Filtro, D extends EntidadeService> implements Serializable {

    private E entidade;
    private LazyDataModel<E> model;
    private Boolean inativo = false;
    private EntidadeService entidadeService;

    public void novo() {
        this.entidade = null;
        createEntidade();
        this.inativo = false;
        antesDeInicializar();
    }

    public void inicializar() {
        antesDeInicializar();
        createEntidade();
        this.model = new ModeloGenerico<E>(entidade, getGenericService()) {
        };
        depoisDeInicializar();
    }

    public void salvar() {
        try {
            antesDeSalvar();
            getGenericService().salvar(entidade.getClass(), entidade);
            this.novo();
            depoisDeSalvar();
            Messages.addGlobalInfo("salvo com sucesso!!");
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao salvar o " + entidade.getClass().getSimpleName());
        }
    }

    public void alterar(E e) {
        this.entidade = e;
        this.inativo = true;
    }

    public void excluir(E e) {
        String erro = "";
        try {
            antesDeExcluir();
            getGenericService().excluir(entidade.getClass(), e);
            depoisDeEcluir();
        } catch (Exception ex) {
            erro = "Erro ao excluir o " + e.getClass().getSimpleName() + "\n";
            String[] search = {"ForeignKey".toLowerCase(), "Foreign Key".toLowerCase()};
            if (ex.getMessage() != null) {
                if (ex.getMessage().toLowerCase().contains(search[0])
                        || ex.getMessage().toLowerCase().contains(search[1])) {
                    erro = "esse registro não pode ser excluido, já existe movimentação";
                }
            }
        } finally {
            if (!erro.isEmpty()) {
                Messages.addGlobalError(erro);
            } else {
                Messages.addGlobalInfo("excluido com sucesso!!");
            }
        }
    }

    public void pesquisar() {
        entidade.setFiltrar(false);
        realizarPesquisa();
    }

    public void filtrar() {
        entidade.setFiltrar(true);
        realizarPesquisa();
    }

    private void realizarPesquisa() {
        model = new ModeloGenerico<E>(entidade, getGenericService()) {
        };
    }

    void antesDeInicializar() {
    }

    void depoisDeInicializar() {
    }

    void antesDeSalvar() {
    }

    void depoisDeSalvar() {
    }

    void antesDeExcluir() {
    }

    void depoisDeEcluir() {
    }

    void depoisCriarEntidade() {
    }

    public abstract D getGenericService();

    public void createEntidade() {
        String type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
        try {
            E e = (E) Class.forName(type).newInstance();
            this.entidade = e;
            depoisCriarEntidade();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("ex = " + ex);
        }
    }

}
