package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.servico.EmpresaService;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("empresaBean")
@ManagedBean
@Scope("view")
public class EmpresaBean extends GenericoBean<Empresa, EmpresaService> {

    @Autowired
    private EmpresaService empresaService;

    @Override
    public EmpresaService getGenericService() {
        return empresaService;
    }

    @Override
    public Empresa createEntidade() {
        return new Empresa();
    }

}
