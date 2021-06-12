package com.logica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.FenomenoDAO;
import com.persistence.entities.Fenomeno;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.FenomenoLocal;



@Stateless
@LocalBean
public class FenomenoBean implements Serializable {

	
	@PersistenceContext
	private EntityManager em;
	private static final long serialVersionUID = 1L;
	
	public FenomenoBean() {
    	
    }
	
	public List<FenomenoLocal> obternerTodos() throws PersistenciaException {

		List<FenomenoLocal> fenomenosLocales = new ArrayList<FenomenoLocal>();
		List<Fenomeno> fenomenos = FenomenoDAO.obtenerTodos(em);

		for (Fenomeno f : fenomenos) {
			fenomenosLocales.add(toFenomenoLocal(f));
		}
	
		return fenomenosLocales;
	}
    
	public Fenomeno toFenomeno(FenomenoLocal fl) {
		Fenomeno fenomeno = new Fenomeno();
		fenomeno.setId_fenomeno(fl.getId_fenomeno() != null ? fl.getId_fenomeno().longValue() : null);
		fenomeno.setCodigo(fl.getCodigo());
		fenomeno.setDescripcion(fl.getDescripcion());
		fenomeno.setNombre(fl.getNombre());
		fenomeno.setTel_emergencia(fl.getTel_emergencia());
		
		return fenomeno;
	}

	public FenomenoLocal toFenomenoLocal(Fenomeno f) {
		FenomenoLocal fenomenoLocal = new FenomenoLocal();
		fenomenoLocal.setId_fenomeno(f.getId_fenomeno());
		fenomenoLocal.setCodigo(f.getCodigo());
		fenomenoLocal.setDescripcion(f.getDescripcion());
		fenomenoLocal.setNombre(f.getNombre());
		fenomenoLocal.setTel_emergencia(f.getTel_emergencia());
		
		return fenomenoLocal;
	}

}
