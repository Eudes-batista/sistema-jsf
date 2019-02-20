package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.EstadoPK;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.EstadoService;
import com.zoomtecnologia.zox.servico.PaisService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("estadoBean")
@ManagedBean
@Scope("view")
public class EstadoBean extends GenericoBean<Estado, EstadoService> implements Serializable {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private PaisService paisService;

    @Getter
    @Setter
    private List<Pais> paises;

    @Override
    void depoisDeInicializar() {
        this.paises = this.paisService.listaTodos(Pais.class);
    }

    @Override
    public EstadoService getGenericService() {
        return estadoService;
    }

    @Override
    void depoisCriarEntidade() {
        this.getEntidade().setEstadoPK(new EstadoPK());
    }

}
