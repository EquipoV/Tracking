/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.dto;

/**
 *
 * @author Christian
 */
public class RespuestaAcciones {
    
    private int codigo;
    private int idTracking;
    private String mensajeError;
    private String descripcionError;

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
     * @return the idTracking
     */
    public int getIdTracking() {
        return idTracking;
    }

    /**
     * @param idTracking the idTracking to set
     */
    public void setIdTracking(int idTracking) {
        this.idTracking = idTracking;
    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    /**
     * @return the descripcionError
     */
    public String getDescripcionError() {
        return descripcionError;
    }

    /**
     * @param descripcionError the descripcionError to set
     */
    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }
    
    
}
