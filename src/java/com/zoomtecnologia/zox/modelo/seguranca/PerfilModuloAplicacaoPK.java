package com.zoomtecnologia.zox.modelo.seguranca;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PerfilModuloAplicacaoPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="codigo_perfil_usuario",nullable = false)
    @ForeignKey(name="perfil_modulo_aplicacaoFKperfil_usuario")
    private PerfilUsuario perfilUsuario;
    
    @ManyToOne
    @JoinColumn(name="codigo_modulo",nullable = false)
    @ForeignKey(name="perfil_modulo_aplicacaoFKmodulo")
    private Modulo modulo;
        
    @ManyToOne
    @JoinColumn(name="codigo_aplicacao",nullable = false)
    @ForeignKey(name="perfil_modulo_aplicacaoFKaplicacao")
    private Aplicacao aplicacao;
    
}
