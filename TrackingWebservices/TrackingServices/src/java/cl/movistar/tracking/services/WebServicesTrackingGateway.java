/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services;


import cl.movistar.datoscliente.gateway.DatosClienteFacade;
import cl.movistar.midrange.provision.convergente.gateway.ProvisionConvergenteFacade;
import cl.movistar.midrange.provision.convergente.product.types.ActionType;
import cl.movistar.midrange.provision.convergente.product.types.Characteristic;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrder;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse;
import cl.movistar.midrange.provision.convergente.product.types.ProductSpecType;
import cl.movistar.ofertador.dto.ResponseDetalleOferta;
import cl.movistar.ofertador.services.gateway.OfertadorFacade;
import cl.movistar.osb.GetDetalleVO;
import cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.ActivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.gateway.ParqueAltaFacade;
import cl.movistar.services.parque.gateway.ParqueBajaFacade;
import cl.movistar.tracking.dto.AltaBolsaRequest;
import cl.movistar.tracking.dto.BajaBolsaRequest;
import cl.movistar.tracking.dto.BitacoraRecurrenciaRequest;
import cl.movistar.tracking.dto.CambioEstadoRequest;
import cl.movistar.tracking.dto.CambioUmbralRequest;
import cl.movistar.tracking.dto.OfertaBolsa;
import cl.movistar.tracking.dto.RegistroVentaRequest;
import cl.movistar.tracking.dto.Respuesta;
import cl.movistar.tracking.dto.RespuestaAcciones;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.dto.TrackingResponse;
import cl.movistar.tracking.hibernate.AccionNegocio;
import cl.movistar.tracking.hibernate.AccionSistema;
import cl.movistar.tracking.hibernate.BitacoraRecurrencia;
import cl.movistar.tracking.hibernate.CambioUmbral;
import cl.movistar.tracking.hibernate.Canal;
import cl.movistar.tracking.hibernate.EventoNegocio;
import cl.movistar.tracking.hibernate.EventoSistema;
import cl.movistar.tracking.hibernate.EventosTracking;
import cl.movistar.tracking.hibernate.MovimientosTracking;
import cl.movistar.tracking.hibernate.TrackingHibernateUtil;
import cl.movistar.tracking.hibernate.VentaBolsa;
import com.telefonica.midrange.findproductofferingservice.gateway.CatalogoFacade;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingRequest;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;


public class WebServicesTrackingGateway {

    public static WebServicesTrackingGateway getInstance() {
        return INSTANCE;
    }
    private ActivaBolsaAbonadoRequestDTO ActivaBolsaAbonadoRequestDTO;
    
