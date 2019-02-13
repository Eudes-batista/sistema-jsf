package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
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
@EqualsAndHashCode(of = {"usuario","empresa","perfilUsuario"})
public class UsuarioEmpresaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="codigo_usuario", nullable = false)
    @ForeignKey(name="usuario_empresaPKusuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="codigo_empresa", nullable = false)
    @ForeignKey(name="usuario_empresaPKempresa")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name="codigo_perfil", nullable = false)
    @ForeignKey(name="usuario_empresaPKperfil")
    private PerfilUsuario perfilUsuario;
}
