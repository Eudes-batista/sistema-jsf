package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cfop;
import com.zoomtecnologia.zox.servico.CfopService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author administrador
 */
@Service("cfopBean")
@ManagedBean
@Scope("view")
public class CfopBean extends GenericoBean<Cfop, CfopService> implements Serializable {

    @Autowired
    private CfopService cfopService;

    @Getter
    @Setter
    private Map<String, String> cops = new HashMap<>();

    public void carregarCop() {
        cops.clear();
        String cfop = String.valueOf(super.getEntidade().getCodigo());
        if (!cfop.trim().isEmpty()) {
            if (String.valueOf(cfop.trim().charAt(0)).equals("5") || String.valueOf(cfop.trim().charAt(0)).equals("6") || String.valueOf(cfop.trim().charAt(0)).equals("7")) {
                cops.put("SP10", "VENDA");
                cops.put("SP20", "DEVOLUCAO DE COMPRA");
                cops.put("SP30", "REMESSA");
                cops.put("SP50", "RETORNO");
                cops.put("SP60", "TRANSFERÊNCIA");
                cops.put("SP65", "AJUSTE DE ESTOQUE");
                cops.put("SP70", "PRESTACAO DE SERVICO");
                cops.put("SP80", "ANULACÃO DE VALOR");
                cops.put("SP90", "OPERAÇÃO FINANCEIRA");
                cops.put("SP91", "RESSARCIMENTO DE VALOR");
                cops.put("SP99", "OUTRAS SAÍDAS/PRESTACÕES");
            } else if (String.valueOf(cfop.trim().charAt(0)).equals("1") || String.valueOf(cfop.trim().charAt(0)).equals("2") || String.valueOf(cfop.trim().charAt(0)).equals("3")) {
                cops.put("EA10", "COMPRA");
                cops.put("EA20", "DEVOLUÇÃO DE VENDA");
                cops.put("EA30", "RETORNO DE REMESSA");
                cops.put("EA40", "DEVOLUCAO DE REMESSA");
                cops.put("EA50", "ENTRADA");
                cops.put("EA60", "TRANSFERÊNCIA");
                cops.put("EA65", "AJUSTE DE ESTOQUE");
                cops.put("EA70", "AQUISIÇÃO DE SERVICO");
                cops.put("EA80", "ANULAÇÃO DE VALOR");
                cops.put("EA90", "OPERAÇÃO FINANCEIRA");
                cops.put("EA91", "RESSARCIMENTO DE VALOR");
                cops.put("EA99", "OUTRAS ENTRADAS/AQUISICOES");
            }
        }
    }

    @Override
    public CfopService getGenericService() {
        return cfopService;
    }

    @Override
    public Cfop createEntidade() {
        return new Cfop();
    }

}
