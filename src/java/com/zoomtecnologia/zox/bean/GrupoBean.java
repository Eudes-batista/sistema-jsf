/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupoPK;
import com.zoomtecnologia.zox.servico.GrupoService;
import com.zoomtecnologia.zox.servico.SubGrupoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author eudes
 */
@Service("grupoBean")
@ManagedBean
@Scope("view")
@Getter
@Setter
public class GrupoBean extends GenericoBean<Grupo, GrupoService> {

    private static final long serialVersionUID = 1L;

    @Autowired

    GrupoService grupoService;
    
    @Autowired
    SubGrupoService subGrupoService;

    @Autowired
    private SubgrupoBean subgrupoBean;

    private Map<Grupo, List<SubGrupo>> subgrupoPorGrupo = new HashMap<>();

    private List<SubGrupo> subgrupos;

    private SubGrupo sub;

    @Override
    public void novo() {
        super.novo();
    }

    /**
     * PREENCHE A SUBCONSULTA
     *
     * @param grupo
     * @return List UMA LISTA DE SubGrupo
     */
    public List<SubGrupo> getSubgrupos(Grupo grupo) {
        List<SubGrupo> subgruposPor = subGrupoService.listarPorGrupo(grupo);
        subgrupoPorGrupo.put(grupo, subgruposPor);
        return subgruposPor;
    }

    public void excluirSubgrupo(SubGrupo subGrupo) {
        subgrupoBean.excluir(sub);
    }

    public void salvarSubgrupo() {
        sub.getSubGrupoPK().setGrupo(super.getEntidade());
        subGrupoService.salvar(SubGrupo.class, sub);
        subgrupos = subGrupoService.listarPorGrupo(sub.getSubGrupoPK().getGrupo());
    }

    /**
     * Essa metodo e chamdo quando aperta o link no codigo do frupo da grid e lista os
     * subgrupos referente aquele grupo selecionado
     *
     * @param grupo
     */
    @Override
    public void alterar(Grupo grupo) {
        super.alterar(grupo);
        subgrupos = subGrupoService.listarPorGrupo(grupo);
        sub = new SubGrupo();
        sub.setSubGrupoPK(new SubGrupoPK());
    }
    public void alterarSubgrupo(Grupo grupo) {
        super.alterar(grupo);
        subgrupos = subGrupoService.listarPorGrupo(grupo);
        sub = new SubGrupo();
        sub.setSubGrupoPK(new SubGrupoPK());
    }

    @Override
    public void salvar() {
        super.salvar();
        sub = new SubGrupo();
        sub.setSubGrupoPK(new SubGrupoPK());
    }

    @Override
    public GrupoService getGenericService() {
        return grupoService;
    }

    @Override
    public Grupo createEntidade() {
        return new Grupo();
    }

}
