package com.zoomtecnologia.zox.modelo;

import com.zoomtecnologia.zox.filtros.FiltroGeneric;
import com.zoomtecnologia.zox.servico.GenericService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public abstract class ModelGeneric<E extends FiltroGeneric, D extends GenericService> extends LazyDataModel<E> {

    private static final long serialVersionUID = 1L;
    private FiltroGeneric filtro;
    private GenericService genericServico;

    public ModelGeneric() {
        this.genericServico = getGenericServiceModel();
        this.filtro = getGenericFiltro();
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
        filtro.setPropriedadeOrdenacao(sortField);

        setRowCount(genericServico.quantidadeFiltrados(filtro));

        return genericServico.filtrados(filtro);
    }

    public abstract D getGenericServiceModel();

    public abstract E getGenericFiltro();
}
