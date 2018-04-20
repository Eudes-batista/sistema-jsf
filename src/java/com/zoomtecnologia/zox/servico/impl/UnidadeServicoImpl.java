package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Unidades;
import com.zoomtecnologia.zox.servico.UnidadeServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("unidadeServico")
@Transactional
public class UnidadeServicoImpl implements UnidadeServico {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Unidades unidade) {

        if (buscarId(unidade.getCodigo()) == null) {
            entityManager.persist(unidade);
        } else {
            alterar(unidade);
        }

    }

    @Override
    public void alterar(Unidades unidade) {
        entityManager.merge(unidade);
    }

    @Override
    public Unidades buscarId(String codigo) {
        return entityManager.find(Unidades.class, codigo);
    }

    @Override
    public void excluir(Unidades unidade) {
        entityManager.remove(buscarId(unidade.getCodigo()));
    }

    @Override
    public List<Unidades> listarTodos() {
        return entityManager.createNamedQuery("Unidade.listarTodos", Unidades.class).getResultList();
    }

    @Override
    public List<Unidades> bucarDescricao(String descricao) {
        return entityManager.createNamedQuery("Unidade.buscarDescricao",
                Unidades.class).setParameter("descricao", "%" + descricao + "%").getResultList();

    }

}
