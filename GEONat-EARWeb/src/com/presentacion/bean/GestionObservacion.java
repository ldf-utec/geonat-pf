package com.presentacion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import com.logica.bean.DetalleBean;
import com.logica.bean.ImagenBean;
import com.logica.bean.ObservacionBean;
import com.persistence.exception.Mensajes;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.DetalleLocal;
import com.presentacion.entitiesLocales.ObservacionLocal;
import com.presentacion.entitiesLocales.UsuarioLocal;

@Named(value = "gestionObservacion")
@SessionScoped
public class GestionObservacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	ObservacionBean observacionBean;
	@EJB
	DetalleBean detalleBean;
	@EJB
	ImagenBean imagenBean;

	private ObservacionLocal observacion;
	private Long idObservacion = null;

	private List<ObservacionLocal> observaciones = new ArrayList<ObservacionLocal>();
	private List<DetalleLocal> detalles = new ArrayList<DetalleLocal>();

	private Date date;

	public GestionObservacion() {
		super();
	}

	public void obtenerTodas() throws PersistenciaException {
		observaciones.clear();
		observaciones = observacionBean.obternerTodas();
	}

	public void init() throws PersistenciaException {
		detalles = detalleBean.obternerDetallesPorObservacion(observacion.getId());
	}

	public String salvarCambios() {
		try {

			observacion.setFechaHoraRev(date = new Date());
			observacion.setExperto((UsuarioLocal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario"));
			observacionBean.modificarObservacion(this.observacion);

			Mensajes.mostrar(FacesMessage.SEVERITY_INFO, "Info:", "Se ha modificado exitosamente");

		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_ERROR, "Error:", "No se pudo agregar el usuario");
			e.printStackTrace();
		}

		observaciones.clear();
		return "/pages/bienvenido/bienvenido.xhtml";

	}

	public void buscarObservacion() throws PersistenciaException {
		try {

			observaciones.clear();

			if (idObservacion == null) {
				throw new PersistenciaException("Debe ingresar un Id de observación para realizar la búsqueda");
			}
			observacion = observacionBean.buscarObservacion(this.idObservacion);
			observaciones.add(this.observacion);
			idObservacion = null;

		} catch (PersistenciaException e) {
			
			Mensajes.mostrar(FacesMessage.SEVERITY_WARN, "Advertencia:", e.getMessage());
			e.printStackTrace();
		}
	}

	public String revisar(ObservacionLocal obs) throws PersistenciaException {
		this.setObservacion(obs);
		return "/pages/observacion/revisionObservacion.xhtml";
	}

	public String menuItem() {
		observaciones.clear();
		return "/pages/observacion/buscarObservacion.xhtml";
	}

	/////////// GettersAndSetters/////////////////
	public ObservacionLocal getObservacion() {
		return observacion;
	}

	public void setObservacion(ObservacionLocal observacion) {
		this.observacion = observacion;
	}

	public List<ObservacionLocal> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<ObservacionLocal> observaciones) {
		this.observaciones = observaciones;
	}

	public List<DetalleLocal> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleLocal> detalles) {
		this.detalles = detalles;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdObservacion() {
		return idObservacion;
	}

	public void setIdObservacion(Long idObservacion) {
		this.idObservacion = idObservacion;
	}

}
