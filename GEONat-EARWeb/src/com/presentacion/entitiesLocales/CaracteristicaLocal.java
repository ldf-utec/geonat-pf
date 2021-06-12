package com.presentacion.entitiesLocales;

import java.io.Serializable;

public class CaracteristicaLocal implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long Id_caracteristica;

	private String etiqueta_presentacion;

	private String nombre;
	
	private String tipo_dato;

	private FenomenoLocal fenomeno;

	public Long getId_caracteristica() {
		return Id_caracteristica;
	}

	public void setId_caracteristica(Long id_caracteristica) {
		Id_caracteristica = id_caracteristica;
	}

	public String getEtiqueta_presentacion() {
		return etiqueta_presentacion;
	}

	public void setEtiqueta_presentacion(String etiqueta_presentacion) {
		this.etiqueta_presentacion = etiqueta_presentacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_dato() {
		return tipo_dato;
	}

	public void setTipo_dato(String tipo_dato) {
		this.tipo_dato = tipo_dato;
	}

	public FenomenoLocal getFenomeno() {
		return fenomeno;
	}

	public void setFenomeno(FenomenoLocal fenomeno) {
		this.fenomeno = fenomeno;
	}
	
}
