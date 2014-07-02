/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import cl.movistar.tracking.dto.BitacoraRecurrenciaRequest;
import cl.movistar.tracking.dto.CambioUmbralRequest;
import cl.movistar.tracking.dto.TrackingResponse;
import cl.movistar.tracking.hibernate.Canal;
import cl.movistar.tracking.hibernate.MovimientosTracking;
import cl.movistar.tracking.services.WebServicesTrackingFacade;
import cl.movistar.tracking.services.WebServicesTrackingGateway;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class TrackingServicesTest {
    
    public TrackingServicesTest() {
        webServicesTrackingFacade = new WebServicesTrackingFacade();
    }
    
    @Test    
    public void deberiaObtenerCanal(){
        int codigoCanal = 1;
        Canal canal = webServicesTrackingFacade.obtenerCanal(codigoCanal);
        assertNotNull("No es una entrada valida.", canal);
    }
    
//    @Test    
//    public void deberiaRegistrarParque(){
//        String codigoOferta = "OFE002";
//        boolean registro = WebServicesTrackingGateway.getInstance().registraParque(5001, "OFE002", "clastra", "97590320", 2);
//        assertTrue("No es una entrada valida.", registro);
//    }
    
    
    @Test    
    public void deberiaObtenerMovimientos(){
        int numeroCelular = 97590320;
        List<MovimientosTracking> bitacoras = webServicesTrackingFacade.obtenerMovimientos(numeroCelular);
        assertNotNull("No es una entrada valida.", bitacoras);
    }
    
    @Test    
    public void deberiaRealizarCambioUmbral(){
        CambioUmbralRequest request = new CambioUmbralRequest();
        request.setCanal("2");
        request.setCantidadFinal(100);
        request.setCantidadInicial(50);
        request.setCodigoEventoSistema(5);
        request.setDescripcion("Cambio de umbral prueba");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String dateInString = "31-08-1982 10:20:56";
        try {
            Date date = sdf.parse(dateInString);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(date);
            XMLGregorianCalendar dealCloseDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            request.setFechaModificacion(dealCloseDate);
        } catch (ParseException ex) {
            Logger.getLogger(TrackingServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(TrackingServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setNombre("Cambio Umbral");
        request.setTipoProducto("Minutos");
        request.setCodigo("BA-123");
        
        TrackingResponse trackingResponse  = webServicesTrackingFacade.realizarCambioUmbral(request);
        assertNotNull("No es un canal valido.", trackingResponse.getRespuestaServicio().getCodigoError());
    }
    
    
    @Test    
    public void deberiaRegistrarBitacoraRecurrencia(){
        
        BitacoraRecurrenciaRequest bitacoraRecurrenciaRequest = new BitacoraRecurrenciaRequest();
        bitacoraRecurrenciaRequest.setCanal("3");
        bitacoraRecurrenciaRequest.setCodigoEventoSistema(4001);
        bitacoraRecurrenciaRequest.setIdRed("ed123");
        bitacoraRecurrenciaRequest.setNumeroAbonado(1212241);
        
        TrackingResponse trackingResponse  = webServicesTrackingFacade.registrarBitacoraRecurrencia(bitacoraRecurrenciaRequest);
        assertNotNull("No es un canal valido.", trackingResponse.getRespuestaServicio().getCodigoError());
    }
    
    private WebServicesTrackingFacade webServicesTrackingFacade;
}