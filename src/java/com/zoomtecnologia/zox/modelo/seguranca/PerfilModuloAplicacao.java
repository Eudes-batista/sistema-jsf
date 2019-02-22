package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "perfil_modulo_aplicacao")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PerfilModuloAplicacao extends Filtro implements EntidadeBase<PerfilModuloAplicacaoPK>, Serializable {

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
    @Column(name = "status_aplicacao", nullable = false)
    private Boolean statusAplicacao;
    @Column(name = "status_modulo", nullable = false)
    private Boolean statusModulo;

    @Override
    public PerfilModuloAplicacaoPK getId() {
        return this.perfilModuloAplicacaoPK;
    }

}
