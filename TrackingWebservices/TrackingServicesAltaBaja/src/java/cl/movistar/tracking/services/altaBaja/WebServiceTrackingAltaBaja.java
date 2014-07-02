/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services.altaBaja;

import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.dto.TrackingResponse;
import javax.jws.WebService;

/**
 *
 * @author Christian
 */
@WebService(serviceName = "TrackingAltaBajaService", portName = "TrackingAltaBaja", endpointInterface = "cl.movistar.tracking.services.TrackingAltaBaja", targetNamespace = "http://services.tracking.movistar.cl", wsdlLocation = "WEB-INF/wsdl/WebServiceTrackingAltaBaja/TrackingServicesAltaBaja.wsdl")
public class WebServiceTrackingAltaBaja {

    public cl.movistar.tracking.dto.TrackingResponse trackingAltaBajaBolsa(cl.movistar.tracking.dto.AltaBajaBolsaRequest altaBajaBolsaRequest) {
        TrackingResponse trackingResponse = new TrackingResponse();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
        WebServicesTrackingFacade webServicesTrackingFacade = new WebServicesTrackingFacade();
        respuestaServicio = webServicesTrackingFacade.validaEntradaAltaBajaBolsa(altaBajaBolsaRequest);
        if(respuestaServicio.getCodigoError() != 0){
            trackingResponse.setRespuestaServicio(respuestaServicio);
        }else{
            trackingResponse = webServicesTrackingFacade.altaBajaDeBolsa(altaBajaBolsaRequest);
        }
        
        return trackingResponse;
    }
    
}
