/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wagner
 */
@FacesConverter("converterMaskInteger")
public class ConverterMaskInteger implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!(value = value.replaceAll("\\D", "")).isEmpty()) {   
            return Integer.parseInt(value);
        }
        return 0;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }

}
