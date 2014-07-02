/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.services.parque.gateway;


import cl.movistar.configuracion.Configuracion;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoWS;
import cl.movistar.services.parque.DesactivaBolsaAbonadoWSService;
import cl.movistar.services.parque.DesactivaBolsaAbonadoWSServiceLocator;
import cl.movistar.services.parque.DesactivaBolsaAbonadoWSSoapBindingStub;
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
public class ParqueBajaGateway {
    
    public static ParqueBajaGateway getInstance() {
        return INSTANCE;
    }
    
    private static final Logger logger = Logger.getLogger(ParqueBajaGateway.class.getName());
    private static final ParqueBajaGateway INSTANCE = new ParqueBajaGateway();
    private DesactivaBolsaAbonadoWSService w;
    private DesactivaBolsaAbonadoWS ws;
    private Configuracion config;
    
    private ParqueBajaGateway() {
        w = new DesactivaBolsaAbonadoWSServiceLocator();
        try {
            URL endpoint = new java.net.URL(Configuracion.getInstance().getEndpointParqueBaja());
            ws = new DesactivaBolsaAbonadoWSSoapBindingStub(endpoint,w);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public DesactivaBolsaAbonadoResponseDTO informarParqueBaja(DesactivaBolsaAbonadoRequestDTO request) {
        DesactivaBolsaAbonadoResponseDTO response = new DesactivaBolsaAbonadoResponseDTO();
        try {
            response = ws.desactivaBolsa(request);
        
        } catch (RemoteException ex) {
            Logger.getLogger(ParqueBajaGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    

    
}
