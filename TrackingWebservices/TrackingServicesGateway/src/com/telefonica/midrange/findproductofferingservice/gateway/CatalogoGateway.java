/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.midrange.findproductofferingservice.gateway;

import cl.movistar.configuracion.Configuracion;
import com.telefonica.midrange.findproductofferingservice.FindProductOfferingBindingStub;
import com.telefonica.midrange.findproductofferingservice.FindProductOfferingPortType;
import com.telefonica.midrange.findproductofferingservice.FindProductOfferingService;
import com.telefonica.midrange.findproductofferingservice.FindProductOfferingServiceLocator;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingRequest;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingResponse;
import com.telefonica.midrange.findproductofferingservice.types.ProductOfferingAttributes;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Properties;


import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Christian
 */
public class CatalogoGateway {

    public static CatalogoGateway getInstance() {
        return INSTANCE;
    }
    
    public FindProductOfferingResponse findProductOffering(FindProductOfferingRequest request) {
        logger.info("Entre a findProductOffering");
        FindProductOfferingResponse response = new FindProductOfferingResponse();
        try {
            logger.info("Antes de llamar al Webservices de Catalogo");
            response = ws.findProductOffering(request);
        } catch (Exception ex) {
            logger.error("Error al llamar el servicio de Catalogo");
            logger.error(ex);
        }
        return response;
    }
    
    private CatalogoGateway() {
        String resourceLog = "cl/movistar/configuracion/TrackingServicesLog4j.properties";
        InputStream isLog = this.getClass().getClassLoader().getResourceAsStream(resourceLog);
        Properties props = new Properties();
        w = new FindProductOfferingServiceLocator();
        try {
            URL endpoint = new java.net.URL(Configuracion.getInstance().getEndpointCatalogo());
            ws = new FindProductOfferingBindingStub(endpoint,w);
            props.load(isLog);
            PropertyConfigurator.configure(props);
            isLog.close();
        } catch (AxisFault ex) {
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
    
    private static final CatalogoGateway INSTANCE = new CatalogoGateway();
    private static final Logger logger = Logger.getLogger(CatalogoGateway.class.getName());    
    private FindProductOfferingService w;
    private FindProductOfferingPortType ws;
    private Configuracion config;

    
    
}
