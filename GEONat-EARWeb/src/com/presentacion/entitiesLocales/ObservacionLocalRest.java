package com.presentacion.entitiesLocales;

import java.util.Date;

public class ObservacionLocalRest {

	private Long id;

	private String descripcion;

	private float latitud;

	private float longitud;

	private float altitud;

	private String criticidad;

	String fechaHoraRegistro;

	private FenomenoLocal fenomeno;

	private String comentariosAdicionales;

	private String comentariosRev;

	private String fiabilidadRev;

	private Boolean estado;

	private Boolean cambioEstado;

	//Date fechaHoraRev = new Date();

	private UsuarioLocal volunatio;

	private UsuarioLocal experto;

	private LocalidadLocal localidad;

	public ObservacionLocalRest() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(String fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public FenomenoLocal getFenomeno() {
		return fenomeno;
	}

	public void setFenomeno(FenomenoLocal fenomeno) {
		this.fenomeno = fenomeno;
	}

	public String getComentariosAdicionales() {
		return comentariosAdicionales;
	}

	public void setComentariosAdicionales(String comentariosAdicionales) {
		this.comentariosAdicionales = comentariosAdicionales;
	}

	public String getComentariosRev() {
		return comentariosRev;
	}

	public void setComentariosRev(String comentariosRev) {
		this.comentariosRev = comentariosRev;
	}

	public String getFiabilidadRev() {
		return fiabilidadRev;
	}

	public void setFiabilidadRev(String fiabilidadRev) {
		this.fiabilidadRev = fiabilidadRev;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getCambioEstado() {
		return cambioEstado;
	}

	public void setCambioEstado(Boolean cambioEstado) {
		this.cambioEstado = cambioEstado;
	}

	/*
	 * public Date getFechaHoraRev() { return fechaHoraRev; }
	 * 
	 * public void setFechaHoraRev(Date fechaHoraRev) { this.fechaHoraRev =
	 * fechaHoraRev; }
	 */

	public UsuarioLocal getVolunatio() {
		return volunatio;
	}

	public void setVolunatio(UsuarioLocal volunatio) {
		this.volunatio = volunatio;
	}

	public UsuarioLocal getExperto() {
		return experto;
	}

	public void setExperto(UsuarioLocal experto) {
		this.experto = experto;
	}

	public LocalidadLocal getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadLocal localidad) {
		this.localidad = localidad;
	}

}
