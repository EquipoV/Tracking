/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.controller;

import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.EventosTracking;

/**
 *
 * @author Christian
 */
public class EliminaController {
    
    public EliminaController() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        controller = new EventosTracking();
        controller.setId(codigo);
        
        eliminado = trackingPersistenciaFacade.eliminarController(controller);
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private EventosTracking controller;
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
     * @return the controller
     */
    public EventosTracking getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(EventosTracking controller) {
        this.controller = controller;
    }

    
    
}
