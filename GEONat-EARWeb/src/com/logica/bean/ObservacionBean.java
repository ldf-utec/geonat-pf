package com.logica.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.ObservacionDAO;
import com.persistence.entities.Observacion;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.ObservacionLocal;
import com.presentacion.entitiesLocales.ObservacionLocalRest;

@Stateless
@LocalBean
public class ObservacionBean implements Serializable {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private FenomenoBean fenomenoBean;
	@Inject
	private UsuarioBean usuarioBean;
	@Inject
	private LocalidadBean localidadBean;

	private static final long serialVersionUID = 1L;

	public ObservacionBean() {

	}
	
	public void agregarObservacion(ObservacionLocal observacionSeleccionada) throws PersistenciaException {

		ObservacionDAO.agregarObservacion(em, toObservacion(observacionSeleccionada));
	}

	public void modificarObservacion(ObservacionLocal observacionSeleccionada) throws PersistenciaException {

		ObservacionDAO.modificarObservacion(em, toObservacion(observacionSeleccionada));
	}

	public void eliminarObservacion(ObservacionLocal observacion) throws PersistenciaException {

		ObservacionDAO.eliminarObservacion(em, toObservacion(observacion));
	}

	public ObservacionLocal buscarObservacion(Long id) throws PersistenciaException {

		return toObservacionLocal(ObservacionDAO.buscarObservacion(em, id));
	}
	
	public Long getIdUltimaObservacion() throws PersistenciaException {

		return ObservacionDAO.getIdUltimaObservacion(em);
	}

	public List<ObservacionLocal> obternerTodas() throws PersistenciaException {

		List<ObservacionLocal> observacionesLocales = new ArrayList<ObservacionLocal>();
		List<Observacion> observaciones = ObservacionDAO.obtenerTodas(em);

		for (Observacion o : observaciones) {

			observacionesLocales.add(toObservacionLocal(o));
		}
		return observacionesLocales;
	}
	
	//obtiene las observaciones para el primer reporte (por zona)
	public List<ObservacionLocal> obtenerReporte(String nombreZona, Date fechaIni, Date fechaFin) throws PersistenciaException{
		
		List<ObservacionLocal> observacionesLocales = new ArrayList<ObservacionLocal>();
		List<Observacion> observaciones = ObservacionDAO.obtenerReporte(em, nombreZona, fechaIni, fechaFin);
		
		for (Observacion o : observaciones) {

			observacionesLocales.add(toObservacionLocal(o));
		}
		return observacionesLocales;
	}
	
	//obtiene las observaciones para el segundo reporte (por criticidad)
		public List<ObservacionLocal> obtenerReporte2(String nombreCriticidad, Date fechaIni, Date fechaFin) throws PersistenciaException{
			
			List<ObservacionLocal> observacionesLocales = new ArrayList<ObservacionLocal>();
			List<Observacion> observaciones = ObservacionDAO.obtenerReporte2(em, nombreCriticidad, fechaIni, fechaFin);
			
			for (Observacion o : observaciones) {

				observacionesLocales.add(toObservacionLocal(o));
			}
			return observacionesLocales;
		}

	public Observacion toObservacion(ObservacionLocal ol) {
		Observacion observacion = new Observacion();
		observacion.setId_observacion(ol.getId() != null ? ol.getId().longValue() : null);
		observacion.setAltitud(ol.getAltitud());
		observacion.setCambio_estado(ol.getCambioEstado());
		observacion.setComentarios_adicionales(ol.getComentariosAdicionales());
		observacion.setComentarios_rev(ol.getComentariosRev());
		observacion.setCriticidad(ol.getCriticidad());
		observacion.setDescripcion(ol.getDescripcion());
		observacion.setEstado(ol.getEstado());
		observacion.setFechaHora_registro(ol.getFechaHoraRegistro());
		observacion.setFechaHora_rev(ol.getFechaHoraRev());
		observacion.setFenomeno(fenomenoBean.toFenomeno(ol.getFenomeno()));
		observacion.setFiabilidad_rev(ol.getFiabilidadRev());
		observacion.setExperto(ol.getExperto() != null ? usuarioBean.toUsuario(ol.getExperto()) : null);
		observacion.setId_Volunatio(usuarioBean.toUsuario(ol.getVolunatio()));
		observacion.setLatitud(ol.getLatitud());
		observacion.setLocalidad(localidadBean.toLocalidad(ol.getLocalidad()));
		observacion.setLongitud(ol.getLongitud());

		return observacion;
	}

