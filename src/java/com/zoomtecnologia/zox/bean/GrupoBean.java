/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import com.zoomtecnologia.zox.servico.GrupoService;
import com.zoomtecnologia.zox.servico.SubGrupoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service("grupoBean")
@ManagedBean
@Scope("view")
public class GrupoBean extends GenericoBean<Grupo, GrupoService> {

    private static final long serialVersionUID = 1L;

    @Autowired
    GrupoService grupoService;
    
    @Autowired
    SubGrupoService subGrupoService;

    public List<SubGrupo> getSubgrupos(Grupo grupo) {
        return subGrupoService.listarPorGrupo(grupo);
    }
    
    @Override
    public GrupoService getGenericService() {
        return grupoService;
    }

    @Override
    public Grupo createEntidade() {
        return new Grupo();
    }

}
