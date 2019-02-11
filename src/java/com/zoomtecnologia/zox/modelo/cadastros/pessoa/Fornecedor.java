/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.cadastros.pessoa;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "fornecedor")
@Data
@EqualsAndHashCode(callSuper = false, of="pessoa")
public class Fornecedor extends Filtro implements Serializable,EntidadeBase<Pessoa>{

    @Id
    @OneToOne
    @JoinColumn(name="codigo_pessoa", nullable = false)
    @ForeignKey(name="fornecedorFKpessoa")
    private Pessoa pessoa;
    
    @Column(name="ultima_nota", length = 9)
    private Integer ultimaNota;
    
    @Column(name="ultimo_pedido", length = 9)
    private Integer ultimoPedido;
    
    @Column(name="prazo_entrega", length = 3)
    private Integer prazoEntrega;
    
    @Column(name="limite_compra", precision = 10, scale = 3)
    private Double limiteCompra;

    @Column(length = 1, name = "status", columnDefinition = "varchar(1) default 'A' ", nullable = false)
    private String status;

    @Override
    public Pessoa getId() {
        return this.pessoa;
    }

}
