package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "conta")
@Getter
@Setter
public class Conta extends Filtro implements EntidadeBase<ContatoPK>, Serializable {

    @EmbeddedId
    private ContatoPK contatoPK;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "agencia", nullable = true, length = 10)
    private String agencia;

    @Column(name = "digito_agencia", nullable = true, length = 2)
    private String digitoAgencia;

    @Column(name = "conta", nullable = true, length = 10)
    private String conta;

    @Column(name = "digito_conta", nullable = true, length = 2)
    private String digitoConta;

    @Column(name = "saldo", nullable = true, precision = 20, scale = 6)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "codigo_banco", nullable = false)
    @ForeignKey(name = "contaFKbanco")
    private Banco banco;

    @Override
    public ContatoPK getId() {
        return this.contatoPK;
    }

}
