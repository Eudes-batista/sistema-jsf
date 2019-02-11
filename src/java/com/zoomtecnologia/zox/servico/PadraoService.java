package com.zoomtecnologia.zox.servico;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PadraoService<E> extends Serializable {

    public E buscarPorId(Class<E> classe, E e);

    public void salvar(Class<E> classe, E entidade);

    public void alterar(E entidade);

    public void excluir(Class<E> classe, E entidade);

    public List<E> listaTodos(Class<E> classe);

}
