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

    /**
     * CODIGO DE OPERACAO FISCAL
     */
    @Id
    @Column(name = "OPCDCFOP", length = 4, nullable = false)
    private Integer codigo;

    /**
     * NATUREZA DA OPERACAO
     */
    @Column(name = "OPDSCFOP", length = 60, nullable = false)
    private String naturezaOperacao;

    /**
     * CODIGO DO COP (CLASSE DA OPERACAO OU PRESTACAO)
     */
    @Column(name = "OPCODCOP", length = 4, nullable = false)
    private String codigocop;

    /**
     * DESCRICAO DO COP (CLASSE DA OPERACAO OU PRESTACAO)
     */
    @Column(name = "OPDESCOP", length = 30, nullable = false)
    private String descricaocop;

    /**
     * DESCRICAO COMPLETA DA NATUREZA DA OPERACAO
     */
    @Column(name = "OPDESCRI", length = 30, nullable = false)
    private String descCompNatOp;

}
