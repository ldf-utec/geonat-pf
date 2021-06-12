package com.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Caracteristica
 *
 */
@Entity
@Table(name = "Caracteristicas")
@SequenceGenerator(
	    name="CaracteristicasSeq",
	    sequenceName = "CARACTERISTICAS_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Caracteristica implements Serializable {

	private static final long serialVersionUID = 1L;

	public Caracteristica() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CaracteristicasSeq")
	@Column(nullable = false)
	private Long Id_caracteristica;

	@Column(length = 60, nullable = true)
	private String etiqueta_presentacion;

	@Column(length = 40, nullable = true)
	private String nombre;
	
	@Column(length = 40, nullable = true)
	private String tipo_dato;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Id_fenomeno")
	private Fenomeno fenomeno;

	public Long getId_caracteristica() {
		return Id_caracteristica;
	}

	public void setId_caracteristica(Long id_caracteristica) {
		Id_caracteristica = id_caracteristica;
	}

	public String getEtiqueta_presentacion() {
		return etiqueta_presentacion;
	}

	public void setEtiqueta_presentacion(String etiqueta_presentacion) {
		this.etiqueta_presentacion = etiqueta_presentacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_dato() {
		return tipo_dato;
	}

	public void setTipo_dato(String tipo_dato) {
		this.tipo_dato = tipo_dato;
	}

	public Fenomeno getFenomeno() {
		return fenomeno;
	}

	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

