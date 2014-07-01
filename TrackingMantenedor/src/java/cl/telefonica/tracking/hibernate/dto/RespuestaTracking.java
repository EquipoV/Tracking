/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.telefonica.tracking.hibernate.dto;


/**
 *
 * @author Christian
 */
public class RespuestaTracking {
    
    private int idSolicitud;
    private String estado;
    private String mensaje;

    /**
     * @return the idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
