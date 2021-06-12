package com.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.persistence.exception.PersistenciaException;

@Path("caracteristica")
public interface ICaracteristicaRest {

	@GET
	@Path("echo")
	@Produces({ MediaType.TEXT_PLAIN })
	public String echo();

	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCaracteristicas();
	
	//Colocas el ID del fenomeno, y te trae las caracteristyicas del mismo
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCaracteristicasPorFenomeno(@PathParam("id") Long id) throws PersistenciaException;
	
}