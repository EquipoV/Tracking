/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.canal;


import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.Canal;

/**
 *
 * @author Christian
 */
public class EliminaCanal {
    
    public EliminaCanal() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        
        canal = new Canal();
        try {
            canal.setId(codigo);
            eliminado = trackingPersistenciaFacade.eliminarCanal(canal);
        } catch (Exception e) {
            eliminado = false;
        }
        
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private Canal canal;
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
     * @return the canal
     */
    public Canal getCanal() {
        return canal;
    }

    /**
     * @param canal the canal to set
     */
    public void setCanal(Canal canal) {
        this.canal = canal;
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

    
    
}
