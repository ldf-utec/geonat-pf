package com.ws.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.logica.bean.ImagenBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.ImagenLocal;

@Stateless
@LocalBean
public class ImagenRest implements IImagenRest {

	@Inject
	private ImagenBean imagenBean;

	@Override
	public String echo() {
		return "Servicio Localidades Disponible";
	}

	@Override
	public Response agregar(ImagenLocal imagen) {

		try {
			System.out.println(imagen.toString());
			imagenBean.agregar(imagen);
			return Response.ok().build();
			
		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}

	}
	
	@Override
	public Response buscarPorObservacion(@PathParam("id") Long id) {
		
		try {
			ImagenLocal ret = imagenBean.buscarPorObservacion(id);
			return Response.ok().entity(ret).build();

		} catch (PersistenciaException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
