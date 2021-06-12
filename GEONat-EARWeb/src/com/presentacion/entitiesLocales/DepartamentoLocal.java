package com.presentacion.entitiesLocales;

public class DepartamentoLocal {
	
	private Long Id_departamento;
	private int codigo;
	private String nombre;
	private ZonaLocal zona;
	
	public DepartamentoLocal() {
		
	}
	
	public DepartamentoLocal(Long Id_departamento, int codigo, String nombre, ZonaLocal zona) {
		this.Id_departamento= Id_departamento;
		this.codigo = codigo;
		this.nombre = nombre;
		this.zona = zona;
	}

	public Long getId_departamento() {
		return Id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		Id_departamento = id_departamento;
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

	public ZonaLocal getZona() {
		return zona;
	}

	public void setZona(ZonaLocal zona) {
		this.zona = zona;
	}


}
