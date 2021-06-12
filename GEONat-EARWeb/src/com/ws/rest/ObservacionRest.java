package com.ws.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.logica.bean.DetalleBean;
import com.logica.bean.ImagenBean;
import com.logica.bean.ObservacionBean;
import com.persistence.exception.PersistenciaException;
import com.presentacion.entitiesLocales.DetalleLocal;
import com.presentacion.entitiesLocales.DetalleLocalRest;
import com.presentacion.entitiesLocales.ImagenLocal;
import com.presentacion.entitiesLocales.ObservacionFinal;
import com.presentacion.entitiesLocales.ObservacionLocal;

@Stateless
@LocalBean
public class ObservacionRest implements IObservacionRest {

	@Inject
	private ObservacionBean observacionBean;
	@Inject
	private ImagenBean imagenBean;
	@Inject
	private DetalleBean detalleBean;

	@Override
	public String echo() {
		return "Servicio Observaciones Disponible";
	}

	@Override
	public Response agregarObservacion(ObservacionFinal observacionFinal) throws ParseException {

		try {

			ObservacionLocal observacionLocal = new ObservacionLocal();
			observacionLocal = observacionBean.toObservacionLocal(observacionFinal.getObservacion());
			//no cortar aca la FechaHoraRev, se rompe todo. observacionLocal.setFechaHoraRev(null);
			observacionBean.agregarObservacion(observacionLocal);
			Long idUltimaObs = observacionBean.getIdUltimaObservacion();

			if (observacionFinal.getImagen() != null) {
				ImagenLocal imagenLocal = new ImagenLocal();
				imagenLocal = imagenBean.toImagenLocal(observacionFinal.getImagen());
				imagenLocal.getObservacion().setId(idUltimaObs);
				imagenBean.agregar(imagenLocal);
			}

			if (observacionFinal.getDetalles().size() > 0) {

				List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
				for (DetalleLocalRest d : observacionFinal.getDetalles()) {
					detallesLocales.add(detalleBean.toDetalleLocal(d));
				}
				for (DetalleLocal c : detallesLocales) {

					c.getObservacion().setId(idUltimaObs);
				}
				for (DetalleLocal d : detallesLocales) {
					detalleBean.agregarDetalle(d);
				}
			}
			return Response.ok().build();

		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	public Response modificarObservacion(ObservacionFinal observacionFinal)
			throws PersistenciaException, ParseException {

		try {
			
			ObservacionLocal observacionLocal = new ObservacionLocal();
			observacionLocal = observacionBean.toObservacionLocal(observacionFinal.getObservacion());
			observacionBean.modificarObservacion(observacionLocal);
			if (observacionFinal.getDetalles().size() > 0) {
				
				List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
				for (DetalleLocalRest d : observacionFinal.getDetalles()) {

					detallesLocales.add(detalleBean.toDetalleLocal(d));
				}
				for (DetalleLocal d : detallesLocales) {
					detalleBean.modificarDetalle(d);
				}
			}
			
			if (observacionFinal.getImagen() != null) {
				
				ImagenLocal imagenLocal = new ImagenLocal();
				imagenLocal = imagenBean.toImagenLocal(observacionFinal.getImagen());
				imagenBean.modificar(imagenLocal);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.ok().build();
	}

	@Override
	public Response eliminarObservacion(ObservacionFinal observacionFinal) throws ParseException {

		ObservacionLocal observacionLocal = new ObservacionLocal();
		observacionLocal = observacionBean.toObservacionLocal(observacionFinal.getObservacion());

		try {
			if (observacionFinal.getImagen() != null) {

				ImagenLocal imagenLocal = new ImagenLocal();
				imagenLocal = imagenBean.toImagenLocal(observacionFinal.getImagen());
				imagenBean.eliminar(imagenLocal);
			}

			if (observacionFinal.getDetalles() != null) {

				List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
				for (DetalleLocalRest d : observacionFinal.getDetalles()) {

					detallesLocales.add(detalleBean.toDetalleLocal(d));
				}

				for (DetalleLocal d : detallesLocales) {
					detalleBean.eliminarDetalle(d);
				}
			}

			observacionBean.eliminarObservacion(observacionLocal);

		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

	@Override
	public Response getObservaciones() {
		try {
			List<ObservacionFinal> observacionesFinales = new ArrayList<ObservacionFinal>();
			ImagenLocal imagenLocal;

			List<ObservacionLocal> observacionesLocales = observacionBean.obternerTodas();

			for (ObservacionLocal observacionLocal : observacionesLocales) {

				ObservacionFinal observacionFinal = new ObservacionFinal();
				observacionFinal.setObservacion(observacionBean.toObservacionLocalRest(observacionLocal));

				try {
					imagenLocal = imagenBean.buscarPorObservacion(observacionLocal.getId());
					observacionFinal.setImagen(imagenBean.toImagenLocalRest(imagenLocal));

				} catch (Exception e) {
					System.out.println("Esta observación no tiene Imagenes");
				}

				try {

					List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
					detallesLocales = detalleBean
							.obternerDetallesPorObservacion(observacionFinal.getObservacion().getId());
					List<DetalleLocalRest> detallesLocalesRest = new ArrayList<DetalleLocalRest>();

					for (DetalleLocal d : detallesLocales) {
						detallesLocalesRest.add(detalleBean.toDetalleLocalRest(d));
					}

					observacionFinal.setDetalles(detallesLocalesRest);

				} catch (Exception e) {
					System.out.println("Esta observación no tiene Detalles");
				}

				observacionesFinales.add(observacionFinal);

			}

			return Response.ok().entity(observacionesFinales).build();

		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response getObservacion(@PathParam("id") Long id) throws PersistenciaException {
		try {

			ObservacionFinal observacionFinal = new ObservacionFinal();
			List<DetalleLocal> detallesLocales = new ArrayList<DetalleLocal>();
			List<DetalleLocalRest> detallesLocalesRest = new ArrayList<DetalleLocalRest>();
			ImagenLocal imagenLocal = null;

			ObservacionLocal observacionLocal = observacionBean.buscarObservacion(id);
			observacionFinal.setObservacion(observacionBean.toObservacionLocalRest(observacionLocal));

			try {

				imagenLocal = imagenBean.buscarPorObservacion(observacionLocal.getId());
				observacionFinal.setImagen(imagenBean.toImagenLocalRest(imagenLocal));

			} catch (PersistenciaException e) {
				System.out.println("Esa observación no tiene Imagenes");
			}

			try {

				detallesLocales = detalleBean.obternerDetallesPorObservacion(observacionLocal.getId());
				
				for (DetalleLocal d : detallesLocales) {
					detallesLocalesRest.add(detalleBean.toDetalleLocalRest(d));
				}
				observacionFinal.setDetalles(detallesLocalesRest);

			} catch (PersistenciaException e) {
				System.out.println("Esa observación no tiene Detalles");
			}

			

			return Response.ok().entity(observacionFinal).build();

		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
