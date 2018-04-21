package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {

    @Id
    @Column(length = 20, name = "CUDOCIDE", nullable = false)
    @Length(max = 20, message = "Campo documento de identificação não receber mas que {max} caracteres")
    @NotNull(message = "Campo documento de identificação não pode ser nulo!!")
    String documentoIdentificacao;

    @Column(length = 60, name = "CURAZSOC", nullable = false)
    @Length(max = 60, message = "Campo Razao Social não receber mas que {max} caracteres")
    @NotNull(message = "Campo Razao Social não pode ser nulo!!")
    String razaoSocial;

    @Column(length = 50, name = "CUNOMFAN", nullable = false)
    @Length(max = 50, message = "Campo Fantasia não receber mas que {max} caracteres")
    @NotNull(message = "Campo Fantasia não pode ser nulo!!")
    String nomeFantasia;

    @Column(length = 1, nullable = false, name = "CUTIPPES")
    @NotNull(message = "Campo Fantasia não pode ser nulo!!")
    String tipoPessoa;

    @Column(length = 18, name = "CUINSEST", nullable = true)
    @Length(max = 18, message = "Campo Inscrição Estadual não receber mas que {max} caracteres")
    String inscricaoEstadual;

    @Column(length = 18, name = "CUINSMUN")
    @Length(max = 18, message = "Campo Inscrição Municipal não receber mas que {max} caracteres")
    String inscricaoMunicipal;

    @Temporal(TemporalType.DATE)
    @Column(name = "CUDTNASC")
    @NotNull(message = "Campo Data de Nascimento não pode ser nulo!!")
    Date dataNascimento;

    @Column(name = "CUESTCIV", length = 1)
    @NotNull(message = "Campo Estado Civil não pode ser nulo!!")
    String estadoCivil;

    @Column(name = "CUTPSEXO", length = 1)
    @NotNull(message = "Campo Tipo de Sexo não pode ser nulo!!")
    String tipoSexo;

    @Column(name = "CUREGTRI", length = 1, nullable = false)
    @NotNull(message = "Campo Regime Tributario não pode ser nulo!!")
    String regimeTributario;

    @Column(length = 7, name = "CUNUCNAE")
    @Length(max = 7, message = "Campo CNAE não receber mas que {max} caracteres")
    String cnae;

    @Column(length = 7, name = "CUSUFRAM")
    @Length(max = 7, message = "Campo Número Suframa não receber mas que {max} caracteres")
    String suframa;

    @Column(length = 18, name = "CUINSSST")
    @Length(max = 18, message = "Campo Inscrição Estadual ST não receber mas que {max} caracteres")
    String inscricaoEstadualST;

    @Column(name = "CUFUNFUN", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N' ")
    String funcionario;

    @Column(name = "CUFUNFOR", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String fornecedor;

    @Column(name = "CUFUNCLI", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String cliente;

    @Column(name = "CUFUNVEN", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String vendedor;

    @Column(name = "CUFUNTRA", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String transportadora;

    @Column(name = "CUFUNPRO", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String produtor;

    @Column(name = "CUFUNFAB", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
    String fabricante;

    @Column(length = 12, name = "CUSALARI", precision = 12, scale = 2)
    @Min(value = 0, message = "Campo salario não pode receber números negativos")
    Double salario;

    @Column(length = 5, name = "CUCOMSER", precision = 5, scale = 3)
    @Min(value = 0, message = "Campo Comissão por Serviço não pode receber números negativos")
    Double comissaoServico;

    @Column(length = 5, name = "CUCOMPRO", precision = 5, scale = 3)
    @Min(value = 0, message = "Campo Comissão por Produto não pode receber números negativos")
    Double comissaoProduto;

    @Column(length = 12, name = "CUVLMETA", precision = 12, scale = 2)
    @Min(value = 0, message = "Campo Valo da Meta não pode receber números negativos")
    Double valorMeta;

    @Column(length = 1, name = "CUCOMMET", columnDefinition = "varchar(1) default 'N' ")
    @Length(max = 1, message = "Campo paga comissao so pode receber apenas {max} caracteres")
    String isPagaComissao;

    @Column(length = 12, name = "CUTOTCRE", precision = 12, scale = 2)
    @Min(value = 0, message = "Campo Valor total pendente no contas a receber não pode receber números negativos")
    Double valorTotalContaReceberPendente;

    @Column(length = 12, name = "CUTOTCPG", precision = 12, scale = 2)
    @Min(value = 0, message = "Campo Valor total pendente no contas a apagar não pode receber números negativos")
    Double valorTotalContaApagarPendente;

    @Column(length = 1, name = "CUTIPTAB", columnDefinition = "varchar(1) default '1' ")
    @Length(max = 1, message = "Campo Tabela cliente apenas {max} caracteres")
    String tabelaCliente;

    @Column(length = 1, name = "CUCTCORR", columnDefinition = "varchar(1) default 'N' ")
    @Length(max = 1, message = "Campo Correntista apenas {max} caracteres")
    String conrrentista;

    @Column(name = "CUOBSERV", columnDefinition = "text")
    String observasao;

    @Column(length = 1, name = "CUSITUAC", columnDefinition = "varchar(1) default 'A' ", nullable = false)
    @Length(max = 1, message = "Campo status apenas {max} caracteres")
    String status;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Campo data da ultima Atualização não pode ser nulo")
    @Column(name = "CUULTALT", nullable = false)
    Date dataUltimaAtualizacao;

    @Column(length = 30, name = "CUUSUALT", nullable = false)
    @Length(max = 30, message = "Campo Usuario da Ultima atualização apenas {max} caracteres")
    String usuarioUltimaAtu;

    @Column(name = "CUCFINAL", columnDefinition = "enum('0','1') NOT NULL DEFAULT '0' ")
    String consumidorFinal;

    @Column(name = "CUIIEDES", columnDefinition = "enum('1','2','9') NOT NULL DEFAULT '1' ")
    String indicadorIE;

    @Column(name = "CUCONTAB", length = 20)
    @Length(max = 20, message = "Número de conta contabil só pode receber {max} caracteres")
    String numeroContabil;

    @Column(name = "CUIMAGEM")
    @Lob
    byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "CUFUNCAO", nullable = true, referencedColumnName = "FUCODFUN")
    @ForeignKey(name = "pessoaFKfunfuncao")
    FuncaoFuncionario funcaoFuncionario;

    @OneToMany(mappedBy = "enderecoPK.pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "documentoPK.pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Documento> documentos = new ArrayList<>();

}
