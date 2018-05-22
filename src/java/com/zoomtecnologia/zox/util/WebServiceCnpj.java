package com.zoomtecnologia.zox.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Wagner
 */
public class WebServiceCnpj {

    private final String URL = "https://www.receitaws.com.br/v1/cnpj/";
    private String mensagemErro;
    private String cnpj;

    public WebServiceCnpj() {
    }

    public WebServiceCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public DadosEmpresa consultarCnpj() {
        try {
            URL url = new URL(URL + cnpj.replaceAll("\\D", ""));
            HttpURLConnection uRLConnection = (HttpURLConnection) url.openConnection();
            uRLConnection.setRequestMethod("GET");
            uRLConnection.setReadTimeout(300);
            String linha = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()))) {
                while (br.ready()) {
                    linha += br.readLine();
                }
            }
            return new Gson().fromJson(linha, DadosEmpresa.class);
        } catch (MalformedURLException ex) {
            mensagemErro = "Erro na formação da url";
        } catch (IOException ex) {
            mensagemErro = "Erro na consulta dos dados\n verifique se voce está conectado a internet ou se digitou o cnpj corretamente ";
        }
        return null;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
