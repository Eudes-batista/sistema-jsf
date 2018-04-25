package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.EntidadeBase;
import com.zoomtecnologia.zox.servico.PadraoService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericServiceImpl<E extends EntidadeBase> implements PadraoService<E> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public E buscarPorId(Class<E> classe, E e) {
        return entityManager.find(classe, e.getId());
    }

    @Override
    public void salvar(Class<E> classe, E entidade) {
        E e = buscarPorId(classe, entidade);
        if (e == null) {
            System.out.println("e = " + entidade);
            entityManager.persist(entidade);
        } else {
            alterar(entidade);
        }
    }

    @Override
    public void alterar(E entidade) {
        entityManager.merge(entidade);
    }

    @Override
    public void excluir(Class<E> classe, E entidade) {
        entityManager.remove(buscarPorId(classe, entidade));
    }
}
