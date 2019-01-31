package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "empresa")
@Data
@EqualsAndHashCode(callSuper = false,of={"codigo"})
@NamedQueries({
    @NamedQuery(name = "Empresa.buscarnomePessoa",
            query = "select e from Empresa e where e.razaoSocial like :nomePessoa or "
            + "e.nomeFantasia like :nomeFantasia or "
            + "e.documentoIndentificacao = :documetoIndentificacao or "
            + "e.inscricaoEstadual = :inscricaoEstadual")
   ,@NamedQuery(name="Empresa.buscarPorCodigo",query="select e from Empresa e where e.codigo=:codigo")     
})
public class Empresa extends Filtro implements EntidadeBase<String>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DA EMPRESA
     */
    @Id
    @Column(name = "codigo", length = 3, nullable = false)
    private String codigo;

    /**
     * DOCUMENTO DE INDENTIFICACAO EX: (<b>CNPJ,OUTROS</b>)
     */
    @Column(name = "documento_indentificacao", length = 18, nullable = false)
    @CNPJ(message = "CNPJ invalido, verifique o cnpj")
    private String documentoIndentificacao;

    /**
     * RAZAO SOCIAL DA EMPRESA
     */
    @Column(name = "razao_social", length = 60, nullable = false)
    private String razaoSocial;

    /**
     * NOME FANTASIA
     */
    @Column(name = "nome_fantasia", length = 60, nullable = false)
    private String nomeFantasia;

    @Column(name = "endereco", length = 60, nullable = false)
    private String endereco;

    @Column(name = "numeroEndereco", length = 10, nullable = false)
    private String numeroEndereco;

    @Column(name = "complemento", length = 60, nullable = true)
    private String complemento;

    @Column(name = "bairro", length = 60, nullable = false)
    private String bairro;

    @Column(name = "codigo_municipio", length = 7, nullable = false)
    private Integer codigoMunicipio;

    @Column(name = "nome_municipio", length = 60, nullable = false)
    private String nomeMunicipio;

    @Column(name = "sigla_estado", length = 2, nullable = false)
    private String siglaEstado;

    @Column(name = "cep", length = 8, nullable = false)
    private Integer cep;

    @Column(name = "codigo_pais", length = 4, nullable = false, columnDefinition = "int not null default 1054")
    private Integer codigoPais;

    @Column(name = "descricao_pais", length = 50, nullable = false, columnDefinition = "varchar(50) not null default 'BRASIL'")
    private String descricaoPais;

    @Column(name = "inscricao_estadual", length = 14, nullable = false, columnDefinition = "varchar(14) not null default 'ISENTO'")
    private String inscricaoEstadual;

    @Column(name = "inscricao_estadual_st", length = 14)
    private String inscricaoEstadualSt;

    @Column(name = "inscricao_municipal", length = 15)
    private String inscricaoMunicipal;

    @Column(name = "cnae", length = 7)
    private Integer cnae;

    /**
     * CODIGO DE REGIME TRIBUTARIO DA EMPRESA (1) SEMPLES NACIONAL, (2) SIMPLES
     * NACIONAL - EXCESSO DE SUBLIMITE DE RECEITA BRUTA OU (3) REGIME NACIONAL
     */
    @Column(name = "regime_tributario", length = 7, nullable = false, columnDefinition = "varchar(7) not null default '1' ")
    private String regimeTributario;

    @Column(name = "telefone", length = 14)
    private String telefone;

    @Override
    public String getId() {
        return this.codigo;
    }

   

}
