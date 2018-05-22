package com.zoomtecnologia.zox.bean;

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
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
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
    private ConfiguracaoEmpresaBean configuracaoEmpresaBean;
    
    @Autowired
    private ConfiguracaoEmpresaService configuracaoEmpresaService;
    
    private ConfiguracaoEmpresa configuracaoEmpresa ;

    @Getter
    @Setter
    private List<Estado> estados;
    @Getter
    @Setter
    private List<Cidade> cidades;

    @Override
    public void novo() {
        super.novo();
        this.estados = this.estadoService.listaTodos(Estado.class);
    }
    
    public void carregarCidade() {
        if (super.getEntidade().getSiglaEstado() != null) {
            if (!super.getEntidade().getSiglaEstado().isEmpty()) {
                this.cidades = this.cidadeService.listarPorEstado(super.getEntidade().getSiglaEstado());
            }
        }
    }

    public void carregarDadosEmpresa() {
        WebServiceCnpj webServiceCnpj = new WebServiceCnpj(super.getEntidade().getDocumentoIndentificacao());
        DadosEmpresa dados = webServiceCnpj.consultarCnpj();
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

    }

    @Override
    public void salvar() {
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
        this.configuracaoEmpresa = new ConfiguracaoEmpresa();
        configuracaoEmpresaBean.setEntidade(this.configuracaoEmpresa);
        configuracaoEmpresaBean.getEntidade().setEmpresa(super.getEntidade());
        super.salvar();
        super.setInativo(Boolean.TRUE);
    }

    @Override
    public void alterar(Empresa e) {
        this.estados = this.estadoService.listaTodos(Estado.class);
        super.alterar(e);
        configuracaoEmpresaBean.setEntidade(configuracaoEmpresaService.buscarConfiguracaoPorEmpresa(e));
    }

    public void consultarCep() {
        if (super.getEntidade().getCep() != null) {
            WebServiceCep cep = WebServiceCep.searchCep(String.valueOf(super.getEntidade().getCep()));
            if(cep.wasSuccessful()){
                super.getEntidade().setEndereco(cep.getLogradouro());
                super.getEntidade().setBairro(cep.getBairro());
                super.getEntidade().setSiglaEstado(cep.getUf());
                carregarCidade();
                super.getEntidade().setNomeMunicipio(cep.getCidade().toUpperCase());
            }else{
                Messages.addGlobalWarn("cep não encontrado");
            }
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
