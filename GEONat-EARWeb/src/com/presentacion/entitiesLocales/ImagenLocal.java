package com.presentacion.entitiesLocales;

import java.io.Serializable;
import java.util.Arrays;

public class ImagenLocal implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long Id_imagen;
	
	private byte[] imagen;
	
	private ObservacionLocal observacion;

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

	public ObservacionLocal getObservacion() {
		return observacion;
	}

	public void setObservacion(ObservacionLocal observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "ImagenLocal [Id_imagen=" + Id_imagen + ", imagen=" + Arrays.toString(imagen) + ", observacion="
				+ observacion + "]";
	}
	
	
	
}
