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

    private PerfilUsuario perfilUsuario;

    @Override
    void antesDeInicializar() {
        this.modulos = this.moduloService.listaTodos(Modulo.class);
        this.perfilModuloAplicacaos = new ArrayList<>();
        this.modulo = this.modulos.get(0);
        this.listarPorModulo();
    }

    @Override
    void depoisDeInicializar() {
        this.perfilModuloAplicacoesAdicionadas = new ArrayList<>();
    }

    public void listarPorModulo() {
        if (modulo == null) {
            return;
        }
        this.perfilModuloAplicacaos.clear();
        if (this.getEntidade() != null && this.getEntidade().getId() != null) {
            this.perfilModuloAplicacaos = this.perfilModuloAplicacaoService.listarPerfilModuloAplicacaoPorPerfil(this.getEntidade(), this.modulo);
        } else {
            List<ModuloAplicacao> listarAplicacaoPorModulo = this.moduloAplicacaoService.listarAplicacaoPorModulo(modulo);
            for (ModuloAplicacao moduloAplicacao : listarAplicacaoPorModulo) {
                this.perfilModuloAplicacaos.add(new PerfilModuloAplicacao(new PerfilModuloAplicacaoPK(this.getEntidade(), modulo, moduloAplicacao.getModuloAplicacaoPK().getAplicacao()),
                        Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));
            }
        }
    }

    public void adicionarPermicao() {
        for (PerfilModuloAplicacao perfilModuloAplicacoesSelecionada : perfilModuloAplicacoesSelecionadas) {
            this.perfilModuloAplicacoesAdicionadas.add(perfilModuloAplicacoesSelecionada);
        }
    }

    @Override
    void antesDeSalvar() {
        this.perfilUsuario = this.getEntidade();
    }

    @Override
    void depoisDeSalvar() {
        for (PerfilModuloAplicacao perfilModuloAplicacoesAdicionada : perfilModuloAplicacoesAdicionadas) {
            perfilModuloAplicacoesAdicionada.getPerfilModuloAplicacaoPK().setPerfilUsuario(perfilUsuario);
            this.perfilModuloAplicacaoService.salvar(PerfilModuloAplicacao.class, perfilModuloAplicacoesAdicionada);
        }
    }

    @Override
    public void novo() {
        super.novo();
        this.getEntidade().setStatus(true);
    }

    @Override
    public PerfilUsuarioService getGenericService() {
        return this.perfilUsuarioService;
    }
}
