package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.filtros.*;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;

public interface UnidadeServico extends GenericService<Unidade,FiltroUnidade>{
    
    public Unidade buscarId(String codigo);
}
