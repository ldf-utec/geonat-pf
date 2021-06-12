package com.presentacion.entitiesLocales;

public class ZonaLocal {

	private Long Id_Zona;
	private int codigo;
	private String nombre;

	public ZonaLocal() {

	}

	public ZonaLocal(Long Id_Zona, int codigo, String nombre) {
		
		this.Id_Zona = Id_Zona;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Long getId_Zona() {
		return Id_Zona;
	}

	public void setId_Zona(Long id_Zona) {
		Id_Zona = id_Zona;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
