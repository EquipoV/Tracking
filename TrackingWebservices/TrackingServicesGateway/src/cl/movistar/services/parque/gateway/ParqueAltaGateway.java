/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.services.parque.gateway;


import cl.movistar.configuracion.Configuracion;
import cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.ActivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.ActivaBolsaAbonadoWS;
import cl.movistar.services.parque.ActivaBolsaAbonadoWSService;
import cl.movistar.services.parque.ActivaBolsaAbonadoWSServiceLocator;
import cl.movistar.services.parque.ActivaBolsaAbonadoWSSoapBindingStub;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.axis.AxisFault;

/**
 *
 * @author Christian
 */
public class ParqueAltaGateway {
    
    public static ParqueAltaGateway getInstance() {
        return INSTANCE;
    }
    
    private static final Logger logger = Logger.getLogger(ParqueAltaGateway.class.getName());
    private static final ParqueAltaGateway INSTANCE = new ParqueAltaGateway();
    private ActivaBolsaAbonadoWSService w;
    private ActivaBolsaAbonadoWS ws;
    private Configuracion config;
    
    private ParqueAltaGateway() {
        w = new ActivaBolsaAbonadoWSServiceLocator();
        try {
            URL endpoint = new java.net.URL(Configuracion.getInstance().getEndpointParqueAlta());
            ws = new ActivaBolsaAbonadoWSSoapBindingStub(endpoint,w);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ActivaBolsaAbonadoResponseDTO informarParqueAlta(ActivaBolsaAbonadoRequestDTO request) {
        ActivaBolsaAbonadoResponseDTO response = new ActivaBolsaAbonadoResponseDTO();
        try {
            response = ws.activaBolsa(request);
            
        } catch (RemoteException ex) {
            Logger.getLogger(ParqueAltaGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    
    
}
