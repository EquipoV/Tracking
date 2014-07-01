/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.action.canal;


import cl.telefonica.tracking.gateway.TrackingFacade;
import cl.telefonica.tracking.hibernate.dto.Canal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ListaCanal {
    
    public ListaCanal() {
        super();
    }
   
    public String execute() throws Exception {
        TrackingFacade trackingFacade = new TrackingFacade();
        
        respuestaServicio = new ArrayList();
        respuestaServicio = trackingFacade.listarCanales();
        
        return "success";
    }
    
    private List<Canal> respuestaServicio; 

    /**
     * @return the respuestaServicio
     */
    public List<Canal> getRespuestaServicio() {
        return respuestaServicio;
    }

    /**
     * @param respuestaServicio the respuestaServicio to set
     */
    public void setRespuestaServicio(List<Canal> respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    
}
