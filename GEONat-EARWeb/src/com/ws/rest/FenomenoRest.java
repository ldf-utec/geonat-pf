package com.ws.rest;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.logica.bean.FenomenoBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.FenomenoLocal;

@Stateless
@LocalBean
public class FenomenoRest implements IFenomenoRest{
	
	@Inject
	private FenomenoBean fenomenoBean;
	
	@Override
	public String echo() {
		return "Servicio Fenomenos Disponible";
	}
	
	@Override
	public Response getFenomenos() {
		try {
			
			List <FenomenoLocal> ret = fenomenoBean.obternerTodos();
			return Response.ok().entity(ret).build();

		} catch (PersistenciaException e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
