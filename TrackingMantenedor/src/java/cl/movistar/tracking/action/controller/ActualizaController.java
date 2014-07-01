/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.controller;

import cl.telefonica.tracking.hibernate.dto.Canal;
import cl.telefonica.tracking.hibernate.dto.EventosTracking;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;
import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;

/**
 *
 * @author Christian
 */
public class ActualizaController {
    
    public ActualizaController() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        
        controller = new EventosTracking();
        controller.setId(codigo);
        controller.setDescripcion(descripcion);
        controller.setNombre(nombre);
        
        TrackingFacade trackingFacade = new TrackingFacade();
      
        controller.setEventoSistema(Integer.parseInt(eventoSistemaCodigo));
        
        EventoNegocio eventoNegocio = new EventoNegocio();
        controller.setEventoNegocio(Integer.parseInt(eventoNegocioCodigo));
       
        controller.setCanal(Integer.parseInt(canalCodigo));
        actualizado = trackingPersistenciaFacade.actualizarController(controller);
        
        if(actualizado){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private EventosTracking controller;
    private String eventoNegocioCodigo;
    private String eventoSistemaCodigo;
    private String canalCodigo;
    private boolean actualizado;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    /**
     * @return the eventoNegocioCodigo
     */
    public String getEventoNegocioCodigo() {
        return eventoNegocioCodigo;
    }

    /**
     * @param eventoNegocioCodigo the eventoNegocioCodigo to set
     */
    public void setEventoNegocioCodigo(String eventoNegocioCodigo) {
        this.eventoNegocioCodigo = eventoNegocioCodigo;
    }

    /**
     * @return the eventoSistemaCodigo
     */
    public String getEventoSistemaCodigo() {
        return eventoSistemaCodigo;
    }

    /**
     * @param eventoSistemaCodigo the eventoSistemaCodigo to set
     */
    public void setEventoSistemaCodigo(String eventoSistemaCodigo) {
        this.eventoSistemaCodigo = eventoSistemaCodigo;
    }

    /**
     * @return the actualizado
     */
    public boolean isActualizado() {
        return actualizado;
    }

    /**
     * @param actualizado the actualizado to set
     */
    public void setActualizado(boolean actualizado) {
        this.actualizado = actualizado;
    }

    /**
     * @return the canalCodigo
     */
    public String getCanalCodigo() {
        return canalCodigo;
    }

    /**
     * @param canalCodigo the canalCodigo to set
     */
    public void setCanalCodigo(String canalCodigo) {
        this.canalCodigo = canalCodigo;
    }
    
    
    
}
