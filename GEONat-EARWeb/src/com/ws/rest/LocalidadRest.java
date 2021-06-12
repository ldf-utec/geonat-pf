package com.ws.rest;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.logica.bean.LocalidadBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.LocalidadLocal;

@Stateless
@LocalBean
public class LocalidadRest implements ILocalidadRest{
	
	@Inject
	private LocalidadBean localidadBean;
	
	@Override
	public String echo() {
		return "Servicio Localidades Disponible";
	}
	
	@Override
	public Response getLocalidades() {
		try {
			List<LocalidadLocal> ret = localidadBean.obternerTodas();
			return Response.ok().entity(ret).build();

		} catch (PersistenciaException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
