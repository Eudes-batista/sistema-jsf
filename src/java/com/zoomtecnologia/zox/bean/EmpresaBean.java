package com.zoomtecnologia.zox.bean;

import br.com.certificado.ConsultarDados;
import br.com.certificado.LerCertificado;
import com.zoomtecnologia.zox.modelo.cadastros.ConfiguracaoEmpresa;
import com.zoomtecnologia.zox.modelo.cadastros.Empresa;
import com.zoomtecnologia.zox.servico.EmpresaService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private ConfiguracaoEmpresaBean configuracaoEmpresaBean;

    @Getter
    @Setter
    private ConfiguracaoEmpresa configuracaoEmpresa;

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
                    if (this.getEntidade().getPessoa().getDocumentoPessoa().replaceAll("\\D", "").equals(dados.getCnpj())) {
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
            String nomeDoArquivo = "logo_" + this.getEntidade().getCodigo() + "." + img[1];
            caminho = caminho + nomeDoArquivo;
            FileOutputStream fileOutputStream = new FileOutputStream(caminho);
            fileOutputStream.write(event.getFile().getContents());
            this.configuracaoEmpresa.setCaminhoLogo(nomeDoArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpresaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpresaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    void antesDeSalvar() {
        salvarConfiguracao();
    }

    @Override
    void depoisDeSalvar() {
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
    public EmpresaService getGenericService() {
        return empresaService;
    }

}
