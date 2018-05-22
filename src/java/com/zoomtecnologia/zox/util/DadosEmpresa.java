package com.zoomtecnologia.zox.util;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosEmpresa implements Serializable{

    private AtividadePrincipal atividade_principal[];
    private String data_situacao;
    private String nome;
    private String uf;
    private String telefone;
    private QuadroSocial qsa[];
    private String situacao;
    private String bairro;
    private String logradouro;
    private String numero;
    private String cep;
    private String municipio;
    private String abertura;
    private String natureza_juridica;
    private String fantasia;
    private String cnpj;
    private String ultima_atualizacao;
    private String status;
    private String tipo;
    private String complemento;
    private String email;
    private String efr;
    private String motivo_situacao;
    private String situacao_especial;
    private String data_situacao_especial;
    private AtividadeSecudaria atividades_secundarias[];
    private String capital_social;
    private Object extra;
}
