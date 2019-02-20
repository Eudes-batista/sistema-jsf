package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoEntrada;
import com.zoomtecnologia.zox.servico.FormaPagamentoEntradaService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("formaPagamentoEntradaBean")
@ManagedBean
@Scope("view")
public class FormaPagamentoEntradaBean extends GenericoBean<FormaPagamentoEntrada, FormaPagamentoEntradaService> implements Serializable {

    @Autowired
    private FormaPagamentoEntradaService formaPagamentoEntradaService;

    @Override
    public FormaPagamentoEntradaService getGenericService() {
        return this.formaPagamentoEntradaService;
    }
}
