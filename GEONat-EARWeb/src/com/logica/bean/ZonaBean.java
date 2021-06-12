package com.logica.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.ZonaDAO;
import com.persistence.entities.Zona;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.ZonaLocal;

@Stateless
@LocalBean
public class ZonaBean {

	@PersistenceContext
	private EntityManager em;

	public ZonaBean() {

	}

	public List<ZonaLocal> obternerTodas() throws PersistenciaException {

		List<ZonaLocal> zonasLocales = new ArrayList<ZonaLocal>();
		List<Zona> zonas = ZonaDAO.obtenerTodas(em);

		for (Zona z : zonas) {
			zonasLocales.add(toZonaLocal(z));
		}
		return zonasLocales;
	}

	public Zona toZona(ZonaLocal zl) {
		Zona zona = new Zona();
		zona.setId_Zona(zl.getId_Zona() != null ? zl.getId_Zona().longValue() : null);
		zona.setCodigo(zl.getCodigo());
		zona.setNombre(zl.getNombre());

		return zona;
	}

	public ZonaLocal toZonaLocal(Zona z) {
		ZonaLocal zonaLocal = new ZonaLocal();
		zonaLocal.setId_Zona(z.getId_Zona());
		zonaLocal.setCodigo(z.getCodigo());
		zonaLocal.setNombre(z.getNombre());

		return zonaLocal;
	}

}
