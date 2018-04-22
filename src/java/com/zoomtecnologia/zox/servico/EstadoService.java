package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.EstadoPK;

/**
 *
 * @author eudes
 */
public interface EstadoService extends GenericService<Estado>{
    
    public Estado buscarPorId(EstadoPK estadoPK);
}
