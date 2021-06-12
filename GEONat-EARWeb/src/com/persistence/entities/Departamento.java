package com.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
@Table(name = "Departamentos")
@SequenceGenerator(
	    name="DepartamentosSeq",
	    sequenceName = "DEPARTAMENTOS_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	public Departamento() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DepartamentosSeq")
	@Column(nullable = false)
	private Long Id_departamento;

	@Column(nullable = false)
	private int codigo;

	@Column(length = 40, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_zona")
	private Zona zona;

	public Long getId_departamento() {
		return Id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		Id_departamento = id_departamento;
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

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}

