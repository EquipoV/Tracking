/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.accionNegocio;


import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.AccionNegocio;

/**
 *
 * @author Christian
 */
public class EliminaAccionNegocio {
    
    public EliminaAccionNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        accionNegocio = new AccionNegocio();
        accionNegocio.setId(codigo);
        
        eliminado = trackingPersistenciaFacade.eliminarAccionNegocio(accionNegocio);
        
        if(eliminado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private AccionNegocio accionNegocio;
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
     * @return the accionNegocio
     */
    public AccionNegocio getAccionNegocio() {
        return accionNegocio;
    }

    /**
     * @param accionNegocio the accionNegocio to set
     */
    public void setAccionNegocio(AccionNegocio accionNegocio) {
        this.accionNegocio = accionNegocio;
    }

    
}
