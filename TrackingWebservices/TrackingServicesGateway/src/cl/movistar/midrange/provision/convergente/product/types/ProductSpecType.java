/**
 * ProductSpecType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.midrange.provision.convergente.product.types;

public class ProductSpecType  implements java.io.Serializable {
    private cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic;

    private java.lang.String productDescription;

    private java.lang.String productName;

    private java.lang.String productNumber;

    public ProductSpecType() {
    }

    public ProductSpecType(
           cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic,
           java.lang.String productDescription,
           java.lang.String productName,
           java.lang.String productNumber) {
           this.characteristic = characteristic;
           this.productDescription = productDescription;
           this.productName = productName;
           this.productNumber = productNumber;
    }


    /**
     * Gets the characteristic value for this ProductSpecType.
     * 
     * @return characteristic
     */
    public cl.movistar.midrange.provision.convergente.product.types.Characteristic[] getCharacteristic() {
        return characteristic;
    }


    /**
     * Sets the characteristic value for this ProductSpecType.
     * 
     * @param characteristic
     */
    public void setCharacteristic(cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic) {
        this.characteristic = characteristic;
    }

    public cl.movistar.midrange.provision.convergente.product.types.Characteristic getCharacteristic(int i) {
        return this.characteristic[i];
    }

    public void setCharacteristic(int i, cl.movistar.midrange.provision.convergente.product.types.Characteristic _value) {
        this.characteristic[i] = _value;
    }


    /**
     * Gets the productDescription value for this ProductSpecType.
     * 
     * @return productDescription
     */
    public java.lang.String getProductDescription() {
        return productDescription;
    }


    /**
     * Sets the productDescription value for this ProductSpecType.
     * 
     * @param productDescription
     */
    public void setProductDescription(java.lang.String productDescription) {
        this.productDescription = productDescription;
    }


    /**
     * Gets the productName value for this ProductSpecType.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this ProductSpecType.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the productNumber value for this ProductSpecType.
     * 
     * @return productNumber
     */
    public java.lang.String getProductNumber() {
        return productNumber;
    }


    /**
     * Sets the productNumber value for this ProductSpecType.
     * 
     * @param productNumber
     */
    public void setProductNumber(java.lang.String productNumber) {
        this.productNumber = productNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductSpecType)) return false;
        ProductSpecType other = (ProductSpecType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.characteristic==null && other.getCharacteristic()==null) || 
             (this.characteristic!=null &&
              java.util.Arrays.equals(this.characteristic, other.getCharacteristic()))) &&
            ((this.productDescription==null && other.getProductDescription()==null) || 
             (this.productDescription!=null &&
              this.productDescription.equals(other.getProductDescription()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.productNumber==null && other.getProductNumber()==null) || 
             (this.productNumber!=null &&
              this.productNumber.equals(other.getProductNumber())));
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
        if (getCharacteristic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCharacteristic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCharacteristic(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProductDescription() != null) {
            _hashCode += getProductDescription().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getProductNumber() != null) {
            _hashCode += getProductNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductSpecType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "productSpecType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("characteristic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "characteristic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "characteristic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
