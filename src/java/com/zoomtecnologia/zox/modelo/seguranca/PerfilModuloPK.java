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
@EqualsAndHashCode(of = {"modulo", "perfilUsuario"})
public class PerfilModuloPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "codigo_perfil_usuario", nullable = false)
    @ForeignKey(name = "perfil_moduloPKperfil_usuario")
    private PerfilUsuario perfilUsuario;
    
    @ManyToOne
    @JoinColumn(name = "codigo_modulo", nullable = false)
    @ForeignKey(name = "perfil_moduloPKmodulo")
    private Modulo modulo;

}
