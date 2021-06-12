package com.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Observaciones", uniqueConstraints={
		@UniqueConstraint(name = "UK_Observaciones", 
		columnNames = {"Id_observacion", "fechaHora_registro"})})

@SequenceGenerator(
	    name="ObservacionesSeq",
	    sequenceName = "OBSERVACIONES_SEQ",
	    initialValue = 1, 
	    allocationSize = 1
	)

public class Observacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public Observacion() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ObservacionesSeq")
	@Column(nullable = false)
	private Long Id_observacion;

	@Column(length = 500)
	private String descripcion;
	
	
	@Column(precision = 2, scale = 5, nullable = false)
	private float latitud;

	@Column(precision = 2, scale = 5, nullable = false)
	private float longitud;
	
	@Column(precision = 2, scale = 5, nullable = false)
	private float altitud;
	
	@Column(length = 30, nullable = false)
	private String criticidad;

	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaHora_registro;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_fenomeno")
	private Fenomeno fenomeno;

	@Column(length = 500)
	private String comentarios_adicionales;
	
	@Column(length = 500)
	private String comentarios_rev;

	@Column(length = 30)
	private String fiabilidad_rev;
	
	@Column(nullable = false)
	private Boolean estado;
	
	@Column(nullable = true)
	private Boolean cambio_estado;

	@Basic(optional = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaHora_rev;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_Usuario")
	private Usuario volunatio;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "Id_Experto")
	private Usuario experto;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Id_localidad")
	private Localidad localidad;

	public Long getId_observacion() {
		return Id_observacion;
	}

	public void setId_observacion(Long id_observacion) {
		Id_observacion = id_observacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getCriticidad() {
		return criticidad;
	}

	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
	}

	public Date getFechaHora_registro() {
		return fechaHora_registro;
	}

	public void setFechaHora_registro(Date fechaHora_registro) {
		this.fechaHora_registro = fechaHora_registro;
	}

	public Fenomeno getFenomeno() {
		return fenomeno;
	}

	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}

	public String getComentarios_adicionales() {
		return comentarios_adicionales;
	}

	public void setComentarios_adicionales(String comentarios_adicionales) {
		this.comentarios_adicionales = comentarios_adicionales;
	}

	public String getComentarios_rev() {
		return comentarios_rev;
	}

	public void setComentarios_rev(String comentarios_rev) {
		this.comentarios_rev = comentarios_rev;
	}

	public String getFiabilidad_rev() {
		return fiabilidad_rev;
	}

	public void setFiabilidad_rev(String fiabilidad_rev) {
		this.fiabilidad_rev = fiabilidad_rev;
	}

	public Date getFechaHora_rev() {
		return fechaHora_rev;
	}

	public void setFechaHora_rev(Date fechaHora_rev) {
		this.fechaHora_rev = fechaHora_rev;
	}


	public Usuario getVolunatio() {
		return volunatio;
	}

	public void setId_Volunatio(Usuario volunatio) {
		this.volunatio = volunatio;
	}

	public Usuario getExperto() {
		return experto;
	}

	public void setExperto(Usuario experto) {
		this.experto = experto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getCambio_estado() {
		return cambio_estado;
	}

	public void setCambio_estado(Boolean cambio_estado) {
		this.cambio_estado = cambio_estado;
	}
	
}


