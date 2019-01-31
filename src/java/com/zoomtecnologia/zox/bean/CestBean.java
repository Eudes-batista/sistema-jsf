package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Cest;
import com.zoomtecnologia.zox.modelo.estoque.CestPK;
import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.CestService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("cestBean")
@ManagedBean
@Scope("view")
public class CestBean extends GenericoBean<Cest, CestService> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    @Getter
    private CestService cestService;

    @Getter
    @Setter
    private Ncm ncm;

    @Setter
    @Getter
    private List<Cest> cests;

    @Override
    public CestService getGenericService() {
        return this.cestService;
    }

    public List<Cest> listarCestPorNcm(Ncm ncm) {
        return cestService.listarCestPorNcm(ncm);
    }

    @Override
    public void salvar() {
        this.getEntidade().getCestPK().setNcm(ncm);
        super.salvar();
        setCests(this.listarCestPorNcm(ncm));
    }

    @Override
    public Cest createEntidade() {
        Cest cest = new Cest();
        cest.setCestPK(new CestPK());
        return cest;
    }

}
