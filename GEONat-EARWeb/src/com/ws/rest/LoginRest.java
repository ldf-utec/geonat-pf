package com.ws.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;
import com.logica.bean.LoginBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Stateless
@LocalBean
public class LoginRest implements ILoginRest {

	@Inject
	private LoginBean loginBean;
	
	public String echo() {
		return "Servicio Login Disponible";
	}
	
	public Response Login(UsuarioLocal usuario) throws NamingException {
		
		try {
			usuario = loginBean.login(usuario);
			return Response.ok().entity("ok").build();
			
		} catch (PersistenciaException e) {
			
			return Response.ok().entity(e.getMessage()).build();
		}
	}
	
	public Response LoginUsuario(UsuarioLocal usuario) throws NamingException{
		try {
			usuario = loginBean.login(usuario);
			return Response.ok().entity(usuario).build();
			
		} catch (PersistenciaException e) {
			
			return Response.ok().entity(e.getMessage()).build();
		}
	}
}