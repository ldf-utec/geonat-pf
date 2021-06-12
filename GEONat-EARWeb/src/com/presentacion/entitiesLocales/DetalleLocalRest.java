package com.presentacion.entitiesLocales;

import java.io.Serializable;
import java.util.Date;

public class DetalleLocalRest implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long Id_detalle;

	private Date valor_fecha_hora;
	
	private Integer valor_numerico;

	private String valor_texto;

	private CaracteristicaLocal caracteristica;
	
	private ObservacionLocalRest observacion;

	public Long getId_detalle() {
		return Id_detalle;
	}

	public void setId_detalle(Long id_detalle) {
		Id_detalle = id_detalle;
	}

	public Date getValor_fecha_hora() {
		return valor_fecha_hora;
	}

	public void setValor_fecha_hora(Date valor_fecha_hora) {
		this.valor_fecha_hora = valor_fecha_hora;
	}

	public Integer getValor_numerico() {
		return valor_numerico;
	}

	public void setValor_numerico(Integer valor_numerico) {
		this.valor_numerico = valor_numerico;
	}

	public String getValor_texto() {
		return valor_texto;
	}

	public void setValor_texto(String valor_texto) {
		this.valor_texto = valor_texto;
	}

	public CaracteristicaLocal getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaLocal caracteristica) {
		this.caracteristica = caracteristica;
	}

	public ObservacionLocalRest getObservacion() {
		return observacion;
	}

	public void setObservacion(ObservacionLocalRest observacion) {
		this.observacion = observacion;
	}

}
