package com.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Imagen
 *
 */
@Entity
@Table(name = "Imagenes", uniqueConstraints = { @UniqueConstraint(name = "UK_Imagenes", columnNames = { "Id_observacion", "Id_imagen" }) })
@SequenceGenerator(
	    name="ImagenesSeq",
	    sequenceName = "IMAGENES_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Imagen implements Serializable {

	private static final long serialVersionUID = 1L;

	public Imagen() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ImagenesSeq")
	@Column(nullable = false)
	private Long Id_imagen;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_observacion")
	private Observacion observacion;

	@Lob
	@Column(nullable = true)
	private byte[] imagen;

	public Long getId_imagen() {
		return Id_imagen;
	}

	public void setId_imagen(Long id_imagen) {
		Id_imagen = id_imagen;
	}


	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

