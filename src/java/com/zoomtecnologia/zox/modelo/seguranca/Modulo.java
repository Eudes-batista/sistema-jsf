
package com.zoomtecnologia.zox.modelo.seguranca;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name="modulo")
@Data
@EqualsAndHashCode(callSuper = false, of = "codigo")
@NamedQueries(value={
    @NamedQuery(name = "Modulo.listarModulosAtivos",query = "select m from Modulo m where m.statusModulo=1")
})
public class Modulo extends Filtro implements EntidadeBase<Integer>, Serializable{
    
    @Id
    @Column(name = "codigo", nullable = false, length = 6)
    private Integer codigo;
    
    @Column(name = "nome", nullable = false, length = 15)
    private String nome;
    
    @Column(name = "status_modulo", nullable = false)
    private Boolean statusModulo;

    @Override
    public Integer getId() {
        return this.codigo;
    }
    
}
