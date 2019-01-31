/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cnae;
import com.zoomtecnologia.zox.servico.CnaeService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("cnaeBean")
@ManagedBean
@Scope("view")
public class CnaeBean extends GenericoBean<Cnae, CnaeService>{
    @Autowired
    private CnaeService cnaeService;

    @Override
    public CnaeService getGenericService() {
        return this.cnaeService;
    }

    @Override
    public Cnae createEntidade() {
        return new Cnae();
    }
    
}
