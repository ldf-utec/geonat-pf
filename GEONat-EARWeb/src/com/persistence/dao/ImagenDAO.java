package com.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Imagen;
import com.persistence.exception.PersistenciaException;

public class ImagenDAO {

	public static void agregar(EntityManager em, Imagen imagen) throws PersistenciaException {
		try {
			em.persist(imagen);
			em.flush();
		} catch (PersistenceException e) {
			
			throw new PersistenciaException("No se pudo crear la imagen");
		}
	}

	public static void modificar(EntityManager em,Imagen imagen) throws PersistenciaException {
		try {
			em.merge(imagen);
			em.flush();
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo actualizar la imagen");
		}
	}

	public static void eliminar(EntityManager em, Imagen imagen) throws PersistenciaException {
		try {
			em.remove(em.contains(imagen) ? imagen : em.merge(imagen));
			em.flush();
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo eliminar la imagen");
		}
	} 

	public static Imagen buscar(EntityManager em,int id) throws PersistenciaException {
		try {
			Imagen imagen = em.find(Imagen.class, id);
			return imagen;
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo encontrar la imagen");
		}
	}
	
	public static Imagen buscarPorObservacion (EntityManager em, Long id_observacion) throws PersistenciaException {
			
		try {

			String query = "Select i from Imagen i where i.observacion.id='"+ id_observacion+ "' ";
			Imagen result = (Imagen) em.createQuery(query, Imagen.class).getSingleResult();

			return result;

		} catch (PersistenceException e) {
			
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
}
