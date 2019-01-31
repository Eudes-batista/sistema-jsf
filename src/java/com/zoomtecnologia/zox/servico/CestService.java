package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.estoque.Cest;
import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CestService extends EntidadeService<Cest>{
    
    public List<Cest> listarCestPorNcm(Ncm ncm);
    
}
