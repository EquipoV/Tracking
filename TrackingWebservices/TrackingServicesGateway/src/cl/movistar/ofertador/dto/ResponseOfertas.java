/**
 * ResponseOfertas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto;

public class ResponseOfertas  implements java.io.Serializable {
    private cl.movistar.ofertador.dto.Oferta[] ofertas;

    private cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio;

    public ResponseOfertas() {
    }

    public ResponseOfertas(
           cl.movistar.ofertador.dto.Oferta[] ofertas,
           cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio) {
           this.ofertas = ofertas;
           this.respuestaServicio = respuestaServicio;
    }


    /**
     * Gets the ofertas value for this ResponseOfertas.
     * 
     * @return ofertas
     */
    public cl.movistar.ofertador.dto.Oferta[] getOfertas() {
        return ofertas;
    }


    /**
     * Sets the ofertas value for this ResponseOfertas.
     * 
     * @param ofertas
     */
    public void setOfertas(cl.movistar.ofertador.dto.Oferta[] ofertas) {
        this.ofertas = ofertas;
    }


    /**
     * Gets the respuestaServicio value for this ResponseOfertas.
     * 
     * @return respuestaServicio
     */
    public cl.movistar.ofertador.dto.RespuestaServicio getRespuestaServicio() {
        return respuestaServicio;
    }


    /**
     * Sets the respuestaServicio value for this ResponseOfertas.
     * 
     * @param respuestaServicio
     */
    public void setRespuestaServicio(cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseOfertas)) return false;
        ResponseOfertas other = (ResponseOfertas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ofertas==null && other.getOfertas()==null) || 
             (this.ofertas!=null &&
              java.util.Arrays.equals(this.ofertas, other.getOfertas()))) &&
            ((this.respuestaServicio==null && other.getRespuestaServicio()==null) || 
             (this.respuestaServicio!=null &&
              this.respuestaServicio.equals(other.getRespuestaServicio())));
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
        if (getOfertas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOfertas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOfertas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRespuestaServicio() != null) {
            _hashCode += getRespuestaServicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseOfertas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseOfertas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ofertas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ofertas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Oferta"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "respuestaServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "RespuestaServicio"));
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
