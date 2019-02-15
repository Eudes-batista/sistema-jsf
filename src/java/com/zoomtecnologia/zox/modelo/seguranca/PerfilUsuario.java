
package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "perfil_usuario")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class PerfilUsuario extends Filtro implements EntidadeBase<Integer>, Serializable{
 
    @Id
    @Column(name = "codigo", nullable = false, length = 3)
    private Integer codigo;
      
    @Column(name = "descricao", nullable = false, length = 20)
    private String descricao;
    
    @Column(name = "obs", nullable = false, length = 120)
    private String obs;
    
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "desconto", nullable = false, precision = 6, scale = 3)
    private Double desconto;
    
    @Column(name = "acrescimo", nullable = false, precision = 6, scale = 3)
    private Double acrescimo;

    @Override
    public Integer getId() {
        return this.codigo;
    }
    
}
