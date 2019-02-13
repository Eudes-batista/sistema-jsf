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
public class PerfilModulo extends Filtro implements EntidadeBase<PerfilModuloPK>, Serializable {

    @EmbeddedId
    private PerfilModuloPK perfilModuloPK;

    @Override
    public PerfilModuloPK getId() {
        return this.perfilModuloPK;
    }
}
