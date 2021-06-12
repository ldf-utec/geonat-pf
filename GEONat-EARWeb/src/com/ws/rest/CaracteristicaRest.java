package com.ws.rest;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.logica.bean.CaracteristicaBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.CaracteristicaLocal;

@Stateless
@LocalBean
public class CaracteristicaRest implements ICaracteristicaRest {

	@Inject
	private CaracteristicaBean caracteristicaBean;

	@Override
	public String echo() {
		return "Servicio Caracteristicas Disponible";
	}

	@Override
	public Response getCaracteristicasPorFenomeno(@PathParam("id") Long id) throws PersistenciaException {
		
		try {
			List<CaracteristicaLocal> caracteristicas = caracteristicaBean.obternerCaracteristicasPorFenomeno(id);
			return Response.ok().entity(caracteristicas).build();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}

	@Override
	public Response getCaracteristicas() {
		try {
			List<CaracteristicaLocal> ret = caracteristicaBean.obternerTodas();			
			return Response.ok().entity(ret).build();

		} catch (PersistenciaException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
