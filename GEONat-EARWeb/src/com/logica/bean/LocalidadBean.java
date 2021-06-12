package com.logica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.LocalidadDAO;
import com.persistence.entities.Localidad;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.LocalidadLocal;

@Stateless
@LocalBean
public class LocalidadBean implements Serializable{

	@PersistenceContext
	private EntityManager em;
	@Inject
	private DepartamentoBean departamentoBean;
	private static final long serialVersionUID = 1L;
	
	
    public LocalidadBean() {

    }    
    
    public List<LocalidadLocal> obternerTodas() throws PersistenciaException {

		List<LocalidadLocal> localidadesLocales = new ArrayList<LocalidadLocal>();
		List<Localidad> localidades = LocalidadDAO.obtenerTodas(em);

		for (Localidad l: localidades) {
			localidadesLocales.add(toLocalidadLocal(l));
		}
		return localidadesLocales;
	}
    
    public Localidad toLocalidad(LocalidadLocal ll) {
		Localidad localidad = new Localidad();
		localidad.setId_localidad(ll.getId_localidad() != null ? ll.getId_localidad() : null);
		localidad.setAltitud(ll.getAltitud());
		localidad.setLatitud(ll.getLatitud());
		localidad.setLongitud(ll.getLongitud());
		localidad.setCodigo(ll.getCodigo());
		localidad.setNombre(ll.getNombre());
		localidad.setDepartamento(departamentoBean.toDepartamento(ll.getDepartamento()));
			
		return localidad;
	}

	public LocalidadLocal toLocalidadLocal(Localidad l) {
		LocalidadLocal localidadLocal = new LocalidadLocal();
		localidadLocal.setId_localidad(l.getId_localidad());
		localidadLocal.setAltitud(l.getAltitud());
		localidadLocal.setLatitud(l.getLatitud());
		localidadLocal.setLongitud(l.getLongitud());
		localidadLocal.setCodigo(l.getCodigo());
		localidadLocal.setNombre(l.getNombre());
		localidadLocal.setDepartamento(departamentoBean.toDepartamentoLocal(l.getDepartamento()));
			
		return localidadLocal;
	}


}
