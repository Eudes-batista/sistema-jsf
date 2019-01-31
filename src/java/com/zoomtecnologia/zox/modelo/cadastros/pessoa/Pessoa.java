package com.zoomtecnologia.zox.modelo.cadastros.pessoa;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import com.zoomtecnologia.zox.modelo.cadastros.Contato;
import com.zoomtecnologia.zox.modelo.cadastros.Documento;
import com.zoomtecnologia.zox.modelo.cadastros.Endereco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pessoa")
@Data
@EqualsAndHashCode(callSuper = false,of = {"documentoPessoa"})
public class Pessoa extends Filtro implements EntidadeBase<String>, Serializable {

    @Id
    @Column(length = 20, name = "documento_pessoa", nullable = false)
    @Length(max = 20, message = "Campo documento de identificação não receber mas que {max} caracteres")
    @NotNull(message = "Campo documento de identificação não pode ser nulo!!")
    private String documentoPessoa;

    @Column(length = 60, name = "nome_pessoa", nullable = false)
    @Length(max = 60, message = "Campo Razao Social não receber mas que {max} caracteres")
    @NotNull(message = "Campo Razao Social não pode ser nulo!!")
    private String nomePessoa;

    @Column(length = 50, name = "nome_fantasia", nullable = false)
    @Length(max = 50, message = "Campo Fantasia não receber mas que {max} caracteres")
    @NotNull(message = "Campo Fantasia não pode ser nulo!!")
    private String nomeFantasia;

    @Column(length = 1, nullable = false, name = "tipo_pessoa")
    @NotNull(message = "Campo Fantasia não pode ser nulo!!")
    private String tipoPessoa;

    @Column(length = 18, name = "inscricao_estadual", nullable = true)
    @Length(max = 18, message = "Campo Inscrição Estadual não receber mas que {max} caracteres")
    private String inscricaoEstadual;

    @Column(length = 18, name = "inscricao_municipal")
    @Length(max = 18, message = "Campo Inscrição Municipal não receber mas que {max} caracteres")
    private String inscricaoMunicipal;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    @NotNull(message = "Campo Data de Nascimento não pode ser nulo!!")
    private Date dataNascimento;

    @Column(name = "estado_civil", length = 1)
    @NotNull(message = "Campo Estado Civil não pode ser nulo!!")
    private String estadoCivil;

    @Column(name = "sexo", length = 1)
    @NotNull(message = "Campo Tipo de Sexo não pode ser nulo!!")
    private String tipoSexo;

    @Column(name = "regime_tributario", length = 1, nullable = false)
    @NotNull(message = "Campo Regime Tributario não pode ser nulo!!")
    private String regimeTributario;

    @Column(length = 7, name = "suframa")
    @Length(max = 7, message = "Campo Número Suframa não receber mas que {max} caracteres")
    private String suframa;

    @Column(length = 18, name = "inscricao_estadual_st")
    @Length(max = 18, message = "Campo Inscrição Estadual ST não receber mas que {max} caracteres")
    private String inscricaoEstadualST;

//    @Column(name = "funcionario", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N' ")
//    private String funcionario;
//
//    @Column(name = "fornecedor", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String fornecedor;
//
//    @Column(name = "cliente", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String cliente;
//
//    @Column(name = "vendedor", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String vendedor;
//
//    @Column(name = "transportadora", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String transportadora;
//
//    @Column(name = "produtor", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String produtor;
//
//    @Column(name = "fabricante", columnDefinition = "enum('S','N') NOT NULL DEFAULT 'N'")
//    private String fabricante;

    
    @Column(name = "CUOBSERV", columnDefinition = "text")
    private String observasao;

    @Column(length = 1, name = "status", columnDefinition = "varchar(1) default 'A' ", nullable = false)
    @Length(max = 1, message = "Campo status apenas {max} caracteres")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Campo data da ultima Atualização não pode ser nulo")
    @Column(name = "data_ultima_atualizacao", nullable = false)
    private Date dataUltimaAtualizacao;

    @Column(length = 30, name = "usuario_ultima_atualizacao", nullable = false)
    @Length(max = 30, message = "Campo Usuario da Ultima atualização apenas {max} caracteres")
    private String usuarioUltimaAtu;

    @Column(name = "consumidor_final", columnDefinition = "enum('0','1') NOT NULL DEFAULT '0' ")
    private String consumidorFinal;

    @Column(name = "indicador_ie", columnDefinition = "enum('1','2','9') NOT NULL DEFAULT '1' ")
    private String indicadorIE;

    @Column(name = "imagem")
    @Lob
    private byte[] imagem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoPk.pessoa", orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "contatoPK.pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "documentoPK.pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos = new ArrayList<>();

    @Override
    public String getId() {
        return this.documentoPessoa;
    }
}
