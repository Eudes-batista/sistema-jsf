package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;
import com.zoomtecnologia.zox.modelo.seguranca.ModuloAplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilModuloAplicacao;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilModuloAplicacaoPK;
import com.zoomtecnologia.zox.modelo.seguranca.PerfilUsuario;
import com.zoomtecnologia.zox.servico.ModuloAplicacaoService;
import com.zoomtecnologia.zox.servico.ModuloService;
import com.zoomtecnologia.zox.servico.PerfilModuloAplicacaoService;
import com.zoomtecnologia.zox.servico.PerfilUsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("perfilUsuarioBean")
@ManagedBean
@Scope("view")
public class PerfilUsuarioBean extends GenericoBean<PerfilUsuario, PerfilUsuarioService> {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @Autowired
    private PerfilModuloAplicacaoService perfilModuloAplicacaoService;

    @Autowired
    private ModuloService moduloService;

    @Autowired
    private ModuloAplicacaoService moduloAplicacaoService;

    @Getter
    @Setter
    private List<Modulo> modulos;

    @Getter
    @Setter
    private List<PerfilModuloAplicacao> perfilModuloAplicacaos;

    @Getter
    @Setter
    private List<PerfilModuloAplicacao> perfilModuloAplicacoesSelecionadas;

    @Getter
    @Setter
    private List<PerfilModuloAplicacao> perfilModuloAplicacoesAdicionadas;

    @Getter
    @Setter
    private Modulo modulo;

    @Getter
    @Setter
    private boolean statusModulo;

    private boolean editar;

    @Getter
    @Setter
    private String pesquisa;

    public void adicionarPermicao() {
        this.perfilModuloAplicacoesAdicionadas.clear();
        if (perfilModuloAplicacoesSelecionadas == null || perfilModuloAplicacoesSelecionadas.isEmpty()) {
            Messages.addGlobalWarn("Selecione uma aplicação.");
            return;
        }
        for (PerfilModuloAplicacao perfilModuloAplicacoesSelecionada : perfilModuloAplicacoesSelecionadas) {
            perfilModuloAplicacoesSelecionada.setStatusModulo(this.statusModulo);
            this.perfilModuloAplicacaoService.salvar(PerfilModuloAplicacao.class, perfilModuloAplicacoesSelecionada);
            this.perfilModuloAplicacoesAdicionadas.add(perfilModuloAplicacoesSelecionada);
        }
        Messages.addGlobalInfo("Alterado com sucesso!");
    }

    private void adicionarPerilModuloAplicacao(Modulo modulo, PerfilUsuario perfilUsuario) {
        List<ModuloAplicacao> listarAplicacaoPorModulo = this.moduloAplicacaoService.listarAplicacaoPorModulo(modulo);
        for (ModuloAplicacao moduloAplicacao : listarAplicacaoPorModulo) {
            PerfilModuloAplicacao perfilModuloAplicacao = new PerfilModuloAplicacao(new PerfilModuloAplicacaoPK(perfilUsuario, modulo, moduloAplicacao.getModuloAplicacaoPK().getAplicacao()),
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
            this.perfilModuloAplicacaoService.salvar(PerfilModuloAplicacao.class, perfilModuloAplicacao);
        }
    }

    public void listarPorModulo() {
        if (modulo == null || this.getEntidade() == null) {
            return;
        }
        this.perfilModuloAplicacaos.clear();
        this.perfilModuloAplicacaos = this.perfilModuloAplicacaoService.listarPerfilModuloAplicacaoPorPerfil(this.getEntidade(), this.modulo);
        for (PerfilModuloAplicacao perfilModuloAplicacao : perfilModuloAplicacaos) {
            this.statusModulo = false;
            if (perfilModuloAplicacao.getStatusModulo()) {
                this.statusModulo = true;
                break;
            }
        }
    }

    public void pesquisarAplicacoes() {
        this.perfilModuloAplicacaos = this.perfilModuloAplicacaoService.pesquisarAplicacoes(this.getEntidade(), this.modulo, pesquisa);
    }

    @Override
    void antesDeInicializar() {
        this.modulos = this.moduloService.listarModulosAtivos();
        this.perfilModuloAplicacaos = new ArrayList<>();
    }

    @Override
    void depoisDeInicializar() {
        this.perfilModuloAplicacoesAdicionadas = new ArrayList<>();
    }

    @Override
    public void salvar() {
        getGenericService().salvar(PerfilUsuario.class, this.getEntidade());
        Messages.addGlobalInfo("salvo com sucesso!");
        this.depoisDeSalvar();
    }

    @Override
    void depoisDeSalvar() {
        if (this.perfilModuloAplicacoesAdicionadas.isEmpty() && !editar) {
            for (Modulo modulo : this.modulos) {
                this.adicionarPerilModuloAplicacao(modulo, this.getEntidade());
            }
        }
        this.setInativo(true);
        this.editar=true;
    }

    @Override
    public void alterar(PerfilUsuario e) {
        if(!this.modulos.isEmpty())
            this.modulo = this.modulos.get(0);
        super.alterar(e);
        this.editar = true;
        listarPorModulo();
    }

    @Override
    public void novo() {
        super.novo();
        this.getEntidade().setStatus(true);
        this.editar = false;
        this.depoisDeInicializar();
    }

    @Override
    public PerfilUsuarioService getGenericService() {
        return this.perfilUsuarioService;
    }
}
