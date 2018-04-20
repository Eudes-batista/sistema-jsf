package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("unidadeBean")
@ManagedBean
public class UnidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    UnidadeServico unidadeServico;

    @Getter
    @Setter
    Unidade unidade;

    @Getter
    @Setter
    List<Unidade> unidades;

    @Getter
    @Setter
    String pesquisa;

    public void inicializar() {
        unidades = unidadeServico.listarTodos();
        unidade = new Unidade();
    }

    public void salvar() {
        try {
            unidadeServico.salvar(unidade);
            Messages.addGlobalInfo("salvar com sucesso!!");
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao salvar : " + ex.getMessage());
        }
    }

    public void alterar(Unidade unidades) {
        this.unidade = unidades;
    }

    public void excluir(Unidade unidades) {
        try {
            unidadeServico.excluir(unidades);
            Messages.addGlobalInfo("excluido com sucesso!!");
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao excluir : " + ex.getMessage());
        }
        this.unidades.remove(unidade);
    }

    public void pesquisarDescricao() {
        unidades = unidadeServico.bucarDescricao(pesquisa);
    }
}
