package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.EntityBase;
import com.zoomtecnologia.zox.servico.GenericService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;

public class GenericServiceImpl<E extends EntityBase> implements GenericService<E> {

    @PersistenceContext
    private EntityManager entityManager;

    public E buscarPorId(E e) {
        System.out.println("buscarPorId = " + e.getClass().getSimpleName());
        return (E) entityManager.find(e.getClass(), e.getId());
    }

    @Override
    public void salvar(E entidade) {
         E e =buscarPorId(entidade);
         System.out.println("salvar = " + e);
        if (e == null) {
            System.out.println("salvar = " + entidade.getClass().getSimpleName());
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
    public void excluir(E entidade) {
        entityManager.remove(buscarPorId(entidade));
    }

    public List<? extends EntityBase> listarTodos(E e) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends EntityBase> createQuery = builder.createQuery(e.getClass());
        createQuery.from(e.getClass());
        return entityManager.createQuery(createQuery).getResultList();
    }

    @Override
    public List<E> listarTodos() {
        return null;
    }

    @Override
    public List<E> filtrados(E filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidadeFiltrados(E filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Criteria criarCriteriaParaFiltro(E filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
