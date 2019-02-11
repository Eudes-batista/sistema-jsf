package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contado")
@Getter
@Setter
public class Contato extends Filtro implements EntidadeBase<ContatoPK>, Serializable {

    @EmbeddedId
    private ContatoPK contatoPK;

    @Length(max = 30, message = "campo nome só pode ter apenas {max} caracteres")
    @Column(length = 30, name = "descricao")
    private String descricao;

    @Override
    public ContatoPK getId() {
        return contatoPK;
    }
}
