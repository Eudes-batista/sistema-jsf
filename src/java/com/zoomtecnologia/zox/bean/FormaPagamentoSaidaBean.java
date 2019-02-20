package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.FormaPagamentoSaida;
import com.zoomtecnologia.zox.servico.FormaPagamentoSaidaService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("formaPagamentoSaidaBean")
@ManagedBean
@Scope("view")
public class FormaPagamentoSaidaBean extends GenericoBean<FormaPagamentoSaida, FormaPagamentoSaidaService> implements Serializable {

    @Autowired
    private FormaPagamentoSaidaService formaPagamentoSaidaService;

    @Override
    public FormaPagamentoSaidaService getGenericService() {
        return this.formaPagamentoSaidaService;
    }
}
