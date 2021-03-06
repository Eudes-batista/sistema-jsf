package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.SubGrupo;
import com.zoomtecnologia.zox.modelo.estoque.SubGrupoPK;
import com.zoomtecnologia.zox.servico.SubGrupoService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("subgrupoBean")
@ManagedBean
@Scope("view")
public class SubgrupoBean extends GenericoBean<SubGrupo, SubGrupoService> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    @Getter
    private SubGrupoService subGrupoService;

    @Override
    public SubGrupoService getGenericService() {
        return this.subGrupoService;
    }

    @Override
    void depoisCriarEntidade() {
        this.getEntidade().setSubGrupoPK(new SubGrupoPK());
    }
}
