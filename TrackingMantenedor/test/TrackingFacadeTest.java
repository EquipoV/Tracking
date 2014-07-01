

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.AccionNegocio;
import cl.telefonica.tracking.hibernate.dto.AccionSistema;
import cl.telefonica.tracking.hibernate.dto.Canal;
import cl.telefonica.tracking.hibernate.dto.EventosTracking;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Christian
 */
public class TrackingFacadeTest {

    
    public TrackingFacadeTest() {
        trackingFacade = new TrackingFacade();
    }
    
    @Test    
    public void deberiaIngresar(){
        boolean login = trackingFacade.loginTracking("admin","15555555-5");
        assertTrue("No se pudo logiar.", login);
    }
    
       
    @Test    
    public void deberiaListarCanales(){
        List<Canal> canales = new ArrayList();
        canales = trackingFacade.listarCanales();
        assertNotNull("No hay canales creados.", canales);
    }
    
    @Test    
    public void deberiaListarEventosSistema(){
        List<EventoSistema> eventosSistema = new ArrayList();
        eventosSistema = trackingFacade.listarEventosSistema();
        assertNotNull("No eventos de sistemas creados.", eventosSistema);
    }
    
    @Test    
    public void deberiaListarAccionesSistemas(){
        List<AccionSistema> accionesSistema = new ArrayList();
        accionesSistema = trackingFacade.listarAccionesSistema();
        assertNotNull("No hay acciones de sistema creados.", accionesSistema);
    }
    
    @Test    
    public void deberiaListarEventosNegocio(){
        List<EventoNegocio> eventosNegocio = new ArrayList();
        eventosNegocio = trackingFacade.listarEventosNegocio();
        assertNotNull("No hay eventos de negocio creados.", eventosNegocio);
    }
    
    @Test    
    public void deberiaListarAccionesNeogio(){
        List<AccionNegocio> accionesNegocio = new ArrayList();
        accionesNegocio = trackingFacade.listarAccionesNegocio();
        assertNotNull("No hay acciones de sistema creados.", accionesNegocio);
    }
    
    @Test    
    public void deberiaListarController(){
        List<EventosTracking> controllers = new ArrayList();
        controllers = trackingFacade.listarControllerEventoSistemaEventoNegocio();
        assertNotNull("No hay acciones de sistema creados.", controllers);
    }
    
    
    private TrackingFacade trackingFacade;
}
