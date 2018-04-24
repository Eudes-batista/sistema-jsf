/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Contato;
import com.zoomtecnologia.zox.modelo.cadastros.ContatoPK;
import com.zoomtecnologia.zox.modelo.cadastros.TipoContato;
import com.zoomtecnologia.zox.servico.ContatoService;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service("contatoBean")
@ManagedBean
@Scope("view")
public class ContatoBean extends GenericoBean<Contato, ContatoService> {

    @Autowired
    ContatoService contatoService;

    @Getter
    @Setter
    List<TipoContato> tipoContatos;

    @Override
    public void inicializar() {
        this.tipoContatos = Arrays.asList(TipoContato.values());
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContatoService getGenericService() {
        return contatoService;
    }

    @Override
    public Contato createEntidade() {
        Contato contato = new Contato();
        contato.setContatoPK(new ContatoPK());
        return contato;
    }

}
