/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoSistema;

import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaEventoSistema {
    
    public ListaEventoSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        eventos = new ArrayList();
        eventos = trackingFacade.listarEventosSistema();
        
        return "success";
    }
    
    private List<EventoSistema> eventos; 

    /**
     * @return the eventos
     */
    public List<EventoSistema> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<EventoSistema> eventos) {
        this.eventos = eventos;
    }

    
    
}
