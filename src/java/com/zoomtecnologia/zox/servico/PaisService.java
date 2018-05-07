package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisService extends EntidadeService<Pais> {
    public List<Pais> pesquisarPorPais(String descricao);
}
