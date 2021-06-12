package com.ws.rest;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.ObservacionFinal;


@Path("observacion")
public interface IObservacionRest {

	@GET
	@Path("echo")
	@Produces({ MediaType.TEXT_PLAIN })
	public String echo();

	@POST
	@Path("agregar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarObservacion(ObservacionFinal observacionFinal) throws ParseException;
	
	@DELETE
	@Path("/eliminar")
	public Response eliminarObservacion(ObservacionFinal observacionFinal) throws ParseException;
	
	@PUT
	@Path("modificar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarObservacion(ObservacionFinal observacionFinal) throws PersistenciaException, ParseException;
	
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObservaciones();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObservacion(@PathParam("id") Long id) throws PersistenciaException;
	
}