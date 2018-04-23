
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
public class NcmBean implements Serializable{

    @Autowired
    NcmService ncmService;
    
    @PostConstruct
    public void init(){
        Ncm ncm = new Ncm();
        ncm.setCodigo("12345678");
        ncm.setDescricao("TESTE DE NCM");
        try{
            ncmService.salvar(ncm);
        }catch(Exception ex){
            System.out.println("ex = " + ex.getMessage());
        }
    }
    
}
