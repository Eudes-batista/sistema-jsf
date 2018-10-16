package com.zoomtecnologia.zox.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterData")
public class ConverterData implements Converter {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date data = null;
        try {
            if (value != null) {
                data = simpleDateFormat.parse(value);
                return data;
            }
        } finally {
            return data;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            if (value instanceof Date) {
                Date data = (Date) value;
                return simpleDateFormat.format(data);
            }
        }
        return "";
    }

}
