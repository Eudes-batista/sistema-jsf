/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "forma_pagamento_entrada")
@Data
@EqualsAndHashCode(callSuper = false, of = {"codigo"})
public class FormaPagamentoEntrada extends Filtro implements EntidadeBase<Integer>, Serializable{
   
    @Id
    @Column(name = "codigo", nullable = false, length = 3)
    private Integer codigo; 
    
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @Column(name = "taxa", nullable = true, precision = 6, scale = 3)
    private Double taxa;
    
    @Column(name = "prazo_recebimento", nullable = true, length = 3)
    private Integer prazoRecebimento;
    
    @Column(name = "intervalo", nullable = true, length = 3)
    private Integer intervalo;

    @Column(name = "numero_parcelas", nullable = true, length = 3)
    private Integer numeroParcelas;

    @ManyToOne
    @JoinColumn(name = "codigo_empresa", nullable = false)
    @ForeignKey(name= "forma_pagamento_entradaFKempresa")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name = "tipo_pagamento", nullable = false)
    @ForeignKey(name= "forma_pagamento_entradaFKtipo_pagamento")
    private TipoPagamento tipo;

    @Override
    public Integer getId() {
        return this.codigo;
    }
    
    
}
