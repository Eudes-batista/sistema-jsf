
package com.zoomtecnologia.zox.modelo;

import com.zoomtecnologia.zox.filtros.FiltroPais;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.PaisService;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelPais extends ModelGeneric<Pais, PaisService, FiltroPais>{

    @Autowired
    PaisService paisService;
    
    @Override
    public PaisService getGenericService() {
        return paisService;
    }

    @Override
    public FiltroPais getGenericFiltro() {
        return new FiltroPais();
    }

}
