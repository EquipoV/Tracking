/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoSistema;


import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;

/**
 *
 * @author Christian
 */
public class EliminaEventoSistema {
    
    public EliminaEventoSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        eventoSistema = new EventoSistema();
        eventoSistema.setId(codigo);
        eliminado = trackingPersistenciaFacade.eliminarEventoSistema(eventoSistema);
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private EventoSistema eventoSistema;
    private boolean eliminado;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    /**
     * @return the eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the eventoSistema
     */
    public EventoSistema getEventoSistema() {
        return eventoSistema;
    }

    /**
     * @param eventoSistema the eventoSistema to set
     */
    public void setEventoSistema(EventoSistema eventoSistema) {
        this.eventoSistema = eventoSistema;
    }

    
    
}
