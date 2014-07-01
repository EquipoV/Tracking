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
public class CreaAccionNegocio {
    
    public CreaAccionNegocio() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingPersistenciaFacade trackingPersistenciaFacade = new TrackingPersistenciaFacade();
        String respuesta = "";
        accionNegocio = new AccionNegocio();
        accionNegocio.setId(codigo);
        accionNegocio.setDescripcion(descripcion);
        accionNegocio.setNombre(nombre);
        accionNegocio.setTipo(tipo);
        accionNegocio.setData(data);
        
        respuestaServicio = trackingPersistenciaFacade.crearAccionNegocio(accionNegocio);
        
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
    private AccionNegocio accionNegocio;
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

    
    
}
