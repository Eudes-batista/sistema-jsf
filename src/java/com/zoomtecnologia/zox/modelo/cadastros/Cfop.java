package com.zoomtecnologia.zox.modelo.cadastros;

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
@Table(name = "cfop")
@Data
@EqualsAndHashCode(callSuper = false)
public class Cfop extends Filtro implements EntidadeBase<Integer>, Serializable {

    private static final long serialVersionUID = 1L;

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
     * DESCRICAO COMPLETA DA NATUREZA DA OPERACAO
     */
    @Column(name = "OPDESCRI", length = 30)
    private String descCompNatOp;
    
    @Override
    public Integer getId() {
        return this.codigo;
    }

}
