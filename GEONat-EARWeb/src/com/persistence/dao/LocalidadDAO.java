package com.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Localidad;
import com.persistence.exception.PersistenciaException;

public class LocalidadDAO {
	
	public static List<Localidad> obtenerTodas(EntityManager em) throws PersistenciaException{

		try {
			String query = "Select l from Localidad l order by l.nombre";
			List<Localidad> resultList = (List<Localidad>) em.createQuery(query, Localidad.class).getResultList();
			return resultList;
			
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
}
