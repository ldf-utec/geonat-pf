package com.logica.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.DetalleDAO;
import com.persistence.entities.Detalle;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.DetalleLocal;
import com.presentacion.entitiesLocales.DetalleLocalRest;


@Stateless
@LocalBean
public class DetalleBean implements Serializable{

	@PersistenceContext
	private EntityManager em;
	private static final long serialVersionUID = 1L;
	
	@Inject
	CaracteristicaBean caracteristicaBean;
	
	@Inject
	ObservacionBean observacionBean;
	
	
    public DetalleBean() {
   
    }

    public void agregarDetalle(DetalleLocal detalle) throws PersistenciaException {
		DetalleDAO.agregarDetalle(em, toDetalle(detalle));
	} 
    
    public void modificarDetalle(DetalleLocal detalle) throws PersistenciaException {

		DetalleDAO.modificarDetalle(em, toDetalle(detalle));
	}
    
    public void eliminarDetalle(DetalleLocal detalle) throws PersistenciaException {
    	
    	DetalleDAO.eliminarDetalle(em, toDetalle(detalle));
    }
    
    public List<DetalleLocal> obternerTodas() throws PersistenciaException {

		List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
		List<Detalle> detalles = DetalleDAO.obtenerTodas(em);

		for (Detalle d : detalles) {

			detallesLocales.add(toDetalleLocal(d));
		}
		return detallesLocales;
	}
    
    public List<DetalleLocal> obternerDetallesPorObservacion(Long id_observacion) throws PersistenciaException {

		List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
		List<Detalle> detalles = DetalleDAO.obtenerDetallesPorObservacion(em, id_observacion);

		for (Detalle d : detalles) {

			detallesLocales.add(toDetalleLocal(d));
		}
		return detallesLocales;
	}
    
    public Detalle toDetalle(DetalleLocal dl) {
		Detalle detalle = new Detalle();
		detalle.setId_detalle(dl.getId_detalle() != null ? dl.getId_detalle() : null);
		detalle.setValor_fecha_hora(dl.getValor_fecha_hora() != null ? dl.getValor_fecha_hora() : null);
		detalle.setValor_numerico(dl.getValor_numerico() != null ? dl.getValor_numerico() : null);
		detalle.setValor_texto(dl.getValor_texto() != null ? dl.getValor_texto() : null);
		detalle.setCaracteristica(caracteristicaBean.toCaracteristica(dl.getCaracteristica()));
		detalle.setObservacion(observacionBean.toObservacion(dl.getObservacion()));
		
		return detalle;
	}

	public DetalleLocal toDetalleLocal(Detalle d) {
		DetalleLocal detalleLocal = new DetalleLocal();
		detalleLocal.setId_detalle(d.getId_detalle() != null ? d.getId_detalle() : null);
		detalleLocal.setValor_fecha_hora(d.getValor_fecha_hora() != null ? d.getValor_fecha_hora() : null);
		detalleLocal.setValor_numerico(d.getValor_numerico() != null ? d.getValor_numerico() : null);
		detalleLocal.setValor_texto(d.getValor_texto() != null ? d.getValor_texto() : null);
		detalleLocal.setCaracteristica(caracteristicaBean.toCaracteristicaLocal(d.getCaracteristica()));
		detalleLocal.setObservacion(observacionBean.toObservacionLocal(d.getObservacion()));
		
		return detalleLocal;
	}

	public DetalleLocalRest toDetalleLocalRest(DetalleLocal dl) {
		DetalleLocalRest detalleLocalRest = new DetalleLocalRest();
		detalleLocalRest.setId_detalle(dl.getId_detalle() != null ? dl.getId_detalle() : null);
		detalleLocalRest.setValor_fecha_hora(dl.getValor_fecha_hora() != null ? dl.getValor_fecha_hora() : null);
		detalleLocalRest.setValor_numerico(dl.getValor_numerico() != null ? dl.getValor_numerico() : null);
		detalleLocalRest.setValor_texto(dl.getValor_texto() != null ? dl.getValor_texto() : null);
		detalleLocalRest.setCaracteristica(dl.getCaracteristica());
		detalleLocalRest.setObservacion(observacionBean.toObservacionLocalRest(dl.getObservacion()));
		
		return detalleLocalRest;
	}

	public DetalleLocal toDetalleLocal(DetalleLocalRest d) throws ParseException {
		DetalleLocal detalleLocal = new DetalleLocal();
		detalleLocal.setId_detalle(d.getId_detalle() != null ? d.getId_detalle() : null);
		detalleLocal.setValor_fecha_hora(d.getValor_fecha_hora() != null ? d.getValor_fecha_hora() : null);
		detalleLocal.setValor_numerico(d.getValor_numerico() != null ? d.getValor_numerico() : null);
		detalleLocal.setValor_texto(d.getValor_texto() != null ? d.getValor_texto() : null);
		detalleLocal.setCaracteristica(d.getCaracteristica());
		detalleLocal.setObservacion(observacionBean.toObservacionLocal(d.getObservacion()));
		
		return detalleLocal;
	}
}
