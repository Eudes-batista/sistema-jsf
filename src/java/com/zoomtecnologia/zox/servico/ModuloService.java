package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloService extends EntidadeService<Modulo>{
    public List<Modulo> listarModulosAtivos();
}
