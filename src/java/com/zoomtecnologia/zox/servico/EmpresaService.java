/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wagner
 */
@Repository
public interface EmpresaService extends EntidadeService<Empresa>{
    
    public Empresa buscarPorEmpresa(Empresa empresa);
    
}
