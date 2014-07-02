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
import cl.telefonica.tracking.hibernate.dto.TrackingHibernateUtil;
import cl.telefonica.tracking.hibernate.dto.Usuarios;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Christian
 */
public class TrackingHibernateGateway {

    public static TrackingHibernateGateway getInstance() {
        return INSTANCE;
    }
    private Session session;
    private static final Logger logger = Logger.getLogger(TrackingHibernateGateway.class.getName());
    private static final TrackingHibernateGateway INSTANCE = new TrackingHibernateGateway();

    private TrackingHibernateGateway() {
    }

    boolean loginTracking(String contrasena, String rut) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.Usuarios where rut =" + "'" + rut + "' and contrasena = '" + contrasena + "'");
            List<Usuarios> usuario = query.list();

            usuario.get(0);
            return true;
        } catch (IndexOutOfBoundsException e) {
            //logger
            return false;
        } finally {
            session.close();
        }
//        return true;
    }

    public List<Canal> listarCanales() {
        List<Canal> canales = null;
        try {

            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.Canal ORDER BY id");
            canales = query.list();
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return canales;
    }

    public List<EventoSistema> listarEventosSistema() {
       List<EventoSistema> eventos = null;
        try {
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.EventoSistema ORDER BY id");
        eventos = query.list();
       } catch (Exception e) {
       } finally {
            session.close();
        }
        
        return eventos;
    }

    public List<AccionSistema> listarAccionesSistema() {
        List<AccionSistema> acciones = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.AccionSistema ORDER BY id");
        acciones = query.list();
       } catch (Exception e) {
        } finally {
            session.close();
        }
        return acciones;
    }

    public List<EventoNegocio> listarEventosNegocio() {
        List<EventoNegocio> eventos = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.EventoNegocio ORDER BY id");
        eventos = query.list();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        
        return eventos;
    }

    public List<AccionNegocio> listarAccionesNegocio() {
        List<AccionNegocio> accion = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.AccionNegocio ORDER BY id");
        accion = query.list();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return accion;
    }

    public List<EventosTracking> listarControllerEventoSistemaEventoNegocio() {
        List<EventosTracking> eventos = null;
       try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM cl.telefonica.tracking.hibernate.dto.EventosTracking ORDER BY id");
        eventos = query.list();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return eventos;
    }

    public AccionSistema obtieneAccionSistemaPorCodigo(String codigoAccion) {
        AccionSistema accion = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        accion = (AccionSistema) session.load(AccionSistema.class, codigoAccion);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return accion;
    }

    public Canal obtieneCanalPorCodigo(String codigo) {
        Canal canal = null;
       try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        canal = (Canal) session.load(AccionSistema.class, codigo);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return canal;
    }

    public AccionNegocio obtieneAccionNegocioPorCodigo(String codigoAccion) {
        AccionNegocio accion = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        accion = (AccionNegocio) session.load(AccionNegocio.class, codigoAccion);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return accion;
    }

    public EventoNegocio obtieneEventoNegocioPorCodigo(String codigoEvento) {
        EventoNegocio evento = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        evento = (EventoNegocio) session.load(EventoNegocio.class, codigoEvento);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return evento;
    }

    public EventoSistema obtieneEventoSistemaPorCodigo(String codigoEvento) {
        EventoSistema evento = null;
        try{
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        evento = (EventoSistema) session.load(EventoSistema.class, codigoEvento);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return evento;
    }

    boolean crearCanal(Canal canal) {
        boolean creado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(canal);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarCanal(Canal canal) {
        boolean actualizado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Canal canalAlmacenado = (Canal) session.load(Canal.class, canal.getId());
            canalAlmacenado.setDescripcion(canal.getDescripcion());
            canalAlmacenado.setNombre(canal.getNombre());
            session.update(canalAlmacenado);
            session.getTransaction().commit();
            actualizado = true;
        } catch (Exception e) {
            return actualizado;
        } finally {
            session.close();
        }

        return actualizado;

    }

    boolean eliminarCanal(Canal canal) {

        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.Canal where id = :id");
            q.setParameter("id", canal.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return false;
    }

    boolean crearEventoSistema(EventoSistema eventoSistema) {
        boolean creado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(eventoSistema);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarEventoSistema(EventoSistema eventoSistema) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(eventoSistema);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    boolean eliminarEventoSistema(EventoSistema eventoSistema) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.EventoSistema where id = :id");
            q.setParameter("id", eventoSistema.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    boolean crearAccionSistema(AccionSistema accionSistema) {
        boolean creado = false;
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(accionSistema);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarAccionSistema(AccionSistema accionSistema) {

        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(accionSistema);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return true;

    }

    boolean eliminarAccionSistema(AccionSistema accionSistema) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.AccionSistema where id = :id");
            q.setParameter("id", accionSistema.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return false;
    }

    boolean crearEventoNegocio(EventoNegocio eventoNegocio) {
        boolean creado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(eventoNegocio);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarEventoNegocio(EventoNegocio eventoNegocio) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(eventoNegocio);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    boolean eliminarEventoNegocio(EventoNegocio eventoNegocio) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.EventoNegocio where id = :id");
            q.setParameter("id", eventoNegocio.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return false;
    }

    boolean crearAccionNegocio(AccionNegocio accionNegocio) {
        boolean creado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(accionNegocio);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarAccionNegocio(AccionNegocio accionNegocio) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(accionNegocio);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    boolean eliminarAccionNegocio(AccionNegocio accionNegocio) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.AccionNegocio where id = :id");
            q.setParameter("id", accionNegocio.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return false;
    }

    boolean crearController(EventosTracking controller) {
        boolean creado = false;
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(controller);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            return creado;
        } finally {
            session.close();
        }
        return creado;
    }

    boolean actualizarController(EventosTracking controller) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(controller);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    boolean eliminarController(EventosTracking eventoTracking) {
        try {
            session = TrackingHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete cl.telefonica.tracking.hibernate.dto.EventoTracking where id = :id");
            q.setParameter("id", eventoTracking.getId());
            int result = q.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return false;
    }
}
