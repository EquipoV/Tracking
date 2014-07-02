/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services.altaBaja;


import cl.movistar.tracking.dto.AltaBajaBolsaRequest;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.hibernate.altaBaja.Canal;
import cl.movistar.tracking.hibernate.altaBaja.EventosTracking;
import cl.movistar.tracking.hibernate.altaBaja.TrackingHibernateUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class WebServicesValidacionesGatewayAltaBaja {

    public static WebServicesValidacionesGatewayAltaBaja getInstance() {
        return INSTANCE;
    }
    
    public RespuestaServicio validaEntradaAltaBolsa(AltaBajaBolsaRequest altaBajaBolsaRequest) {
        logger.info("Entre a validarEntradaAltaBajaBolsa");
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        boolean entradaValida = false;
        try {
            String agencia = altaBajaBolsaRequest.getAgencia();
            if(agencia.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el campo agencia");
                respuestaServicio.setDescripcionError("La agencia es un campo obligatorio");
                return respuestaServicio;
            }
            String codigoBolsa = altaBajaBolsaRequest.getBolsa().getCodigo();
            if(codigoBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el codigo de la bolsa");
                respuestaServicio.setDescripcionError("El codigo de la bolsa es un campo obligatorio");
                return respuestaServicio;
            }
            int ciclo = altaBajaBolsaRequest.getCiclo();
            String cicloAux = String.valueOf(ciclo);
            if(cicloAux.equalsIgnoreCase("0")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el ciclo del cliente");
                respuestaServicio.setDescripcionError("El ciclo del cliente es un campo obligatorio");
                return respuestaServicio;
            }
            String descripcionBolsa = altaBajaBolsaRequest.getBolsa().getDescripcion();
            if(descripcionBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer la descripcion de la bolsa");
                respuestaServicio.setDescripcionError("La descripcion de la bolsa es un campo obligatorio");
                return respuestaServicio;
            }
            String idRedBolsa = altaBajaBolsaRequest.getBolsa().getIdRed();
            if(idRedBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el id de red de la bolsa");
                respuestaServicio.setDescripcionError("El id de red de la bolsa es un campo obligatorio");
                return respuestaServicio;
            }
            String nombreBolsa = altaBajaBolsaRequest.getBolsa().getNombre();
            if(nombreBolsa.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el nombre de la bolsa");
                respuestaServicio.setDescripcionError("El nombre de la bolsa es un campo obligatorio");
                return respuestaServicio;
            }
            String canal = altaBajaBolsaRequest.getCanal();
            if(canal.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el canal");
                respuestaServicio.setDescripcionError("El canal es un campo obligatorio");
                return respuestaServicio;
            }
            int codigoEvento = altaBajaBolsaRequest.getCodigoEventoSistema();
            String codigoEventoAux = String.valueOf(codigoEvento);
            if(codigoEventoAux.equalsIgnoreCase("0")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el codigo de evento");
                respuestaServicio.setDescripcionError("El codigo de evento es un campo obligatorio");
                return respuestaServicio;
            }
            int codigoVendedor = altaBajaBolsaRequest.getCodigoVendedor();
            String codigoVendedorAux = String.valueOf(codigoVendedor);
            if(codigoVendedorAux.equalsIgnoreCase("0")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el codigo del vendedor");
                respuestaServicio.setDescripcionError("El codigo del vendedor es un campo obligatorio");
                return respuestaServicio;
            }
            int numeroCelular = altaBajaBolsaRequest.getNumeroCelular();
            String numeroCelularAux = String.valueOf(numeroCelular);
            if(numeroCelularAux.equalsIgnoreCase("0")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el numero celular");
                respuestaServicio.setDescripcionError("El numero celular es un campo obligatorio");
                return respuestaServicio;
            }
            String subCanal = altaBajaBolsaRequest.getSubCanal();
            if(subCanal.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el sub canal");
                respuestaServicio.setDescripcionError("El sub canal es un campo obligatorio");
                return respuestaServicio;
            }
            String usuario = altaBajaBolsaRequest.getUsuario();
            if(usuario.equalsIgnoreCase("")){
                respuestaServicio.setCodigoError(3422);
                respuestaServicio.setMensajeError("Error al leer el usuario");
                respuestaServicio.setDescripcionError("El usuario es un campo obligatorio");
                return respuestaServicio;
            }
        } catch (Exception e) {
            logger.info("Error al leer los parametros");
            respuestaServicio.setCodigoError(3422);
            respuestaServicio.setMensajeError("Error al leer los parametros");
            respuestaServicio.setDescripcionError("Ocurrio un error al leer los parametros de entrada");
            return respuestaServicio;
        }
 
        
        // validar si es codigo de alta o baja
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int idCanal = 0;
        try {
            int codigoCanal = Integer.parseInt(altaBajaBolsaRequest.getCanal());
            Canal canalBd = (Canal) session.load(Canal.class, codigoCanal);
            idCanal = canalBd.getId();
        } catch (Exception e) {
            logger.error("Canal no configurado en el sistema Tracking");
            respuestaServicio.setCodigoError(21);
            respuestaServicio.setDescripcionError("Canal no configurado en el sistema Tracking");
            respuestaServicio.setMensajeError("Canal no valido");
            return respuestaServicio;
        }
        
        int idEventoTracking = 0;
        try {
            EventosTracking eventoTrackingBd = (EventosTracking) session.load(EventosTracking.class, altaBajaBolsaRequest.getCodigoEventoSistema());
            idEventoTracking = eventoTrackingBd.getId();
            if(idEventoTracking < 1000 || idEventoTracking> 2999){
                respuestaServicio.setCodigoError(21);
                respuestaServicio.setDescripcionError("Solo se pueden informar eventos de alta o de baja por este medio");
                respuestaServicio.setMensajeError("Evento informado no valido");
                return respuestaServicio;
            }
            int idCanalEvento = eventoTrackingBd.getCanal();
            if(idCanalEvento != idCanal){
                respuestaServicio.setCodigoError(21);
                respuestaServicio.setDescripcionError("No se puede informar este evento a traves del canal");
                respuestaServicio.setMensajeError("No se puede informar este evento a traves del canal");
                return respuestaServicio;
            }
        } catch (Exception e) {
            logger.error("EventosTracking no configurado en el sistema Tracking");
            respuestaServicio.setCodigoError(21);
            respuestaServicio.setDescripcionError("Evento no configurado en el sistema Tracking");
            respuestaServicio.setMensajeError("Evento informado no configurado");
            return respuestaServicio;
        }
        
        return respuestaServicio;
    }
    
    
    
    private Session session;
    private static final Logger logger = Logger.getLogger(WebServicesValidacionesGatewayAltaBaja.class.getName());    
    private static final WebServicesValidacionesGatewayAltaBaja INSTANCE = new WebServicesValidacionesGatewayAltaBaja();
    
    
    private WebServicesValidacionesGatewayAltaBaja() {
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        String resourceLog = "cl/movistar/tracking/services/altaBaja/TrackingServicesAltaBajaLog4j.properties";
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
    
    
    
}
