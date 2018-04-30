/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
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
    private GrupoService grupoService;

    @Autowired
    private SubGrupoService subGrupoService;

    private Map<Grupo, List<SubGrupo>> subgrupoPorGrupo = new HashMap<>();

    private boolean modoAtualizacao = false;

    private List<SubGrupo> subgrupos;

    @Override
    public void novo() {
        super.novo();
        modoAtualizacao = false;
    }

    public List<SubGrupo> getSubgrupos(Grupo grupo) {
        List<SubGrupo> subgrupos = subGrupoService.listarPorGrupo(grupo);
        subgrupoPorGrupo.put(grupo, subgrupos);
        return subgrupos;
    }

    public void excluirSubgrupo(SubGrupo subGrupo) {
        subGrupoService.excluir(SubGrupo.class, subGrupo);

    }

    @Override
    public void alterar(Grupo e) {
        super.alterar(e);
        subgrupos = subGrupoService.listarPorGrupo(e);
    }

    @Override
    public void salvar() {
        super.salvar();
        modoAtualizacao = true;
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
