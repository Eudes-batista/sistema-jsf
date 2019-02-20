package com.zoomtecnologia.zox.modelo.seguranca;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "perfil_modulo_aplicacao")
@Getter
@Setter
@ToString
public class PerfilModuloAplicacao implements Serializable {

    @EmbeddedId
    private PerfilModuloAplicacaoPK perfilModuloAplicacaoPK;

    @Column(name = "consultar", nullable = false)
    private Boolean consultar;
    @Column(name = "incluir", nullable = false)
    private Boolean incluir;
    @Column(name = "alterar", nullable = false)
    private Boolean alterar;
    @Column(name = "excluir", nullable = false)
    private Boolean excluir;

}
