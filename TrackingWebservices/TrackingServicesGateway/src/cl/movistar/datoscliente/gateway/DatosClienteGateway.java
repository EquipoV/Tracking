/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.movistar.datoscliente.gateway;

import cl.movistar.configuracion.Configuracion;
import cl.movistar.osb.ConsultarDetalleAbonado;
import cl.movistar.osb.ConsultarDetalleAbonadoPortBindingStub;
import cl.movistar.osb.ConsultarDetalleAbonadoService;
import cl.movistar.osb.ConsultarDetalleAbonadoServiceLocator;
import cl.movistar.osb.GetDetalleVO;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.axis.AxisFault;

/**
 *
 * @author RRR
 */
public class DatosClienteGateway {
    
    public static DatosClienteGateway getInstance(){
        return INSTANCE;
    }
    
    
    public GetDetalleVO obtenerDatosCliente(int numeroCelular) {
       
        GetDetalleVO respuesta = new GetDetalleVO();
        try {
            respuesta = webServices.getDetalleAbonado(numeroCelular);
        } catch (RemoteException ex) {
            Logger.getLogger(DatosClienteGateway.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return respuesta;
        
    }
    
    
    private DatosClienteGateway(){
    
        w = new ConsultarDetalleAbonadoServiceLocator();
		
        try {
            URL endpoint = new URL(Configuracion.getInstance().getEndpointDatosCliente());
            webServices = new ConsultarDetalleAbonadoPortBindingStub(endpoint,w);
            
            
        } catch (AxisFault e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
    }
    
    private ConsultarDetalleAbonadoService w;
    private ConsultarDetalleAbonado webServices;
    private static final DatosClienteGateway INSTANCE =new DatosClienteGateway();

   
}
