package cl.movistar.configuracion;

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
    
    private String endpointProvisionConvergente;
    private String endpointParqueAlta;
    private String endpointParqueBaja;
    private String endpointCatalogo;
    private String endpointOfertador;
    private String endpointDatosCliente;
    
    
    
    private static final Configuracion INSTANCE = new Configuracion();
    private static final Logger logger = Logger.getLogger(Configuracion.class.getName());
    
    
    public static Configuracion getInstance() {
        return INSTANCE;
    }
    private Configuracion() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("config.properties"));
            this.endpointProvisionConvergente = props.getProperty("servicioProvisionConvergente.endpoint");
            this.endpointParqueAlta = props.getProperty("servicioParqueAlta.endpoint");
            this.endpointParqueBaja = props.getProperty("servicioParqueBaja.endpoint");
            this.endpointCatalogo = props.getProperty("servicioCatalogo.endpoint");
            this.endpointOfertador = props.getProperty("servicioOfertador.endpoint");
            this.endpointDatosCliente = props.getProperty("servicioDatosCliente.endpoint");
            
            
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "No se pudo cargar la configuración.", ex);
        }
    }


    /**
     * @return the endpointProvisionConvergente
     */
    public String getEndpointProvisionConvergente() {
        return endpointProvisionConvergente;
    }

    /**
     * @param endpointProvisionConvergente the endpointProvisionConvergente to set
     */
    public void setEndpointProvisionConvergente(String endpointProvisionConvergente) {
        this.endpointProvisionConvergente = endpointProvisionConvergente;
    }

    /**
     * @return the endpointParqueAlta
     */
    public String getEndpointParqueAlta() {
        return endpointParqueAlta;
    }

    /**
     * @param endpointParqueAlta the endpointParqueAlta to set
     */
    public void setEndpointParqueAlta(String endpointParqueAlta) {
        this.endpointParqueAlta = endpointParqueAlta;
    }

    /**
     * @return the endpointParqueBaja
     */
    public String getEndpointParqueBaja() {
        return endpointParqueBaja;
    }

    /**
     * @param endpointParqueBaja the endpointParqueBaja to set
     */
    public void setEndpointParqueBaja(String endpointParqueBaja) {
        this.endpointParqueBaja = endpointParqueBaja;
    }

    /**
     * @return the endpointCatalogo
     */
    public String getEndpointCatalogo() {
        return endpointCatalogo;
    }

    /**
     * @param endpointCatalogo the endpointCatalogo to set
     */
    public void setEndpointCatalogo(String endpointCatalogo) {
        this.endpointCatalogo = endpointCatalogo;
    }

    /**
     * @return the endpointOfertador
     */
    public String getEndpointOfertador() {
        return endpointOfertador;
    }

    /**
     * @param endpointOfertador the endpointOfertador to set
     */
    public void setEndpointOfertador(String endpointOfertador) {
        this.endpointOfertador = endpointOfertador;
    }

    /**
     * @return the endpointDatosCliente
     */
    public String getEndpointDatosCliente() {
        return endpointDatosCliente;
    }

    /**
     * @param endpointDatosCliente the endpointDatosCliente to set
     */
    public void setEndpointDatosCliente(String endpointDatosCliente) {
        this.endpointDatosCliente = endpointDatosCliente;
    }


    
}
