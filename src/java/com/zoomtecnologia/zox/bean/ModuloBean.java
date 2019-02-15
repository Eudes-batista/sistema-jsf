/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.servico.ModuloService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("moduloBean")
@ManagedBean
@Scope("view")
public class ModuloBean extends GenericoBean<Modulo, ModuloService> {

    @Autowired
    private ModuloService moduloService;

    @Override
    public ModuloService getGenericService() {
        return this.moduloService;
    }

    @Override
    public Modulo createEntidade() {
        return new Modulo();
    }
}
