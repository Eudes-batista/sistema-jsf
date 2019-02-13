package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modulo_aplicacao")
@Getter
@Setter
public class ModuloAplicacao extends Filtro implements EntidadeBase<ModuloAplicacaoPK>, Serializable {

    @EmbeddedId
    private ModuloAplicacaoPK moduloAplicacaoPK;

    @Override
    public ModuloAplicacaoPK getId() {
        return this.moduloAplicacaoPK;
    }

}
