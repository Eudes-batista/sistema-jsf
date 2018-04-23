package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author eudes
 */
@Embeddable
@Getter
@Setter
public class LocalEstoquePK implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * CODIGO DO LOCAL DO ESTOQUE
     */
    @Column(name = "ELCODLOC", length = 4, nullable = false)
    private Integer codigo;

    /**
     * CODIGO DO PRODUTO
     */
    @ManyToOne
    @JoinColumn(name = "ELREFPRO", nullable = false)
    @ForeignKey(name = "local_estoqueFKproduto")
    Produto produto;

}
