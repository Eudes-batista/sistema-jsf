/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.converter;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author eudes
 */
@FacesConverter("converterEstado")
public class ConverterEstado implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            Estado estado = (Estado) component.getAttributes().get(value);
            return estado;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Estado estado = (Estado) value;
            component.getAttributes().put(estado.getNome(), estado);
            return estado.getNome();
        }
        return "";
    }

}
