/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.eventoNegocio;

import cl.telefonica.tracking.gateway.TrackingPersistenciaFacade;
import cl.telefonica.tracking.hibernate.dto.AccionNegocio;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CreaEventoNegocio {
    
    public CreaEventoNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
       
        eventoNegocio = new EventoNegocio();
        eventoNegocio.setId(codigo);
        eventoNegocio.setDescripcion(descripcion);
        eventoNegocio.setNombre(nombre);
        
        
//        List<AccionNegocio> accionesNegocio = new ArrayList();
//        String[] codigos = codigosAccionesNegocio.split(",");
//        for (int i = 0; i < codigos.length; i++) {
//            AccionNegocio accionNegocio = new AccionNegocio();
//            String codigoAccionNegocioAux = codigos[i].trim();
//            accionNegocio.setId(Integer.parseInt(codigoAccionNegocioAux));
//            accionesNegocio.add(accionNegocio);
//        }
        
        eventoNegocio.setAccionesNegocio(codigosAccionesNegocio);
        
        respuestaServicio = trackingPersistenciaFacade.crearEventoNegocio(eventoNegocio);
        
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
    private EventoNegocio eventoNegocio;
    private String codigosAccionesNegocio;
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

    /**
     * @return the codigosAccionesNegocio
     */
    public String getCodigosAccionesNegocio() {
        return codigosAccionesNegocio;
    }

    /**
     * @param codigosAccionesNegocio the codigosAccionesNegocio to set
     */
    public void setCodigosAccionesNegocio(String codigosAccionesNegocio) {
        this.codigosAccionesNegocio = codigosAccionesNegocio;
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
