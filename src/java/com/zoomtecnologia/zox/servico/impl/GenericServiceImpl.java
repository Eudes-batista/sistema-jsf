
package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.filtros.FiltroGeneric;
import com.zoomtecnologia.zox.modelo.EntityBase;
import com.zoomtecnologia.zox.servico.GenericService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;

public class GenericServiceImpl<E extends EntityBase,F extends FiltroGeneric> implements GenericService<E, F>{

    @PersistenceContext
    private EntityManager entityManager;
    
    public void salvar(E entidade){
       entityManager.persist(entidade);
    }

    public EntityBase buscarPorId(EntityBase base){
        return entityManager.find(base.getClass(), base.getId());
    }
    
    @Override
    public void alterar(E entidade) {
        entityManager.merge(entidade);
    }

    @Override
    public void excluir(E entidade) {
        entityManager.remove(buscarPorId(entidade));
    }

    @Override
    public List<E> filtrados(F filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidadeFiltrados(F filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Criteria criarCriteriaParaFiltro(F filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
