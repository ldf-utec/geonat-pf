package com.persistence.exception;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Mensajes {

	public Mensajes() {

	}

	public static void mostrar(Severity severity, String titulo, String msj) {
		FacesMessage facesMsg = new FacesMessage(severity, titulo, msj);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

}
