package com.presentacion.dto;


import com.entities.TipoDocumento;
import com.entities.TipoUsuario;

public class UsuarioDTO {

	private Integer id;
	
	private String nombreUsuario;
	
	private String nombre;
	
	private String apellido;

	private TipoDocumento tipoDocumento;

	private String nroDocumento;

	private String email;

	private String direccion;

	private Boolean estadoActivo;

	private TipoUsuario tipoUsuario;
	
	private String password;

	
	// Constructores
	public UsuarioDTO(Integer id, String nombreUsuario, String nombre, String apellido,
			TipoDocumento tipoDocumento, String nroDocumento, String email, String direccion, TipoUsuario tipoUsuario, String password) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.email = email;
		this.direccion = direccion;
		this.tipoUsuario = tipoUsuario;
		this.password = password;
	}

	
	public UsuarioDTO() {
		super();
	}


	// Getters y Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Boolean getEstadoActivo() {
		return estadoActivo;
	}


	public void setEstadoActivo(Boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
