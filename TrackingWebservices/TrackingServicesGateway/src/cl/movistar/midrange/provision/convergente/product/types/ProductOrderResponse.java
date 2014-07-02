/**
 * ProductOrderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.midrange.provision.convergente.product.types;

public class ProductOrderResponse  implements java.io.Serializable {
    private java.lang.String businessId;

    private java.lang.String processId;

    private java.util.Calendar interactionDate;

    private java.util.Calendar interactionDateComplete;

    private java.lang.String interactionStatus;

    private java.lang.String interactionDescription;

    private cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic;

    public ProductOrderResponse() {
    }

    public ProductOrderResponse(
           java.lang.String businessId,
           java.lang.String processId,
           java.util.Calendar interactionDate,
           java.util.Calendar interactionDateComplete,
           java.lang.String interactionStatus,
           java.lang.String interactionDescription,
           cl.movistar.midrange.provision.convergente.product.types.Characteristic[] characteristic) {
           this.businessId = businessId;
           this.processId = processId;
           this.interactionDate = interactionDate;
           this.interactionDateComplete = interactionDateComplete;
           this.interactionStatus = interactionStatus;
           this.interactionDescription = interactionDescription;
           this.characteristic = characteristic;
    }


    /**
     * Gets the businessId value for this ProductOrderResponse.
     * 
     * @return businessId
     */
    public java.lang.String getBusinessId() {
        return businessId;
    }


    /**
     * Sets the businessId value for this ProductOrderResponse.
     * 
     * @param businessId
     */
    public void setBusinessId(java.lang.String businessId) {
        this.businessId = businessId;
    }


    /**
     * Gets the processId value for this ProductOrderResponse.
     * 
     * @return processId
     */
    public java.lang.String getProcessId() {
        return processId;
    }


    /**
     * Sets the processId value for this ProductOrderResponse.
     * 
     * @param processId
     */
    public void setProcessId(java.lang.String processId) {
        this.processId = processId;
    }


    /**
     * Gets the interactionDate value for this ProductOrderResponse.
     * 
     * @return interactionDate
     */
    public java.util.Calendar getInteractionDate() {
        return interactionDate;
    }


    /**
     * Sets the interactionDate value for this ProductOrderResponse.
     * 
     * @param interactionDate
     */
    public void setInteractionDate(java.util.Calendar interactionDate) {
        this.interactionDate = interactionDate;
    }


    /**
     * Gets the interactionDateComplete value for this ProductOrderResponse.
     * 
     * @return interactionDateComplete
     */
    public java.util.Calendar getInteractionDateComplete() {
        return interactionDateComplete;
    }


    /**
     * Sets the interactionDateComplete value for this ProductOrderResponse.
     * 
     * @param interactionDateComplete
     */
    public void setInteractionDateComplete(java.util.Calendar interactionDateComplete) {
        this.interactionDateComplete = interactionDateComplete;
    }


    /**
     * Gets the interactionStatus value for this ProductOrderResponse.
     * 
     * @return interactionStatus
     */
    public java.lang.String getInteractionStatus() {
        return interactionStatus;
    }


    /**
     * Sets the interactionStatus value for this ProductOrderResponse.
     * 
     * @param interactionStatus
     */
    public void setInteractionStatus(java.lang.String interactionStatus) {
        this.interactionStatus = interactionStatus;
    }


    /**
     * Gets the interactionDescription value for this ProductOrderResponse.
     * 
     * @return interactionDescription
     */
    public java.lang.String getInteractionDescription() {
        return interactionDescription;
    }


    /**
     * Sets the interactionDescription value for this ProductOrderResponse.
     * 
     * @param interactionDescription
     */
    public void setInteractionDescription(java.lang.String interactionDescription) {
        this.interactionDescription = interactionDescription;
    }


    /**
     * Gets the characteristic value for this ProductOrderResponse.
     * 
     * @return characteristic
     */
    public cl.movistar.midrange.provision.convergente.product.types.Characteristic[] getCharacteristic() {
        return characteristic;
    }


    /**
     * Sets the characteristic value for this ProductOrderResponse.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductOrderResponse)) return false;
        ProductOrderResponse other = (ProductOrderResponse) obj;
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
            ((this.processId==null && other.getProcessId()==null) || 
             (this.processId!=null &&
              this.processId.equals(other.getProcessId()))) &&
            ((this.interactionDate==null && other.getInteractionDate()==null) || 
             (this.interactionDate!=null &&
              this.interactionDate.equals(other.getInteractionDate()))) &&
            ((this.interactionDateComplete==null && other.getInteractionDateComplete()==null) || 
             (this.interactionDateComplete!=null &&
              this.interactionDateComplete.equals(other.getInteractionDateComplete()))) &&
            ((this.interactionStatus==null && other.getInteractionStatus()==null) || 
             (this.interactionStatus!=null &&
              this.interactionStatus.equals(other.getInteractionStatus()))) &&
            ((this.interactionDescription==null && other.getInteractionDescription()==null) || 
             (this.interactionDescription!=null &&
              this.interactionDescription.equals(other.getInteractionDescription()))) &&
            ((this.characteristic==null && other.getCharacteristic()==null) || 
             (this.characteristic!=null &&
              java.util.Arrays.equals(this.characteristic, other.getCharacteristic())));
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
        if (getProcessId() != null) {
            _hashCode += getProcessId().hashCode();
        }
        if (getInteractionDate() != null) {
            _hashCode += getInteractionDate().hashCode();
        }
        if (getInteractionDateComplete() != null) {
            _hashCode += getInteractionDateComplete().hashCode();
        }
        if (getInteractionStatus() != null) {
            _hashCode += getInteractionStatus().hashCode();
        }
        if (getInteractionDescription() != null) {
            _hashCode += getInteractionDescription().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductOrderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://types.product.convergente.provision.midrange.movistar.cl/", "productOrderResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionDateComplete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionDateComplete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionDescription"));
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
