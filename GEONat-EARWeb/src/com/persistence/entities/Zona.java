package com.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Zona
 *
 */
@Entity
@Table(name = "Zonas", uniqueConstraints = { @UniqueConstraint(name = "UK_Zonas", columnNames = { "codigo" }) })
@SequenceGenerator(
	    name="ZonasSeq",
	    sequenceName = "Zonas_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Zona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Zona() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ZonasSeq")
	@Column(nullable = false)
	private Long Id_Zona;

	@Column(nullable = false)
	private int codigo;

	@Column(length = 30, nullable = false)
	private String nombre;

	public Long getId_Zona() {
		return Id_Zona;
	}

	public void setId_Zona(Long id_Zona) {
		Id_Zona = id_Zona;
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

}
