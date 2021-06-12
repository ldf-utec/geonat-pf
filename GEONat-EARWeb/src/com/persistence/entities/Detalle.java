package com.persistence.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Detalles")
@SequenceGenerator(
	    name="DetallesSeq",
	    sequenceName = "DETALLES_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Detalle implements Serializable {

	private static final long serialVersionUID = 1L;

	public Detalle() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetallesSeq")
	@Column(nullable = false)
	private Long Id_detalle;

	@Column(nullable = true)
	private Date valor_fecha_hora;
	
	@Column(nullable = true)
	private Integer valor_numerico;

	@Column(length = 60, nullable = true)
	private String valor_texto;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_caracteristica")
	private Caracteristica caracteristica;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_observacion")
	private Observacion observacion;

	public Long getId_detalle() {
		return Id_detalle;
	}

	public void setId_detalle(Long id_detalle) {
		Id_detalle = id_detalle;
	}

	public Date getValor_fecha_hora() {
		return valor_fecha_hora;
	}

	public void setValor_fecha_hora(Date valor_fecha_hora) {
		this.valor_fecha_hora = valor_fecha_hora;
	}

	public Integer getValor_numerico() {
		return valor_numerico;
	}

	public void setValor_numerico(Integer valor_numerico) {
		this.valor_numerico = valor_numerico;
	}

	public String getValor_texto() {
		return valor_texto;
	}

	public void setValor_texto(String valor_texto) {
		this.valor_texto = valor_texto;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}



