/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnolgia.zox.teste;

import com.zoomtecnologia.zox.modelo.cadastros.TipoPagamento;

/**
 *
 * @author Wagner
 */
public class Teste {
    
    public static void main(String[] args) {
        String tabela = new TipoPagamento().getClass().getSimpleName();
        System.out.println("tabela = " + gerarNomeDaTabela(tabela).replaceFirst("_", ""));
    }
    
    private static String gerarNomeDaTabela(String tabela) {
        String palavra = "";
        for (int i = 0; i < tabela.length(); i++) {
            char letra = tabela.charAt(i);
            if (Character.isUpperCase(letra)) {
                palavra+="_"+letra;
                continue;
            }
            palavra += letra;
        }
        return palavra.toLowerCase();
    }
    
}
