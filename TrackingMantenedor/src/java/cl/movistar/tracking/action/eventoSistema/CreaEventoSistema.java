/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoSistema;

import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CreaEventoSistema {
    
    public CreaEventoSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        eventoSistema = new EventoSistema();
        eventoSistema.setId(codigo);
        eventoSistema.setDescripcion(descripcion);
        eventoSistema.setNombre(nombre);
//        
//        List<AccionSistema> accionesSistema = new ArrayList();
//        String[] codigos = codigosAccionesSistema.split(",");
//        for (int i = 0; i < codigos.length; i++) {
//            AccionSistema accionSistema = new AccionSistema();
//            String codigoAccionSistemaAux = codigos[i].trim();
//            accionSistema.setCodigo(Integer.parseInt(codigoAccionSistemaAux));
//            accionesSistema.add(accionSistema);
//        }
        
        eventoSistema.setAccionesSistema(codigosAccionesSistema);
        
        respuestaServicio = trackingPersistenciaFacade.crearEventoSistema(eventoSistema);
        
        if(respuestaServicio){
            respuesta = "success";
        }else{
            respuesta = "error";
        }
        return respuesta;
    }
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private EventoSistema eventoSistema;
    private String codigosAccionesSistema;
    private boolean respuestaServicio;

    
    
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

    /**
     * @return the codigosAccionesSistema
     */
    public String getCodigosAccionesSistema() {
        return codigosAccionesSistema;
    }

    /**
     * @param codigosAccionesSistema the codigosAccionesSistema to set
     */
    public void setCodigosAccionesSistema(String codigosAccionesSistema) {
        this.codigosAccionesSistema = codigosAccionesSistema;
    }

    /**
     * @return the respuestaServicio
     */
    public boolean isRespuestaServicio() {
        return respuestaServicio;
    }

    /**
     * @param respuestaServicio the respuestaServicio to set
     */
    public void setRespuestaServicio(boolean respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    
    
    
    
}
