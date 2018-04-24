package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import com.zoomtecnologia.zox.modelo.EntidadeBase;

@Entity
@Table(name = "contado")
@Data
@EqualsAndHashCode(callSuper = false)
public class Contato extends Filtro implements EntidadeBase<ContatoPK>, Serializable {

    @EmbeddedId
    ContatoPK contatoPK;

    @Length(max = 30, message = "campo nome só pode ter apenas {max} caracteres")
    @Column(length = 30, name = "CPDESCRI")
    String descricao;

    @Override
    public ContatoPK getId() {
        return contatoPK;
    }
}
