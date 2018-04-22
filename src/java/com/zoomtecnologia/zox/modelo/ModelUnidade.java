
package com.zoomtecnologia.zox.modelo;

import com.zoomtecnologia.zox.filtros.FiltroUnidade;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelUnidade extends ModelGeneric<Unidade, UnidadeServico, FiltroUnidade>{

    @Autowired
    private UnidadeServico unidadeServico;
    
    @Override
    public UnidadeServico getGenericService() {
        return unidadeServico;
    }

    @Override
    public FiltroUnidade getGenericFiltro() {
       return new FiltroUnidade();
    }

}
