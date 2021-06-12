package com.presentacion.entitiesLocales;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ObservacionLocal implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long id;

	@Length(max = 500)
	private String descripcion;

	@NotNull
	private float latitud;

	@NotNull
	private float longitud;

	@NotNull
	private float altitud;

	@NotNull
	@Length(max = 30)
	private String criticidad;

	@NotNull
	Date fechaHoraRegistro = new Date();

	@NotNull
	private FenomenoLocal fenomeno;

	@Length(max = 500)
	private String comentariosAdicionales;

	@Length(max = 500)
	private String comentariosRev;

	@Length(max = 30)
	private String fiabilidadRev;

	@NotNull
	private Boolean estado;

	private Boolean cambioEstado;

	Date fechaHoraRev = new Date();

	@NotNull
	private UsuarioLocal volunatio;

	private UsuarioLocal experto;

	@NotNull
	private LocalidadLocal localidad;

	public ObservacionLocal() {

	}

	public ObservacionLocal(Long id, String descripcion, float latitud, float longitud, float altitud,
			String criticidad, Date fechaHoraRegistro, FenomenoLocal fenomeno, String comentariosAdicionales,
			String comentariosRev, String fiabilidadRev, Boolean estado, Boolean cambioEstado, Date fechaHoraRev,
			UsuarioLocal voluntario, UsuarioLocal experto, LocalidadLocal localidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.criticidad = criticidad;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.fenomeno = fenomeno;
		this.comentariosAdicionales = comentariosAdicionales;
		this.comentariosRev = comentariosRev;
		this.fiabilidadRev = fiabilidadRev;
		this.estado = estado;
		this.cambioEstado = cambioEstado;
		this.fechaHoraRev = fechaHoraRev;
		this.volunatio = voluntario;
		this.experto = experto;
		this.localidad = localidad;

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

	public Date getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(Date fechaHoraRegistro) {
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

	public Date getFechaHoraRev() {
		return fechaHoraRev;
	}

	public void setFechaHoraRev(Date fechaHoraRev) {
		this.fechaHoraRev = fechaHoraRev;
	}

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
