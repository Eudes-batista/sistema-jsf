package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "permissao")
@Data
@EqualsAndHashCode(callSuper = false, of = {"permissaoPK"})
public class Permissao extends Filtro implements EntidadeBase<PermissaoPK>, Serializable {

    @EmbeddedId
    private PermissaoPK permissaoPK;

    @Column(name = "incluir", nullable = false, columnDefinition = "varchar(1) default 'S'", length = 1)
    private String incluir;

    @Column(name = "excluir", nullable = false, columnDefinition = "varchar(1) default 'S'", length = 1)
    private String excluir;

    @Column(name = "alterar", nullable = false, columnDefinition = "varchar(1) default 'S'", length = 1)
    private String alterar;

    @Column(name = "visualizar", nullable = false, columnDefinition = "varchar(1) default 'S'", length = 1)
    private String visualizar;

    @Override
    public PermissaoPK getId() {
        return this.permissaoPK;
    }

}
