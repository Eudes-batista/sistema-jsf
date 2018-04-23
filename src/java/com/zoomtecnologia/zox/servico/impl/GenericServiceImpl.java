package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.EntityBase;
import com.zoomtecnologia.zox.servico.PadraoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericServiceImpl<E extends EntityBase> implements PadraoService<E> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public E buscarPorId(Class<E> classe, E e) {
        return entityManager.find(classe, e.getId());
    }

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

    public void excluir(Class<E> classe, E entidade) {
        entityManager.remove(buscarPorId(classe, entidade));
    }

    public List<? extends EntityBase> listarTodos(E e) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends EntityBase> createQuery = builder.createQuery(e.getClass());
        createQuery.from(e.getClass());
        return entityManager.createQuery(createQuery).getResultList();
    }

}
