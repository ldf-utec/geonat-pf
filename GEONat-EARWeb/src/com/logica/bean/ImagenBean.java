package com.logica.bean;

import java.io.Serializable;
import java.text.ParseException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.persistence.dao.ImagenDAO;
import com.persistence.entities.Imagen;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.ImagenLocal;
import com.presentacion.entitiesLocales.ImagenLocalRest;

@Stateless
@LocalBean
public class ImagenBean implements Serializable {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private ObservacionBean observacionBean;
	private static final long serialVersionUID = 1L;

	public ImagenBean() {

	}

	public void agregar(ImagenLocal imagen) throws PersistenciaException {

		ImagenLocal imagen2 = new ImagenLocal();
		if (!imagen.equals(imagen2)) {
			ImagenDAO.agregar(em, toImagen(imagen));
		}
		
		
	}

	public void modificar(ImagenLocal imagen) throws PersistenciaException {

		ImagenDAO.modificar(em, toImagen(imagen));
	}

	public void eliminar(ImagenLocal imagen) throws PersistenciaException {

		ImagenDAO.eliminar(em, toImagen(imagen));
	}

	public ImagenLocal buscar(int id) throws PersistenciaException {

		return toImagenLocal(ImagenDAO.buscar(em, id));
	}
	
	public ImagenLocal buscarPorObservacion(Long id_observacion) throws PersistenciaException {

		return toImagenLocal(ImagenDAO.buscarPorObservacion(em, id_observacion));
	}

	public Imagen toImagen(ImagenLocal il) {
		Imagen imagen = new Imagen();
		imagen.setId_imagen(il.getId_imagen() != null ? il.getId_imagen() : null);
		imagen.setImagen(il.getImagen());
		imagen.setObservacion(observacionBean.toObservacion(il.getObservacion()));

		return imagen;
	}

	public ImagenLocal toImagenLocal(Imagen i) {
		ImagenLocal imagenLocal = new ImagenLocal();
		imagenLocal.setId_imagen(i.getId_imagen() != null ? i.getId_imagen() : null);
		imagenLocal.setImagen(i.getImagen());
		imagenLocal.setObservacion(observacionBean.toObservacionLocal(i.getObservacion()));

		return imagenLocal;
	}
	
	public ImagenLocalRest toImagenLocalRest(ImagenLocal il) {
		ImagenLocalRest imagenLocalRest = new ImagenLocalRest();
		imagenLocalRest.setId_imagen(il.getId_imagen() != null ? il.getId_imagen() : null);
		imagenLocalRest.setImagen(il.getImagen());
		imagenLocalRest.setObservacion(observacionBean.toObservacionLocalRest(il.getObservacion()));

		return imagenLocalRest;
	}

	public ImagenLocal toImagenLocal(ImagenLocalRest i) throws ParseException {
		ImagenLocal imagenLocal = new ImagenLocal();
		imagenLocal.setId_imagen(i.getId_imagen() != null ? i.getId_imagen() : null);
		imagenLocal.setImagen(i.getImagen());
		imagenLocal.setObservacion(observacionBean.toObservacionLocal(i.getObservacion()));

		return imagenLocal;
	}


}
