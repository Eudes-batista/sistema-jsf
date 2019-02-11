package com.zoomtecnologia.zox.modelo.cadastros.pessoa;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "meta_vendedor")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class Meta extends Filtro implements EntidadeBase<Integer>, Serializable {

    @Id
    @Column(name = "codigo", nullable = false, length = 9)
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo_pessoa", nullable = false)
    @ForeignKey(name = "metaFKvendedor")
    private Vendedor vendedor;

    @Column(name = "meta", nullable = false, precision = 20, scale = 6)
    private Double meta;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicial", nullable = false)
    private Date dataInicial;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_final", nullable = false)
    private Date dataFinal;

    @Override
    public Integer getId() {
        return this.codigo;
    }

}
