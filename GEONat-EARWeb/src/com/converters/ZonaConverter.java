package com.converters;

import java.io.Serializable;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.presentacion.bean.GestionReporte;
import com.presentacion.entitiesLocales.ZonaLocal;

@FacesConverter(value = "zonaConverter")
public class ZonaConverter implements Converter<Object>, Serializable{

	private static final long serialVersionUID = 1L;
		
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String nombreZona) {
		
		if (context == null) {
			throw new NullPointerException("Context");
		}else if (component == null) {
			throw new NullPointerException("Component");
		}
		
		ValueExpression vex = context.getApplication().getExpressionFactory()
        		.createValueExpression(context.getELContext(),"#{gestionReporte}", GestionReporte.class);
        GestionReporte gestionReporte = (GestionReporte)vex.getValue(context.getELContext());

        return gestionReporte.getZonaHash().get(nombreZona);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object zona) {
		
		if (context == null) {
			throw new NullPointerException("Context");
		}else if (component == null) {
			throw new NullPointerException("Component");
		}
		return ((ZonaLocal)zona).getNombre();
	}
	

}
