package com.ws.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.businessLogic.services.UsuarioService;
import com.exception.ServiciosException;
import com.presentacion.dto.UsuarioDTO;

@Stateless
@LocalBean
public class UsuariosRest implements IUsuariosRest{

	@Inject
	private UsuarioService usuariosService;

	@Override
	public List<UsuarioDTO> listarUsuarios() throws ServiciosException  {
		
		List<UsuarioDTO> usuarios = usuariosService.obtenerUsuarios();
		
		return usuarios;
	
	}
	
	
	
}
