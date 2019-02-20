/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnolgia.zox.teste;

import com.zoomtecnologia.zox.modelo.seguranca.Modulo;

/**
 *
 * @author Wagner
 */
public class Teste {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Modulo modulo =(Modulo) Class.forName(Modulo.class.getCanonicalName()).newInstance();
        modulo.setNome("Teste");
        modulo.setCodigo(1);
        
        System.out.println("modulo = " + modulo);
    }
    
}
