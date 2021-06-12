package com.presentacion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import com.logica.bean.DetalleBean;
import com.logica.bean.ObservacionBean;
import com.logica.bean.ZonaBean;
import com.persistence.exception.Mensajes;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.DetalleLocal;
import com.presentacion.entitiesLocales.ObservacionLocal;
import com.presentacion.entitiesLocales.ZonaLocal;

@Named(value = "gestionReporte")
@SessionScoped
public class GestionReporte implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	ObservacionBean observacionBean;
	@EJB
	ZonaBean zonaBean;
	@EJB
	DetalleBean detalleBean;

	private ObservacionLocal observacion;
	private List<ObservacionLocal> observaciones = new ArrayList<ObservacionLocal>();
	private List<DetalleLocal> detalles = new ArrayList<DetalleLocal>();
	private List<ZonaLocal> zonas = new ArrayList<ZonaLocal>();
	private ArrayList<String> criticidades = new ArrayList<String>();
	private HashMap<String, ZonaLocal> zonaHash = new HashMap<String, ZonaLocal>();
	private ZonaLocal zona;
	private Date fechaIni;
	private Date fechaFin;
	private String criticidad;

	public GestionReporte() {
		super();
	}
	
	
	public void obtenerZonas() throws PersistenciaException {
		zonas = zonaBean.obternerTodas();

		for (ZonaLocal z : zonas) {
			zonaHash.put(z.getNombre(), z);
		}
	}
	
	public void obtenerCriticidades() throws PersistenciaException {
		criticidades.add(0,"Baja");
		criticidades.add(1,"Media");
		criticidades.add(2,"Alta");

	}

	
	public void obtenerDetallesPorObservacion() throws PersistenciaException {

		detalles = detalleBean.obternerDetallesPorObservacion(observacion.getId());
	}

	//obtiene las observaciones para el primer reporte (por zonas)
	public void buscarObservaciones() throws PersistenciaException {
		try {

			observaciones.clear();

			if (this.fechaIni == null || this.fechaFin == null) {
				throw new PersistenciaException("Debe ingresar ambas fechas");
			}
			
			if(this.fechaIni.compareTo(this.fechaFin) > 0) {
				throw new PersistenciaException("La fecha de Fin debe ser posterior a la fecha de Inicio.");
			}

			this.observaciones = observacionBean.obtenerReporte(this.zona.getNombre(), this.fechaIni, this.fechaFin);

			if (this.observaciones.size() == 0) {
				throw new PersistenciaException("No hay resultados para la búsqueda.");
			}

		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_WARN, "Advertencia:", e.getMessage());
			e.printStackTrace();
		}
	}
	
	//obtiene las observaciones para el segundo reporte (por criticidad)
	public void buscarObservaciones2() throws PersistenciaException {
		try {

			observaciones.clear();

			if (this.fechaIni == null || this.fechaFin == null) {
				throw new PersistenciaException("Debe ingresar ambas fechas");
			}
			
			if(this.fechaIni.compareTo(this.fechaFin) > 0) {
				throw new PersistenciaException("La fecha de Fin debe ser posterior a la fecha de Inicio.");
			}

			this.observaciones = observacionBean.obtenerReporte2(this.getCriticidad(), this.fechaIni, this.fechaFin);
			System.out.println("criticidad "+this.getCriticidad()+"fecha inicio "+this.fechaIni+"fecha final "+this.fechaFin);
			

			if (this.observaciones.size() == 0) {
				throw new PersistenciaException("No hay resultados para la búsqueda.");
			}

		} catch (PersistenciaException e) {

			Mensajes.mostrar(FacesMessage.SEVERITY_WARN, "Advertencia:", e.getMessage());
			e.printStackTrace();
		}
	}

	public String mostrarObservacion(ObservacionLocal obs) {
		this.setObservacion(obs);
		return "mostrarObservacion.xhtml";
	}

	//lleva a pagina de reportes por fecha y zona
	public String menuItem1() {
		observaciones.clear();
		fechaIni = null;
		fechaFin = null;
		zona = null;
		return "/pages/reporte/buscarObservacionReporte.xhtml";
	}
	
	//lleva a pagina de reportes por fecha y criticidad
	public String menuItem2() {
		observaciones.clear();
		fechaIni = null;
		fechaFin = null;
		zona = null;
		return "/pages/reporte/buscarObservacionReporte2.xhtml";
	}
	

	/////////// GettersAndSetters/////////////////
	public List<ObservacionLocal> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<ObservacionLocal> observaciones) {
		this.observaciones = observaciones;
	}

	public ZonaLocal getZona() {
		return zona;
	}

	public void setZona(ZonaLocal zona) {
		this.zona = zona;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<ZonaLocal> getZonas() {
		return zonas;
	}
	

	public void setZonas(List<ZonaLocal> zonas) {
		this.zonas = zonas;
	}

	public HashMap<String, ZonaLocal> getZonaHash() {
		return zonaHash;
	}

	public void setZonaHash(HashMap<String, ZonaLocal> zonaHash) {
		this.zonaHash = zonaHash;
	}

	public ObservacionLocal getObservacion() {
		return observacion;
	}

	public void setObservacion(ObservacionLocal observacion) {
		this.observacion = observacion;
	}

	public List<DetalleLocal> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleLocal> detalles) {
		this.detalles = detalles;
	}


	public String getCriticidad() {
		return criticidad;
	}


	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
	}


	public ArrayList<String> getCriticidades() {
		return criticidades;
	}


	public void setCriticidades(ArrayList<String> criticidades) {
		this.criticidades = criticidades;
	}
	
	
}
