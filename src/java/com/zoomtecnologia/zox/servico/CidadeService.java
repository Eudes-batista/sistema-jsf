package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Cidade;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eudes
 */
@Repository
public interface CidadeService extends EntidadeService<Cidade>{
    public List<Cidade> listarPorEstado(String estado);
}
