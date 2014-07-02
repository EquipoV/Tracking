/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.services.parque.gateway;

import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;

/**
 *
 * @author Christian
 */
public class ParqueBajaFacade {

    public DesactivaBolsaAbonadoResponseDTO informarParqueBaja(DesactivaBolsaAbonadoRequestDTO request) {
        return ParqueBajaGateway.getInstance().informarParqueBaja(request);
    }
    
}
