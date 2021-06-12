package com.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Detalle;
import com.persistence.exception.PersistenciaException;

public class DetalleDAO {
	
	public static void agregarDetalle(EntityManager em, Detalle detalle) throws PersistenciaException {

		try {
			
			em.persist(detalle);
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo agregar el detalle.", e);
		}
	}
	
	public static void modificarDetalle(EntityManager em, Detalle detalle) throws PersistenciaException {

		try {
			em.merge(detalle);
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo modificar el detalle.", e);
		}
	}
	
	public static void eliminarDetalle(EntityManager em, Detalle detalle) throws PersistenciaException {

		try {
			em.remove(em.contains(detalle) ? detalle : em.merge(detalle));
			em.flush();

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo eliminar el detalle.", e);
		}
	}
	
	public static List<Detalle> obtenerTodas(EntityManager em) throws PersistenciaException {

		try {

			String query = "Select c from Detalle c";
			List<Detalle> resultList = (List<Detalle>) em.createQuery(query, Detalle.class).getResultList();

			return resultList;

		} catch (PersistenceException e) {
			
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
	
	public static List<Detalle> obtenerDetallesPorObservacion(EntityManager em, Long id_observacion) throws PersistenciaException {

		try {

			String query = "Select c from Detalle c where c.observacion.id='"+ id_observacion+ "' ";
			List<Detalle> resultList = (List<Detalle>) em.createQuery(query, Detalle.class).getResultList();

			return resultList;

		} catch (PersistenceException e) {
			
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}

}
