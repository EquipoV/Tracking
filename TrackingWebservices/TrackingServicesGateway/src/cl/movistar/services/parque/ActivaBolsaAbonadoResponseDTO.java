/**
 * ActivaBolsaAbonadoResponseDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.services.parque;

public class ActivaBolsaAbonadoResponseDTO  implements java.io.Serializable {
    private java.lang.String codigoRetorno;

    private java.lang.String descripcionRetorno;

    private java.lang.String numeroEvento;

    public ActivaBolsaAbonadoResponseDTO() {
    }

    public ActivaBolsaAbonadoResponseDTO(
           java.lang.String codigoRetorno,
           java.lang.String descripcionRetorno,
           java.lang.String numeroEvento) {
           this.codigoRetorno = codigoRetorno;
           this.descripcionRetorno = descripcionRetorno;
           this.numeroEvento = numeroEvento;
    }


    /**
     * Gets the codigoRetorno value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @return codigoRetorno
     */
    public java.lang.String getCodigoRetorno() {
        return codigoRetorno;
    }


    /**
     * Sets the codigoRetorno value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @param codigoRetorno
     */
    public void setCodigoRetorno(java.lang.String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }


    /**
     * Gets the descripcionRetorno value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @return descripcionRetorno
     */
    public java.lang.String getDescripcionRetorno() {
        return descripcionRetorno;
    }


    /**
     * Sets the descripcionRetorno value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @param descripcionRetorno
     */
    public void setDescripcionRetorno(java.lang.String descripcionRetorno) {
        this.descripcionRetorno = descripcionRetorno;
    }


    /**
     * Gets the numeroEvento value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @return numeroEvento
     */
    public java.lang.String getNumeroEvento() {
        return numeroEvento;
    }


    /**
     * Sets the numeroEvento value for this ActivaBolsaAbonadoResponseDTO.
     * 
     * @param numeroEvento
     */
    public void setNumeroEvento(java.lang.String numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActivaBolsaAbonadoResponseDTO)) return false;
        ActivaBolsaAbonadoResponseDTO other = (ActivaBolsaAbonadoResponseDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoRetorno==null && other.getCodigoRetorno()==null) || 
             (this.codigoRetorno!=null &&
              this.codigoRetorno.equals(other.getCodigoRetorno()))) &&
            ((this.descripcionRetorno==null && other.getDescripcionRetorno()==null) || 
             (this.descripcionRetorno!=null &&
              this.descripcionRetorno.equals(other.getDescripcionRetorno()))) &&
            ((this.numeroEvento==null && other.getNumeroEvento()==null) || 
             (this.numeroEvento!=null &&
              this.numeroEvento.equals(other.getNumeroEvento())));
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
        if (getCodigoRetorno() != null) {
            _hashCode += getCodigoRetorno().hashCode();
        }
        if (getDescripcionRetorno() != null) {
            _hashCode += getDescripcionRetorno().hashCode();
        }
        if (getNumeroEvento() != null) {
            _hashCode += getNumeroEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ActivaBolsaAbonadoResponseDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "ActivaBolsaAbonadoResponseDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "codigoRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "descripcionRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "numeroEvento"));
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
