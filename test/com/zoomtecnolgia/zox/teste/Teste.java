/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnolgia.zox.teste;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Wagner
 */
public class Teste {
    
    public static void main(String[] args) {
        String cidade="RECIFE";
        List<String> collect = Arrays.asList("Recife","Olinda","abreu e lima","jaboatao dos guararapes").stream().filter(s -> s.equalsIgnoreCase(cidade)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        
    }
    
}
