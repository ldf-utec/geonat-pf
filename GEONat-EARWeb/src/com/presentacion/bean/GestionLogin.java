package com.presentacion.bean;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import com.logica.bean.LoginBean;
import com.logica.bean.UsuarioBean;
import com.persistence.exception.Mensajes;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Named(value = "gestionLogin")
@SessionScoped

public class GestionLogin implements Serializable {

	@EJB
	UsuarioBean usuarioBean;
	@EJB
	LoginBean loginBean;

	private static final long serialVersionUID = 1L;
	private UsuarioLocal usuarioLogin = new UsuarioLocal();


	public GestionLogin() {
		super();
	}

	public String login() throws PersistenciaException, NamingException {
		
		try {
			usuarioLogin = loginBean.login(usuarioLogin);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuarioLogin);
			return "/pages/bienvenido/bienvenido.xhtml";
		}catch(PersistenciaException e) {
			
			Mensajes.mostrar(FacesMessage.SEVERITY_ERROR, "Error:", e.getMessage());
		}
		return null;	
	}

	public void logout() throws IOException {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoFinal/index.xhtml");
	}

	public void verificarSesion() {

		try {
			UsuarioLocal u = (UsuarioLocal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			if (u == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoFinal/index.xhtml");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void verificarSesionLogueado() {

		try {
			UsuarioLocal u = (UsuarioLocal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			if (u != null) {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/ProyectoFinal/pages/bienvenido/bienvenido.xhtml");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	
	/////// Setters and Getters///////
	public UsuarioLocal getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioLocal usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

}
