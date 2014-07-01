/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.accionNegocio;


import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.AccionNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaAccionNegocio {
    
    public ListaAccionNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        respuestaServicio = new ArrayList();
        respuestaServicio = trackingFacade.listarAccionesNegocio();
        
        return "success";
    }
    
    private List<AccionNegocio> respuestaServicio; 

    /**
     * @return the respuestaServicio
     */
    public List<AccionNegocio> getRespuestaServicio() {
        return respuestaServicio;
    }

    /**
     * @param respuestaServicio the respuestaServicio to set
     */
    public void setRespuestaServicio(List<AccionNegocio> respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    
  
    
}
