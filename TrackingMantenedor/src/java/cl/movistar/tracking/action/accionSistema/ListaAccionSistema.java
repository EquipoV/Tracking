/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.accionSistema;

import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.AccionSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaAccionSistema {
    
    public ListaAccionSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        respuestaServicio = new ArrayList();
        respuestaServicio = trackingFacade.listarAccionesSistema();
        
        return "success";
    }
    
    private List<AccionSistema> respuestaServicio; 

    /**
     * @return the respuestaServicio
     */
    public List<AccionSistema> getRespuestaServicio() {
        return respuestaServicio;
    }

    /**
     * @param respuestaServicio the respuestaServicio to set
     */
    public void setRespuestaServicio(List<AccionSistema> respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    
    
}