    public TrackingResponse realizarCambioUmbral(CambioUmbralRequest cambioUmbralRequest) {
        logger.info("Entre a realizarCambioUmbral");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar del cambio de umbral
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(cambioUmbralRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(cambioUmbralRequest.getCodigoEventoSistema());

        boolean ejecutoAccionesSistema = ejecutarAccionesSistema(accionesSistema, cambioUmbralRequest);

        if(ejecutoAccionesSistema){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocio(accionesNegocio, cambioUmbralRequest);
            if(ejecutoAccionesNegocio){
                logger.info("El cambio de umbral se ha realizado correctamente");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setMensaje("El cambio de umbral se ha realizado correctamente");
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se almaceno el cambio de umbral");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin realizarCambioUmbral");
        return trackingResponse;
    }
    
    public TrackingResponse registrarBitacoraRecurrencia(BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        logger.info("Entre a registrarBitacoraRecurrencia");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(bitacoraRecurrenciaRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(bitacoraRecurrenciaRequest.getCodigoEventoSistema());

        boolean ejecutoAccionesSistema = ejecutarAccionesSistemaBitacoraRecurrencia(accionesSistema, bitacoraRecurrenciaRequest);

        if(ejecutoAccionesSistema){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocioBitacoraRecurrencia(accionesNegocio, bitacoraRecurrenciaRequest);
            if(ejecutoAccionesNegocio){
                logger.info("Se registro exitosamente en la Bitacora de Recurrencia");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setMensaje("Se registro exitosamente en la Bitacora de Recurrencia");
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se almaceno en bitacora de recurrencia");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin registrarBitacoraRecurrencia");
        return trackingResponse;
    }
    
    public TrackingResponse registrarRegistroVenta(RegistroVentaRequest registroVentaRequest) {
        logger.info("Entre a registrarRegistroVenta");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(registroVentaRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(registroVentaRequest.getCodigoEventoSistema());

       // boolean ejecutoAccionesSistema = ejecutarAccionesSistemaRegistroVenta(accionesSistema, registroVentaRequest);
        RespuestaAcciones respuestaAccionesSistema = ejecutarAccionesSistemaRegistroVenta(accionesSistema, registroVentaRequest);

        if(respuestaAccionesSistema.getIdTracking() !=0){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocioRegistroVenta(accionesNegocio, registroVentaRequest);
            if(ejecutoAccionesNegocio){
                logger.info("Se registro exitosamente en Registro de Ventas");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setMensaje("Se registro exitosamente en Registro de Ventas");
                respuesta.setIdSolicitud(respuestaAccionesSistema.getIdTracking());
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se almaceno en registro de ventas");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin registrarRegistroVenta");
        return trackingResponse;
    }
    
    public TrackingResponse registrarCambioEstado(CambioEstadoRequest cambioEstadoRequest) {
        logger.info("Entre a registrarCambioEstado");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(cambioEstadoRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(cambioEstadoRequest.getCodigoEventoSistema());

        boolean ejecutoAccionesSistema = ejecutarAccionesSistemaCambioEstado(accionesSistema, cambioEstadoRequest);

        if(ejecutoAccionesSistema){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocioCambioEstado(accionesNegocio, cambioEstadoRequest);
            if(ejecutoAccionesNegocio){
                logger.info("Se registro exitosamente el Cambio de Estado");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setMensaje("Se registro exitosamente el Cambio de Estado");
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se almaceno el cambio de estado");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin registrarCambioEstado");
        return trackingResponse;
    }
    
    public TrackingResponse bajaDeBolsa(BajaBolsaRequest bajaBolsaRequest) {
        logger.info("Entre a bajaDeBolsa");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(bajaBolsaRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(bajaBolsaRequest.getCodigoEventoSistema());

        int idTracking = ejecutarAccionesSistemaBajaBolsa(accionesSistema, bajaBolsaRequest);
        //boolean ejecutoAccionesSistema = ejecutarAccionesSistemaBajaBolsa(accionesSistema, bajaBolsaRequest);

        if(idTracking !=0){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocioBajaBolsa(accionesNegocio, bajaBolsaRequest, idTracking);
            if(ejecutoAccionesNegocio){
                logger.info("Se ha recibido con exito la solicitud de baja");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setIdSolicitud(idTracking);
                respuesta.setMensaje("Se ha recibido con exito la solicitud de baja");
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se pudo recibir la solicitud de baja");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin bajaDeBolsa");
        return trackingResponse;
    }
    
    public TrackingResponse altaDeBolsa(AltaBolsaRequest altaBolsaRequest) {
        logger.info("Entre a altaDeBolsa");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(altaBolsaRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(altaBolsaRequest.getCodigoEventoSistema());

        int idTracking = ejecutarAccionesSistemaAltaBolsa(accionesSistema, altaBolsaRequest);
        //boolean ejecutoAccionesSistema = ejecutarAccionesSistemaBajaBolsa(accionesSistema, bajaBolsaRequest);

        if(idTracking !=0){
            boolean ejecutoAccionesNegocio = ejecutarAccionesNegocioAltaBolsa(accionesNegocio, altaBolsaRequest, idTracking);
            if(ejecutoAccionesNegocio){
                logger.info("Se ha recibido con exito la solicitud de Alta");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setIdSolicitud(idTracking);
                respuesta.setMensaje("Se ha recibido con exito la solicitud de Alta");
                session.getTransaction().commit();     
                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setMensajeError("Error ejecutando acciones de negocio");
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError("Ocurrio un error al ejecutar las acciones de sistema por lo que no se pudo recibir la solicitud de alta");
            respuestaServicio.setMensajeError("Error ejecutando acciones de sistema");
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin altaDeBolsa");
        return trackingResponse;
    }
    
    private WebServicesTrackingGateway() {
        
        String resourceLog = "cl/movistar/tracking/services/TrackingServicesLog4j.properties";
        InputStream isLog = this.getClass().getClassLoader().getResourceAsStream(resourceLog);
        Properties props = new Properties();
        try {
            props.load(isLog);
            PropertyConfigurator.configure(props);
            isLog.close();
        } catch (IOException ex) {
            logger.error("IOException");
            logger.error(ex);
        }
        
    }
    
 
    private Session session;
    private static final Logger logger = Logger.getLogger(WebServicesTrackingGateway.class.getName());    
    private static final WebServicesTrackingGateway INSTANCE = new WebServicesTrackingGateway();

    private List<AccionSistema> obtenerListadoAccionesSistema(Integer codigoEventoSistema) {
        List<AccionSistema> listadoAccionessSistema = new ArrayList();
        
        //session.beginTransaction();
        String hql = "FROM cl.movistar.tracking.hibernate.EventosTracking eventos WHERE eventos.id =" + codigoEventoSistema;
        Query query = session.createQuery(hql);
        List<EventosTracking> eventos = query.list();
        
        String hql3 = "FROM cl.movistar.tracking.hibernate.EventoSistema eventos WHERE eventos.id =" + eventos.get(0).getEventoSistema();
        Query query3 = session.createQuery(hql3);
        List<EventoSistema> eventosSistema = query3.list();
        
        String accionesSistemaAux = eventosSistema.get(0).getAccionesSistema();
        String[] accionesSistema = accionesSistemaAux.split(",");
        
        for (int i = 0; i < accionesSistema.length -1 ; i++) {
            String hql2 = "FROM cl.movistar.tracking.hibernate.AccionSistema accion WHERE accion.id =" + accionesSistema[i];
            Query query2 = session.createQuery(hql2);
            List<AccionSistema> acccion = query2.list();
            listadoAccionessSistema.add(acccion.get(0));
        }
        
        return listadoAccionessSistema;
    }

    private List<AccionNegocio> obtenerListadoAccionesNegocio(Integer codigoEventoSistema) {
        List<AccionNegocio> listadoAccionesNegocio = new ArrayList();
        
        //session.beginTransaction();
        String hql = "FROM cl.movistar.tracking.hibernate.EventosTracking eventos WHERE eventos.id =" + codigoEventoSistema;
        Query query = session.createQuery(hql);
        List<EventosTracking> eventos = query.list();
        
        String hql3 = "FROM cl.movistar.tracking.hibernate.EventoNegocio eventos WHERE eventos.id =" + eventos.get(0).getEventoNegocio();
        Query query3 = session.createQuery(hql3);
        List<EventoNegocio> eventosNegocio = query3.list();
        
        String accionesNegocioAux = eventosNegocio.get(0).getAccionesNegocio();
        String[] accionesNegocio = accionesNegocioAux.split(",");
        
        for (int i = 0; i < accionesNegocio.length -1 ; i++) {
            String hql2 = "FROM cl.movistar.tracking.hibernate.AccionNegocio accion WHERE accion.id =" + accionesNegocio[i];
            Query query2 = session.createQuery(hql2);
            List<AccionNegocio> acccion = query2.list();
            listadoAccionesNegocio.add(acccion.get(0));
        }
        
        return listadoAccionesNegocio;
    }

    private boolean ejecutarAccionesSistema(List<AccionSistema> accionesSistema, CambioUmbralRequest cambioUmbralRequest) {
        boolean ejecutoAcciones = false;
        int idMovimiento = 0;
        int idCambioUmbral = 0;
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                       // int idAux = obtenerIdMovimientosTracking();
                       // movimientosTracking.setId(idAux);
                        movimientosTracking.setCanal(Integer.parseInt(cambioUmbralRequest.getCanal()));
                        movimientosTracking.setEstado(1); // revisar el codigo de estado para realizado
                        movimientosTracking.setFechaNotificacion(cambioUmbralRequest.getFechaModificacion().toGregorianCalendar().getTime());
                        movimientosTracking.setIdEventoTracking(cambioUmbralRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoOferta(cambioUmbralRequest.getCodigo());
                        ResponseDetalleOferta responseOferta = obtieneDetalleOfertaOfertador(cambioUmbralRequest.getCodigo());
                        movimientosTracking.setNombreOferta(responseOferta.getDetalleOferta().getNombre());
                        movimientosTracking.setPrecio(responseOferta.getDetalleOferta().getPrecios()[0].getPrecioOferta());
                        session.save(movimientosTracking);
                        session.persist(movimientosTracking);
                        idMovimiento = movimientosTracking.getId();
                        
                    }else if(data.equalsIgnoreCase("cambio_umbral")){
                        CambioUmbral cambioUmbral = new CambioUmbral();
                     //   int idAux = obtenerIdCambioUmbral();
                     //   cambioUmbral.setId(idAux);
                        cambioUmbral.setDescripcion(cambioUmbralRequest.getDescripcion());
                        cambioUmbral.setFechaModificacion(cambioUmbralRequest.getFechaModificacion().toGregorianCalendar().getTime());
                        cambioUmbral.setIdBolsa(cambioUmbralRequest.getCodigo());
                        cambioUmbral.setIdTracking(cambioUmbralRequest.getCodigoEventoSistema());
                        cambioUmbral.setNombre(cambioUmbralRequest.getNombre());
                        cambioUmbral.setTipoProducto(cambioUmbralRequest.getTipoProducto());
                        cambioUmbral.setUnidadAntigua(cambioUmbralRequest.getCantidadInicial());
                        cambioUmbral.setUnidadNueva(cambioUmbralRequest.getCantidadFinal());
                        session.save(cambioUmbral);
                        session.persist(cambioUmbral);
                        idCambioUmbral = cambioUmbral.getId();
                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        ejecutoAcciones = false;
                        
                    }

                }
            }
            
            if(idMovimiento!=0 && idCambioUmbral!=0){
                try {
                    MovimientosTracking movimiento = (MovimientosTracking) session.load(MovimientosTracking.class, idMovimiento);
                    movimiento.setIdTracking(idCambioUmbral);
                    session.update(movimiento);
                    CambioUmbral cambio = (CambioUmbral) session.load(CambioUmbral.class, idCambioUmbral);
                    cambio.setIdTracking(idMovimiento);
                    session.update(cambio);
                } catch (Exception e) {
                    //error al actualizar registro
                    session.getTransaction().rollback();
                }
                
                ejecutoAcciones = true;
                
            }else{
                ejecutoAcciones = false;
            }
            
            
            
        } catch (Exception e) {
            ejecutoAcciones = false;
            session.getTransaction().rollback();
        }
        
        return ejecutoAcciones;
    }

    private boolean ejecutarAccionesNegocio(List<AccionNegocio> accionesNegocio, CambioUmbralRequest cambioUmbralRequest) {
        boolean ejecutoAcciones = false;
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else{
                // error accion no programada
                ejecutoAcciones = false;

            }
        }
        
        return ejecutoAcciones;
    }

    private boolean ejecutarAccionesSistemaBitacoraRecurrencia(List<AccionSistema> accionesSistema, BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        boolean ejecutoAcciones = false;
        int idMovimiento = 0;
        int idBitacoraRecurrencia = 0;
        // con el id de red se obtiene los datos de la oferta
        OfertaBolsa oferta = obtieneOfertaByIdRed(bitacoraRecurrenciaRequest.getIdRed());
        
        if(oferta.getNombre().equalsIgnoreCase("ERROR")){
            return false;
        }
        
        DatosClienteFacade datosClienteFacade = new DatosClienteFacade();
        GetDetalleVO consultaAbonadoSCLResponseDTO = datosClienteFacade.obtenerDatosCliente(bitacoraRecurrenciaRequest.getNumeroAbonado());
        
        if(consultaAbonadoSCLResponseDTO.getCodigoRetorno() != 0){
            logger.info("No se obtuvieron los datos del usuario");
            return false;
        }
        
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                     //   int idAux = obtenerIdMovimientosTracking();
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                       // movimientosTracking.setId(idAux);
                        movimientosTracking.setCanal(Integer.parseInt(bitacoraRecurrenciaRequest.getCanal()));
                        movimientosTracking.setEstado(1); // revisar el codigo de estado para realizado
                        movimientosTracking.setIdEventoTracking(bitacoraRecurrenciaRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoCliente(consultaAbonadoSCLResponseDTO.getCodCliente());
                        movimientosTracking.setNumeroCelular(bitacoraRecurrenciaRequest.getNumeroAbonado());
                        movimientosTracking.setCodigoOferta(oferta.getCodigo());
                        movimientosTracking.setNombreOferta(oferta.getNombre());
                        movimientosTracking.setPrecio(oferta.getPrecio());
                        movimientosTracking.setNumeroAbonado(consultaAbonadoSCLResponseDTO.getNumAbonado());
                        movimientosTracking.setFechaActivacion(Calendar.getInstance().getTime());
                        session.save(movimientosTracking);
                        session.persist(movimientosTracking);
                        idMovimiento = movimientosTracking.getId();
                        
                    }else if(data.equalsIgnoreCase("bitacora_recurrencia")){
                     //   int idAux = obtenerIdBitacoraRecurrencia();
                        BitacoraRecurrencia bitacoraRecurrencia = new BitacoraRecurrencia();
                       // bitacoraRecurrencia.setId(idAux);

//                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        Date fechaHoy = new Date();
                        
                        bitacoraRecurrencia.setFechaFin(Calendar.getInstance().getTime());
                        bitacoraRecurrencia.setFechaInicio(Calendar.getInstance().getTime());
                        bitacoraRecurrencia.setIdBolsa(oferta.getCodigo());
                        bitacoraRecurrencia.setIdTracking(idMovimiento);
                        bitacoraRecurrencia.setNombreBolsa(oferta.getNombre());
                        
                        session.save(bitacoraRecurrencia);
                        session.persist(bitacoraRecurrencia);
                        idBitacoraRecurrencia = bitacoraRecurrencia.getId();
                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        ejecutoAcciones = false;
                        
                    }

                }
            }
            
            if(idMovimiento!=0 && idBitacoraRecurrencia!=0){
                try {
                    MovimientosTracking movimiento = (MovimientosTracking) session.load(MovimientosTracking.class, idMovimiento);
                    movimiento.setIdTracking(idBitacoraRecurrencia);
                    session.update(movimiento);
                    
                } catch (Exception e) {
                    //error al actualizar registro
                    session.getTransaction().rollback();
                }
                
                ejecutoAcciones = true;
                
            }else{
                ejecutoAcciones = false;
            }
            
            
            
        } catch (Exception e) {
            ejecutoAcciones = false;
            session.getTransaction().rollback();
        }
        
        return ejecutoAcciones;
    }

    private boolean ejecutarAccionesNegocioBitacoraRecurrencia(List<AccionNegocio> accionesNegocio, BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        boolean ejecutoAcciones = false;
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else{
                // error accion no programada
                ejecutoAcciones = false;

            }
        }
        
        return ejecutoAcciones;
    }

    private RespuestaAcciones ejecutarAccionesSistemaRegistroVenta(List<AccionSistema> accionesSistema, RegistroVentaRequest registroVentaRequest) {
        //boolean ejecutoAcciones = false;
        RespuestaAcciones respuestaAccionesSistema = new RespuestaAcciones();
        
        int idMovimiento = 0;
        int idRegistroVenta = 0;
        // con el id de red se obtiene los datos de la oferta
        OfertaBolsa oferta = obtieneOfertaByIdRed(registroVentaRequest.getIdRed());
        if(oferta.getNombre().equalsIgnoreCase("ERROR")){
            logger.info("No se obtuvieron la oferta");
            respuestaAccionesSistema.setMensajeError("Ocurrio un error al obtener los datos de la oferta");
            respuestaAccionesSistema.setDescripcionError("Ocurrio un error al obtener los datos de la oferta");
            
            return respuestaAccionesSistema;
        }
        DatosClienteFacade datosClienteFacade = new DatosClienteFacade();
        GetDetalleVO consultaAbonadoSCLResponseDTO = datosClienteFacade.obtenerDatosCliente(registroVentaRequest.getNumeroAbonadoBeneficiario());
        
        if(consultaAbonadoSCLResponseDTO.getCodigoRetorno() != 0){
            logger.info("No se obtuvieron los datos del usuario");
            respuestaAccionesSistema.setMensajeError("Ocurrio un error al obtener los datos del cliente con numero: " + registroVentaRequest.getNumeroAbonadoBeneficiario());
            respuestaAccionesSistema.setDescripcionError("El servicio de consultaAbonadoSCLResponseDTO respondio: " + consultaAbonadoSCLResponseDTO.getMensajeRetorno());
            
            return respuestaAccionesSistema;
        }
        
        
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                       // int idAux = obtenerIdMovimientosTracking();
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                       // movimientosTracking.setId(idAux);
                        movimientosTracking.setCanal(Integer.parseInt(registroVentaRequest.getCanal()));
                        movimientosTracking.setEstado(1); // revisar el codigo de estado para realizado
                        movimientosTracking.setIdEventoTracking(registroVentaRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoOferta(oferta.getCodigo());
                        movimientosTracking.setNombreOferta(oferta.getNombre());
                        movimientosTracking.setPrecio(registroVentaRequest.getPrecioBolsa());
                        
                        // no estoy usando registroVentaRequest.getCantidad();
                        movimientosTracking.setCicloFacturacion(consultaAbonadoSCLResponseDTO.getDiaFacturacion());
                        movimientosTracking.setDescuento(0);
                        movimientosTracking.setPuntosUtilizados(0);
                        movimientosTracking.setNumeroAbonado(consultaAbonadoSCLResponseDTO.getNumAbonado());
                        movimientosTracking.setNumeroCelular(registroVentaRequest.getNumeroAbonadoBeneficiario());
                       // movimientosTracking.setCodigoVendedor(registroVentaRequest.getUsuario());
                        movimientosTracking.setUsuario(registroVentaRequest.getUsuario());
                        movimientosTracking.setFechaActivacion(registroVentaRequest.getFechaActivacion().toGregorianCalendar().getTime());
                        movimientosTracking.setFechaContratacion(registroVentaRequest.getFechaActivacion().toGregorianCalendar().getTime());
                        movimientosTracking.setFechaNotificacion(registroVentaRequest.getFechaActivacion().toGregorianCalendar().getTime());
                        movimientosTracking.setCodigoCliente(consultaAbonadoSCLResponseDTO.getCodCliente());
                        
                        session.save(movimientosTracking);
                        session.persist(movimientosTracking);
                        idMovimiento = movimientosTracking.getId();
                        
                    }else if(data.equalsIgnoreCase("venta_bolsa")){
                      //  int idAux = obtenerIdMovimientosTracking();
                        VentaBolsa ventaBolsa = new VentaBolsa();
                        //ventaBolsa.setId(idAux);
                        
                        ventaBolsa.setCanal(Integer.parseInt(registroVentaRequest.getCanal()));
                        //registroVentaRequest.getCantidad();
                        ventaBolsa.setIdTracking(idMovimiento);
                        
                        ventaBolsa.setFechaActivacion(registroVentaRequest.getFechaActivacion().toGregorianCalendar().getTime());
                        ventaBolsa.setFechaContratacion(registroVentaRequest.getFechaActivacion().toGregorianCalendar().getTime());
                        ventaBolsa.setCodigoOferta(oferta.getCodigo());
                        ventaBolsa.setNombreOferta(oferta.getNombre());
                        
                        ventaBolsa.setNumeroAbonado(consultaAbonadoSCLResponseDTO.getNumAbonado());
                        ventaBolsa.setNumeroCelular(registroVentaRequest.getNumeroAbonadoBeneficiario());
                        ventaBolsa.setCodigoCliente(consultaAbonadoSCLResponseDTO.getCodCliente());
                        ventaBolsa.setPrecio(registroVentaRequest.getPrecioBolsa());
                        ventaBolsa.setCodigoVendedor(registroVentaRequest.getUsuario());
                        
                        session.save(ventaBolsa);
                        session.persist(ventaBolsa);
                        idRegistroVenta = ventaBolsa.getId();
                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        
                        
                    }

                }
            }
            
            if(idMovimiento!=0 && idRegistroVenta!=0){
                try {
                    MovimientosTracking movimiento = (MovimientosTracking) session.load(MovimientosTracking.class, idMovimiento);
                    movimiento.setIdTracking(idRegistroVenta);
                    session.update(movimiento);
                    
                } catch (Exception e) {
                    //error al actualizar registro
                    session.getTransaction().rollback();
                }
                
                
                
            }else{
                
            }
            
            respuestaAccionesSistema.setIdTracking(idMovimiento);
            
        } catch (Exception e) {
            
            session.getTransaction().rollback();
        }
        
        return respuestaAccionesSistema;
    }

    private boolean ejecutarAccionesNegocioRegistroVenta(List<AccionNegocio> accionesNegocio, RegistroVentaRequest registroVentaRequest) {
        boolean ejecutoAcciones = false;
        OfertaBolsa oferta = obtieneOfertaByIdRed(registroVentaRequest.getIdRed());
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else if(tipo.equalsIgnoreCase("WebServices Parque")){
                // Llamar a parque
//                ParqueAltaFacade parqueAltaFacade = new ParqueAltaFacade();
//                ActivaBolsaAbonadoRequestDTO activaBolsaAbonadoRequestDTO = new ActivaBolsaAbonadoRequestDTO();
//                activaBolsaAbonadoRequestDTO.setCodServicio(oferta.getCodigo());
//                activaBolsaAbonadoRequestDTO.setNomUsuario(registroVentaRequest.getUsuario());
//                activaBolsaAbonadoRequestDTO.setNumAbonado(String.valueOf(registroVentaRequest.getNumeroAbonadoBeneficiario()));
//                ActivaBolsaAbonadoResponseDTO activaBolsaAbonadoResponseDTO = parqueAltaFacade.informarParqueAlta(activaBolsaAbonadoRequestDTO);
//                if(activaBolsaAbonadoResponseDTO.getCodigoRetorno().equalsIgnoreCase("0")){
//                    ejecutoAcciones = true;
//                }else{
//                    ejecutoAcciones = false;
//                }

                ejecutoAcciones = true;
            }else{
                // error accion no programada
                ejecutoAcciones = false;

            }
        }
        
        return ejecutoAcciones;
    }
    
    private boolean ejecutarAccionesSistemaCambioEstado(List<AccionSistema> accionesSistema, CambioEstadoRequest cambioEstadoRequest) {
        boolean ejecutoAcciones = false;
        try {
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                        MovimientosTracking movimiento = (MovimientosTracking) session.load(MovimientosTracking.class, cambioEstadoRequest.getIdSolicitud());
                        movimiento.setEstado(Integer.parseInt(cambioEstadoRequest.getEstado()));
                        if(movimiento.getEstado() == 1001){
                            movimiento.setFechaNotificacion(Calendar.getInstance().getTime());
                            session.update(movimiento);   
                        }
                        if(movimiento.getEstado() == 2000){
                        //    int IdAux = obtenerIdRegistroVenta();
                            VentaBolsa ventaBolsa = new VentaBolsa();
                            //ventaBolsa.setId(IdAux);
                            ventaBolsa.setUsuario(movimiento.getUsuario());
                            ventaBolsa.setAgencia(verificaNull(String.valueOf(movimiento.getAgencia())));
                            ventaBolsa.setCanal(verificaNull(movimiento.getCanal()));
                            ventaBolsa.setCicloFacturacion(verificaNull(movimiento.getCicloFacturacion()));
                            ventaBolsa.setCodigoCliente(verificaNull(movimiento.getCodigoCliente()));
                            ventaBolsa.setCodigoOferta(verificaNull(movimiento.getCodigoOferta()));
                            ventaBolsa.setCodigoVendedor(verificaNull(movimiento.getCodigoVendedor()));
                            ventaBolsa.setDescuento(verificaNull(movimiento.getDescuento()));
                            ventaBolsa.setEstado(verificaNull(movimiento.getEstado()));
                            
                            movimiento.setFechaActivacion(Calendar.getInstance().getTime());
                            session.update(movimiento); 
                            ventaBolsa.setFechaActivacion(Calendar.getInstance().getTime());
                            ventaBolsa.setFechaContratacion(movimiento.getFechaContratacion());
                            ventaBolsa.setFechaNotificacion(movimiento.getFechaNotificacion());
                            ventaBolsa.setIdTracking(cambioEstadoRequest.getIdSolicitud());
                            ventaBolsa.setNombreOferta(verificaNull(movimiento.getNombreOferta()));
                            ventaBolsa.setNumeroAbonado(verificaNull(movimiento.getNumeroAbonado()));
                            ventaBolsa.setNumeroCelular(verificaNull(movimiento.getNumeroCelular()));
                            ventaBolsa.setPrecio(verificaNull(movimiento.getPrecio()));
                            ventaBolsa.setPuntosUtilizados(verificaNull(movimiento.getPuntosUtilizados()));
                            ventaBolsa.setSubCanal(verificaNull(movimiento.getSubCanal()));
                            session.save(ventaBolsa);
                            registraParque(movimiento.getIdEventoTracking(), movimiento.getCodigoOferta(), String.valueOf(movimiento.getCodigoCliente()), String.valueOf(movimiento.getNumeroAbonado()), movimiento.getCanal());
                            
                        }
                        ejecutoAcciones = true;
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        ejecutoAcciones = false;
                    }
                }
            }
            
        } catch (Exception e) {
            ejecutoAcciones = false;
            session.getTransaction().rollback();
        }
        
        return ejecutoAcciones;
    }

    private boolean ejecutarAccionesNegocioCambioEstado(List<AccionNegocio> accionesNegocio, CambioEstadoRequest cambioEstadoRequest) {
        boolean ejecutoAcciones = false;
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else{
                // error accion no programada
                ejecutoAcciones = false;

            }
        }
        
        return ejecutoAcciones;
    }

    private int ejecutarAccionesSistemaBajaBolsa(List<AccionSistema> accionesSistema, BajaBolsaRequest bajaBolsaRequest) {
        boolean ejecutoAcciones = false;
        int idMovimiento = 0;
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                     //   int idAux = obtenerIdMovimientosTracking();
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                        //movimientosTracking.setId(idAux);
                        movimientosTracking.setCanal(Integer.parseInt(bajaBolsaRequest.getCanal()));
                        movimientosTracking.setEstado(1); // revisar el codigo de estado para realizado
                        movimientosTracking.setIdEventoTracking(bajaBolsaRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoOferta(bajaBolsaRequest.getBolsa().getCodigo());
                        movimientosTracking.setNombreOferta(bajaBolsaRequest.getBolsa().getNombre());
                        
                        // no estoy usando registroVentaRequest.getCantidad();
                        
                        movimientosTracking.setNumeroAbonado(bajaBolsaRequest.getNumeroAbonado());
                        movimientosTracking.setNumeroCelular(bajaBolsaRequest.getNumeroCelular());
                        movimientosTracking.setCodigoVendedor(bajaBolsaRequest.getUsuario());
//                        ResponseDetalleOferta responseOferta = obtieneDetalleOfertaOfertador(bajaBolsaRequest.getBolsa().getCodigo());
//                        movimientosTracking.setPrecio(responseOferta.getDetalleOferta().getPrecios()[0].getPrecioOferta());
                        session.save(movimientosTracking);
                        session.persist(movimientosTracking);
                        idMovimiento = movimientosTracking.getId();
                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        ejecutoAcciones = false;
                        
                    }

                }
            }
            
            
        } catch (Exception e) {
            ejecutoAcciones = false;
            session.getTransaction().rollback();
        }
        
        return idMovimiento;
    }

    private boolean ejecutarAccionesNegocioBajaBolsa(List<AccionNegocio> accionesNegocio, BajaBolsaRequest bajaBolsaRequest, int idTracking) {
        boolean ejecutoAcciones = false;
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else if(tipo.equalsIgnoreCase("WebServices Provision")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(bajaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(bajaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue("");

                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("NO");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(bajaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.B);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(bajaBolsaRequest.getBolsa().getDescripcion());
                productSpecType.setProductName(bajaBolsaRequest.getBolsa().getNombre());
                productSpecType.setProductNumber(bajaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    ejecutoAcciones = true;
                }else{
                    ejecutoAcciones = false;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Parque Baja")){
                // Llamar a parque
                logger.info("Registrando baja de parque del cliente");
                ParqueBajaFacade parqueBajaFacade = new ParqueBajaFacade();
                ActivaBolsaAbonadoRequestDTO activaBolsaAbonadoRequestDTO = new ActivaBolsaAbonadoRequestDTO();
                
                DesactivaBolsaAbonadoRequestDTO desactivaBolsaAbonadoRequestDTO = new DesactivaBolsaAbonadoRequestDTO();
                desactivaBolsaAbonadoRequestDTO.setCodServicio(bajaBolsaRequest.getBolsa().getCodigo());
                desactivaBolsaAbonadoRequestDTO.setNomUsuario(bajaBolsaRequest.getUsuario());
                desactivaBolsaAbonadoRequestDTO.setNumAbonado(String.valueOf(bajaBolsaRequest.getNumeroAbonado()));
                
                DesactivaBolsaAbonadoResponseDTO desactivaBolsaAbonadoResponseDTO = parqueBajaFacade.informarParqueBaja(desactivaBolsaAbonadoRequestDTO);
                if(desactivaBolsaAbonadoResponseDTO.getCodigoRetorno().equalsIgnoreCase("0")){
                    logger.info("Registrando baja de parque del cliente OK");
                    ejecutoAcciones = true;
                }else{
                    logger.info("Registrando baja de parque del cliente NOK");
                    logger.info("Registrando baja de parque del cliente Codigo: " + desactivaBolsaAbonadoResponseDTO.getCodigoRetorno());
                    logger.info("Registrando baja de parque del cliente Mensaje: " + desactivaBolsaAbonadoResponseDTO.getDescripcionRetorno());
                    ejecutoAcciones = false;
                }

            }else{
                // error accion no programada
                ejecutoAcciones = false;

            }
        }
        
        return ejecutoAcciones;
    }

    private int ejecutarAccionesSistemaAltaBolsa(List<AccionSistema> accionesSistema, AltaBolsaRequest altaBolsaRequest) {
        logger.info("Entre a ejecutarAccionesSistemaAltaBolsa");
        boolean ejecutoAcciones = false;
        DatosClienteFacade datosClienteFacade = new DatosClienteFacade();
        GetDetalleVO consultaAbonadoSCLResponseDTO = datosClienteFacade.obtenerDatosCliente(altaBolsaRequest.getNumeroCelular());
        
        if(consultaAbonadoSCLResponseDTO.getCodigoRetorno() != 0){
            logger.info("No se obtuvieron los datos del usuario");
            return 0;
        }
        
        int idMovimiento = 0;
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                    //    int idAux = obtenerIdMovimientosTracking();
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                        //movimientosTracking.setId(idAux);
                        //movimientosTracking.setAgencia(idMovimiento);
                        movimientosTracking.setCicloFacturacion(altaBolsaRequest.getCiclo());
                        movimientosTracking.setCodigoCliente(consultaAbonadoSCLResponseDTO.getCodCliente());
                        movimientosTracking.setDescuento(0);

                      //  Calendar fecha = Calendar.getInstance();
                      //  Date fechaHoy = fecha.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date fechaHoy = new Date();
                        //movimientosTracking.setFechaActivacion(fechaHoy);
                        movimientosTracking.setFechaContratacion(dateFormat.parse(dateFormat.format(fechaHoy)));
                        movimientosTracking.setFechaNotificacion(dateFormat.parse(dateFormat.format(fechaHoy)));
                        movimientosTracking.setPuntosUtilizados(idMovimiento);
                        movimientosTracking.setSubCanal(idMovimiento);

                        movimientosTracking.setCanal(Integer.parseInt(altaBolsaRequest.getCanal()));
                        movimientosTracking.setEstado(1001); // revisar el codigo de estado para realizado
                        movimientosTracking.setIdEventoTracking(altaBolsaRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoOferta(altaBolsaRequest.getBolsa().getCodigo());
                        movimientosTracking.setNombreOferta(altaBolsaRequest.getBolsa().getNombre());
                        movimientosTracking.setIdTracking(0);
                        // no estoy usando registroVentaRequest.getCantidad();
                        movimientosTracking.setNumeroAbonado(altaBolsaRequest.getNumeroAbonado());
                        movimientosTracking.setNumeroCelular(altaBolsaRequest.getNumeroCelular());
                        movimientosTracking.setCodigoVendedor(altaBolsaRequest.getUsuario());

                        ResponseDetalleOferta responseOferta = obtieneDetalleOfertaOfertador(altaBolsaRequest.getBolsa().getCodigo());

                        if(responseOferta.getRespuestaServicio().getCodigo() == 0){
                            logger.info("Ofertador encontro la oferta");
                            logger.info("Set precio");
                            movimientosTracking.setPrecio(responseOferta.getDetalleOferta().getPrecios()[0].getPrecioOferta());
                            logger.info("Insertando movimiento");
                            session.save(movimientosTracking);
                            session.persist(movimientosTracking);
                            idMovimiento = movimientosTracking.getId();
                        }else{
                            logger.info("La oferta no fue encontrada");
                            session.getTransaction().rollback();
                            ejecutoAcciones = false;
                        }
                        logger.info("Flujo OK");

                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        ejecutoAcciones = false;
                        
                    }

                }
            }
            
            
        } catch (Exception e) {
            logger.info("Fallo la insercion del movimiento");
            e.printStackTrace();
            ejecutoAcciones = false;
            session.getTransaction().rollback();
        }
        
        return idMovimiento;
    }

    private boolean ejecutarAccionesNegocioAltaBolsa(List<AccionNegocio> accionesNegocio, AltaBolsaRequest altaBolsaRequest, int idTracking) {
        logger.info("Entre a ejecutar las acciones de negocio");
        
        boolean ejecutoAcciones = false;
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                ejecutoAcciones = true;
            }else if(tipo.equalsIgnoreCase("WebServices Provision con confirmacion")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));

                String mensajeSms = accionNegocio.getData();
                mensajeSms = mensajeSms.replace("&", altaBolsaRequest.getBolsa().getNombre());
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue(mensajeSms);
                
                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("SI");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(altaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.A);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(altaBolsaRequest.getBolsa().getDescripcion());
                productSpecType.setProductName(altaBolsaRequest.getBolsa().getNombre());
                productSpecType.setProductNumber(altaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    ejecutoAcciones = true;
                }else{
                    ejecutoAcciones = false;
                    return ejecutoAcciones;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Provision sin confirmacion")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue("");

                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("NO");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(altaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.A);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(String.valueOf(altaBolsaRequest.getBolsa().getDescripcion()));
                productSpecType.setProductName(String.valueOf(altaBolsaRequest.getBolsa().getNombre()));
                productSpecType.setProductNumber(altaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    ejecutoAcciones = true;
                }else{
                    ejecutoAcciones = false;
                    return ejecutoAcciones;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Parque")){
                // Llamar a parque
//                ParqueBajaFacade parqueBajaFacade = new ParqueBajaFacade();
//                ActivaBolsaAbonadoRequestDTO activaBolsaAbonadoRequestDTO = new ActivaBolsaAbonadoRequestDTO();
//                
//                DesactivaBolsaAbonadoRequestDTO desactivaBolsaAbonadoRequestDTO = new DesactivaBolsaAbonadoRequestDTO();
//                desactivaBolsaAbonadoRequestDTO.setCodServicio(altaBolsaRequest.getBolsa().getCodigo());
//                desactivaBolsaAbonadoRequestDTO.setNomUsuario(altaBolsaRequest.getUsuario());
//                desactivaBolsaAbonadoRequestDTO.setNumAbonado(String.valueOf(altaBolsaRequest.getNumeroAbonado()));
//                
//                DesactivaBolsaAbonadoResponseDTO desactivaBolsaAbonadoResponseDTO = parqueBajaFacade.informarParqueBaja(desactivaBolsaAbonadoRequestDTO);
//                if(desactivaBolsaAbonadoResponseDTO.getCodigoRetorno().equalsIgnoreCase("0")){
//                    ejecutoAcciones = true;
//                }else{
//                    ejecutoAcciones = false;
//                    return ejecutoAcciones;
//                }
                ejecutoAcciones = true;

            }else{
                // error accion no programada
                ejecutoAcciones = false;
                return ejecutoAcciones;

            }
        }
        
        return ejecutoAcciones;
    }
    
    private OfertaBolsa obtieneOfertaByIdRed(String idRed) {
        
        CatalogoFacade catalogoFacade = new CatalogoFacade();
        
        FindProductOfferingRequest request = new FindProductOfferingRequest();
        request.setIdNetwork(idRed);
        request.setProductOfferingEndDateTime("01-01-9999");
        request.setVisualizacionType(0);
        request.setProductOfferingStatus(0);
        request.setSalesChannelId(0);
        request.setProductSpecificationStatus(0);
        request.setProductSpecificationFamily(0);
        request.setProductSpecificationSubFamily(0);
        request.setProductSpecificationUnitType(0);
        request.setTypeDestination(0);
        long numeroAux = 0;
        request.setPriceLowerValue(numeroAux);
        request.setPriceUpperValue(numeroAux);
        request.setMarketSegmentId(0);
        request.setCustomerValue(0);
        request.setFamiliarityType(0);
        
        
        FindProductOfferingResponse response = catalogoFacade.findProductOffering(request);        
        OfertaBolsa oferta = new OfertaBolsa();
        if(response.getReturnCode().equalsIgnoreCase("000")){
            // llamar al ws de catalogo para obtener los datos de la bolsa segun el id de red
            oferta.setCodigo(response.getProductOffering(0).getCodOffering());
            oferta.setNombre(response.getProductOffering(0).getName());
            ResponseDetalleOferta responseOfertador = obtieneDetalleOfertaOfertador(response.getProductOffering(0).getCodOffering());
            oferta.setPrecio(responseOfertador.getDetalleOferta().getPrecios()[0].getPrecioOferta());
        }else{
            oferta.setNombre("ERROR");
            logger.info("Error en llamar a Catalogo");
            logger.info("Codigo de error: " + response.getReturnCode());
            logger.info("Codigo de error: " + response.getReturnDescription());
            
        }
        
        //000
        
        return oferta;
    }
    
    private OfertaBolsa obtieneCodigoServicioSuplementario(String codigoOferta, int codigoCanal) {
        
        CatalogoFacade catalogoFacade = new CatalogoFacade();
        
        FindProductOfferingRequest request = new FindProductOfferingRequest();
        request.setCodOffering(codigoOferta);
        request.setProductOfferingEndDateTime("01-01-9999");
        request.setVisualizacionType(0);
        request.setProductOfferingStatus(0);
        request.setSalesChannelId(codigoCanal);
        request.setProductSpecificationStatus(0);
        request.setProductSpecificationFamily(0);
        request.setProductSpecificationSubFamily(0);
        request.setProductSpecificationUnitType(0);
        request.setTypeDestination(0);
        long numeroAux = 0;
        request.setPriceLowerValue(numeroAux);
        request.setPriceUpperValue(numeroAux);
        request.setMarketSegmentId(0);
        request.setCustomerValue(0);
        request.setFamiliarityType(0);
        
        
        FindProductOfferingResponse response = catalogoFacade.findProductOffering(request);        
        OfertaBolsa oferta = new OfertaBolsa();
        if(response.getReturnCode().equalsIgnoreCase("000")){
            // llamar al ws de catalogo para obtener los datos de la bolsa segun el id de red
            oferta.setCodigo(response.getProductOffering(0).getSupplementaryService());
            
        }else{
            oferta.setNombre("ERROR");
            logger.info("Error en llamar a Catalogo FindProductOfferingResponse");
            logger.info("Codigo de error: " + response.getReturnCode());
            logger.info("Codigo de descripcion: " + response.getReturnDescription());
            
        }
        
        //000
        
        return oferta;
    }
    
    private ResponseDetalleOferta obtieneDetalleOfertaOfertador(String codigoOferta){
        OfertadorFacade ofertadorFacade = new OfertadorFacade();
        ResponseDetalleOferta responseOfertador = ofertadorFacade.obtenerDetalleOferta(codigoOferta);
        return responseOfertador;
    }
    
    private String verificaNull(String valor) {
        String respuesta = "";
        try {
            if(!valor.equals("")){
                respuesta = valor;
            }
        } catch (Exception e) {
        }
        
        return respuesta;
    }

    private int verificaNull(Integer valor) {
        int respuesta = 0;
        try {
            if(!valor.equals(0)){
                respuesta = valor;
            }
        } catch (Exception e) {
        }
        
        return respuesta;
    }

    private Date verificaNullDate(Date fecha) {
        Date respuesta = new Date();
        try {
                respuesta = fecha;
        } catch (Exception e) {
        
        }
        
        return respuesta;
    }

    public List<MovimientosTracking> obtenerMovimientos(int numeroCelular) {
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.movistar.tracking.hibernate.MovimientosTracking2 where numero_celular = '97590320' ");
        List<MovimientosTracking> movimientosTrackingAux = query.list();
//        String query = "FROM cl.movistar.tracking.hibernate.MovimientosTracking";
//        List<MovimientosTracking> movimientos = new ArrayList<MovimientosTracking>();
//        List<MovimientosTracking> movimientosTrackingAux = new ArrayList<MovimientosTracking>();
//        try {
//            Query query2 = session.createQuery(query);
//            movimientos = query2.list();
//            for (MovimientosTracking movimientosTracking : movimientos) {
//                if(movimientosTracking.getNumeroCelular().equals(numeroCelular)){
//                    movimientosTrackingAux.add(movimientosTracking);
//                }
//            }
//        } catch (Exception e) {
//            // cueck
//        }
        
        return movimientosTrackingAux;
    }

