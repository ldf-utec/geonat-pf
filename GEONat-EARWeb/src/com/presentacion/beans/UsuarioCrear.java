package com.presentacion.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.businessLogic.services.UsuarioService;
import com.entities.TipoDocumento;
import com.entities.TipoUsuario;
import com.exception.ServiciosException;
import com.presentacion.dto.UsuarioDTO;
import java.io.Serializable;

@Named
@ViewScoped
public class UsuarioCrear implements Serializable {
	
	private UsuarioDTO usuario;
	
	@Inject
	private UsuarioService usuarioService;
	
	public UsuarioCrear() {
		
	}
	
	
	//se ejecuta antes de desplegar la vista
		public void preRenderViewListener() {
			usuario = new UsuarioDTO();
		}
	

	
	public String salvarCambios() throws ServiciosException{
				
		usuario.setId(0);
		usuario.setTipoDocumento(TipoDocumento.CI);
		usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
		usuario.setEstadoActivo(true);
			
		UsuarioDTO u = (UsuarioDTO) usuarioService.agregarUsuario(usuario);
		
		//mensaje de actualizacion
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo Empleado", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		
		return "Usuarios?faces-redirect=true&includeViewParams=true";
	}


	
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
		
		
	}
