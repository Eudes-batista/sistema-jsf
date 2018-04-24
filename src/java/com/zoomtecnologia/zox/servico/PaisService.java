package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface PaisService extends EntidadeService<Pais> {

    public List<Pais> listarTodos();
}
