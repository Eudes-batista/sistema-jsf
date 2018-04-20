package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "zoxcadcfop")
@Data
public class Cfop implements Serializable {
    
    @Id
    @Column(name = "OPCDCFOP", length = 4, nullable = false)
    private Integer codigo;

    @Column(name = "OPDSCFOP", length = 60, nullable = false)
    private String naturezaOperacao;

    @Column(name = "OPCODCOP", length = 4, nullable = false)
    private String codigocop;

    @Column(name = "OPDESCOP", length = 30, nullable = false)
    private String descricaocop;

    @Column(name = "OPDESCRI", length = 30, nullable = false)
    private String descCompNatOp;

}
