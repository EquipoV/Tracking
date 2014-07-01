/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.accionSistema;



import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.AccionSistema;

/**
 *
 * @author Christian
 */
public class EliminaAccionSistema {
    
    public EliminaAccionSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        accionSistema = new AccionSistema();
        accionSistema.setId(codigo);
        
        eliminado = trackingPersistenciaFacade.eliminarAccionSistema(accionSistema);
        
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private AccionSistema accionSistema;
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
     * @return the accionSistema
     */
    public AccionSistema getAccionSistema() {
        return accionSistema;
    }

    /**
     * @param accionSistema the accionSistema to set
     */
    public void setAccionSistema(AccionSistema accionSistema) {
        this.accionSistema = accionSistema;
    }

    
    
    
}
