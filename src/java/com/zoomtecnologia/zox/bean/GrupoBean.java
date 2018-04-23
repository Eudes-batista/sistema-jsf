/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.servico.GrupoService;
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
public class GrupoBean extends GenericBean<Grupo, GrupoService> {

    @Autowired
    GrupoService GrupoService;

    @Override
    public GrupoService getGenericService() {
        return GrupoService;
    }

    @Override
    public Grupo createEntidade() {
        return new Grupo();
    }

}
