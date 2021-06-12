package com.persistence.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity

@Table(name = "Fenomenos", uniqueConstraints = { 
		@UniqueConstraint(name = "UK_FenomenosC", columnNames = { "codigo"}), 
		@UniqueConstraint(name = "UK_FenomenosN", columnNames = { "nombre"})})

@SequenceGenerator(
	    name="FenomenosSeq",
	    sequenceName = "FENOMENOS_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Fenomeno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FenomenosSeq")
	@Column(nullable = false)
	private Long Id_fenomeno;

	@Column(nullable = false)
	private int codigo;

	@Column(length = 30, nullable = false)
	private String nombre;

	@Column(length = 500, nullable = false)
	private String descripcion;

	@Column(length = 30, nullable = false)
	private String tel_emergencia;

	
	public Fenomeno() {
		super();
	}

	public Long getId_fenomeno() {
		return Id_fenomeno;
	}

	public void setId_fenomeno(Long id_fenomeno) {
		Id_fenomeno = id_fenomeno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTel_emergencia() {
		return tel_emergencia;
	}

	public void setTel_emergencia(String tel_emergencia) {
		this.tel_emergencia = tel_emergencia;
	}

	/**
	 * GETs and SETs
	 */



}
