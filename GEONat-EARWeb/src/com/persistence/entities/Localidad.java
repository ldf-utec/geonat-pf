package com.persistence.entities;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Localidad
 *
 */
@Entity
@Table(name = "Localidades", uniqueConstraints = {
		@UniqueConstraint(name = "UK_Localidades", columnNames = { "codigo" }) })
@SequenceGenerator(
	    name="LocalidadesSeq",
	    sequenceName = "LOCALIDADES_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Localidad implements Serializable {

	private static final long serialVersionUID = 1L;

	public Localidad() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocalidadesSeq")
	@Column(nullable = false)
	private Long Id_localidad;

	@Column(nullable = false)
	private int codigo;

	@Column(length = 30, nullable = false)
	private String nombre;
	
	@Column(precision = 2, scale = 5, nullable = false)
	private float latitud;

	@Column(precision = 2, scale = 5, nullable = false)
	private float longitud;
	
	@Column(precision = 2, scale = 5, nullable = false)
	private float altitud;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_departamento")
	private Departamento departamento;

	public Long getId_localidad() {
		return Id_localidad;
	}

	public void setId_localidad(Long id_localidad) {
		Id_localidad = id_localidad;
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


	

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getAltitud() {
		return altitud;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	

}

