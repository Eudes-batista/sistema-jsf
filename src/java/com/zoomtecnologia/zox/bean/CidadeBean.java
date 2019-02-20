package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Cidade;
import com.zoomtecnologia.zox.modelo.cadastros.CidadePK;
import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.servico.CidadeService;
import com.zoomtecnologia.zox.servico.EstadoService;
import java.io.Serializable;
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
@Service("cidadeBean")
@ManagedBean
@Scope("view")
public class CidadeBean extends GenericoBean<Cidade, CidadeService> implements Serializable {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @Getter
    @Setter
    private List<Estado> estados;

    @Override
    void antesDeInicializar() {
        estados=estadoService.listaTodos(Estado.class);
    }

    @Override
    public CidadeService getGenericService() {
        return cidadeService;
    }

    @Override
    void depoisCriarEntidade() {
        this.getEntidade().setCidadePK(new CidadePK());
    }

}
