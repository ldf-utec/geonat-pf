package com.logica.bean;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Stateless
@LocalBean
public class LoginBean {

	@Inject
	UsuarioBean usuarioBean;

	public LoginBean() {

	}

	public UsuarioLocal login(UsuarioLocal usuario) throws NamingException, PersistenciaException {

		Integer corteString = usuario.getNombreUsuario().indexOf("@");

		if (corteString != -1) {

			String nombreUsuario = usuario.getNombreUsuario().substring(0, corteString);
			boolean b = authenticateJndi(usuario.getNombreUsuario(), usuario.getPass());

			if (b) {
				try {
					usuario = usuarioBean.loginJndi(nombreUsuario);

				} catch (PersistenciaException e) {

					e.printStackTrace();
					throw new PersistenciaException("Usuario no se encuentra aún en el Sistema");
				}
			}

		} else {
			try {
				usuario = usuarioBean.login(usuario.getNombreUsuario(), usuario.getPass());

			} catch (PersistenciaException e) {

				e.printStackTrace();
				throw new PersistenciaException("Usuario o contraseña incorrectos, verifique los datos.");
			}
		}
		if (usuario.getEstado() == false) {

			throw new PersistenciaException("Usuario está dado de baja");
		}
		return usuario;
	}

	public static boolean authenticateJndi(String username, String password)
			throws NamingException, PersistenciaException {

		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		props.put(Context.PROVIDER_URL, "ldap://192.168.1.14:389");

		props.put(Context.SECURITY_PRINCIPAL, username);
		props.put(Context.SECURITY_CREDENTIALS, password);

		try {
			InitialDirContext context;
			context = new InitialDirContext(props);

		} catch (NamingException e) {

			if (e.getCause() != null) {
				if (e.getCause().getMessage().compareTo("Connection timed out") > 0) {
					throw new PersistenciaException("No hay conectividad con el Active Directory.");
				}
			}
			throw new PersistenciaException("Usuario o contraseña incorrectos, verifique los datos");
		}
		return true;
	}

}
