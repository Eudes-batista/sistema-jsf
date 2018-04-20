package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.filtros.FiltroUnidade;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("unidadeBean")
@ManagedBean
@Scope("view")
public class UnidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    UnidadeServico unidadeServico;

    @Getter
    @Setter
    Unidade unidade;

    @Getter
    private LazyDataModel<Unidade> model;
    private FiltroUnidade filtroUnidade = new FiltroUnidade();

    @Getter
    @Setter
    String pesquisa;

    public void inicializar() {
        model = new ModelUnidade(filtroUnidade, unidadeServico);
        unidade = new Unidade();

    }

    public void salvar() {
        try {
            unidade.setCodigo(unidade.getCodigo().toUpperCase());
            unidade.setDescricao(unidade.getDescricao().toUpperCase());
            unidadeServico.salvar(unidade);
            model = new ModelUnidade(filtroUnidade, unidadeServico);
            Messages.addGlobalInfo("salvar com sucesso!!");
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao salvar : " + ex.getMessage());
        }
    }

    public void novo() {
        this.unidade = null;
        this.unidade = new Unidade();
    }

    public void alterar(Unidade unidades) {
        unidade = unidades;
    }

    public void excluir(Unidade unidades) {
        try {
            unidadeServico.excluir(unidades);
            Messages.addGlobalInfo("excluido com sucesso!!");
            model = new ModelUnidade(filtroUnidade, unidadeServico);
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao excluir : " + ex.getMessage());
        }
    }

    public void pesquisar() {
        filtroUnidade.setDescricao(pesquisa);
        model = new ModelUnidade(filtroUnidade, unidadeServico);
    }
}

/**
 * Essa classe é responsavel por realizar a paginacao<br /> no
 * <span style="color:red;">p:dataTable</span> do primefaces
 *
 * @author Eudes
 */
class ModelUnidade extends LazyDataModel<Unidade> {

    private static final long serialVersionUID = 1L;

    private FiltroUnidade filtroUnidade;
    private UnidadeServico unidadeServico;

    public ModelUnidade() {
    }

    /**
     * @param filtroUnidade
     * @param unidadeServico
     */
    public ModelUnidade(FiltroUnidade filtroUnidade, UnidadeServico unidadeServico) {
        this.filtroUnidade = filtroUnidade;
        this.unidadeServico = unidadeServico;
    }

    /**
     * Esse metodo da classe <b>LazyDataModel</b> que carregar o conteudo no
     * p:dataTable
     *
     * @param first passa qual o primeiro registro
     * @param pageSize o total de paginas colocado no p:dataTable
     * @param sortField o campo que está selecionado para ordena
     * @param sortOrder o tipo da ordenação
     * @param filters os filtros que foram realizados no p:dataTable
     * @return um lista de unidade paginas
     */
    @Override
    public List<Unidade> load(int first, int pageSize,
            String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {

        filtroUnidade.setPrimeiroRegistro(first);
        filtroUnidade.setQuantidadeRegistros(pageSize);
        filtroUnidade.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
        filtroUnidade.setPropriedadeOrdenacao(sortField);

        setRowCount(unidadeServico.quantidadeFiltrados(filtroUnidade));

        return unidadeServico.filtrados(filtroUnidade);
    }
}
