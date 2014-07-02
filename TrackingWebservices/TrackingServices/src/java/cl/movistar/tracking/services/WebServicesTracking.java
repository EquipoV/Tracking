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
import cl.movistar.tracking.dto.Respuesta;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.dto.TrackingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jws.WebService;

/**
 *
 * @author Christian
 */
@WebService(serviceName = "TrackingImplService", portName = "TrackingImpl", endpointInterface = "cl.movistar.tracking.services.TrackingImpl", targetNamespace = "http://services.tracking.movistar.cl", wsdlLocation = "WEB-INF/wsdl/WebServicesTracking/TrackingServices.wsdl")
public class WebServicesTracking {

    public TrackingResponse trackingAltaBolsa(AltaBolsaRequest altaBolsaRequest) {
        //TODO implement this method
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        respuestaServicio.setCodigoError(23);
        respuestaServicio.setMensajeError("Esta operacion no esta permitida");
        respuestaServicio.setDescripcionError("Esta operacion fue eliminada de este servicio");
        trackingResponse.setRespuestaServicio(respuestaServicio);
        return trackingResponse;
        
    }

    public TrackingResponse trackingBajaBolsa(BajaBolsaRequest bajaBolsaRequest) {
        //TODO implement this method
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        respuestaServicio.setCodigoError(23);
        respuestaServicio.setMensajeError("Esta operacion no esta permitida");
        respuestaServicio.setDescripcionError("Esta operacion fue eliminada de este servicio");
        trackingResponse.setRespuestaServicio(respuestaServicio);
        return trackingResponse;
    }

    public TrackingResponse trackingCambioEstado(CambioEstadoRequest cambioEstadoRequest) {
        //TODO implement this method
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        WebServicesTrackingFacade webServicesTrackingFacade = new WebServicesTrackingFacade();
        respuestaServicio = webServicesTrackingFacade.validaEntradaCambioEstado(cambioEstadoRequest);
        if(respuestaServicio.getCodigoError() != 0){
            trackingResponse.setRespuestaServicio(respuestaServicio);
        }else{
            trackingResponse = webServicesTrackingFacade.registrarCambioEstado(cambioEstadoRequest);
        }
        
        return trackingResponse;
    }

    public TrackingResponse trackingCambioUmbral(CambioUmbralRequest cambioUmbralRequest) {
        //TODO implement this method
        
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        
        WebServicesTrackingFacade webServicesTrackingFacade = new WebServicesTrackingFacade();
        respuestaServicio = webServicesTrackingFacade.validaEntradaCambioUmbral(cambioUmbralRequest);
        if(respuestaServicio.getCodigoError() != 0){
            trackingResponse.setRespuestaServicio(respuestaServicio);
        }else{
            trackingResponse = webServicesTrackingFacade.realizarCambioUmbral(cambioUmbralRequest);
        }
        
        return trackingResponse;
    }

    public TrackingResponse trackingRegistroVenta(RegistroVentaRequest registroVentaRequest) {
        //TODO implement this method
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        WebServicesTrackingFacade webServicesTrackingFacade = new WebServicesTrackingFacade();
        respuestaServicio = webServicesTrackingFacade.validaEntradaRegistroVenta(registroVentaRequest);
        if(respuestaServicio.getCodigoError() != 0){
            trackingResponse.setRespuestaServicio(respuestaServicio);
        }else{
            trackingResponse = webServicesTrackingFacade.registrarRegistroVenta(registroVentaRequest);
        }
        
        return trackingResponse;
    }

    public TrackingResponse trackingBitacoraRecurrencia(BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        //TODO implement this method
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        
        WebServicesTrackingFacade webServicesTrackingFacade = new WebServicesTrackingFacade();
        respuestaServicio = webServicesTrackingFacade.validaEntradaBitacoraRecurrencia(bitacoraRecurrenciaRequest);
        if(respuestaServicio.getCodigoError() != 0){
            trackingResponse.setRespuestaServicio(respuestaServicio);
        }else{
            trackingResponse = webServicesTrackingFacade.registrarBitacoraRecurrencia(bitacoraRecurrenciaRequest);
        }
        
        return trackingResponse;
    }

    private WebServicesTrackingFacade webServicesTrackingFacade;
    private static final Logger logger = LoggerFactory.getLogger(WebServicesTracking.class);
    
}
