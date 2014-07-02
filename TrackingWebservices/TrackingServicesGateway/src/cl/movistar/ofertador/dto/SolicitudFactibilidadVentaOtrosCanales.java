/**
 * SolicitudFactibilidadVentaOtrosCanales.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto;

public class SolicitudFactibilidadVentaOtrosCanales  implements java.io.Serializable {
    private java.lang.String idRed;

    private int numeroCelular;

    public SolicitudFactibilidadVentaOtrosCanales() {
    }

    public SolicitudFactibilidadVentaOtrosCanales(
           java.lang.String idRed,
           int numeroCelular) {
           this.idRed = idRed;
           this.numeroCelular = numeroCelular;
    }


    /**
     * Gets the idRed value for this SolicitudFactibilidadVentaOtrosCanales.
     * 
     * @return idRed
     */
    public java.lang.String getIdRed() {
        return idRed;
    }


    /**
     * Sets the idRed value for this SolicitudFactibilidadVentaOtrosCanales.
     * 
     * @param idRed
     */
    public void setIdRed(java.lang.String idRed) {
        this.idRed = idRed;
    }


    /**
     * Gets the numeroCelular value for this SolicitudFactibilidadVentaOtrosCanales.
     * 
     * @return numeroCelular
     */
    public int getNumeroCelular() {
        return numeroCelular;
    }


    /**
     * Sets the numeroCelular value for this SolicitudFactibilidadVentaOtrosCanales.
     * 
     * @param numeroCelular
     */
    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitudFactibilidadVentaOtrosCanales)) return false;
        SolicitudFactibilidadVentaOtrosCanales other = (SolicitudFactibilidadVentaOtrosCanales) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idRed==null && other.getIdRed()==null) || 
             (this.idRed!=null &&
              this.idRed.equals(other.getIdRed()))) &&
            this.numeroCelular == other.getNumeroCelular();
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
        if (getIdRed() != null) {
            _hashCode += getIdRed().hashCode();
        }
        _hashCode += getNumeroCelular();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitudFactibilidadVentaOtrosCanales.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudFactibilidadVentaOtrosCanales"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "idRed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCelular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "numeroCelular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
