/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.movistar.datoscliente.gateway;

import cl.movistar.osb.GetDetalleVO;



/**
 *
 * @author RRR
 */
public class DatosClienteFacade {

    public GetDetalleVO obtenerDatosCliente(int numeroCelular) {
        return DatosClienteGateway.getInstance().obtenerDatosCliente(numeroCelular);
    }
    
}
