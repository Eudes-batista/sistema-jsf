package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.estoque.Unidades;
import java.util.List;

public interface UnidadeServico{

    
    public void salvar(Unidades unidade);

    public void alterar(Unidades unidade) ;

    public void excluir(Unidades unidade) ;
    
    public List<Unidades> listarTodos();
    
    public Unidades buscarId(String codigo);
    
    public List<Unidades> bucarDescricao(String descricao);
}
