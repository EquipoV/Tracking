/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action;

import cl.telefonica.tracking.hibernate.dto.RespuestaTracking;
import cl.telefonica.tracking.gateway.TrackingFacade;


/**
 *
 * @author Christian
 */
public class InicioSesion {

    public InicioSesion() {
        super();
    }

    public String execute() throws Exception {

        TrackingFacade trackingFacade = new TrackingFacade();
        
        try {
            login = trackingFacade.loginTracking(contrasena, rut);
//            login = true;
        } catch (Exception e) {
            
        }

        return "success";
    }

    private boolean login;
    private String contrasena;
    private String rut;

    

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the login
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(boolean login) {
        this.login = login;
    }

   

    
}
