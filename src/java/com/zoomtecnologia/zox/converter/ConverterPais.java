/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.converter;

import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wagner
 */
@FacesConverter("converterPais")
public class ConverterPais implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Object obj = component.getAttributes().get(value);
        Pais pais =(Pais) obj;
        return pais;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value ==null){
            return "";
        }
        Pais pais = (Pais) value;
        return pais.getDescricao();
    }
    
}
