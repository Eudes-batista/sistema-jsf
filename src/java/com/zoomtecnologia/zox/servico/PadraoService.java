/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.servico;

import com.zoomtecnologia.zox.modelo.EntityBase;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface PadraoService<E> extends Serializable {

    public E buscarPorId(Class<E> classe, E e);

    public void salvar(Class<E> classe, E entidade);

    public void alterar(E entidade);

    public void excluir(Class<E> classe, E entidade);

    public List<? extends EntityBase> listarTodos(E e);

}
