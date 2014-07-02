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
import cl.movistar.tracking.dto.TrackingResponse;
import cl.movistar.tracking.hibernate.BitacoraRecurrencia;
import cl.movistar.tracking.hibernate.CambioUmbral;
import cl.movistar.tracking.hibernate.Canal;
import cl.movistar.tracking.hibernate.MovimientosTracking;

import java.util.List;

/**
 *
 * @author Christian
 */
public class WebServicesTrackingFacade {

    public TrackingResponse realizarCambioUmbral(CambioUmbralRequest cambioUmbralRequest) {
        return WebServicesTrackingGateway.getInstance().realizarCambioUmbral(cambioUmbralRequest);
    }

    public TrackingResponse registrarBitacoraRecurrencia(BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        return WebServicesTrackingGateway.getInstance().registrarBitacoraRecurrencia(bitacoraRecurrenciaRequest);
    }

    public TrackingResponse registrarRegistroVenta(RegistroVentaRequest registroVentaRequest) {
        return WebServicesTrackingGateway.getInstance().registrarRegistroVenta(registroVentaRequest);
    }

    public TrackingResponse registrarCambioEstado(CambioEstadoRequest cambioEstadoRequest) {
        return WebServicesTrackingGateway.getInstance().registrarCambioEstado(cambioEstadoRequest);
    }

    public TrackingResponse bajaDeBolsa(BajaBolsaRequest bajaBolsaRequest) {
        return WebServicesTrackingGateway.getInstance().bajaDeBolsa(bajaBolsaRequest);
    }

    public TrackingResponse altaDeBolsa(AltaBolsaRequest altaBolsaRequest) {
        return WebServicesTrackingGateway.getInstance().altaDeBolsa(altaBolsaRequest);
    }

    public List<MovimientosTracking> obtenerMovimientos(int numeroCelular) {
        return WebServicesTrackingGateway.getInstance().obtenerMovimientos(numeroCelular);
    }

    public RespuestaServicio validaEntradaAltaBolsa(AltaBolsaRequest altaBolsaRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaAltaBolsa(altaBolsaRequest);
    }

    public RespuestaServicio validaEntradaBajaBolsa(BajaBolsaRequest bajaBolsaRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaBajaBolsa(bajaBolsaRequest);
    }

    public RespuestaServicio validaEntradaCambioEstado(CambioEstadoRequest cambioEstadoRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaCambioEstado(cambioEstadoRequest);
    }

    public RespuestaServicio validaEntradaCambioUmbral(CambioUmbralRequest cambioUmbralRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaCambioUmbral(cambioUmbralRequest);
    }

    public RespuestaServicio validaEntradaRegistroVenta(RegistroVentaRequest registroVentaRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaRegistroVenta(registroVentaRequest);
    }

    public RespuestaServicio validaEntradaBitacoraRecurrencia(BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest) {
        return WebServicesValidacionesGateway.getInstance().validaEntradaBitacoraRecurrencia(bitacoraRecurrenciaRequest);
    }

    public Canal obtenerCanal(int codigoCanal) {
        return WebServicesValidacionesGateway.getInstance().obtenerCanal(codigoCanal);
    }

   
}
