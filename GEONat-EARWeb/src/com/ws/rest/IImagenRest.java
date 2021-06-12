package com.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.presentacion.entitiesLocales.ImagenLocal;

@Path("imagen")
public interface IImagenRest {
	
	@GET
	@Path("echo")
	@Produces({ MediaType.TEXT_PLAIN })
	public String echo();
	
	@POST
    @Path("/subir")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response agregar(ImagenLocal imagen);	
	
	@GET
    @Path("/buscar/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response buscarPorObservacion(@PathParam("id") Long id);	

}