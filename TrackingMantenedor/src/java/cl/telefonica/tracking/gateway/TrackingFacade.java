/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.telefonica.tracking.gateway;



import cl.telefonica.tracking.hibernate.dto.AccionNegocio;
import cl.telefonica.tracking.hibernate.dto.AccionSistema;
import cl.telefonica.tracking.hibernate.dto.Canal;
import cl.telefonica.tracking.hibernate.dto.EventoNegocio;
import cl.telefonica.tracking.hibernate.dto.EventoSistema;
import cl.telefonica.tracking.hibernate.dto.EventosTracking;
import java.util.List;

/**
 *
 * @author Christian
 */
public class TrackingFacade {

    public List<Canal> listarCanales(){
        return TrackingHibernateGateway.getInstance().listarCanales();
    }
    
    public List<EventoSistema> listarEventosSistema() {
        return TrackingHibernateGateway.getInstance().listarEventosSistema();
    }
    
    public List<AccionSistema> listarAccionesSistema() {
        return TrackingHibernateGateway.getInstance().listarAccionesSistema();
    }
    
    public List<EventoNegocio> listarEventosNegocio() {
        return TrackingHibernateGateway.getInstance().listarEventosNegocio();
    }
    
    public List<AccionNegocio> listarAccionesNegocio() {
        return TrackingHibernateGateway.getInstance().listarAccionesNegocio();
    }
    
    public List<EventosTracking> listarControllerEventoSistemaEventoNegocio() {
        return TrackingHibernateGateway.getInstance().listarControllerEventoSistemaEventoNegocio();
    }
    
    public AccionSistema obtieneAccionSistemaPorCodigo(String codigoAccion) {
        return TrackingHibernateGateway.getInstance().obtieneAccionSistemaPorCodigo(codigoAccion);
    }
    
    public Canal obtieneCanalPorCodigo(String codigo) {
        return TrackingHibernateGateway.getInstance().obtieneCanalPorCodigo(codigo);
    }
    
    public AccionNegocio obtieneAccionNegocioPorCodigo(String codigoAccion) {
        return TrackingHibernateGateway.getInstance().obtieneAccionNegocioPorCodigo(codigoAccion);
    }
    
    public EventoNegocio obtieneEventoNegocioPorCodigo(String codigoEvento) {
        return TrackingHibernateGateway.getInstance().obtieneEventoNegocioPorCodigo(codigoEvento);
    }
    
    public EventoSistema obtieneEventoSistemaPorCodigo(String codigoEvento) {
        return TrackingHibernateGateway.getInstance().obtieneEventoSistemaPorCodigo(codigoEvento);
    }

   
    public boolean loginTracking(String contrasena, String rut) {
        return TrackingHibernateGateway.getInstance().loginTracking(contrasena,rut);
    }
}
