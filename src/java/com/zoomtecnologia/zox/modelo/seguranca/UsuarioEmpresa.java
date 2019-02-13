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
@Table(name = "usuario_empresa")
@Getter
@Setter
public class UsuarioEmpresa extends Filtro implements EntidadeBase<UsuarioEmpresaPK>,Serializable{

   @EmbeddedId
   private UsuarioEmpresaPK usuarioEmpresaPK;

    @Override
    public UsuarioEmpresaPK getId() {
        return this.usuarioEmpresaPK;
    }

}
