/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.controller;


import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.EventosTracking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaController {
    
    public ListaController() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        String respuesta = "";
        respuestaServicio = new ArrayList();
        respuestaServicio = trackingFacade.listarControllerEventoSistemaEventoNegocio();
        
        return "success";
    }
    
    private List<EventosTracking> respuestaServicio; 

    /**
     * @return the respuestaServicio
     */
    public List<EventosTracking> getRespuestaServicio() {
        return respuestaServicio;
    }

    /**
     * @param respuestaServicio the respuestaServicio to set
     */
    public void setRespuestaServicio(List<EventosTracking> respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    
    
}
