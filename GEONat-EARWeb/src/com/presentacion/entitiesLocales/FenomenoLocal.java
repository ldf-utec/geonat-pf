package com.presentacion.entitiesLocales;

public class FenomenoLocal {
	
	private Long Id_fenomeno;

	private int codigo;

	private String nombre;

	private String descripcion;

	private String tel_emergencia;

	public Long getId_fenomeno() {
		return Id_fenomeno;
	}

	public void setId_fenomeno(Long id_fenomeno) {
		Id_fenomeno = id_fenomeno;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTel_emergencia() {
		return tel_emergencia;
	}

	public void setTel_emergencia(String tel_emergencia) {
		this.tel_emergencia = tel_emergencia;
	}

}
