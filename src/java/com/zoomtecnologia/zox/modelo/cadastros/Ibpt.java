/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "ibpt")
@Data
@NamedQueries({
    @NamedQuery(name="Ibpt.listarTodos",query="select i from Ibpt i order by i.siglaEstado"),
    @NamedQuery(name="Ibpt.buscarPorEstado",query="select i from Ibpt i where i.siglaEstado = :siglaEstado order by i.siglaEstado")
})
public class Ibpt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "IBESTADO",length = 2,nullable = false)        
    private String siglaEstado;
    
    @Id
    @Column(name = "IBCODIGO",length = 12,nullable = false)        
    private String codigo;
    
    @Id
    @Column(name = "IBCODIEX",length = 2,nullable = false)        
    private String codigoExtra;
    
    @Id
    @Column(name = "IBNRTIPO",length = 2,nullable = false)               
    private String tipo;
    
    @Column(name = "IBCODNCM",length = 8)        
    private String ncm;
    
    @Column(name = "IBDESCRI",length = 12)        
    private String descricao;
    
    @Column(name = "IBNACFED",precision = 6,scale = 3)        
    private Double aliquotaFerderalNacional;
    
    @Column(name = "IBIMPFED",precision = 6,scale = 3)        
    private Double aliquotaFerderalImportacao;
    
    @Column(name = "IBALQEST",precision = 6,scale = 3)        
    private Double aliquotaEstadual;
    
    @Column(name = "IBALQMUN",precision = 6,scale = 3)        
    private Double aliquotaMunicipal;
    
    @Column(name = "IBDATINI")        
    @Temporal(TemporalType.DATE)        
    private Date dataInicialVigencia;
    
    @Column(name = "IBDATFIM")        
    @Temporal(TemporalType.DATE)        
    private Date dataFinalVigencia;
    
    @Column(name = "IBNCHAVE",length = 10)        
    private String numeroDaChave;
    
    @Column(name = "IBVERSAO",length = 10)        
    private String versao;
    
    @Column(name = "IBDSFONT",length = 20)        
    private String fonteInformacao;
    
}
