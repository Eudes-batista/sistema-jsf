package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.EstUnidade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zoomtecnologia.zox.servico.EstUnidadeServico;
import java.util.List;
import org.omnifaces.util.Messages;

@Service("EstUnidadeServico")
@Transactional
public class EstUnidadeServicoImpl implements EstUnidadeServico {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(EstUnidade estUnidade){
        try {
            if (buscarId(estUnidade.getUncodigo()) == null) {
                entityManager.persist(estUnidade);
            } else {
                alterar(estUnidade);
            }
        } catch (Exception ex) {
            Messages.addGlobalError("Erro ao salvar unidade");
        }
    }

    @Override
    public List<EstUnidade> listarTodos() {
        return entityManager.createQuery("select unidade from EstUnidade unidade", EstUnidade.class).getResultList();
    }

    @Override
    public void alterar(EstUnidade estUnidade) {
        entityManager.merge(estUnidade);
    }

    @Override
    public void excluir(EstUnidade estUnidade) {
        entityManager.remove(buscarId(estUnidade.getUncodigo()));
    }

    @Override
    public EstUnidade buscarId(String uncodigo) {
        return entityManager.find(EstUnidade.class, uncodigo);
    }

    @Override
    public List<EstUnidade> buscarDescricao(String undescri) {
        return entityManager
                .createQuery("select unidade from EstUnidade unidade where unidade.undescri like :undescri"
                        , EstUnidade.class)
                .setParameter("undescri","%"+undescri+"%")
                .getResultList();
    }

}
