package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cest")
@Data
@NamedQueries({
    @NamedQuery(name = "Cest.listarTodos", query = "select c from Cest c")
    ,@NamedQuery(name = "Cest.buscarPorDescricao", query = "select c from Cest c where c.descricao like :descricao")
})
public class Cest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DO CEST
     */
    @EmbeddedId
    CestPK cestPK;
    
    /**
     * DESCRICAO DO CEST
     */
    @Column(name = "CEDESCEST", length = 1024, nullable = true)
    private String descricao;

}
