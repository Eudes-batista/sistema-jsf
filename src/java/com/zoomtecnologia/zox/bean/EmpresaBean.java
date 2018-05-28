package com.zoomtecnologia.zox.bean;

import br.com.certificado.ConsultarDados;
import br.com.certificado.LerCertificado;
import com.zoomtecnologia.zox.modelo.cadastros.Cidade;
import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresa;
import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.servico.CidadeService;
import com.zoomtecnologia.zox.servico.ConfiguracaoEmpresaService;
import com.zoomtecnologia.zox.servico.EmpresaService;
import com.zoomtecnologia.zox.servico.EstadoService;
import com.zoomtecnologia.zox.util.DadosEmpresa;
import com.zoomtecnologia.zox.util.WebServiceCep;
import com.zoomtecnologia.zox.util.WebServiceCnpj;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("empresaBean")
@ManagedBean
@Scope("view")
public class EmpresaBean extends GenericoBean<Empresa, EmpresaService> {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private ConfiguracaoEmpresaService configuracaoEmpresaService;

    @Autowired
    private ConfiguracaoEmpresaBean configuracaoEmpresaBean;

    @Getter
    @Setter
    private ConfiguracaoEmpresa configuracaoEmpresa;

    @Getter
    @Setter
    private List<Estado> estados;

    @Getter
    @Setter
    private List<Cidade> cidades;
    
    @Getter
    private String tipo;

    /**
     * Carrega a cidade pelo estado selecionado
     */
    public void carregarCidade() {
        if (super.getEntidade().getSiglaEstado() != null) {
            if (!super.getEntidade().getSiglaEstado().isEmpty()) {
                this.cidades = this.cidadeService.listarPorEstado(super.getEntidade().getSiglaEstado());
            }
        }
    }

    public void carregarCidade(String estado) {
        if (estado != null) {
            this.cidades = this.cidadeService.listarPorEstado(estado);
        }
    }

    /**
     * Faz uma validacao da cidade antes de salvar pegando qual o codigo do pais
     * e o nome
     */
    private void validarCidade() {
        Cidade cidade = null;
        for (Cidade c : this.cidades) {
            if (c.getNome().equalsIgnoreCase(super.getEntidade().getNomeMunicipio())) {
                cidade = c;
            }
        }
        if (cidade != null) {
            super.getEntidade().setCodigoMunicipio(cidade.getCidadePK().getCodigo());
            super.getEntidade().setCodigoPais(cidade.getCidadePK().getEstado().getEstadoPK().getPais().getCodigo());
            super.getEntidade().setDescricaoPais(cidade.getCidadePK().getEstado().getEstadoPK().getPais().getDescricao());
        }
    }

    public void carregarDadosEmpresa() {
        if (!super.getEntidade().getDocumentoIndentificacao().replaceAll("\\D", "").isEmpty()) {
            WebServiceCnpj webServiceCnpj = new WebServiceCnpj(super.getEntidade().getDocumentoIndentificacao());
            DadosEmpresa dados = webServiceCnpj.consultarCnpj();
            if (dados != null) {
                super.getEntidade().setRazaoSocial(dados.getNome());
                super.getEntidade().setNomeFantasia(dados.getFantasia());
                if (dados.getAtividade_principal() != null) {
                    String cnae = dados.getAtividade_principal()[0].getCode();
                    cnae = cnae.replaceAll("\\D", "");
                    super.getEntidade().setCnae(Integer.parseInt(cnae));
                }
                super.getEntidade().setEndereco(dados.getLogradouro());
                super.getEntidade().setBairro(dados.getBairro());
                super.getEntidade().setComplemento(dados.getComplemento());
                super.getEntidade().setNumeroEndereco(dados.getNumero());
                String cep = dados.getCep();
                cep = cep.replaceAll("\\D", "");
                super.getEntidade().setCep(Integer.parseInt(cep));
                super.getEntidade().setSiglaEstado(dados.getUf());
                carregarCidade();
                super.getEntidade().setNomeMunicipio(dados.getMunicipio().toUpperCase());
            } else {
                Messages.addGlobalWarn("CNPJ não encontrado,certifica-se que você digitou o cnpj corretamente\n e se você está conectado a internet.");
            }
        }
    }

