package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tipomovimento")
@Data
public class TipoDeMovimento implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * Codigo do Tipo de Movimento
     */
    @Id
    @Column(name="ETCODIGO",length = 4,nullable = false)
    private Integer codigo;
    
    /**
     * SIGLA DO TIPO DE MOVIMENTO
     */
    @Column(name="ETSIGMOV",length = 4,nullable = false)
    private String siglaMovimento;
    
    /**
     * DESCRICAO DO TIPO DE MOVIMENTO
     */
    @Column(name="ETDESCRI",length = 50,nullable = false)
    private String descricao;
    
    /**
     * SELECAO DO TIPO DE MOVIMENTO
     */
    @Column(name="ETTIPMOV",length = 1,nullable = false,columnDefinition = "enum(E,S) default 'E'")
    private String tipoMovimento;
    
    /**
     * JUSTAR O CUSTO SIM OU NAO NO TIPO DE MOVIMENTO
     */
    @Column(name="ETACUSTO",length = 1,nullable = false,columnDefinition = "enum(A,N,Q,V) default 'N'")
    private String ajustarCusto;
    
    /**
     * PERMITE MOVIMENTOS COM VALOR ZERADO (S) SIM ou (N) NAO
     */
    @Column(name="ETMVZERO",length = 1,nullable = false,columnDefinition = "enum(N,S) default 'S'")
    private String permiteMovimento;
    
    /**
     * PERMITE USAR NAS TELAS DE AJUSTE DE ESTOQUE (S) SIM ou (N) NAO
     */
    @Column(name="ETAJUEST",length = 1,nullable = false,columnDefinition = "enum(N,S) default 'S'")
    private String permitirUsarNaTela;
    
    /**
     * PERMITE USAR EM TELAS DE VENDAS (S) SIM ou (N) NAO
     */
    @Column(name="ETVENDAS",length = 1,nullable = false,columnDefinition = "enum(N,S) default 'S'")
    private String permitirUsarTelaVenda;
    
    /**
     * PERMITE USAR EM TELAS DE COMPRAS (S) SIM ou (N) NAO
     */
    @Column(name="ETCOMPRA",length = 1,nullable = false,columnDefinition = "enum(N,S) default 'S'")
    private String permitirUsarTelaCompra;
    
    /**
     * PERMITE USAR EM TELAS DE PRODUCAO (S) SIM ou (N) NAO
     */
    @Column(name="ETPRODUC",length = 1,nullable = false,columnDefinition = "enum(N,S) default 'S'")
    private String permitirUsarTelaProducao;
    
    /**
     * CFOP DO MOVIMENTO DENTRO DO ESTADO
     */
    @Column(name="ETCFOPDE",length = 4,nullable = false)
    private Integer cfopDentroEsatdo;
    
    /**
     * CFOP DO MOVIMENTO Fora DO ESTADO
     */
    @Column(name="ETCFOPFE",length = 4,nullable = false)
    private Integer cfopForaEsatdo;
    
    /**
     * CFOP DO MOVIMENTO FORA DO PAIS
     */
    @Column(name="ETCFOPFP",length = 4,nullable = false)
    private Integer cfopForaPais;

}
