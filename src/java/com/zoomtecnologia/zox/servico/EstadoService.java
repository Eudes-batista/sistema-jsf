package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eudes
 */
@Repository
public interface EstadoService extends EntidadeService<Estado> {
    public List<Estado> listarPorPais(Pais pais);
}
