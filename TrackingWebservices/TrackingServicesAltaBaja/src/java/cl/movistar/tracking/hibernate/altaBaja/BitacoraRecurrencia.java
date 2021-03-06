package cl.movistar.tracking.hibernate.altaBaja;
// Generated 23-06-2014 06:04:59 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * BitacoraRecurrencia generated by hbm2java
 */
public class BitacoraRecurrencia  implements java.io.Serializable {


     private int id;
     private Date fechaInicio;
     private Date fechaFin;
     private int idTracking;
     private String idBolsa;
     private String nombreBolsa;

    public BitacoraRecurrencia() {
    }

	
    public BitacoraRecurrencia(int id, Date fechaInicio, int idTracking, String idBolsa, String nombreBolsa) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.idTracking = idTracking;
        this.idBolsa = idBolsa;
        this.nombreBolsa = nombreBolsa;
    }
    public BitacoraRecurrencia(int id, Date fechaInicio, Date fechaFin, int idTracking, String idBolsa, String nombreBolsa) {
       this.id = id;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.idTracking = idTracking;
       this.idBolsa = idBolsa;
       this.nombreBolsa = nombreBolsa;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getIdTracking() {
        return this.idTracking;
    }
    
    public void setIdTracking(int idTracking) {
        this.idTracking = idTracking;
    }
    public String getIdBolsa() {
        return this.idBolsa;
    }
    
    public void setIdBolsa(String idBolsa) {
        this.idBolsa = idBolsa;
    }
    public String getNombreBolsa() {
        return this.nombreBolsa;
    }
    
    public void setNombreBolsa(String nombreBolsa) {
        this.nombreBolsa = nombreBolsa;
    }




}


