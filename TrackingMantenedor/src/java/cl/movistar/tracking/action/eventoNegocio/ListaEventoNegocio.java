/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoNegocio;


import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaEventoNegocio {
    
    public ListaEventoNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        eventos = new ArrayList();
        eventos = trackingFacade.listarEventosNegocio();
        
        return "success";
    }
    
    private List<EventoNegocio> eventos; 

    /**
     * @return the eventos
     */
    public List<EventoNegocio> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<EventoNegocio> eventos) {
        this.eventos = eventos;
    }

   
    
}
