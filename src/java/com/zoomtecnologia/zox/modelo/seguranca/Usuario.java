
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
@Table(name = "usuario")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class Usuario extends Filtro implements EntidadeBase<String>, Serializable{

    @Id
    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;
    
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    
    @Column(name = "senha", nullable = false, length = 10)
    private String senha;
    
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Override
    public String getId() {
        return this.codigo;
    }
    
}
