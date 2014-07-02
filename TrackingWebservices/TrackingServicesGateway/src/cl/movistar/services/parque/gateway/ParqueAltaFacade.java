/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.services.parque.gateway;

import cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.ActivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;

/**
 *
 * @author Christian
 */
public class ParqueAltaFacade {

    public ActivaBolsaAbonadoResponseDTO informarParqueAlta(ActivaBolsaAbonadoRequestDTO request) {
        return ParqueAltaGateway.getInstance().informarParqueAlta(request);
    }
    
        
}
