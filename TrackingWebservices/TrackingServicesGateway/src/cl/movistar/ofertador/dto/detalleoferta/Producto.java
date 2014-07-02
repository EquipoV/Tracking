/**
 * Producto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto.detalleoferta;

public class Producto  implements java.io.Serializable {
    private cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto[] caracteristicasProducto;

    private java.lang.String codigoProducto;

    private java.lang.String estado;

    private java.lang.String nombre;

    public Producto() {
    }

    public Producto(
           cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto[] caracteristicasProducto,
           java.lang.String codigoProducto,
           java.lang.String estado,
           java.lang.String nombre) {
           this.caracteristicasProducto = caracteristicasProducto;
           this.codigoProducto = codigoProducto;
           this.estado = estado;
           this.nombre = nombre;
    }


    /**
     * Gets the caracteristicasProducto value for this Producto.
     * 
     * @return caracteristicasProducto
     */
    public cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto[] getCaracteristicasProducto() {
        return caracteristicasProducto;
    }


    /**
     * Sets the caracteristicasProducto value for this Producto.
     * 
     * @param caracteristicasProducto
     */
    public void setCaracteristicasProducto(cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto[] caracteristicasProducto) {
        this.caracteristicasProducto = caracteristicasProducto;
    }


    /**
     * Gets the codigoProducto value for this Producto.
     * 
     * @return codigoProducto
     */
    public java.lang.String getCodigoProducto() {
        return codigoProducto;
    }


    /**
     * Sets the codigoProducto value for this Producto.
     * 
     * @param codigoProducto
     */
    public void setCodigoProducto(java.lang.String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }


    /**
     * Gets the estado value for this Producto.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this Producto.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the nombre value for this Producto.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Producto.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Producto)) return false;
        Producto other = (Producto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caracteristicasProducto==null && other.getCaracteristicasProducto()==null) || 
             (this.caracteristicasProducto!=null &&
              java.util.Arrays.equals(this.caracteristicasProducto, other.getCaracteristicasProducto()))) &&
            ((this.codigoProducto==null && other.getCodigoProducto()==null) || 
             (this.codigoProducto!=null &&
              this.codigoProducto.equals(other.getCodigoProducto()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre())));
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
        if (getCaracteristicasProducto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCaracteristicasProducto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCaracteristicasProducto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodigoProducto() != null) {
            _hashCode += getCodigoProducto().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Producto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Producto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caracteristicasProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "caracteristicasProducto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "CaracteristicaProducto"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoProducto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "nombre"));
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
