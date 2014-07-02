/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.movistar.ofertador.services.gateway;

import cl.movistar.configuracion.Configuracion;
import cl.movistar.ofertador.dto.Oferta;
import cl.movistar.ofertador.dto.Response;
import cl.movistar.ofertador.dto.ResponseDetalleOferta;
import cl.movistar.ofertador.dto.ResponseOfertas;
import cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta;
import cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales;
import cl.movistar.ofertador.dto.SolicitudOferta;
import cl.movistar.ofertador.dto.detalleoferta.DetalleOferta;
import cl.movistar.ofertador.dto.detalleoferta.Precio;
import cl.movistar.ofertador.dto.detalleoferta.Producto;
import cl.movistar.ofertador.services.OfertadorImpl;
import cl.movistar.ofertador.services.OfertadorImplService;
import cl.movistar.ofertador.services.OfertadorImplServiceLocator;
import cl.movistar.ofertador.services.OfertadorImplSoapBindingStub;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author RRR
 */
public class OfertadorGateway {
    
    public static OfertadorGateway getInstance() {
        return INSTANCE;
    } 
    
    public ResponseDetalleOferta obtenerDetalleOferta(String codigoOferta) {
        logger.info("Entre a obtenerDetalleOferta");
        ResponseDetalleOferta response = new ResponseDetalleOferta();
        try {
            logger.info("Antes de llamar al Webservices del Ofertador");
            logger.info("Codigo oferta: " + codigoOferta);
            response = ws.obtenerDetalleOferta(codigoOferta);            
            logger.info("Respuesta del Ofertador: " + response.getRespuestaServicio().getCodigo());
        } catch (RemoteException ex) {           
            logger.error("Error al llamar el servicio del Ofertador");
            logger.error(ex);
        }
        
        return response;
    }
    
    private OfertadorGateway() {
        String resourceLog = "cl/movistar/configuracion/TrackingServicesLog4j.properties";
        InputStream isLog = this.getClass().getClassLoader().getResourceAsStream(resourceLog);
        Properties props = new Properties();
        try {
            this.w = new OfertadorImplServiceLocator();
            URL endpoint = new URL(Configuracion.getInstance().getEndpointOfertador());
            this.ws = new OfertadorImplSoapBindingStub(endpoint,w);
            props.load(isLog);
            PropertyConfigurator.configure(props);
            isLog.close();
        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException");
            logger.error(ex);
        } catch (AxisFault ex) {
            logger.error("AxisFault");
            logger.error(ex);
        } catch (IOException ex) {
            logger.error("IOException");
            logger.error(ex);
        }
    }
    
          
    
   
    private OfertadorImplService w;
    private OfertadorImpl ws;
    private static final Logger logger = Logger.getLogger(OfertadorGateway.class.getName());    
    private static final OfertadorGateway INSTANCE = new OfertadorGateway();

    
}
