/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wagner
 */
@Repository
public interface SubGrupoService extends EntidadeService<SubGrupo>{
    public List<SubGrupo> listarPorGrupo(Grupo grupo);
}
