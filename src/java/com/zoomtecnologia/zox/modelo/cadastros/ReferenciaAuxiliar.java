package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "referencia_auxiliar")
@Getter
@Setter
public class ReferenciaAuxiliar extends Filtro implements EntidadeBase<ReferenciaAuxiliarPK>, Serializable {

    @EmbeddedId
    private ReferenciaAuxiliarPK referenciaAuxiliarPK;

    @Override
    public ReferenciaAuxiliarPK getId() {
        return this.referenciaAuxiliarPK;
    }
}
