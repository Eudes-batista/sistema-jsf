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
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = false, of = {"pessoa"})
public class Cliente extends Filtro implements EntidadeBase<Pessoa>, Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "codigo_pessoa", nullable = false)
    @ForeignKey(name = "clienteFKpessoa")
    private Pessoa pessoa;

    @Column(name = "limite_credito", nullable = true, precision = 10, scale = 3)
    private Double limiteCredito;

    @Column(name = "ultima_nota", nullable = true, length = 9)
    private Integer ultimaNota;

    @Column(name = "ultimo_pedido", nullable = true, length = 9)
    private Integer ultimoPedido;

    @Column(name = "ultimo_orcamento", nullable = true, length = 9)
    private Integer ultimoOrcamento;
    
    @Column(name = "dia_vencimeto", nullable = true, length = 2)
    private Integer diaVencimento;

    @Column(length = 1, name = "status", columnDefinition = "varchar(1) default 'A' ", nullable = false)
    private String status;

    @Column(name = "obs", nullable = true, length = 255)
    private String obs;

    @Override
    public Pessoa getId() {
        return this.pessoa;

    }
}
