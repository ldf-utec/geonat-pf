package com.presentacion.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.businessLogic.services.UsuarioService;
import com.exception.ServiciosException;
import com.presentacion.dto.UsuarioDTO;
import java.io.Serializable;

@Named
@ViewScoped
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UsuarioDTO> listaUsuarios;
	
	@Inject
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() throws ServiciosException {
		listaUsuarios = usuarioService.obtenerUsuarios();
	}

	
	
	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
}
