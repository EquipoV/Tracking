/**
 * CaracteristicaProducto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto.detalleoferta;

public class CaracteristicaProducto  implements java.io.Serializable {
    private java.lang.String codigoCaracteristicaProducto;

    private java.lang.String descripcion;

    private java.lang.String nombre;

    private java.lang.String tecnologia;

    private java.lang.String tipoUnidad;

    private java.lang.String unidad;

    private java.lang.String valocidadMaxima;

    private java.lang.String velocidadReducida;

    public CaracteristicaProducto() {
    }

    public CaracteristicaProducto(
           java.lang.String codigoCaracteristicaProducto,
           java.lang.String descripcion,
           java.lang.String nombre,
           java.lang.String tecnologia,
           java.lang.String tipoUnidad,
           java.lang.String unidad,
           java.lang.String valocidadMaxima,
           java.lang.String velocidadReducida) {
           this.codigoCaracteristicaProducto = codigoCaracteristicaProducto;
           this.descripcion = descripcion;
           this.nombre = nombre;
           this.tecnologia = tecnologia;
           this.tipoUnidad = tipoUnidad;
           this.unidad = unidad;
           this.valocidadMaxima = valocidadMaxima;
           this.velocidadReducida = velocidadReducida;
    }


    /**
     * Gets the codigoCaracteristicaProducto value for this CaracteristicaProducto.
     * 
     * @return codigoCaracteristicaProducto
     */
    public java.lang.String getCodigoCaracteristicaProducto() {
        return codigoCaracteristicaProducto;
    }


    /**
     * Sets the codigoCaracteristicaProducto value for this CaracteristicaProducto.
     * 
     * @param codigoCaracteristicaProducto
     */
    public void setCodigoCaracteristicaProducto(java.lang.String codigoCaracteristicaProducto) {
        this.codigoCaracteristicaProducto = codigoCaracteristicaProducto;
    }


    /**
     * Gets the descripcion value for this CaracteristicaProducto.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this CaracteristicaProducto.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the nombre value for this CaracteristicaProducto.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this CaracteristicaProducto.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the tecnologia value for this CaracteristicaProducto.
     * 
     * @return tecnologia
     */
    public java.lang.String getTecnologia() {
        return tecnologia;
    }


    /**
     * Sets the tecnologia value for this CaracteristicaProducto.
     * 
     * @param tecnologia
     */
    public void setTecnologia(java.lang.String tecnologia) {
        this.tecnologia = tecnologia;
    }


    /**
     * Gets the tipoUnidad value for this CaracteristicaProducto.
     * 
     * @return tipoUnidad
     */
    public java.lang.String getTipoUnidad() {
        return tipoUnidad;
    }


    /**
     * Sets the tipoUnidad value for this CaracteristicaProducto.
     * 
     * @param tipoUnidad
     */
    public void setTipoUnidad(java.lang.String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }


    /**
     * Gets the unidad value for this CaracteristicaProducto.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this CaracteristicaProducto.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valocidadMaxima value for this CaracteristicaProducto.
     * 
     * @return valocidadMaxima
     */
    public java.lang.String getValocidadMaxima() {
        return valocidadMaxima;
    }


    /**
     * Sets the valocidadMaxima value for this CaracteristicaProducto.
     * 
     * @param valocidadMaxima
     */
    public void setValocidadMaxima(java.lang.String valocidadMaxima) {
        this.valocidadMaxima = valocidadMaxima;
    }


    /**
     * Gets the velocidadReducida value for this CaracteristicaProducto.
     * 
     * @return velocidadReducida
     */
    public java.lang.String getVelocidadReducida() {
        return velocidadReducida;
    }


    /**
     * Sets the velocidadReducida value for this CaracteristicaProducto.
     * 
     * @param velocidadReducida
     */
    public void setVelocidadReducida(java.lang.String velocidadReducida) {
        this.velocidadReducida = velocidadReducida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaracteristicaProducto)) return false;
        CaracteristicaProducto other = (CaracteristicaProducto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoCaracteristicaProducto==null && other.getCodigoCaracteristicaProducto()==null) || 
             (this.codigoCaracteristicaProducto!=null &&
              this.codigoCaracteristicaProducto.equals(other.getCodigoCaracteristicaProducto()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.tecnologia==null && other.getTecnologia()==null) || 
             (this.tecnologia!=null &&
              this.tecnologia.equals(other.getTecnologia()))) &&
            ((this.tipoUnidad==null && other.getTipoUnidad()==null) || 
             (this.tipoUnidad!=null &&
              this.tipoUnidad.equals(other.getTipoUnidad()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valocidadMaxima==null && other.getValocidadMaxima()==null) || 
             (this.valocidadMaxima!=null &&
              this.valocidadMaxima.equals(other.getValocidadMaxima()))) &&
            ((this.velocidadReducida==null && other.getVelocidadReducida()==null) || 
             (this.velocidadReducida!=null &&
              this.velocidadReducida.equals(other.getVelocidadReducida())));
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
        if (getCodigoCaracteristicaProducto() != null) {
            _hashCode += getCodigoCaracteristicaProducto().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getTecnologia() != null) {
            _hashCode += getTecnologia().hashCode();
        }
        if (getTipoUnidad() != null) {
            _hashCode += getTipoUnidad().hashCode();
        }
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        if (getValocidadMaxima() != null) {
            _hashCode += getValocidadMaxima().hashCode();
        }
        if (getVelocidadReducida() != null) {
            _hashCode += getVelocidadReducida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaracteristicaProducto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "CaracteristicaProducto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoCaracteristicaProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoCaracteristicaProducto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tecnologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tecnologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoUnidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoUnidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valocidadMaxima");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "valocidadMaxima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("velocidadReducida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "velocidadReducida"));
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
