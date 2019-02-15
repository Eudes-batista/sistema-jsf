package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.EntidadeBase;
import com.zoomtecnologia.zox.servico.PadraoService;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericServiceImpl<E extends EntidadeBase> implements PadraoService<E> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public E buscarPorId(Class<E> classe, E e) {
        return entityManager.find(classe, e.getId());
    }

    @Override
    public void salvar(Class<E> classe, E entidade) {
        E e = null;
        if (entidade.getId() == null) {
            try {
                verificarCampo(entidade, gerarId(classe));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                throw new IllegalArgumentException("Erro ao setar valor no codigo");
            }
        } else {
            e = buscarPorId(classe, entidade);
        }
        if (e == null) {
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

    @Override
    public List<E> listaTodos(Class<E> classe) {
        return entityManager.createQuery("select e from " + classe.getSimpleName() + " e", classe).getResultList();
    }

    @Override
    public Object gerarId(Class<E> classe) {
        String tabela = classe.getSimpleName();
        tabela = gerarNomeDaTabela(tabela);
        Session session = (Session) this.entityManager.unwrap(Session.class);
        SQLQuery sQLQuery = session.createSQLQuery("select codigo from " + tabela + " order by codigo desc limit 1");
        Object codigo = sQLQuery.uniqueResult();
        if (codigo == null) {
            codigo = 0;
        }
        codigo = ((Integer) codigo + 1);
        return  codigo;
    }

    private static String gerarNomeDaTabela(String tabela) {
        String palavra = "";
        for (int i = 0; i < tabela.length(); i++) {
            char letra = tabela.charAt(i);
            if (Character.isUpperCase(letra)) {
                palavra += "_" + letra;
                continue;
            }
            palavra += letra;
        }
        return palavra.toLowerCase().replaceFirst("_", "");
    }

    private void verificarCampo(Object campo, Object value) throws IllegalArgumentException, IllegalAccessException {
        Class<?> classe = campo.getClass();
        if (classe != null) {
            Field[] fields = classe.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    field.set(campo, value);
                    break;
                }
            }
        }
    }

}
