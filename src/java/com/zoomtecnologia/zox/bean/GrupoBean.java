package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Grupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupoPK;
import com.zoomtecnologia.zox.servico.GrupoService;
import com.zoomtecnologia.zox.servico.SubGrupoService;
import java.util.List;
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

    @Autowired
    private SubgrupoBean subgrupoBean;

    private List<SubGrupo> subgrupos;

    private SubGrupo sub;
    
    @Override
    public void novo() {
        super.novo();
    }

    /*Metodos referente ao cadastro de subgrupo*/
    public void salvarSubgrupo() {
        sub.getSubGrupoPK().setGrupo(super.getEntidade());
        subgrupoBean.setEntidade(sub);
        subgrupoBean.salvar();
        listarSubgrupos(super.getEntidade());
    }

    public void alterarSubgrupo(SubGrupo subGrupo) {
        this.sub = subGrupo;
    }

    public void excluirSubgrupo(SubGrupo subGrupo) {
        subgrupoBean.setEntidade(subGrupo);
        subgrupoBean.excluir(subGrupo);
        listarSubgrupos(subGrupo.getSubGrupoPK().getGrupo());
    }

    public void listarSubgrupos(Grupo grupo) {
        super.setEntidade(grupo);
        subgrupos = subGrupoService.listarPorGrupo(grupo);
        sub = new SubGrupo();
        sub.setSubGrupoPK(new SubGrupoPK());
    }

    /* fim */

    @Override
    public GrupoService getGenericService() {
        return grupoService;
    }

    @Override
    public Grupo createEntidade() {
        return new Grupo();
    }

}
