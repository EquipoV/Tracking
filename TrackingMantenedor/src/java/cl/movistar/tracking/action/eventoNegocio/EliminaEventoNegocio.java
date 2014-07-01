/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoNegocio;


import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;

/**
 *
 * @author Christian
 */
public class EliminaEventoNegocio {
    
    public EliminaEventoNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        eventoNegocio = new EventoNegocio();
        eventoNegocio.setId(codigo);
        eliminado = trackingPersistenciaFacade.eliminarEventoNegocio(eventoNegocio);
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private EventoNegocio eventoNegocio;
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
     * @return the eventoNegocio
     */
    public EventoNegocio getEventoNegocio() {
        return eventoNegocio;
    }

    /**
     * @param eventoNegocio the eventoNegocio to set
     */
    public void setEventoNegocio(EventoNegocio eventoNegocio) {
        this.eventoNegocio = eventoNegocio;
    }

    
    
}
