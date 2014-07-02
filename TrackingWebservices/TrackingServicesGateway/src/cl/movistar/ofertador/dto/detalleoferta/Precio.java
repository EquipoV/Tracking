/**
 * Precio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto.detalleoferta;

public class Precio  implements java.io.Serializable {
    private cl.movistar.ofertador.dto.detalleoferta.Canal[] canales;

    private java.lang.String codigoServicioSuplementario;

    private java.lang.String codigoTasacion;

    private int conceptoFacturacion;

    private java.lang.String descuentoOferta;

    private java.lang.String nombreFacturacion;

    private int precioOferta;

    private java.lang.String tipoMoneda;

    public Precio() {
    }

    public Precio(
           cl.movistar.ofertador.dto.detalleoferta.Canal[] canales,
           java.lang.String codigoServicioSuplementario,
           java.lang.String codigoTasacion,
           int conceptoFacturacion,
           java.lang.String descuentoOferta,
           java.lang.String nombreFacturacion,
           int precioOferta,
           java.lang.String tipoMoneda) {
           this.canales = canales;
           this.codigoServicioSuplementario = codigoServicioSuplementario;
           this.codigoTasacion = codigoTasacion;
           this.conceptoFacturacion = conceptoFacturacion;
           this.descuentoOferta = descuentoOferta;
           this.nombreFacturacion = nombreFacturacion;
           this.precioOferta = precioOferta;
           this.tipoMoneda = tipoMoneda;
    }


    /**
     * Gets the canales value for this Precio.
     * 
     * @return canales
     */
    public cl.movistar.ofertador.dto.detalleoferta.Canal[] getCanales() {
        return canales;
    }


    /**
     * Sets the canales value for this Precio.
     * 
     * @param canales
     */
    public void setCanales(cl.movistar.ofertador.dto.detalleoferta.Canal[] canales) {
        this.canales = canales;
    }


    /**
     * Gets the codigoServicioSuplementario value for this Precio.
     * 
     * @return codigoServicioSuplementario
     */
    public java.lang.String getCodigoServicioSuplementario() {
        return codigoServicioSuplementario;
    }


    /**
     * Sets the codigoServicioSuplementario value for this Precio.
     * 
     * @param codigoServicioSuplementario
     */
    public void setCodigoServicioSuplementario(java.lang.String codigoServicioSuplementario) {
        this.codigoServicioSuplementario = codigoServicioSuplementario;
    }


    /**
     * Gets the codigoTasacion value for this Precio.
     * 
     * @return codigoTasacion
     */
    public java.lang.String getCodigoTasacion() {
        return codigoTasacion;
    }


    /**
     * Sets the codigoTasacion value for this Precio.
     * 
     * @param codigoTasacion
     */
    public void setCodigoTasacion(java.lang.String codigoTasacion) {
        this.codigoTasacion = codigoTasacion;
    }


    /**
     * Gets the conceptoFacturacion value for this Precio.
     * 
     * @return conceptoFacturacion
     */
    public int getConceptoFacturacion() {
        return conceptoFacturacion;
    }


    /**
     * Sets the conceptoFacturacion value for this Precio.
     * 
     * @param conceptoFacturacion
     */
    public void setConceptoFacturacion(int conceptoFacturacion) {
        this.conceptoFacturacion = conceptoFacturacion;
    }


    /**
     * Gets the descuentoOferta value for this Precio.
     * 
     * @return descuentoOferta
     */
    public java.lang.String getDescuentoOferta() {
        return descuentoOferta;
    }


    /**
     * Sets the descuentoOferta value for this Precio.
     * 
     * @param descuentoOferta
     */
    public void setDescuentoOferta(java.lang.String descuentoOferta) {
        this.descuentoOferta = descuentoOferta;
    }


    /**
     * Gets the nombreFacturacion value for this Precio.
     * 
     * @return nombreFacturacion
     */
    public java.lang.String getNombreFacturacion() {
        return nombreFacturacion;
    }


    /**
     * Sets the nombreFacturacion value for this Precio.
     * 
     * @param nombreFacturacion
     */
    public void setNombreFacturacion(java.lang.String nombreFacturacion) {
        this.nombreFacturacion = nombreFacturacion;
    }


    /**
     * Gets the precioOferta value for this Precio.
     * 
     * @return precioOferta
     */
    public int getPrecioOferta() {
        return precioOferta;
    }


    /**
     * Sets the precioOferta value for this Precio.
     * 
     * @param precioOferta
     */
    public void setPrecioOferta(int precioOferta) {
        this.precioOferta = precioOferta;
    }


    /**
     * Gets the tipoMoneda value for this Precio.
     * 
     * @return tipoMoneda
     */
    public java.lang.String getTipoMoneda() {
        return tipoMoneda;
    }


    /**
     * Sets the tipoMoneda value for this Precio.
     * 
     * @param tipoMoneda
     */
    public void setTipoMoneda(java.lang.String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Precio)) return false;
        Precio other = (Precio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.canales==null && other.getCanales()==null) || 
             (this.canales!=null &&
              java.util.Arrays.equals(this.canales, other.getCanales()))) &&
            ((this.codigoServicioSuplementario==null && other.getCodigoServicioSuplementario()==null) || 
             (this.codigoServicioSuplementario!=null &&
              this.codigoServicioSuplementario.equals(other.getCodigoServicioSuplementario()))) &&
            ((this.codigoTasacion==null && other.getCodigoTasacion()==null) || 
             (this.codigoTasacion!=null &&
              this.codigoTasacion.equals(other.getCodigoTasacion()))) &&
            this.conceptoFacturacion == other.getConceptoFacturacion() &&
            ((this.descuentoOferta==null && other.getDescuentoOferta()==null) || 
             (this.descuentoOferta!=null &&
              this.descuentoOferta.equals(other.getDescuentoOferta()))) &&
            ((this.nombreFacturacion==null && other.getNombreFacturacion()==null) || 
             (this.nombreFacturacion!=null &&
              this.nombreFacturacion.equals(other.getNombreFacturacion()))) &&
            this.precioOferta == other.getPrecioOferta() &&
            ((this.tipoMoneda==null && other.getTipoMoneda()==null) || 
             (this.tipoMoneda!=null &&
              this.tipoMoneda.equals(other.getTipoMoneda())));
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
        if (getCanales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCanales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCanales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodigoServicioSuplementario() != null) {
            _hashCode += getCodigoServicioSuplementario().hashCode();
        }
        if (getCodigoTasacion() != null) {
            _hashCode += getCodigoTasacion().hashCode();
        }
        _hashCode += getConceptoFacturacion();
        if (getDescuentoOferta() != null) {
            _hashCode += getDescuentoOferta().hashCode();
        }
        if (getNombreFacturacion() != null) {
            _hashCode += getNombreFacturacion().hashCode();
        }
        _hashCode += getPrecioOferta();
        if (getTipoMoneda() != null) {
            _hashCode += getTipoMoneda().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Precio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Precio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "canales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Canal"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoServicioSuplementario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoServicioSuplementario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTasacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoTasacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptoFacturacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "conceptoFacturacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuentoOferta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "descuentoOferta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFacturacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "nombreFacturacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precioOferta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "precioOferta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoMoneda"));
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
