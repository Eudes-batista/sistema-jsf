package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "empresa")
@Data
@NamedQueries({
    @NamedQuery(name = "Empresa.buscarRazaoSocial",
            query = "select e from Empresa e where e.razaoSocial like :razaoSocial or "
            + "e.nomeFantasia like :nomeFantasia or "
            + "e.documentoIndentificacao = :documetoIndentificacao or "
            + "e.inscricaoEstadual = :inscricaoEstadual")
})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO DA EMPRESA
     */
    @Id
    @Column(name = "EPCODEMP", length = 3, nullable = false)
    String codigo;

    /**
     * DOCUMENTO DE INDENTIFICACAO EX: (<b>CNPJ,OUTROS</b>)
     */
    @Column(name = "EPDOCEMI", length = 14, nullable = false)
    String documentoIndentificacao;

    /**
     * RAZAO SOCIAL DA EMPRESA
     */
    @Column(name = "EPRAZSOC", length = 60, nullable = false)
    String razaoSocial;

    /**
     * NOME FANTASIA
     */
    @Column(name = "EPNOMFAN", length = 60, nullable = false)
    String nomeFantasia;

    @Column(name = "EPENDEMP", length = 60, nullable = false)
    String endereco;

    @Column(name = "EPNROEND", length = 10, nullable = false)
    String numeroEndereco;

    @Column(name = "EPCPLEND", length = 60, nullable = true)
    String complemento;

    @Column(name = "EPBAIRRO", length = 60, nullable = true)
    String bairro;

    @Column(name = "EPCODMUN", length = 7, nullable = false)
    Integer codigoMunicipio;

    @Column(name = "EPCIDADE", length = 60, nullable = false)
    String nomeMunicipio;

    @Column(name = "EPCUFEMP", length = 2, nullable = false)
    String siglaEstado;

    @Column(name = "EPCEPEMP", length = 8, nullable = false)
    Integer cep;

    @Column(name = "EPCDPAIS", length = 4, nullable = false, columnDefinition = "int not null default 1054")
    Integer codigoPais;

    @Column(name = "EPDSPAIS", length = 50, nullable = false, columnDefinition = "varchar(50) not null default 'BRASIL'")
    String descricaoPais;

    @Column(name = "EPINSEST", length = 14, nullable = false, columnDefinition = "varchar(14) not null default 'ISENTO'")
    String inscricaoEstadual;

    @Column(name = "EPINSCST", length = 14, nullable = false)
    String inscricaoEstadualSt;

    @Column(name = "EPINSMUN", length = 15, nullable = false)
    String inscricaoMunicipal;

    @Column(name = "EPCDCNAE", length = 7, nullable = false)
    Integer cnae;

    @Column(name = "EPNUMCRT", length = 7, nullable = false, columnDefinition = "enum(0,1,2,3) default '0'")
    String regimeTributario;

    @Column(name = "EPTELEFO", length = 14, nullable = false)
    String telefone;

}
