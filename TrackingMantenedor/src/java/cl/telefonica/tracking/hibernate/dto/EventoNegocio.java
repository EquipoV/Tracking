package cl.telefonica.tracking.hibernate.dto;
// Generated 09-06-2014 12:28:10 PM by Hibernate Tools 3.2.1.GA



/**
 * EventoNegocio generated by hbm2java
 */
public class EventoNegocio  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String descripcion;
     private String accionesNegocio;

    public EventoNegocio() {
    }

    public EventoNegocio(int id, String nombre, String descripcion, String accionesNegocio) {
       this.id = id;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.accionesNegocio = accionesNegocio;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAccionesNegocio() {
        return this.accionesNegocio;
    }
    
    public void setAccionesNegocio(String accionesNegocio) {
        this.accionesNegocio = accionesNegocio;
    }




}

