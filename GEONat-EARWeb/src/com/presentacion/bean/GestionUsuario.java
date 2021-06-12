package com.presentacion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import com.logica.bean.UsuarioBean;
import com.persistence.exception.Mensajes;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Named(value = "gestionUsuario")
@SessionScoped

public class GestionUsuario implements Serializable {

	@EJB
	UsuarioBean usuarioBean;
	private static final long serialVersionUID = 1L;

	private String criterioNombreUsuario;
	private String criterioNumDoc;
	private String modalidad;

	private UsuarioLocal usuarioSeleccionado;
	private List<UsuarioLocal> usuariosSeleccionados = new ArrayList<UsuarioLocal>();;

	public GestionUsuario() {
		super();
	}

	public void preRenderViewListener() {
		usuarioSeleccionado = new UsuarioLocal();
		usuarioSeleccionado.setEstado(true);
	}

	public String salvarCambios() {
		try {
			if(usuarioSeleccionado.getVoluntario() == false && usuarioSeleccionado.getAdministrador() == false && usuarioSeleccionado.getExperto() == false) {

				throw new PersistenciaException("Debe seleccionar al menos un rol para el usuario");
			}
			
			usuarioBean.agregarUsuario(this.usuarioSeleccionado);
			Mensajes.mostrar(FacesMessage.SEVERITY_INFO, "Info:", "Se ha agregado un nuevo Usuario");
			this.usuariosSeleccionados.clear();
			return "/pages/bienvenido/bienvenido.xhtml";
		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_ERROR, "Error:", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String modificar() {
		try {
			if(usuarioSeleccionado.getVoluntario() == false && usuarioSeleccionado.getAdministrador() == false && usuarioSeleccionado.getExperto() == false) {

				throw new PersistenciaException("Debe seleccionar al menos un rol para el usuario");
			}

			usuarioBean.modificarUsuario(this.usuarioSeleccionado);
			Mensajes.mostrar(FacesMessage.SEVERITY_INFO, "Info:", "Se ha modificado el usuario correctamente");
			this.usuariosSeleccionados.clear();
			return "/pages/bienvenido/bienvenido.xhtml";
			
		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_ERROR, "Error:", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void buscarUsuario() throws PersistenciaException {

		try {

			usuariosSeleccionados.clear();

			if (criterioNombreUsuario.equals("") && criterioNumDoc.equals("")) {
				throw new PersistenciaException("Campos Vacíos");
			}

			usuarioSeleccionado = usuarioBean.buscarUsuario(criterioNombreUsuario, criterioNumDoc);
			usuariosSeleccionados.add(usuarioSeleccionado);
			this.criterioNombreUsuario = "";
			this.criterioNumDoc = "";

		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_WARN, "Advertencia:",
					"No se pudo encontrar el usuario, verifique los datos ingresados");
			e.printStackTrace();
		}
	}

	public void bajaUsuario() {

		try {

			usuarioBean.bajaUsuario(this.usuarioSeleccionado);
			usuarioSeleccionado.setEstado(false);
			Mensajes.mostrar(FacesMessage.SEVERITY_INFO, "Info:", "El usuario ha sido dado de baja");

		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_ERROR, "Error:", "No se pudo dar de baja el Usuario");
			e.printStackTrace();
		}
	}

	public String menuItem() {
		this.usuariosSeleccionados.clear();
		return "/pages/usuario/buscarUsuario.xhtml";
	}
	
	public String cancelar() {
		this.usuariosSeleccionados.clear();
		return "/pages/bienvenido/bienvenido.xhtml";
	}

	// Setters and Getters///////////////////////////////
	public UsuarioLocal getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(UsuarioLocal usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public String getCriterioNombreUsuario() {
		return criterioNombreUsuario;
	}

	public void setCriterioNombreUsuario(String criterioNombreUsuario) {
		this.criterioNombreUsuario = criterioNombreUsuario;
	}

	public String getCriterioNumDoc() {
		return criterioNumDoc;
	}

	public void setCriterioNumDoc(String criterioNumDoc) {
		this.criterioNumDoc = criterioNumDoc;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public List<UsuarioLocal> getUsuariosSeleccionados() {
		return usuariosSeleccionados;
	}

	public void setUsuariosSeleccionados(List<UsuarioLocal> usuariosSeleccionados) {
		this.usuariosSeleccionados = usuariosSeleccionados;
	}

}
