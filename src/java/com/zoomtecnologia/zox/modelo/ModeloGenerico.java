package com.zoomtecnologia.zox.modelo;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.servico.EntidadeService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public abstract class ModeloGenerico<E extends Filtro> extends LazyDataModel<E> {

    private static final long serialVersionUID = 1L;
    private final Filtro filtro;
    private final EntidadeService genericServico;

    public ModeloGenerico(Filtro filtro,EntidadeService entidadeService) {
        this.filtro = filtro;
        this.genericServico = entidadeService;
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
    public List<E> load(int first, int pageSize,
            String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {

        filtro.setPrimeiroRegistro(first);
        filtro.setQuantidadeRegistros(pageSize);
        filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
        if (sortField != null) {
            filtro.setPropriedadeOrdenacao(sortField);
        }
        setRowCount(genericServico.quantidadeFiltrados(filtro));

        return genericServico.filtrados(filtro);
    }
}
