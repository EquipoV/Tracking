package cl.telefonica.tracking.gateway;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase responsable de leer y mantener toda la configuración que se lee desde 
 * el archivo config.properties del proyecto.
 * @author Christian
 */
public class Configuracion {
    
    private String baseDatos;
    private String urlDB;
    private String usuarioDB;
    private String passwordDB;
    private String urlDB2;
    private String usuarioDB2;
    private String passwordDB2;
    
    
    private static final Configuracion INSTANCE = new Configuracion();
    private static final Logger logger = Logger.getLogger(Configuracion.class.getName());
    
    
    public static Configuracion getInstance() {
        return INSTANCE;
    }
    private Configuracion() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("config.properties"));
            this.urlDB = props.getProperty("db.url");
            this.usuarioDB = props.getProperty("db.usuario");
            this.passwordDB = props.getProperty("db.clave");
            this.urlDB2 = props.getProperty("db2.url");
            this.usuarioDB2 = props.getProperty("db2.usuario");
            this.passwordDB2 = props.getProperty("db2.clave");
            this.baseDatos = props.getProperty("db.tipo");
            
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "No se pudo cargar la configuración.", ex);
        }
    }
    
    

    /**
     * @return the urlDB
     */
    public String getUrlDB() {
        return urlDB;
    }

    /**
     * @param urlDB the urlDB to set
     */
    public void setUrlDB(String urlDB) {
        this.urlDB = urlDB;
    }

    /**
     * @return the usuarioDB
     */
    public String getUsuarioDB() {
        return usuarioDB;
    }

    /**
     * @param usuarioDB the usuarioDB to set
     */
    public void setUsuarioDB(String usuarioDB) {
        this.usuarioDB = usuarioDB;
    }

    /**
     * @return the passwordDB
     */
    public String getPasswordDB() {
        return passwordDB;
    }

    /**
     * @param passwordDB the passwordDB to set
     */
    public void setPasswordDB(String passwordDB) {
        this.passwordDB = passwordDB;
    }

    /**
     * @return the urlDB2
     */
    public String getUrlDB2() {
        return urlDB2;
    }

    /**
     * @param urlDB2 the urlDB2 to set
     */
    public void setUrlDB2(String urlDB2) {
        this.urlDB2 = urlDB2;
    }

    /**
     * @return the usuarioDB2
     */
    public String getUsuarioDB2() {
        return usuarioDB2;
    }

    /**
     * @param usuarioDB2 the usuarioDB2 to set
     */
    public void setUsuarioDB2(String usuarioDB2) {
        this.usuarioDB2 = usuarioDB2;
    }

    /**
     * @return the passwordDB2
     */
    public String getPasswordDB2() {
        return passwordDB2;
    }

    /**
     * @param passwordDB2 the passwordDB2 to set
     */
    public void setPasswordDB2(String passwordDB2) {
        this.passwordDB2 = passwordDB2;
    }

    /**
     * @return the baseDatos
     */
    public String getBaseDatos() {
        return baseDatos;
    }

    /**
     * @param baseDatos the baseDatos to set
     */
    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    
    
}
