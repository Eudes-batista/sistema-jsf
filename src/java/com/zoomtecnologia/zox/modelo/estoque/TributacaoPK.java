package com.zoomtecnologia.zox.modelo.estoque;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
public class TributacaoPK implements Serializable {

    /**
     * CÓDIGO DA CESTA DE TRIBUTAÇÃO
     */
    @ManyToOne
    @JoinColumn(name = "codigo_cesta_tributacao", nullable = false)
    @ForeignKey(name = "tributacaoFKcesta_tributacao")
    private CestaTributacao cestatributacao;

    /**
     * CÓDIGO DO ESTADO
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo", nullable = false)
        ,@JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais", nullable = false)
    })
    @ForeignKey(name = "tributacaoFKzoxcadestado")
    private Estado estado;

    /**
     * CÓDIGO DO REGIME TRIBUTÁRIO
     */
    @Column(name = "regime_tributario", length = 01, nullable = false, columnDefinition = "enum(1,2,3) default '3'")
    private String regimetributario;

}
