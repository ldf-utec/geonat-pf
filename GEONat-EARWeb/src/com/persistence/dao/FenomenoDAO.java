package com.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.persistence.entities.Fenomeno;
import com.persistence.exception.PersistenciaException;

public class FenomenoDAO {

	public static List<Fenomeno> obtenerTodos(EntityManager em) throws PersistenciaException{

		try {
			String query = "Select f from Fenomeno f order by f.nombre";
			List<Fenomeno> resultList = (List<Fenomeno>) em.createQuery(query, Fenomeno.class).getResultList();
			return resultList;
			
		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}
}
