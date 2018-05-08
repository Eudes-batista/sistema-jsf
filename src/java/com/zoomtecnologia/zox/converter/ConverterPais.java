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
 * @author administrador
 */
@FacesConverter("converterPais")
public class ConverterPais implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            Pais pais = (Pais) component.getAttributes().get(value);
            return pais;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Pais pais = (Pais) value;
            component.getAttributes().put(pais.getDescricao(), pais);
            return pais.getDescricao();
        }
        return "";
    }

}