	public ObservacionLocal toObservacionLocal(Observacion o) {
		ObservacionLocal observacionLocal = new ObservacionLocal();
		observacionLocal.setId(o.getId_observacion() != null ? o.getId_observacion().longValue() : null);
		observacionLocal.setAltitud(o.getAltitud());
		observacionLocal.setCambioEstado(o.getCambio_estado());
		observacionLocal.setComentariosAdicionales(o.getComentarios_adicionales());
		observacionLocal.setComentariosRev(o.getComentarios_rev());
		observacionLocal.setCriticidad(o.getCriticidad());
		observacionLocal.setDescripcion(o.getDescripcion());
		observacionLocal.setEstado(o.getEstado());
		observacionLocal.setFechaHoraRegistro(o.getFechaHora_registro());
		observacionLocal.setFechaHoraRev(o.getFechaHora_rev());
		observacionLocal.setExperto(o.getExperto() != null ? usuarioBean.toUsuarioLocal(o.getExperto()) : null);
		observacionLocal.setVolunatio(usuarioBean.toUsuarioLocal(o.getVolunatio()));
		observacionLocal.setLatitud(o.getLatitud());
		observacionLocal.setLocalidad(localidadBean.toLocalidadLocal(o.getLocalidad()));
		observacionLocal.setLongitud(o.getLongitud());
		observacionLocal.setFenomeno(fenomenoBean.toFenomenoLocal(o.getFenomeno()));
		observacionLocal.setFiabilidadRev(o.getFiabilidad_rev());

		return observacionLocal;
	}

	public ObservacionLocalRest toObservacionLocalRest(ObservacionLocal ol) {
		ObservacionLocalRest observacion = new ObservacionLocalRest();
		observacion.setId(ol.getId() != null ? ol.getId().longValue() : null);
		observacion.setAltitud(ol.getAltitud());
		observacion.setCambioEstado(ol.getCambioEstado());
		observacion.setComentariosAdicionales(ol.getComentariosAdicionales());
		observacion.setComentariosRev(ol.getComentariosRev());
		observacion.setCriticidad(ol.getCriticidad());
		observacion.setDescripcion(ol.getDescripcion());
		observacion.setEstado(ol.getEstado());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		String fechaFechaHoraReg = dateFormat.format(ol.getFechaHoraRegistro()); 
		observacion.setFechaHoraRegistro(fechaFechaHoraReg);
		//observacion.setFechaHoraRev(ol.getFechaHoraRev());
		observacion.setFenomeno(ol.getFenomeno());
		observacion.setFiabilidadRev(ol.getFiabilidadRev());
		observacion.setExperto(ol.getExperto() != null ? ol.getExperto() : null);
		observacion.setVolunatio(ol.getVolunatio());
		observacion.setLatitud(ol.getLatitud());
		observacion.setLocalidad(ol.getLocalidad());
		observacion.setLongitud(ol.getLongitud());

		return observacion;
	}

	public ObservacionLocal toObservacionLocal(ObservacionLocalRest o) throws ParseException {
		ObservacionLocal observacionLocal = new ObservacionLocal();
		observacionLocal.setId(o.getId() != null ? o.getId().longValue() : null);
		observacionLocal.setAltitud(o.getAltitud());
		observacionLocal.setCambioEstado(o.getCambioEstado());
		observacionLocal.setComentariosAdicionales(o.getComentariosAdicionales());
		observacionLocal.setComentariosRev(o.getComentariosRev());
		observacionLocal.setCriticidad(o.getCriticidad());
		observacionLocal.setDescripcion(o.getDescripcion());
		observacionLocal.setEstado(o.getEstado());
		observacionLocal.setFechaHoraRegistro(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(o.getFechaHoraRegistro()));
		//observacionLocal.setFechaHoraRev(o.getFechaHoraRev());
		observacionLocal.setExperto(o.getExperto() != null ? o.getExperto() : null);
		observacionLocal.setVolunatio(o.getVolunatio());
		observacionLocal.setLatitud(o.getLatitud());
		observacionLocal.setLocalidad(o.getLocalidad());
		observacionLocal.setLongitud(o.getLongitud());
		observacionLocal.setFenomeno(o.getFenomeno());
		observacionLocal.setFiabilidadRev(o.getFiabilidadRev());

		return observacionLocal;
	}
}
