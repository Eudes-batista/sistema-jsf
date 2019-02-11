package com.zoomtecnologia.zox.modelo.estoque;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cest")
@Getter @Setter
@NamedQueries({
    @NamedQuery(name = "Cest.listarTodos", query = "select c from Cest c")
    ,@NamedQuery(name = "Cest.buscarPorDescricao", query = "select c from Cest c where c.descricao like :descricao")
    ,@NamedQuery(name = "Cest.listarCestPorNcm", query = "select c from Cest c where c.cestPK.ncm like :ncm")
})
public class Cest extends Filtro implements EntidadeBase<CestPK>,Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DO CEST
     */
    @EmbeddedId
    private CestPK cestPK;
    
    /**
     * DESCRICAO DO CEST
     */
    @Column(name = "descricao", length = 1024, nullable = true)
    private String descricao;

    @Override
    public CestPK getId() {
        return this.cestPK;
    }

}
