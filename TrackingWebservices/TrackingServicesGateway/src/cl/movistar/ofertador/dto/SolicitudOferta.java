/**
 * SolicitudOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto;

public class SolicitudOferta  implements java.io.Serializable {
    private java.lang.String canal;

    private java.lang.String familia;

    private int numeroCelular;

    private java.lang.String visualizacion;

    public SolicitudOferta() {
    }

    public SolicitudOferta(
           java.lang.String canal,
           java.lang.String familia,
           int numeroCelular,
           java.lang.String visualizacion) {
           this.canal = canal;
           this.familia = familia;
           this.numeroCelular = numeroCelular;
           this.visualizacion = visualizacion;
    }


    /**
     * Gets the canal value for this SolicitudOferta.
     * 
     * @return canal
     */
    public java.lang.String getCanal() {
        return canal;
    }


    /**
     * Sets the canal value for this SolicitudOferta.
     * 
     * @param canal
     */
    public void setCanal(java.lang.String canal) {
        this.canal = canal;
    }


    /**
     * Gets the familia value for this SolicitudOferta.
     * 
     * @return familia
     */
    public java.lang.String getFamilia() {
        return familia;
    }


    /**
     * Sets the familia value for this SolicitudOferta.
     * 
     * @param familia
     */
    public void setFamilia(java.lang.String familia) {
        this.familia = familia;
    }


    /**
     * Gets the numeroCelular value for this SolicitudOferta.
     * 
     * @return numeroCelular
     */
    public int getNumeroCelular() {
        return numeroCelular;
    }


    /**
     * Sets the numeroCelular value for this SolicitudOferta.
     * 
     * @param numeroCelular
     */
    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }


    /**
     * Gets the visualizacion value for this SolicitudOferta.
     * 
     * @return visualizacion
     */
    public java.lang.String getVisualizacion() {
        return visualizacion;
    }


    /**
     * Sets the visualizacion value for this SolicitudOferta.
     * 
     * @param visualizacion
     */
    public void setVisualizacion(java.lang.String visualizacion) {
        this.visualizacion = visualizacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitudOferta)) return false;
        SolicitudOferta other = (SolicitudOferta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.canal==null && other.getCanal()==null) || 
             (this.canal!=null &&
              this.canal.equals(other.getCanal()))) &&
            ((this.familia==null && other.getFamilia()==null) || 
             (this.familia!=null &&
              this.familia.equals(other.getFamilia()))) &&
            this.numeroCelular == other.getNumeroCelular() &&
            ((this.visualizacion==null && other.getVisualizacion()==null) || 
             (this.visualizacion!=null &&
              this.visualizacion.equals(other.getVisualizacion())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCanal() != null) {
            _hashCode += getCanal().hashCode();
        }
        if (getFamilia() != null) {
            _hashCode += getFamilia().hashCode();
        }
        _hashCode += getNumeroCelular();
        if (getVisualizacion() != null) {
            _hashCode += getVisualizacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitudOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "canal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "familia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCelular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "numeroCelular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visualizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "visualizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
