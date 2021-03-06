package com.zoomtecnologia.zox.modelo.cadastros.pessoa;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import com.zoomtecnologia.zox.modelo.cadastros.pessoa.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "vendedor")
@Data
@EqualsAndHashCode(callSuper = false, of = {"pessoa"})
public class Vendedor extends Filtro implements EntidadeBase<Pessoa>, Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa", nullable = false)
    @ForeignKey(name = "vendedorFKpessoa")
    private Pessoa pessoa;

    @Column(name = "comissao_vendas", nullable = true, precision = 20, scale = 6)
    private Double comissaoVendas;

    @Column(name = "comissao_produto", nullable = true, precision = 20, scale = 6)
    private Double comissaoProduto;

    @Column(name = "comissao_servico", nullable = true, precision = 20, scale = 6)
    private Double comissaoServico;

    @Column(name = "porcentagem_ou_valor", nullable = false, length = 1, columnDefinition = "varchar(1) dafault 'P'")
    private String porcentagemOuValor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendedor")
    private List<Meta> metas = new ArrayList<>();

    @Override
    public Pessoa getId() {
        return this.pessoa;
    }

}
