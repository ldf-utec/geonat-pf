package com.businessLogic.services;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.DAO.concrete.UsuarioDAO;
import com.DAO.interfaces.IUsuarioDAO;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.presentacion.dto.UsuarioDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value="usuarioService")
@SessionScoped		
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	IUsuarioDAO usuarioDAO;
	
	public UsuarioDTO fromUsuario(Usuario u) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(u.getId_Usuario().intValue());
		usuarioDTO.setNombreUsuario(u.getNombreUsuario());
		usuarioDTO.setNombre(u.getNombre());
		usuarioDTO.setApellido(u.getApellido());
		usuarioDTO.setTipoDocumento(u.getTipoDocumento());
		usuarioDTO.setNroDocumento(u.getNroDocumento());
		usuarioDTO.setEmail(u.getEmail());
		usuarioDTO.setDireccion(u.getDireccion());
		usuarioDTO.setEstadoActivo(u.getEstadoActivo());
		usuarioDTO.setTipoUsuario(u.getTipoUsuario());;
		usuarioDTO.setPassword(u.getPassword());
		return usuarioDTO;
	}
	
	
	public Usuario toUsuario(UsuarioDTO u) {
		Usuario usuario = new Usuario();
		usuario.setId_Usuario(u.getId().intValue());
		usuario.setNombreUsuario(u.getNombreUsuario());
		usuario.setNombre(u.getNombre());
		usuario.setApellido(u.getApellido());
		usuario.setTipoDocumento(u.getTipoDocumento());
		usuario.setNroDocumento(u.getNroDocumento());
		usuario.setEmail(u.getEmail());
		usuario.setDireccion(u.getDireccion());
		usuario.setEstadoActivo(u.getEstadoActivo());
		usuario.setTipoUsuario(u.getTipoUsuario());
		usuario.setPassword(u.getPassword());
		return usuario;
	}
	
	
	// servicios para capa de Presentacion
	
	public List<UsuarioDTO> obtenerUsuarios() throws ServiciosException {
		List<Usuario> usuarios = usuarioDAO.obtenerTodos();
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarios) {
			lista.add(fromUsuario(u));
		}
		return lista;
	}
	
	public UsuarioDTO buscarUsuario(Integer id) throws ServiciosException {
		Usuario u = usuarioDAO.obtenerUno(id);
		return fromUsuario(u);
	}
	
	public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws ServiciosException  {
		Usuario u = usuarioDAO.create(toUsuario(usuarioDTO));
		return fromUsuario(u);
	}


	public void actualizarUsuario(UsuarioDTO usuarioDTO) throws ServiciosException   {
		Usuario u = usuarioDAO.update(toUsuario(usuarioDTO));
	}
	
	
	
	
	
}
