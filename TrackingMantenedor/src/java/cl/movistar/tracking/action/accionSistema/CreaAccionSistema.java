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
public class CreaAccionSistema {
    
    public CreaAccionSistema() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        accionSistema = new AccionSistema();
        accionSistema.setId(codigo);
        accionSistema.setDescripcion(descripcion);
        accionSistema.setNombre(nombre);
        accionSistema.setTipo(tipo);
        accionSistema.setData(data);
        
        respuestaServicio = trackingPersistenciaFacade.crearAccionSistema(accionSistema);
        
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
    private AccionSistema accionSistema;
    private String tipo;
    private String data;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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
