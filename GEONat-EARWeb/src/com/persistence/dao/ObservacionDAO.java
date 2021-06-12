package com.persistence.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TemporalType;
import com.persistence.entities.Observacion;
import com.persistence.exception.PersistenciaException;

public class ObservacionDAO {

	public static void agregarObservacion(EntityManager em, Observacion observacion) throws PersistenciaException {

		try {
			observacion.setFechaHora_rev(null);
			em.persist(observacion);
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo agregar la observacion.", e);
		}
	}

	public static void modificarObservacion(EntityManager em, Observacion observacion) throws PersistenciaException {

		try {
			em.merge(observacion);
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo modificar la observacion.", e);
		}
	}

	public static void eliminarObservacion(EntityManager em, Observacion observacion) throws PersistenciaException {
		try {
			em.remove(em.contains(observacion) ? observacion : em.merge(observacion));
			em.flush();
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo borrar la observacion", e);
		}
	}

	public static Observacion buscarObservacion(EntityManager em, Long id) throws PersistenciaException {

		try {

			Observacion observacion = em.find(Observacion.class, id);
			if (observacion == null) {
				throw new PersistenciaException("No se pudo encontrar la observación, verifique el número de ID");
			}
			return observacion;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo encontrar la Observación", e);
		}
	}

	public static List<Observacion> obtenerTodas(EntityManager em) throws PersistenciaException {

		try {

			String query = "Select o from Observacion o ORDER BY o.Id_observacion";
			List<Observacion> resultList = (List<Observacion>) em.createQuery(query, Observacion.class).getResultList();
			return resultList;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
	
	public static Long getIdUltimaObservacion(EntityManager em) throws PersistenciaException{
		
		try {

			String query = "Select o.Id_observacion from Observacion o order by o.Id_observacion desc";
			Long result = (Long) em.createQuery(query, Long.class).setMaxResults(1).getSingleResult();
			return result;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	} 

	//obtiene observaciones para la primerareporte (por zonas)
	public static List<Observacion> obtenerReporte(EntityManager em, String nombreZona, Date fechaIni, Date fechaFin)
			throws PersistenciaException {

		try {
			
			String query = "Select o from Observacion o Where o.localidad.departamento.zona.nombre = :nombreZona and o.fechaHora_registro Between :fechaIni and :fechaFin";
			List<Observacion> resultList = (List<Observacion>) em.createQuery(query, Observacion.class).setParameter("fechaIni", fechaIni, TemporalType.DATE).setParameter("fechaFin", fechaFin, TemporalType.DATE).setParameter("nombreZona", nombreZona).getResultList();
			return resultList;

		} catch (PersistenceException e) {
			throw new PersistenciaException("Verifique las fechas ingresadas", e);
		}
	}
	
	//obtiene observaciones para el segundo reporte (por criticidad)
		public static List<Observacion> obtenerReporte2(EntityManager em, String nombreCriticidad, Date fechaIni, Date fechaFin)
				throws PersistenciaException {

			try {
				
				String query = "Select o from Observacion o Where o.criticidad = :nombreCriticidad and o.fechaHora_registro Between :fechaIni and :fechaFin";
				List<Observacion> resultList = (List<Observacion>) em.createQuery(query, Observacion.class).setParameter("fechaIni", fechaIni, TemporalType.DATE).setParameter("fechaFin", fechaFin, TemporalType.DATE).setParameter("nombreCriticidad", nombreCriticidad).getResultList();
				return resultList;

			} catch (PersistenceException e) {
				throw new PersistenciaException("Verifique las fechas ingresadas", e);
			}
		}

}
