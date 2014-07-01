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
public class TrackingPersistenciaFacade {

    public boolean crearCanal(Canal canal) {
        return TrackingHibernateGateway.getInstance().crearCanal(canal);
    }

    public boolean actualizarCanal(Canal canal) {
        return TrackingHibernateGateway.getInstance().actualizarCanal(canal);
    }

    public boolean eliminarCanal(Canal canal) {
        return TrackingHibernateGateway.getInstance().eliminarCanal(canal);
    }
    
    public boolean crearEventoSistema(EventoSistema eventoSistema) {
        return TrackingHibernateGateway.getInstance().crearEventoSistema(eventoSistema);
    }

    public boolean actualizarEventoSistema(EventoSistema eventoSistema) {
        return TrackingHibernateGateway.getInstance().actualizarEventoSistema(eventoSistema);
    }

    public boolean eliminarEventoSistema(EventoSistema eventoSistema) {
        return TrackingHibernateGateway.getInstance().eliminarEventoSistema(eventoSistema);
    }

    public boolean crearAccionSistema(AccionSistema accionSistema) {
        return TrackingHibernateGateway.getInstance().crearAccionSistema(accionSistema);
    }

    public boolean actualizarAccionSistema(AccionSistema accionSistema) {
        return TrackingHibernateGateway.getInstance().actualizarAccionSistema(accionSistema);
    }

    public boolean eliminarAccionSistema(AccionSistema accionSistema) {
        return TrackingHibernateGateway.getInstance().eliminarAccionSistema(accionSistema);
    }

    public boolean crearEventoNegocio(EventoNegocio eventoNegocio) {
        return TrackingHibernateGateway.getInstance().crearEventoNegocio(eventoNegocio);
    }

    public boolean actualizarEventoNegocio(EventoNegocio eventoNegocio) {
        return TrackingHibernateGateway.getInstance().actualizarEventoNegocio(eventoNegocio);
    }

    public boolean eliminarEventoNegocio(EventoNegocio eventoNegocio) {
        return TrackingHibernateGateway.getInstance().eliminarEventoNegocio(eventoNegocio);
    }

    public boolean crearAccionNegocio(AccionNegocio accionNegocio) {
        return TrackingHibernateGateway.getInstance().crearAccionNegocio(accionNegocio);
    }

    public boolean actualizarAccionNegocio(AccionNegocio accionNegocio) {
        return TrackingHibernateGateway.getInstance().actualizarAccionNegocio(accionNegocio);
    }

    public boolean eliminarAccionNegocio(AccionNegocio accionNegocio) {
        return TrackingHibernateGateway.getInstance().eliminarAccionNegocio(accionNegocio);
    }

    public boolean crearController(EventosTracking controller) {
        return TrackingHibernateGateway.getInstance().crearController(controller);
    }

    public boolean actualizarController(EventosTracking controller) {
        return TrackingHibernateGateway.getInstance().actualizarController(controller);
    }

    public boolean eliminarController(EventosTracking controller) {
        return TrackingHibernateGateway.getInstance().eliminarController(controller);
    }

    
    
}