//    private int obtenerIdMovimientosTracking() {
//        int idAux = 0;
//        List<MovimientosTracking2> movimientosAux = session.createQuery("from cl.movistar.tracking.hibernate.MovimientosTracking2").list();
//        
//        if(movimientosAux.size() != 0){
//            idAux = movimientosAux.get(movimientosAux.size()-1).getId();
//            idAux++;
//        }else{
//            idAux = 1;
//        }
//        return idAux;
//    }

//    private int obtenerIdCambioUmbral() {
//        int idAux = 0;
//        List<CambioUmbral2> movimientosAux = session.createQuery("from cl.movistar.tracking.hibernate.CambioUmbral2").list();
//        if(movimientosAux.size() != 0){
//            idAux = movimientosAux.get(movimientosAux.size()-1).getId();
//            idAux++;
//        }else{
//            idAux = 1;
//        }
//        return idAux;
//    }
//     
//    private int obtenerIdBitacoraRecurrencia() {
//        int idAux = 0;
//        List<BitacoraRecurrencia2> movimientosAux = session.createQuery("from cl.movistar.tracking.hibernate.BitacoraRecurrencia2").list();
//        if(movimientosAux.size() != 0){
//            idAux = movimientosAux.get(movimientosAux.size()-1).getId();
//            idAux++;
//        }else{
//            idAux = 1;
//        }
//        return idAux;
//    }
//    
//    private int obtenerIdRegistroVenta() {
//        int idAux = 0;
//        List<VentaBolsa2> movimientosAux = session.createQuery("from cl.movistar.tracking.hibernate.VentaBolsa2").list();
//        if(movimientosAux.size() != 0){
//            idAux = movimientosAux.get(movimientosAux.size()-1).getId();
//            idAux++;
//        }else{
//            idAux = 1;
//        }
//        return idAux;
//    }

    private boolean registraParque(int id, String codigoOferta, String usuario, String numeroAbonado, int codigoCanal) {
        boolean parque = false;
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(id);
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("WebServices Parque Alta")){
                // Llamar a parque
                OfertaBolsa oferta = obtieneCodigoServicioSuplementario(codigoOferta, codigoCanal);
                try { 
                    logger.info("Registrando parque del cliente");
                    ParqueAltaFacade parqueAltaFacade = new ParqueAltaFacade();
                    ActivaBolsaAbonadoRequestDTO activaBolsaAbonadoRequestDTO = new ActivaBolsaAbonadoRequestDTO();
                    activaBolsaAbonadoRequestDTO.setCodServicio(oferta.getCodigo());
                    activaBolsaAbonadoRequestDTO.setNomUsuario("clastra");
                    activaBolsaAbonadoRequestDTO.setNumAbonado(numeroAbonado);
                    ActivaBolsaAbonadoResponseDTO activaBolsaAbonadoResponseDTO = parqueAltaFacade.informarParqueAlta(activaBolsaAbonadoRequestDTO);
                    if(activaBolsaAbonadoResponseDTO.getCodigoRetorno().equalsIgnoreCase("0")){
                        logger.info("Respuesta OK del registro de parque del cliente");
                        parque = true;
                    }else{
                        logger.info("Respuesta NOK del registro de parque del cliente");
                        logger.info("Respuesta NOK del registro de parque del cliente codigo: " + activaBolsaAbonadoResponseDTO.getCodigoRetorno());
                        logger.info("Respuesta NOK del registro de parque del cliente mensaje: " + activaBolsaAbonadoResponseDTO.getDescripcionRetorno());
                        parque = false;
                    }
                } catch (Exception e) {
                    logger.info("Error al registrar parque del cliente");
                }
                
            }
        }
        
        
        
        return parque;
    }
}
