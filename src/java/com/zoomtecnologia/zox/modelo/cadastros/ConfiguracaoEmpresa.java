package com.zoomtecnologia.zox.modelo.cadastros;

import com.zoomtecnologia.zox.filtros.Filtro;
import com.zoomtecnologia.zox.modelo.EntidadeBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "configuracao_empresa")
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries({
    @NamedQuery(name = "ConfiguracaoEmpresa.buscarPorEmpresa", query = "select c from ConfiguracaoEmpresa c where c.codigo=:empresa")
})
public class ConfiguracaoEmpresa extends Filtro implements Serializable, EntidadeBase<String> {

    /**
     * CHAVE PRIMARIA CODIGO DA EMPRESA
     */
    @Id
    @Column(name = "codigo", length = 3, nullable = false)
    private String codigo;

    @OneToOne
    @JoinColumn(name = "empresa", nullable = false)
    @ForeignKey(name = "configuracao_empresaFKempresa")
    private Empresa empresa;
    /**
     * CAMINHO DO CERTIFICADO
     */

    @Column(name = "caminho_certificado", nullable = false, columnDefinition = "text")
    private String caminhoCertificado;

    /**
     * SENHA DO CERTIFICADO
     */
    @Column(name = "senha_certificado", length = 20, nullable = false)
    private String senhaCertificado;

    /**
     * AMBIENTE DA NFe (HOMOLOGACAO E PRODUCAO)
     */
    @Column(name = "ambiente_nfe", length = 11, nullable = false)
    private String ambienteNfe;

    /**
     * ID DO TOKEN NFe
     */
    @Column(name = "id_token", length = 20, nullable = true)
    private String idTokenNfe;

    /**
     * TOKEN
     */
    @Column(name = "token_nfe", length = 20, nullable = true)
    private String tokenNfe;

    /**
     * SERVIDOR SMTP
     */
    @Column(name = "servidor_smtp", length = 80, nullable = true)
    private String servidorSmtp;

    /**
     * PORTA DO SERVIDOR SMTP
     */
    @Column(name = "porta_smtp", length = 5, nullable = true)
    private Integer portaSmtp;

    /**
     * EMAIL
     */
    @Column(name = "email", length = 80, nullable = true)
    private String email;

    /**
     * SENHA DO EMAIL
     */
    @Column(name = "senha_email", length = 20, nullable = true)
    private String senhaEmail;

    /**
     * ASSUNTO DO EMAIL
     */
    @Column(name = "assunto_email", length = 80, nullable = true)
    private String assuntoEmail;

    /**
     * MENSAGEM DO EMAIL
     */
    @Column(name = "mensagem_email", nullable = true)
    private String mensagemEmail;

    /**
     * CAMINHO DA LOGO
     */
    @Column(name = "caminho_logo", nullable = true)
    private String caminhoLogo;

    /**
     * NUMERO DA ULTIMA NFE
     */
    @Column(name = "ultima_nfe", length = 9, nullable = false)
    private Integer ultimaNfe;

    /**
     * SERIE DA NFE
     */
    @Column(name = "serie_nfe", length = 3, nullable = false)
    private Integer serieNfe;

    /**
     * DATA DA ULTIMA NFE
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "data_ultima_nfe", nullable = false)
    private Date dataUltimaNfe;

    /**
     * VERSAO DA NFE
     */
    @Column(name = "versao_nfe", length = 4, nullable = false)
    private String versaoNfe;

    /**
     * AMBIENTE DA NFCe (HOMOLOGACAO E PRODUCAO)
     */
    @Column(name = "ambiente_nfce", length = 11, nullable = false)
    private String ambienteNfce;

    /**
     * ID DO TOKEN NFCE
     */
    @Column(name = "id_token_nfce", length = 20, nullable = true)
    private String idTokenNfce;

    /**
     * CSC NFCe
     */
    @Column(name = "csc_nfce", length = 20, nullable = true)
    private String cscNfce;

    /**
     * VERSAO DA NFCE
     */
    @Column(name = "versao_nfce", length = 4, nullable = false)
    private String versaoNfce;

    /**
     * FORMA DE EMISSAO(CONTIGENCIA E NORMAL)
     */
    @Column(name = "forma_emissao", length = 20, nullable = false)
    private String formaEmissao;

    /**
     * CESTA DE TRIBUTACAO PADRAO
     */
    @Column(name = "tributacao_padrao", length = 4, nullable = true)
    private String tributacaoPadrao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "configuracaoEmpresa")
    private List<ConfiguracaoEmpresaNFCe> configuracaoEmpresaNFCes = new ArrayList<>();

    @Override
    public String getId() {
        return this.codigo;
    }

}
