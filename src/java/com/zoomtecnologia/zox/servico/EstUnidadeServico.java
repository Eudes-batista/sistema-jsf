
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.EstUnidade;
import java.util.List;


public interface EstUnidadeServico {

    public void salvar(EstUnidade estUnidade);
    public void alterar(EstUnidade estUnidade);
    public void excluir(EstUnidade estUnidade);
    public EstUnidade buscarId(String uncodigo);
    public List<EstUnidade> buscarDescricao(String undescri);
    public List<EstUnidade> listarTodos();
}
