package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.filtros.*;
import com.zoomtecnologia.zox.modelo.estoque.Unidade;
import java.util.List;

public interface UnidadeServico{

    
    public void salvar(Unidade unidade);

    public void alterar(Unidade unidade);

    public void excluir(Unidade unidade);
    
    public List<Unidade> listarTodos();
    
    public Unidade buscarId(String codigo);
    
    public List<Unidade> bucarDescricao(String descricao);
    
    public List<Unidade> filtrados(FiltroUnidade filtro);
    
    public int quantidadeFiltrados(FiltroUnidade filtro);
    
}
