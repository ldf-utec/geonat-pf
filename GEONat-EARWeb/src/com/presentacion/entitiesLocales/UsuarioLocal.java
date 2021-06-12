package com.presentacion.entitiesLocales;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UsuarioLocal {

	private Long id;
	
	//nombre
	@NotNull
	@Length(max=40)
	private String nombre;
	
	//apellido
	@NotNull
	@Length(max=40)
	private String apellido;
	
	private Boolean voluntario;
	
	private Boolean experto;
	
	private Boolean administrador;

	
	//tipoDoc
	@NotNull
	@Length(max=30)
	private String tipoDoc;
	
	//numDoc
	@NotNull
	@Length(max=30)
	private String numDoc;
	
	//direccion
	@NotNull
	@Length(max=40)
	private String direccion;
	
	//nombreUsuario
	@NotNull
	@Length(max=40)
	private String nombreUsuario;
	
	//email
	@NotNull
	@Length(max=60)
	private String correo;
	
	//password
	@NotNull
	@Length(max=70)
	private String pass;
	
	//activo
	@NotNull
	private boolean estado;
	
	public UsuarioLocal() {
		
	}
	
	public UsuarioLocal(Long id, String nombre, String apellido, boolean experto, boolean administrador, boolean voluntario, String tipoDoc, String numDoc, String direccion, String nombreUsuario, String correo, String pass, Boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.experto = experto;
		this.administrador = administrador;
		this.voluntario = voluntario;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.pass = pass;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Boolean getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Boolean voluntario) {
		this.voluntario = voluntario;
	}

	public Boolean getExperto() {
		return experto;
	}

	public void setExperto(Boolean experto) {
		this.experto = experto;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}	
}
