/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services;

import cl.movistar.tracking.dto.AltaBolsaRequest;
import cl.movistar.tracking.dto.BajaBolsaRequest;
import cl.movistar.tracking.dto.BitacoraRecurrenciaRequest;
import cl.movistar.tracking.dto.CambioEstadoRequest;
import cl.movistar.tracking.dto.CambioUmbralRequest;
import cl.movistar.tracking.dto.RegistroVentaRequest;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.hibernate.Canal;
import cl.movistar.tracking.hibernate.EventosTracking;
import cl.movistar.tracking.hibernate.TrackingHibernateUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class WebServicesValidacionesGateway {

    public static WebServicesValidacionesGateway getInstance() {
        return INSTANCE;
    }
    
    public RespuestaServicio validaEntradaAltaBolsa(AltaBolsaRequest altaBolsaRequest) {
        logger.info("Entre a validarEntradaAltaBolsa");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        String codigoBolsa = "";
        String descripcionBolsa = "";
        String idRedBolsa = "";
        String nombreBolsa = "";
        int canal = 0;
        String usuario = "";
        int ciclo = 0;
        int eventoTracking = 0;
        int numeroAbonado = 0;
        int numeroCelular = 0;
        try {
            logger.info("Leyendo los parametros de entrada");
            codigoBolsa = altaBolsaRequest.getBolsa().getCodigo();
            descripcionBolsa = altaBolsaRequest.getBolsa().getDescripcion();
            idRedBolsa = altaBolsaRequest.getBolsa().getIdRed();
            nombreBolsa = altaBolsaRequest.getBolsa().getNombre();
            canal = Integer.parseInt(altaBolsaRequest.getCanal());
            usuario = altaBolsaRequest.getUsuario();
            ciclo = altaBolsaRequest.getCiclo();
            eventoTracking = altaBolsaRequest.getCodigoEventoSistema();
            numeroAbonado = altaBolsaRequest.getNumeroAbonado();
            numeroCelular = altaBolsaRequest.getNumeroCelular();
            
            if(codigoBolsa.equalsIgnoreCase("") && idRedBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(2314);
                respuestaServicio.setMensajeError("No se envio el codigo de la bolsa");
                respuestaServicio.setDescripcionError("se tiene que enviar el codigo de bolsa o el id de red");
                
            }else if(descripcionBolsa.equalsIgnoreCase("") || nombreBolsa.equalsIgnoreCase("") || canal==0 
                || usuario.equalsIgnoreCase("") || ciclo==0 || eventoTracking==0 || numeroAbonado==0 || numeroCelular==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validarEntradaAltaBolsa");
        return respuestaServicio;
    }
    
    public RespuestaServicio validaEntradaBajaBolsa(BajaBolsaRequest bajaBolsaRequest) {
        logger.info("Entre a validaEntradaBajaBolsa");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        String codigoBolsa = "";
        String descripcionBolsa = "";
        String idRedBolsa = "";
        String nombreBolsa = "";
        int canal = 0;
        String usuario = "";
        int eventoTracking = 0;
        int numeroAbonado = 0;
        int numeroCelular = 0;
        try {
            logger.info("Leyendo los parametros de entrada");
            codigoBolsa = bajaBolsaRequest.getBolsa().getCodigo();
            descripcionBolsa = bajaBolsaRequest.getBolsa().getDescripcion();
            idRedBolsa = bajaBolsaRequest.getBolsa().getIdRed();
            nombreBolsa = bajaBolsaRequest.getBolsa().getNombre();
            canal = Integer.parseInt(bajaBolsaRequest.getCanal());
            usuario = bajaBolsaRequest.getUsuario();
            eventoTracking = bajaBolsaRequest.getCodigoEventoSistema();
            numeroAbonado = bajaBolsaRequest.getNumeroAbonado();
            numeroCelular = bajaBolsaRequest.getNumeroCelular();
            
            if(codigoBolsa.equalsIgnoreCase("") && idRedBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(2314);
                respuestaServicio.setMensajeError("No se envio el codigo de la bolsa");
                respuestaServicio.setDescripcionError("se tiene que enviar el codigo de bolsa o el id de red");
                
            }else if(descripcionBolsa.equalsIgnoreCase("") || nombreBolsa.equalsIgnoreCase("") || canal==0 
                || usuario.equalsIgnoreCase("") || eventoTracking==0 || numeroAbonado==0 || numeroCelular==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validaEntradaBajaBolsa");
        return respuestaServicio;
    }
    
    public RespuestaServicio validaEntradaCambioEstado(CambioEstadoRequest cambioEstadoRequest) {
        logger.info("Entre a validaEntradaCambioEstado");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        String estado = "";
        int idSolicitud = 0;
        int canal = 0;
        int eventoTracking = 0;
        
        try {
            logger.info("Leyendo los parametros de entrada");
            canal = Integer.parseInt(cambioEstadoRequest.getCanal());
            eventoTracking = cambioEstadoRequest.getCodigoEventoSistema();
            estado = cambioEstadoRequest.getEstado();
            int estadoAux = Integer.parseInt(estado);
            idSolicitud = cambioEstadoRequest.getIdSolicitud();
            
            if(estado.equalsIgnoreCase("") || canal==0 || eventoTracking==0 || idSolicitud==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validaEntradaCambioEstado");
        return respuestaServicio;
    }
    
    public RespuestaServicio validaEntradaCambioUmbral(CambioUmbralRequest cambioUmbralRequest) {
        logger.info("Entre a validaEntradaCambioUmbral");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        int canal = 0;
        int eventoTracking = 0;
        int cantidadInicial = 0;
        int cantidadFinal = 0;
        String tipoProducto = "";
        String nombre = "";
        String descripcion = "";
        String codigoBolsa = "";
        
        try {
            logger.info("Leyendo los parametros de entrada");
            XMLGregorianCalendar fechaModificacion = cambioUmbralRequest.getFechaModificacion();
            
            canal = Integer.parseInt(cambioUmbralRequest.getCanal());
            eventoTracking = cambioUmbralRequest.getCodigoEventoSistema();
            cantidadInicial = cambioUmbralRequest.getCantidadInicial();
            cantidadFinal = cambioUmbralRequest.getCantidadFinal();
            tipoProducto = cambioUmbralRequest.getTipoProducto();
            nombre = cambioUmbralRequest.getNombre();
            descripcion = cambioUmbralRequest.getDescripcion();
            codigoBolsa = cambioUmbralRequest.getCodigo();
            
            if(tipoProducto.equalsIgnoreCase("") || nombre.equalsIgnoreCase("") || descripcion.equalsIgnoreCase("") 
                || codigoBolsa.equalsIgnoreCase("") || canal==0 || eventoTracking==0 || cantidadInicial==0 || cantidadFinal==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validaEntradaCambioUmbral");
        return respuestaServicio;
    }
    
    public RespuestaServicio validaEntradaRegistroVenta(RegistroVentaRequest registroVentaRequest) {
        logger.info("Entre a validaEntradaCambioUmbral");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        int canal = 0;
        int eventoTracking = 0;
        int numeroTelefonoBeneficiario = 0;
        int numeroTelefonoComprador = 0;
        int precio = 0;
        String idRed = "";
        String usuario = "";
        
        
        try {
            logger.info("Leyendo los parametros de entrada");
            XMLGregorianCalendar fechaActivacion = registroVentaRequest.getFechaActivacion();
            
            canal = Integer.parseInt(registroVentaRequest.getCanal());
            eventoTracking = registroVentaRequest.getCodigoEventoSistema();
            numeroTelefonoBeneficiario = registroVentaRequest.getNumeroAbonadoBeneficiario();
            numeroTelefonoComprador = registroVentaRequest.getNumeroAbonadoComprador();
            precio = registroVentaRequest.getPrecioBolsa();
            idRed = registroVentaRequest.getIdRed();
            usuario = registroVentaRequest.getUsuario();
            
            if(idRed.equalsIgnoreCase("") || usuario.equalsIgnoreCase("") || canal==0 || eventoTracking==0 
                || numeroTelefonoBeneficiario==0 || numeroTelefonoComprador==0|| precio==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validaEntradaCambioUmbral");
        return respuestaServicio;
    }
    
    public RespuestaServicio validaEntradaBitacoraRecurrencia(BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        logger.info("Entre a validaEntradaBitacoraRecurrencia");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        int canal = 0;
        int eventoTracking = 0;
        int numeroTelefonoBeneficiario = 0;
        String idRed = "";
        
        try {
            logger.info("Leyendo los parametros de entrada");
            canal = Integer.parseInt(bitacoraRecurrenciaRequest.getCanal());
            eventoTracking = bitacoraRecurrenciaRequest.getCodigoEventoSistema();
            numeroTelefonoBeneficiario = bitacoraRecurrenciaRequest.getNumeroAbonado();
            idRed = bitacoraRecurrenciaRequest.getIdRed();
        
            if(idRed.equalsIgnoreCase("") || canal==0 || eventoTracking==0 || numeroTelefonoBeneficiario==0){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error en el envio de parametros");
                respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
                
            }
            entradaValida = true;
            
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error en el envio de parametros");
            respuestaServicio.setDescripcionError("Tiene que enviar todos los parametros requeridos");
        }
        
        if(entradaValida){
            respuestaServicio = validaEventoConCanal(eventoTracking,canal);
        }
        logger.info("Fin validaEntradaBitacoraRecurrencia");
        return respuestaServicio;
    }
    
    private Session session;
    private static final Logger logger = Logger.getLogger(WebServicesValidacionesGateway.class.getName());    
    private static final WebServicesValidacionesGateway INSTANCE = new WebServicesValidacionesGateway();
    
    
    private WebServicesValidacionesGateway() {
        session = TrackingHibernateUtil.getSessionFactory().openSession();
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
    
    private RespuestaServicio validaEventoConCanal(int eventoTracking, int canal) {
        logger.info("Entre a valida Canal y Evento");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        // Entrada valida
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        // valido que el canal exista en la base de datos del tracking
        int idCanal = 0;
        try {
            Canal canalBd = (Canal) session.load(Canal.class, canal);
            idCanal = canalBd.getId();
        } catch (Exception e) {
            logger.error("Canal no configurado en el sistema Tracking");
            respuestaServicio.setCodigoError(21);
            respuestaServicio.setDescripcionError("Canal no configurado en el sistema Tracking");
            respuestaServicio.setMensajeError("Canal no valido");
            return respuestaServicio;
        }
        
        // valido que el evento exista en la base de datos del tracking
        int idCanalTracking = 0;
        try {
            EventosTracking eventoTrackingBd = (EventosTracking) session.load(EventosTracking.class, eventoTracking);
            idCanalTracking = eventoTrackingBd.getCanal();
        } catch (Exception e) {
            logger.error("EventosTracking no configurado en el sistema Tracking");
            respuestaServicio.setCodigoError(21);
            respuestaServicio.setDescripcionError("EventosTracking no configurado en el sistema Tracking");
            respuestaServicio.setMensajeError("EventosTracking no valido");
            return respuestaServicio;
        }
        
        if(idCanal != idCanalTracking){
            logger.error("No es posible informar este evento a traves del canal informado");
            respuestaServicio.setCodigoError(23);
            respuestaServicio.setDescripcionError("No es posible informar este evento a traves del canal informado");
            respuestaServicio.setMensajeError("Evento y canal no validos");
        }else{
            respuestaServicio.setCodigoError(0);
        }
        
        logger.info("Canal y Evento correctamente informados");
        session.close();
        return respuestaServicio;
        
    }

    public Canal obtenerCanal(int codigoCanal) {
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Canal canal = (Canal) session.load(Canal.class, codigoCanal);
        String nombre = canal.getNombre();
        return canal;
    }
    

    

    

    
}
