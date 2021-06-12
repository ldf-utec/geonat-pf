package com.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import com.persistence.entities.Caracteristica;
import com.persistence.exception.PersistenciaException;

public class CaracteristicaDAO {
	
public static List<Caracteristica> buscarCaracteristicasPorFenomeno(EntityManager em, Long id) throws PersistenciaException {
		
		try {
			String query = "Select c from Caracteristica c where c.fenomeno.Id_fenomeno='" + id + "' ";
			List<Caracteristica> caracteristica = (List<Caracteristica>) em.createQuery(query, Caracteristica.class).getResultList();
			return caracteristica;
			
		}catch(PersistenceException e) {
			throw new PersistenciaException("No se pudo encontrar las Característica", e);
		}
		
	}

	public static List<Caracteristica> obtenerTodas(EntityManager em) throws PersistenciaException {

		try {

			String query = "Select c from Caracteristica c";
			List<Caracteristica> resultList = (List<Caracteristica>) em.createQuery(query, Caracteristica.class).getResultList();
			return resultList;

		} catch (PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(), e);
		}
	}

}
