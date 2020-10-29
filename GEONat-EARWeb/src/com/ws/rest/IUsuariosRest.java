package com.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.exception.ServiciosException;
import com.presentacion.dto.UsuarioDTO;

@Path("/usuarios")
public interface IUsuariosRest {
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> listarUsuarios() throws ServiciosException;
}
