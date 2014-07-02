/**
 * ResponseDetalleOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto;

public class ResponseDetalleOferta  implements java.io.Serializable {
    private cl.movistar.ofertador.dto.detalleoferta.DetalleOferta detalleOferta;

    private cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio;

    public ResponseDetalleOferta() {
    }

    public ResponseDetalleOferta(
           cl.movistar.ofertador.dto.detalleoferta.DetalleOferta detalleOferta,
           cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio) {
           this.detalleOferta = detalleOferta;
           this.respuestaServicio = respuestaServicio;
    }


    /**
     * Gets the detalleOferta value for this ResponseDetalleOferta.
     * 
     * @return detalleOferta
     */
    public cl.movistar.ofertador.dto.detalleoferta.DetalleOferta getDetalleOferta() {
        return detalleOferta;
    }


    /**
     * Sets the detalleOferta value for this ResponseDetalleOferta.
     * 
     * @param detalleOferta
     */
    public void setDetalleOferta(cl.movistar.ofertador.dto.detalleoferta.DetalleOferta detalleOferta) {
        this.detalleOferta = detalleOferta;
    }


    /**
     * Gets the respuestaServicio value for this ResponseDetalleOferta.
     * 
     * @return respuestaServicio
     */
    public cl.movistar.ofertador.dto.RespuestaServicio getRespuestaServicio() {
        return respuestaServicio;
    }


    /**
     * Sets the respuestaServicio value for this ResponseDetalleOferta.
     * 
     * @param respuestaServicio
     */
    public void setRespuestaServicio(cl.movistar.ofertador.dto.RespuestaServicio respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseDetalleOferta)) return false;
        ResponseDetalleOferta other = (ResponseDetalleOferta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.detalleOferta==null && other.getDetalleOferta()==null) || 
             (this.detalleOferta!=null &&
              this.detalleOferta.equals(other.getDetalleOferta()))) &&
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
        if (getDetalleOferta() != null) {
            _hashCode += getDetalleOferta().hashCode();
        }
        if (getRespuestaServicio() != null) {
            _hashCode += getRespuestaServicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseDetalleOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseDetalleOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detalleOferta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "detalleOferta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "DetalleOferta"));
        elemField.setNillable(true);
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
