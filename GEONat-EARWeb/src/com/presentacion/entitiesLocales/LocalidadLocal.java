package com.presentacion.entitiesLocales;

public class LocalidadLocal {

	
	private Long Id_localidad;
	private int codigo;
	private String nombre;
	private float latitud;
	private float longitud;
	private float altitud;
	private DepartamentoLocal departamento;
	
	public LocalidadLocal() {
		super();
	}
	
	public LocalidadLocal(Long Id_localidad, int codigo, String nombre, float latitud, float longitud, float altitud, DepartamentoLocal departamento) {
		super();
		this.Id_localidad= Id_localidad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.departamento = departamento;
	}

	public Long getId_localidad() {
		return Id_localidad;
	}

	public void setId_localidad(Long id_localidad) {
		Id_localidad = id_localidad;
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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getAltitud() {
		return altitud;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

	public DepartamentoLocal getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoLocal departamento) {
		this.departamento = departamento;
	}
	
	
}
