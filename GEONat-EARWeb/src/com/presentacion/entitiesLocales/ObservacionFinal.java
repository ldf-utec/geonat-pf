package com.presentacion.entitiesLocales;

import java.util.List;

public class ObservacionFinal {
	
	private ObservacionLocalRest observacion;
	private ImagenLocalRest imagen;
	private List<DetalleLocalRest> detalles;
	
	public ObservacionFinal() {
		
	}
	
	public ObservacionLocalRest getObservacion() {
		return observacion;
	}
	public void setObservacion(ObservacionLocalRest observacion) {
		this.observacion = observacion;
	}
	public ImagenLocalRest getImagen() {
		return imagen;
	}
	public void setImagen(ImagenLocalRest imagen) {
		this.imagen = imagen;
	}
	public List<DetalleLocalRest> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleLocalRest> detalles) {
		this.detalles = detalles;
	}
	
	

}
