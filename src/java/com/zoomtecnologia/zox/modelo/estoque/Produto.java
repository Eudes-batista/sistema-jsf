package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "produto")
@Data
@NamedQueries({
    @NamedQuery(name = "Produto.buscarDescricao", query = "select p from Produto p where p.descricao like :descricao")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "referencia", length = 20, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_ncm", nullable = false)
    @ForeignKey(name = "produtoFKncm")
    private Ncm ncm;

    @Column(name = "codigo_cest", length = 7, nullable = true)
    private Integer cest;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = SubGrupo.class)
    @JoinColumns({
        @JoinColumn(name = "codigo_subgrupo", referencedColumnName = "codigo", nullable = false)
        ,@JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo_grupo", nullable = false)
    })
    @ForeignKey(name = "produtoFKsubgrupo")
    private SubGrupo subGrupo;

    @Column(name = "descricao", length = 120, nullable = false)
    private String descricao;

    @Column(name = "aplicacao", nullable = true, columnDefinition = "text")
    private String aplicacao;

    @Column(name = "tipo", nullable = true, columnDefinition = "enum(P,S) default 'P'")
    private String tipo;

    @Column(name = "ultima_atualizacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao;

    @Column(name = "fabricante", length = 20, nullable = true)
    private String fabricante;

    @Column(name = "produtor", length = 20, nullable = true)
    private String produtor;

    @Column(name = "dias_vencimento", length = 5, nullable = true)
    private String diasVencimento;

    @Column(name = "iat", nullable = false, columnDefinition = "enum(A,T) default 'A'")
    private String iat;

    @Column(name = "balanca", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    private String balanca;

    @Column(name = "informacoes_nutricionais", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    private String informacaoNutricional;

    @Column(name = "imprime_data_validade", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    private String imprimiDataValidade;

    @Column(name = "classe_enquadramento_ipi", length = 5, nullable = true)
    private String classeEnquadramentoIpi;

    @Column(name = "selo", length = 60, nullable = true)
    private String codigoSelo;

    @Column(name = "ean_tributacao", length = 20, nullable = true)
    private String eanTributacao;

    @Column(name = "embalagem_principal", length = 20, nullable = false)
    private String codigoEmbalagemPrincipal;

    @ManyToOne
    @JoinColumn(name = "cogido_unidade", nullable = false)
    @ForeignKey(name = "unidadeFKproduto")
    private Unidade unidade;

    @Column(name = "fator_multiplicacao", precision = 5, scale = 3, nullable = false)
    private Double fatorMultiplicacao;

}
