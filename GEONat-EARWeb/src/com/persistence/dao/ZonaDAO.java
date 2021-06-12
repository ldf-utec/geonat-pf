package com.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Zona;
import com.persistence.exception.PersistenciaException;

public class ZonaDAO {

	public static List<Zona> obtenerTodas(EntityManager em) throws PersistenciaException {

		try {
			String query = "Select z from Zona z";
			List<Zona> resultList = (List<Zona>) em.createQuery(query, Zona.class).getResultList();
			return resultList;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
}