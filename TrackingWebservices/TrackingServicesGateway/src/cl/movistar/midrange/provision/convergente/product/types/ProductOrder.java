/**
 * ProductOrder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.midrange.provision.convergente.product.types;

public class ProductOrder  implements java.io.Serializable {
    private java.lang.String businessId;

    private cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic;

    private cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem[] productOrdenItem;

    public ProductOrder() {
    }

    public ProductOrder(
           java.lang.String businessId,
           cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic,
           cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem[] productOrdenItem) {
           this.businessId = businessId;
           this.characteristic = characteristic;
           this.productOrdenItem = productOrdenItem;
    }


    /**
     * Gets the businessId value for this ProductOrder.
     * 
     * @return businessId
     */
    public java.lang.String getBusinessId() {
        return businessId;
    }


    /**
     * Sets the businessId value for this ProductOrder.
     * 
     * @param businessId
     */
    public void setBusinessId(java.lang.String businessId) {
        this.businessId = businessId;
    }


    /**
     * Gets the characteristic value for this ProductOrder.
     * 
     * @return characteristic
     */
    public cl.movistar.midrange.provision.convergente.product.types.Characteristic[] getCharacteristic() {
        return characteristic;
    }


    /**
     * Sets the characteristic value for this ProductOrder.
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
     * Gets the productOrdenItem value for this ProductOrder.
     * 
     * @return productOrdenItem
     */
    public cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem[] getProductOrdenItem() {
        return productOrdenItem;
    }


    /**
     * Sets the productOrdenItem value for this ProductOrder.
     * 
     * @param productOrdenItem
     */
    public void setProductOrdenItem(cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem[] productOrdenItem) {
        this.productOrdenItem = productOrdenItem;
    }

    public cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem getProductOrdenItem(int i) {
        return this.productOrdenItem[i];
    }

    public void setProductOrdenItem(int i, cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem _value) {
        this.productOrdenItem[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductOrder)) return false;
        ProductOrder other = (ProductOrder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessId==null && other.getBusinessId()==null) || 
             (this.businessId!=null &&
              this.businessId.equals(other.getBusinessId()))) &&
            ((this.characteristic==null && other.getCharacteristic()==null) || 
             (this.characteristic!=null &&
              java.util.Arrays.equals(this.characteristic, other.getCharacteristic()))) &&
            ((this.productOrdenItem==null && other.getProductOrdenItem()==null) || 
             (this.productOrdenItem!=null &&
              java.util.Arrays.equals(this.productOrdenItem, other.getProductOrdenItem())));
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
        if (getBusinessId() != null) {
            _hashCode += getBusinessId().hashCode();
        }
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
        if (getProductOrdenItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductOrdenItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductOrdenItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductOrder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "productOrder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("characteristic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "characteristic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "characteristic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productOrdenItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productOrdenItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "productOrderItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
