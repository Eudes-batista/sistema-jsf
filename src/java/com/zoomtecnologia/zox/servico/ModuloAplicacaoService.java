package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.seguranca.Aplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacao;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloAplicacaoService extends EntidadeService<ModuloAplicacao>{
    
    public List<ModuloAplicacao> listarModulosAplicacao(Aplicacao aplicacao);
}
