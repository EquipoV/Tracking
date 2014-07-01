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
public class CreaCanal {
    
    public CreaCanal() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        try {
            canal = new Canal();
            canal.setId(codigo);
            canal.setDescripcion(descripcion);
            canal.setNombre(nombre);

            respuestaServicio = trackingPersistenciaFacade.crearCanal(canal);
        } catch (Exception e) {
            respuesta = "error";
        }
        
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
    private Canal canal;
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
