package com.zoomtecnologia.zox.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author eudes
 */
public class WebServiceCep {

    private Cep cep;
    private String mensagemErro;

    public WebServiceCep(Cep cep) {
        this.cep = cep;
    }
    
    public Cep consultarCep() {
        String path = "https://viacep.com.br/ws/" + cep.getCep() + "/json/";
        try {
            URL url = new URL(path);
            URLConnection urlConnection = url.openConnection();
            String linha = "";
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                while (buffer.ready()) {
                    linha += buffer.readLine();
                }
            }
            Gson gson = new Gson();
            return ((Cep) gson.fromJson(linha, Cep.class));
        } catch (MalformedURLException ex) {
            this.mensagemErro = "URL errada,verifique os parametros para a consulta\n";
            this.mensagemErro += path;
        } catch (IOException ex) {
            this.mensagemErro = "Erro na consulta dos dados site indisponivel.";
        }
        return null;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Cep getCep() {
        return cep;
    }

}

