/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.telefonica.tracking.hibernate.dto;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Christian
 */
public class TrackingHibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        SessionFactory sessionFactoryAUX;
        try {

            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.

            sessionFactoryAUX = new Configuration().configure(
                    "hibernateJNDI.cfg.xml").buildSessionFactory();
            if (sessionFactoryAUX.openSession().beginTransaction().isActive()) {
               sessionFactoryAUX.openSession().close();
            }
        } catch (Throwable ex) {
            sessionFactoryAUX = new Configuration().configure(
                    "hibernateDesarrollo.cfg.xml").buildSessionFactory();
            if (sessionFactoryAUX.openSession().beginTransaction().isActive()) {
                sessionFactoryAUX.openSession().close();
            }
        }
        sessionFactory = sessionFactoryAUX;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
