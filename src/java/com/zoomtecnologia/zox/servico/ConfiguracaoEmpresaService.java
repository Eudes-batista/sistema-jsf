
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresa;
import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoEmpresaService extends EntidadeService<ConfiguracaoEmpresa>{
    public ConfiguracaoEmpresa buscarConfiguracaoPorEmpresa(Empresa empresa);
}