    public void consultarCep() {
        if (super.getEntidade().getCep() != null) {
            WebServiceCep cep = WebServiceCep.searchCep(String.valueOf(super.getEntidade().getCep()));
            if (cep.wasSuccessful()) {
                super.getEntidade().setEndereco(cep.getLogradouro());
                super.getEntidade().setBairro(cep.getBairro());
                super.getEntidade().setSiglaEstado(cep.getUf());
                carregarCidade();
                super.getEntidade().setNomeMunicipio(cep.getCidade().toUpperCase());
            } else {
                Messages.addGlobalWarn("cep não encontrado");
            }
        }
    }

    public void carregarCertificado(FileUploadEvent event) {
        String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/");
        UploadedFile file = event.getFile();
        String path = realPath + "" + file.getFileName();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            fileOutputStream.write(file.getContents());
            this.configuracaoEmpresa.setCaminhoCertificado(path);
        } catch (FileNotFoundException ex) {
            System.out.println("ex = " + ex);
        } catch (IOException ex) {
            System.out.println("ex = " + ex);
        }
    }

    public boolean validarCertificado() {
        if (configuracaoEmpresa != null) {
            if (configuracaoEmpresa.getCaminhoCertificado() != null) {
                LerCertificado lerCertificado = new LerCertificado(configuracaoEmpresa.getCaminhoCertificado(), configuracaoEmpresa.getSenhaCertificado());
                if (lerCertificado.verificarSenha()) {
                    ConsultarDados dados = lerCertificado.carregarDados();
                    if(this.getEntidade().getDocumentoIndentificacao().replaceAll("\\D", "").equals(dados.getCnpj())) {
                        return true;
                    }
                    Messages.addGlobalWarn("Esse certifcado não pertence a essa empresa");
                } else {
                    Messages.addGlobalWarn("senha errada ou certificado não contem os dados dessa empresa");
                }
            }
        }
        return false;
    }

    public void carregarLogo(FileUploadEvent event) {
       String caminho = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/imagens/");
        try {
           String[] img = event.getFile().getFileName().split(Pattern.quote("."));
            this.tipo = img[1];
            caminho = caminho+"logo."+this.tipo;
            FileOutputStream fileOutputStream = new FileOutputStream(caminho);
            fileOutputStream.write(event.getFile().getContents());
            this.configuracaoEmpresa.setCaminhoLogo(this.tipo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpresaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpresaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
//    --------------ALTERAÇÕES NO BANCO---------------------
    
    
    
    /**
     * quando aperta o botao novo essa acao é acionada
     */
    @Override
    public void novo() {
        super.novo();
        this.estados = this.estadoService.listaTodos(Estado.class);
    }

    @Override
    public void salvar() {
        validarCidade();
        salvarConfiguracao();
        super.salvar();
        super.setInativo(Boolean.TRUE);
    }

    private void salvarConfiguracao() {
        if (this.configuracaoEmpresa == null) {
            this.configuracaoEmpresa = new ConfiguracaoEmpresa();
        }
        if (this.getInativo()) {
            configuracaoEmpresaBean.setEntidade(this.configuracaoEmpresa);
            configuracaoEmpresaBean.getEntidade().setEmpresa(super.getEntidade());
            configuracaoEmpresaBean.getEntidade().setCodigo(super.getEntidade().getCodigo());
            if (validarCertificado()) {
                configuracaoEmpresaBean.salvar();
            }
        }
    }

    @Override
    public void alterar(Empresa e) {
        this.estados = this.estadoService.listaTodos(Estado.class);
        carregarCidade(e.getSiglaEstado());
        super.alterar(empresaService.buscarPorEmpresa(e));
        this.configuracaoEmpresa = configuracaoEmpresaService.buscarConfiguracaoPorEmpresa(e);
        if (this.configuracaoEmpresa != null) {
            configuracaoEmpresaBean.setEntidade(this.configuracaoEmpresa);
        } else {
            this.configuracaoEmpresa = new ConfiguracaoEmpresa();
        }
    }

    @Override
    public EmpresaService getGenericService() {
        return empresaService;
    }

    @Override
    public Empresa createEntidade() {
        return new Empresa();
    }

}
