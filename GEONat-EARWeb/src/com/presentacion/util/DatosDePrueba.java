package com.presentacion.util;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.interfaces.IUsuarioDAO;
import com.entities.TipoDocumento;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Servlet implementation class DatosDePrueba
 */
@WebServlet("/DatosDePrueba")
public class DatosDePrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	IUsuarioDAO usuarioDAO;

	
    public DatosDePrueba() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		creaUsuarios();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	//-------  USUARIOS
			private void creaUsuarios() {
						
				 try {
					 
					 List<Usuario> listaUsuarios = usuarioDAO.obtenerTodos();
					 
					 if (listaUsuarios.size()<1) {
						System.out.println("NO existen datos de prueba de Usuarios: "+ listaUsuarios.size() );
						for (int i = 0; i < 10; i++) {
							Usuario u = new Usuario();
							u.setNombre("Nombre" + i);
							u.setApellido("Apellido" + i);
							u.setNombreUsuario("nombreUsuario" + i);
							u.setDireccion("Dirección" + i);
							u.setEmail("email" + i + "@email" + 1+ ".com");
							u.setNroDocumento("0000000" + i);
							u.setEstadoActivo(true);
							u.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
							u.setTipoDocumento(TipoDocumento.CARTA_CIUDADANIA);
							u.setPassword(Integer.toString(i));
												
							// Llamada al servicio remoto UsuarioBeanRemote para solicitarle que cree el usuario "usuario1"
							try {
								usuarioDAO.create(u);
								System.out.println("Usuario creado " + i);
								System.out.println("Vez: " + i + "Lista: " + listaUsuarios.size());
							} catch (ServiciosException err) {
								err.printStackTrace();
							}
						}
					}
					else {
						System.out.println("Ya existen datos de prueba Usuarios");
					}
					
				} catch (ServiciosException e) {
					e.printStackTrace();
				} ;
			}

}
