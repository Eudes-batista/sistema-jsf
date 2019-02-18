package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.seguranca.Aplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacaoPK;
import com.zoomtecnologia.zox.servico.AplicacaoService;
import com.zoomtecnologia.zox.servico.ModuloAplicacaoService;
import com.zoomtecnologia.zox.servico.ModuloService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("aplicacaoBean")
@ManagedBean
@Scope("view")
public class AplicacaoBean extends GenericoBean<Aplicacao, AplicacaoService> {

    @Autowired
    private AplicacaoService aplicacaoService;

    @Autowired
    private ModuloAplicacaoService moduloAplicacaoService;
        
    @Autowired
    private ModuloService moduloService;

    @Getter
    @Setter
    private List<Modulo> modulosSelecionados;
    
    @Getter
    @Setter
    private List<Modulo> modulos;
    
    public void listarModulosAplicacao(Aplicacao aplicacao){
        this.modulosSelecionados = new ArrayList<>();
        List<ModuloAplicacao> modulosAplicacoes = this.moduloAplicacaoService.listarModulosAplicacao(aplicacao);
        for (ModuloAplicacao modulosAplicacao : modulosAplicacoes) {
            this.modulosSelecionados.add(modulosAplicacao.getModuloAplicacaoPK().getModulo());
        }
    }
    
    private void listarModulos() {
        this.modulos = this.moduloService.listaTodos(Modulo.class);        
    }

    @Override
    public void inicializar() {
        super.inicializar(); 
        listarModulos();
    }    
    
    @Override
    public void alterar(Aplicacao e) {
        super.alterar(e); 
        listarModulosAplicacao(e);
    }
    
    
    @Override
    public void salvar() {
        Aplicacao aplicacao = this.getEntidade();
        super.salvar();
        this.moduloAplicacaoService.excluirModulosPorAplicacao(aplicacao);
        for (Modulo modulosSelecionado : modulosSelecionados) {
            ModuloAplicacao moduloAplicacao = new ModuloAplicacao();
            ModuloAplicacaoPK moduloAplicacaoPK = new ModuloAplicacaoPK();
            moduloAplicacaoPK.setAplicacao(aplicacao);
            moduloAplicacaoPK.setModulo(modulosSelecionado);
            moduloAplicacao.setModuloAplicacaoPK(moduloAplicacaoPK);
            this.moduloAplicacaoService.salvar(ModuloAplicacao.class, moduloAplicacao);
        }
    }

    @Override
    public AplicacaoService getGenericService() {
        return this.aplicacaoService;
    }

    @Override
    public Aplicacao createEntidade() {
        return new Aplicacao();
    }
}
