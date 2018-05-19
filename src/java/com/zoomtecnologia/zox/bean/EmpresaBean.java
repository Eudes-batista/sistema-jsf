package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cidade;
import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.servico.CidadeService;
import com.zoomtecnologia.zox.servico.EmpresaService;
import com.zoomtecnologia.zox.servico.EstadoService;
import com.zoomtecnologia.zox.util.WebServiceCep;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("empresaBean")
@ManagedBean
@Scope("view")
public class EmpresaBean extends GenericoBean<Empresa, EmpresaService> {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @Getter
    @Setter
    private List<Estado> estados;
    @Getter
    @Setter
    private List<Cidade> cidades;

    @Override
    public void inicializar() {
        super.inicializar();
        this.estados = this.estadoService.listaTodos(Estado.class);
    }

    public void carregarCidade() {
        if (super.getEntidade().getSiglaEstado() != null) 
            if (!super.getEntidade().getSiglaEstado().isEmpty()) 
                this.cidades = this.cidadeService.listarPorEstado(super.getEntidade().getSiglaEstado());
        
    }

    public void consultarCep() {
        WebServiceCep cep = WebServiceCep.searchCep(String.valueOf(super.getEntidade().getCep()));
        super.getEntidade().setEndereco(cep.getLogradouro());
        super.getEntidade().setBairro(cep.getBairro());
    }

    @Override
    public EmpresaService getGenericService() {
        return empresaService;
    }

    @Override
    public Empresa createEntidade() {
        return new Empresa();
    }

}
