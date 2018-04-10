package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.EstUnidade;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoomtecnologia.zox.servico.EstUnidadeServico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Service("estUnidadeBean")
@ManagedBean
@Getter
@Setter
public class EstUnidadeBean implements Serializable {

    private EstUnidade estUnidade;
    private List<EstUnidade> unidades;

    @Autowired
    private EstUnidadeServico estUnidadeServico;

    public EstUnidadeBean() {
    }

    @PostConstruct
    public void init() {
        unidades = estUnidadeServico.listarTodos();
    }

}
