package com.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: USUARIOS
 * @author Winux
 */

@Entity
@Table(name = "Usuarios", uniqueConstraints={@UniqueConstraint(name = "UK_UsuariosNU", columnNames = {"nombreUsuario"}), @UniqueConstraint(name = "UK_UsuariosD", columnNames = { "numDoc"})})
@SequenceGenerator(
	    name="UsuariosSeq",
	    sequenceName = "USUARIOS_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuariosSeq")
	@Column(nullable = false)
	private Long id_usuario;
	
	@Column(length = 30, nullable = false)
	private String nombreUsuario;	
	
	@Column(nullable = true)
	private Boolean voluntario;
	
	@Column(nullable = true)
	private Boolean experto;
	
	@Column(nullable = true)
	private Boolean administrador;
	

	@Column(length = 40, nullable = false)
	private String nombre;
	
	@Column(length = 40, nullable = false)
	private String apellido;
	
	//Activo, Baja
	@Column(nullable = false)
	private Boolean estado;
	
	//CI, Pasaporte, Carta ciudadania, Otro
	@Column(length = 30, nullable = false)
	private String tipoDoc;
	
	@Column(length = 30, nullable = false)
	private String numDoc;	
	
	@Column(length = 40, nullable = false)
	private String direccion;
	
	@Column(length = 60, nullable = false)
	private String correo;
	
	@Column(length = 70, nullable = false)
	private String pass;
		
	public Usuario() {
		
	}
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return id_usuario;
	}

	public void setId(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

}