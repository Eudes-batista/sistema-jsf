package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.TipoPagamento;
import com.zoomtecnologia.zox.servico.TipoPagamentoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("tipoPagamentoBean")
@ManagedBean
@Scope("view")
public class TipoPagamentoBean extends GenericoBean<TipoPagamento, TipoPagamentoService> implements Serializable{

    @Autowired
    private TipoPagamentoService tipoPagamentoService;
    
    public List<TipoPagamento> listarTipoPagamento() {
        return this.tipoPagamentoService.listaTodos(TipoPagamento.class);
    }
    
    
    @Override
    public TipoPagamentoService getGenericService() {
        return this.tipoPagamentoService;
    }

    @Override
    public TipoPagamento createEntidade() {
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setAscendente(true);
        tipoPagamento.setPropriedadeOrdenacao("descricao");
        return tipoPagamento;
    }
    
}
