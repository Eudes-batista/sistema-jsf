package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Unidade;
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
    public void salvar(Unidade unidade) {

        if (buscarId(unidade.getCodigo()) == null) {
            entityManager.persist(unidade);
        } else {
            alterar(unidade);
        }

    }

    @Override
    public void alterar(Unidade unidade) {
        entityManager.merge(unidade);
    }

    @Override
    public Unidade buscarId(String codigo) {
        return entityManager.find(Unidade.class, codigo);
    }

    @Override
    public void excluir(Unidade unidade) {
        entityManager.remove(buscarId(unidade.getCodigo()));
    }

    @Override
    public List<Unidade> listarTodos() {
        return entityManager.createNamedQuery("Unidade.listarTodos", Unidade.class).getResultList();
    }

    @Override
    public List<Unidade> bucarDescricao(String descricao) {
        return entityManager.createNamedQuery("Unidade.buscarDescricao",
                Unidade.class).setParameter("descricao", "%" + descricao + "%").getResultList();

    }

}
