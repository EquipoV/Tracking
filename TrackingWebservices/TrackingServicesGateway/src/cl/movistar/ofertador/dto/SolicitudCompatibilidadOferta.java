/**
 * SolicitudCompatibilidadOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto;

public class SolicitudCompatibilidadOferta  implements java.io.Serializable {
    private java.lang.String familiaridadOferta1;

    private java.lang.String familiaridadOferta2;

    public SolicitudCompatibilidadOferta() {
    }

    public SolicitudCompatibilidadOferta(
           java.lang.String familiaridadOferta1,
           java.lang.String familiaridadOferta2) {
           this.familiaridadOferta1 = familiaridadOferta1;
           this.familiaridadOferta2 = familiaridadOferta2;
    }


    /**
     * Gets the familiaridadOferta1 value for this SolicitudCompatibilidadOferta.
     * 
     * @return familiaridadOferta1
     */
    public java.lang.String getFamiliaridadOferta1() {
        return familiaridadOferta1;
    }


    /**
     * Sets the familiaridadOferta1 value for this SolicitudCompatibilidadOferta.
     * 
     * @param familiaridadOferta1
     */
    public void setFamiliaridadOferta1(java.lang.String familiaridadOferta1) {
        this.familiaridadOferta1 = familiaridadOferta1;
    }


    /**
     * Gets the familiaridadOferta2 value for this SolicitudCompatibilidadOferta.
     * 
     * @return familiaridadOferta2
     */
    public java.lang.String getFamiliaridadOferta2() {
        return familiaridadOferta2;
    }


    /**
     * Sets the familiaridadOferta2 value for this SolicitudCompatibilidadOferta.
     * 
     * @param familiaridadOferta2
     */
    public void setFamiliaridadOferta2(java.lang.String familiaridadOferta2) {
        this.familiaridadOferta2 = familiaridadOferta2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitudCompatibilidadOferta)) return false;
        SolicitudCompatibilidadOferta other = (SolicitudCompatibilidadOferta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.familiaridadOferta1==null && other.getFamiliaridadOferta1()==null) || 
             (this.familiaridadOferta1!=null &&
              this.familiaridadOferta1.equals(other.getFamiliaridadOferta1()))) &&
            ((this.familiaridadOferta2==null && other.getFamiliaridadOferta2()==null) || 
             (this.familiaridadOferta2!=null &&
              this.familiaridadOferta2.equals(other.getFamiliaridadOferta2())));
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
        if (getFamiliaridadOferta1() != null) {
            _hashCode += getFamiliaridadOferta1().hashCode();
        }
        if (getFamiliaridadOferta2() != null) {
            _hashCode += getFamiliaridadOferta2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitudCompatibilidadOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudCompatibilidadOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familiaridadOferta1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "familiaridadOferta1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familiaridadOferta2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "familiaridadOferta2"));
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
