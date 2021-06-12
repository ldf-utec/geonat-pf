package com.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Usuario;
import com.persistence.exception.PersistenciaException;

public class UsuarioDAO {

	public static void agregarUsuario(EntityManager em, Usuario usuario) throws PersistenciaException {

		try {
			em.persist(usuario);
			em.flush();

		} catch (Exception e) {
			
			if (e.getCause().getCause().getMessage().contains("UK_USUARIOSNU")) {
				
				throw new PersistenciaException("El nombre de usuario ingresado ya esta en uso, por favor elija otro.", e);
			
			} else if (e.getCause().getCause().getMessage().contains("UK_USUARIOSD")) {

				throw new PersistenciaException("El número de documento ingresado ya existe en el sistema", e);
			
			} else {
			
				throw new PersistenciaException("No se pudo agregar el usuario.", e);
			}
		}
	}

	public static void modificarUsuario(EntityManager em, Usuario usuario) throws PersistenciaException {

		try {
			em.merge(usuario);
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo modificar el usuario.", e);
		}
	}

	public static void bajaUsuario(EntityManager em, Usuario usuario) throws PersistenciaException {

		try {
			usuario.setEstado(false);
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo dar de baja el usuario.", e);
		}
	}

	public static Usuario buscarUsuario(EntityManager em, String criterioNombreUsuario, String criterioNumDoc)
			throws PersistenciaException {

		try {

			String query = "Select u from Usuario u  ";
			String queryCriterio = "";

			if (criterioNombreUsuario != null && !criterioNombreUsuario.contentEquals("")) {

				queryCriterio += (!queryCriterio.isEmpty() ? " and " : "") + " u.nombreUsuario='"
						+ criterioNombreUsuario + "' ";
			}
			if (criterioNumDoc != null && !criterioNumDoc.equals("")) {
				queryCriterio += (!queryCriterio.isEmpty() ? " and " : "") + " u.numDoc='" + criterioNumDoc + "'  ";
			}

			if (!queryCriterio.contentEquals("")) {
				query += " where " + queryCriterio;
			}

			Usuario usuario = em.createQuery(query, Usuario.class).getSingleResult();
			return usuario;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}

	public static Usuario login(EntityManager em, String user, String pass) throws PersistenciaException {

		try {
			String query = "Select u from Usuario u where u.nombreUsuario='" + user + "' and u.pass='" + pass + "'";

			Usuario u = em.createQuery(query, Usuario.class).getSingleResult();
			return u;

		} catch (PersistenceException e) {
			throw new PersistenciaException("Usuario o contraseña Incorrectos", e);
		}
	}

	public static Usuario loginJndi(EntityManager em, String user) throws PersistenciaException {

		try {
			String query = "Select u from Usuario u where u.nombreUsuario='" + user + "'";

			Usuario u = em.createQuery(query, Usuario.class).getSingleResult();
			return u;

		} catch (PersistenceException e) {
			throw new PersistenciaException("El Usuario no está creado en el Sistema", e);
		}
	}

}
