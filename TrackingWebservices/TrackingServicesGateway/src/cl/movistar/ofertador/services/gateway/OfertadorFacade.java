package cl.movistar.ofertador.services.gateway;

import cl.movistar.ofertador.dto.Response;
import cl.movistar.ofertador.dto.ResponseDetalleOferta;
import cl.movistar.ofertador.dto.ResponseOfertas;
import cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta;
import cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales;
import cl.movistar.ofertador.dto.SolicitudOferta;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RRR
 */
public class OfertadorFacade {

    public ResponseDetalleOferta obtenerDetalleOferta(String codigoOferta) {
        return OfertadorGateway.getInstance().obtenerDetalleOferta(codigoOferta);
    }

    
    
}
