/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.util;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Wagner
 */
@Getter @Setter 
public class AtividadePrincipal implements Serializable{
    
    private String text;
    private String code;
}
