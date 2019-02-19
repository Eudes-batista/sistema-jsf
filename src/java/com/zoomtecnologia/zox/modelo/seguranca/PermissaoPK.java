package com.zoomtecnologia.zox.modelo.seguranca;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(of = {"perfilAplicacao"})
public class PermissaoPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="codigo_perfil_aplicacao", nullable = false)
    @ForeignKey(name="permissaoPKperfil_aplicacao")
    private PerfilAplicacao perfilAplicacao;
   
}
