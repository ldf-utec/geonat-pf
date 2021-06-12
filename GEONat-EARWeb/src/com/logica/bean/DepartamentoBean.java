package com.logica.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.persistence.entities.Departamento;
import com.presentacion.entitiesLocales.DepartamentoLocal;

@Stateless
@LocalBean
public class DepartamentoBean {

	@Inject
	private ZonaBean zonaBean;
	
    public DepartamentoBean() {

    }
    
    public Departamento toDepartamento(DepartamentoLocal dl) {
		Departamento departamento = new Departamento();
		departamento.setId_departamento(dl.getId_departamento() != null ? dl.getId_departamento().longValue() : null);
		departamento.setCodigo(dl.getCodigo());
		departamento.setNombre(dl.getNombre());
		departamento.setZona(zonaBean.toZona(dl.getZona()));
		
		return departamento;
	}

	public DepartamentoLocal toDepartamentoLocal(Departamento d) {
		DepartamentoLocal departamentoLocal = new DepartamentoLocal();
		departamentoLocal.setId_departamento(d.getId_departamento());
		departamentoLocal.setCodigo(d.getCodigo());
		departamentoLocal.setNombre(d.getNombre());
		departamentoLocal.setZona(zonaBean.toZonaLocal(d.getZona()));
		
		return departamentoLocal;
	}

}
