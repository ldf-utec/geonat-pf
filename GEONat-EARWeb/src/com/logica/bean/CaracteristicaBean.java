package com.logica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.CaracteristicaDAO;
import com.persistence.entities.Caracteristica;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.CaracteristicaLocal;


@Stateless
@LocalBean
public class CaracteristicaBean implements Serializable{
		
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private FenomenoBean fenomenoBean;

	private static final long serialVersionUID = 1L;

    public CaracteristicaBean() {

    }
    
    public List<CaracteristicaLocal> obternerCaracteristicasPorFenomeno(Long id) throws PersistenciaException {

		List<CaracteristicaLocal> caracteristicasLocales = new ArrayList<CaracteristicaLocal>();
		List<Caracteristica> caracteristicas = CaracteristicaDAO.buscarCaracteristicasPorFenomeno(em, id);

		for (Caracteristica c : caracteristicas) {

			caracteristicasLocales.add(toCaracteristicaLocal(c));
		}
		return caracteristicasLocales;
	}
    
    public List<CaracteristicaLocal> obternerTodas() throws PersistenciaException {

		List<CaracteristicaLocal> caracteristicasLocales = new ArrayList<CaracteristicaLocal>();
		List<Caracteristica> caracteristicas = CaracteristicaDAO.obtenerTodas(em);

		for (Caracteristica c : caracteristicas) {

			caracteristicasLocales.add(toCaracteristicaLocal(c));
		}
		return caracteristicasLocales;
	}
    
    public Caracteristica toCaracteristica(CaracteristicaLocal cl) {
		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setId_caracteristica(cl.getId_caracteristica() != null ? cl.getId_caracteristica().longValue() : null);
		caracteristica.setFenomeno(fenomenoBean.toFenomeno(cl.getFenomeno()));
		caracteristica.setEtiqueta_presentacion(cl.getEtiqueta_presentacion());
		caracteristica.setNombre(cl.getNombre());
		caracteristica.setTipo_dato(cl.getTipo_dato());
		
		return caracteristica;
	}

	public CaracteristicaLocal toCaracteristicaLocal(Caracteristica c) {
		CaracteristicaLocal caracteristicaLocal = new CaracteristicaLocal();
		caracteristicaLocal.setId_caracteristica(c.getId_caracteristica() != null ? c.getId_caracteristica().longValue() : null);
		caracteristicaLocal.setEtiqueta_presentacion(c.getEtiqueta_presentacion());
		caracteristicaLocal.setFenomeno(fenomenoBean.toFenomenoLocal(c.getFenomeno()));
		caracteristicaLocal.setNombre(c.getNombre());
		caracteristicaLocal.setTipo_dato(c.getTipo_dato());
		
		return caracteristicaLocal;
	}
}
