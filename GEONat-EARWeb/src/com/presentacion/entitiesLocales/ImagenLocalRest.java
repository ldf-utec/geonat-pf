package com.presentacion.entitiesLocales;

import java.io.Serializable;

public class ImagenLocalRest implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long Id_imagen;
	
	private byte[] imagen;
	
	private ObservacionLocalRest observacion;

	public Long getId_imagen() {
		return Id_imagen;
	}

	public void setId_imagen(Long id_imagen) {
		Id_imagen = id_imagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public ObservacionLocalRest getObservacion() {
		return observacion;
	}

	public void setObservacion(ObservacionLocalRest observacion) {
		this.observacion = observacion;
	}

}
