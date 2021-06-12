package com.ws.rest;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.logica.bean.DetalleBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.DetalleLocal;


@Stateless
@LocalBean
public class DetalleRest implements IDetalleRest{

	@Inject
	private DetalleBean detalleBean;
	
    public DetalleRest() {
        
    }

    @Override
	public String echo() {
		return "Servicio Detalles Disponible";
	}

    @Override
	public Response agregarDetalle(DetalleLocal detalleLocal) {
		try {
			
			detalleBean.agregarDetalle(detalleLocal);
			return Response.ok().build();

		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}
    
    @Override
	public Response getDetallesPorObservacion(@PathParam("id") Long id) throws PersistenciaException {
		
		try {
			List<DetalleLocal> detalles = detalleBean.obternerDetallesPorObservacion(id);
			return Response.ok().entity(detalles).build();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
    
    @Override
	public Response getDetalles() {
		try {
			List<DetalleLocal> ret = detalleBean.obternerTodas();			
			return Response.ok().entity(ret).build();

		} catch (PersistenciaException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
