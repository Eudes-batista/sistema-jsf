/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.filtros.FiltroPais;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;

/**
 *
 * @author Administrador
 */
public interface PaisService extends GenericService<Pais, FiltroPais> {

    public Pais bucarPorId(Integer codigo);
}
