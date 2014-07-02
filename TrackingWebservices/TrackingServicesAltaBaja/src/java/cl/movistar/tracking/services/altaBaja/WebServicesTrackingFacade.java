/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services.altaBaja;


import cl.movistar.tracking.dto.AltaBajaBolsaRequest;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.dto.TrackingResponse;


/**
 *
 * @author Christian
 */
public class WebServicesTrackingFacade {

    public TrackingResponse altaBajaDeBolsa(AltaBajaBolsaRequest altaBajaBolsaRequest) {
        return WebServicesTrackingGatewayAltaBaja.getInstance().altaBajaDeBolsa(altaBajaBolsaRequest);
    }

    public RespuestaServicio validaEntradaAltaBajaBolsa(AltaBajaBolsaRequest altaBajaBolsaRequest) {
        return WebServicesValidacionesGatewayAltaBaja.getInstance().validaEntradaAltaBolsa(altaBajaBolsaRequest);
    }

    
   
}
