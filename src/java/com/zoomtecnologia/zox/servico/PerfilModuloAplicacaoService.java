package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilModuloAplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilUsuario;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilModuloAplicacaoService extends EntidadeService<PerfilModuloAplicacao>{
    public List<PerfilModuloAplicacao> listarPerfilModuloAplicacaoPorPerfil(PerfilUsuario perfilUsuario,Modulo modulo);
    public List<PerfilModuloAplicacao> pesquisarAplicacoes(PerfilUsuario perfilUsuario,Modulo modulo,String aplicacao);
}
