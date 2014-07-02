/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.midrange.provision.convergente.gateway;

import cl.movistar.configuracion.Configuracion;
import cl.movistar.midrange.provision.convergente.product.ProductOrderLocator;
import cl.movistar.midrange.provision.convergente.product.ProductOrder;
import cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate;
import cl.movistar.midrange.provision.convergente.product.ProductOrderPortBindingStub;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Properties;


import org.apache.axis.AxisFault;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author Christian
 */
public class ProvisionConvergenteGateway {
    
    public static ProvisionConvergenteGateway getInstance() {
        return INSTANCE;
    }
    
    private static final Logger logger = Logger.getLogger(ProvisionConvergenteGateway.class.getName());
    private static final ProvisionConvergenteGateway INSTANCE = new ProvisionConvergenteGateway();
    private ProductOrder w;
    private ProductOrderDelegate ws;
    private Configuracion config;
    
    private ProvisionConvergenteGateway() {
        String resourceLog = "cl/movistar/configuracion/TrackingServicesLog4j.properties";
        InputStream isLog = this.getClass().getClassLoader().getResourceAsStream(resourceLog);
        Properties props = new Properties();
        w = new ProductOrderLocator();
        try {
            URL endpoint = new java.net.URL(Configuracion.getInstance().getEndpointProvisionConvergente());
            ws = new ProductOrderPortBindingStub(endpoint,w);
            props.load(isLog);
            PropertyConfigurator.configure(props);
            isLog.close();
        } catch (AxisFault ex) {
            // TODO Auto-generated catch block
            logger.error("AxisFault");
            logger.error(ex);
        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException");
            logger.error(ex);
        } catch (IOException ex) {
            logger.error("IOException");
            logger.error(ex);
        }
        
        

    }

    public ProductOrderResponse llamarProvisionadorConvergente(cl.movistar.midrange.provision.convergente.product.types.ProductOrder request) {
        logger.info("Entre a llamarProvisionadorConvergente");
        ProductOrderResponse response = new ProductOrderResponse();
        try {
            logger.info("Antes de llamar al Webservices del Provisionador");
            response = ws.start(request);
        } catch (RemoteException ex) {
            logger.error("Error al llamar el servicio de Provisionador Convergente");
            logger.error(ex);
        }
        return response;
    }
}
