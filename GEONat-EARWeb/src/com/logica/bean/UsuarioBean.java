package com.logica.bean;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.UsuarioDAO;
import com.persistence.entities.Usuario;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Stateless
@LocalBean

public class UsuarioBean implements Serializable {

	@PersistenceContext
	private EntityManager em;

	private static final long serialVersionUID = 1L;

	public void agregarUsuario(UsuarioLocal usuarioSeleccionado) throws PersistenciaException{
		UsuarioDAO.agregarUsuario(em, toUsuario(usuarioSeleccionado));
	}

	public void modificarUsuario(UsuarioLocal usuarioSeleccionado) throws PersistenciaException {
		UsuarioDAO.modificarUsuario(em, toUsuario(usuarioSeleccionado));
	}

	public UsuarioLocal buscarUsuario(String criterioNombreUsuario, String criterioNumDoc)
			throws PersistenciaException {
		return toUsuarioLocal(UsuarioDAO.buscarUsuario(em, criterioNombreUsuario, criterioNumDoc));
	}

	public void bajaUsuario(UsuarioLocal usuarioSeleccionado) throws PersistenciaException {
		UsuarioDAO.bajaUsuario(em, toUsuario(usuarioSeleccionado));
	}

	public UsuarioLocal login(String user, String pass) throws PersistenciaException {
		return toUsuarioLocal(UsuarioDAO.login(em, user, pass));
	}
	
	public UsuarioLocal loginJndi(String user) throws PersistenciaException {
		return toUsuarioLocal(UsuarioDAO.loginJndi(em, user));
	}


	////////////////////// Funciones para los
	////////////////////// Usuarios//////////////////////////////////
	public Usuario toUsuario(UsuarioLocal uc) {
		Usuario usuario = new Usuario();
		usuario.setId(uc.getId() != null ? uc.getId() : null);
		usuario.setNombre(uc.getNombre());
		usuario.setApellido(uc.getApellido());
		usuario.setExperto(uc.getExperto());
		usuario.setAdministrador(uc.getAdministrador());
		usuario.setVoluntario(uc.getVoluntario());
		usuario.setTipoDoc(uc.getTipoDoc());
		usuario.setNumDoc(uc.getNumDoc());
		usuario.setDireccion(uc.getDireccion());
		usuario.setNombreUsuario(uc.getNombreUsuario());
		usuario.setCorreo(uc.getCorreo());
		usuario.setPass(uc.getPass());
		usuario.setEstado(uc.getEstado());
		return usuario;
	}

	public UsuarioLocal toUsuarioLocal(Usuario u) {
		UsuarioLocal usuarioLocal = new UsuarioLocal();
		usuarioLocal.setId(u.getId());
		usuarioLocal.setExperto(u.getExperto());
		usuarioLocal.setAdministrador(u.getAdministrador());
		usuarioLocal.setVoluntario(u.getVoluntario());
		usuarioLocal.setNombre(u.getNombre());
		usuarioLocal.setApellido(u.getApellido());
		usuarioLocal.setTipoDoc(u.getTipoDoc());
		usuarioLocal.setNumDoc(u.getNumDoc());
		usuarioLocal.setDireccion(u.getDireccion());
		usuarioLocal.setNombreUsuario(u.getNombreUsuario());
		usuarioLocal.setCorreo(u.getCorreo());
		usuarioLocal.setPass(u.getPass());
		usuarioLocal.setEstado(u.getEstado());
		return usuarioLocal;
	}
}
