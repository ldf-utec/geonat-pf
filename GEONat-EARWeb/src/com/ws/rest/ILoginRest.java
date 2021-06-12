package com.ws.rest;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.presentacion.entitiesLocales.UsuarioLocal;

@Path("login")
public interface ILoginRest {
	
	@GET
	@Path("echo")
	@Produces({ MediaType.TEXT_PLAIN })
	public String echo();

	@POST
	@Path("autenticar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Login(UsuarioLocal usuario) throws NamingException;
	
	@POST
	@Path("autenticarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response LoginUsuario(UsuarioLocal usuario) throws NamingException;
}
