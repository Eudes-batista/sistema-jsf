package com.zoomtecnologia.zox.servico;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;

/**
 *
 * @author Administrador
 */
public interface PaisService extends GenericService<Pais> {
    public Pais bucarPorId(Integer codigo);
}
