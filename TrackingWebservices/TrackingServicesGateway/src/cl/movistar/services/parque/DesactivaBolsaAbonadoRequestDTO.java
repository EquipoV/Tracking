/**
 * DesactivaBolsaAbonadoRequestDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.services.parque;

public class DesactivaBolsaAbonadoRequestDTO  implements java.io.Serializable {
    private java.lang.String codServicio;

    private java.lang.String nomUsuario;

    private java.lang.String numAbonado;

    public DesactivaBolsaAbonadoRequestDTO() {
    }

    public DesactivaBolsaAbonadoRequestDTO(
           java.lang.String codServicio,
           java.lang.String nomUsuario,
           java.lang.String numAbonado) {
           this.codServicio = codServicio;
           this.nomUsuario = nomUsuario;
           this.numAbonado = numAbonado;
    }


    /**
     * Gets the codServicio value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @return codServicio
     */
    public java.lang.String getCodServicio() {
        return codServicio;
    }


    /**
     * Sets the codServicio value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @param codServicio
     */
    public void setCodServicio(java.lang.String codServicio) {
        this.codServicio = codServicio;
    }


    /**
     * Gets the nomUsuario value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @return nomUsuario
     */
    public java.lang.String getNomUsuario() {
        return nomUsuario;
    }


    /**
     * Sets the nomUsuario value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @param nomUsuario
     */
    public void setNomUsuario(java.lang.String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }


    /**
     * Gets the numAbonado value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @return numAbonado
     */
    public java.lang.String getNumAbonado() {
        return numAbonado;
    }


    /**
     * Sets the numAbonado value for this DesactivaBolsaAbonadoRequestDTO.
     * 
     * @param numAbonado
     */
    public void setNumAbonado(java.lang.String numAbonado) {
        this.numAbonado = numAbonado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DesactivaBolsaAbonadoRequestDTO)) return false;
        DesactivaBolsaAbonadoRequestDTO other = (DesactivaBolsaAbonadoRequestDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codServicio==null && other.getCodServicio()==null) || 
             (this.codServicio!=null &&
              this.codServicio.equals(other.getCodServicio()))) &&
            ((this.nomUsuario==null && other.getNomUsuario()==null) || 
             (this.nomUsuario!=null &&
              this.nomUsuario.equals(other.getNomUsuario()))) &&
            ((this.numAbonado==null && other.getNumAbonado()==null) || 
             (this.numAbonado!=null &&
              this.numAbonado.equals(other.getNumAbonado())));
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
        if (getCodServicio() != null) {
            _hashCode += getCodServicio().hashCode();
        }
        if (getNomUsuario() != null) {
            _hashCode += getNomUsuario().hashCode();
        }
        if (getNumAbonado() != null) {
            _hashCode += getNumAbonado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DesactivaBolsaAbonadoRequestDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "DesactivaBolsaAbonadoRequestDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "codServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "nomUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numAbonado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "numAbonado"));
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
