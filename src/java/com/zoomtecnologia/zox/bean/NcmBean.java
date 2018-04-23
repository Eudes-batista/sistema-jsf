package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.NcmService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ncmBean")
@ManagedBean
public class NcmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    NcmService ncmService;

    @PostConstruct
    public void init() {
        Ncm ncm = new Ncm();
        ncm.setCodigo("02102000");
        ncm.setDescricao("TESTE DE NCM");
        try {
            ncmService.salvar(Ncm.class, ncm);
            Ncm n = ncmService.buscarPorId(Ncm.class, ncm);
            System.out.println("ncm = " + n);
        } catch (Exception ex) {
            System.out.println("ex = " + ex.getMessage());
        }
    }

}
