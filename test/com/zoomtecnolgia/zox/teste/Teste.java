/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnolgia.zox.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class Teste {
    
    public static void main(String[] args)  {
    
        List<String> sistema = new ArrayList(Arrays.asList("Sigmasat","Omega","Zox","Saiph","Unico"));
        List<String> sistema2 = new ArrayList(Arrays.asList("Sigmasat","Omega","Zox","Saiph"));
        
        if(sistema.containsAll(sistema2)){
            System.out.println("conteudos iguais");
        }else{
            System.out.println("conteudos diferentes");            
        }
        
        if(sistema.removeAll(sistema2)){
            System.out.println("sistema = " + sistema);
        }
        
    }
    
}
