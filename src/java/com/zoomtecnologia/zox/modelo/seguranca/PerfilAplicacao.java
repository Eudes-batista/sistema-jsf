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
@Table(name = "perfil_modulo")
@Getter
@Setter
public class PerfilAplicacao extends Filtro implements EntidadeBase<PerfilAplicacaoPK>, Serializable {

    @EmbeddedId
    private PerfilAplicacaoPK perfilModuloPK;

    @Override
    public PerfilAplicacaoPK getId() {
        return this.perfilModuloPK;
    }
}
