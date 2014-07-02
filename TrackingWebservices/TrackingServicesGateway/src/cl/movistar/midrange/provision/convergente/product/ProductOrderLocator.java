/**
 * ProductOrderLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.midrange.provision.convergente.product;

public class ProductOrderLocator extends org.apache.axis.client.Service implements cl.movistar.midrange.provision.convergente.product.ProductOrder {

    public ProductOrderLocator() {
    }


    public ProductOrderLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProductOrderLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProductOrder
    private java.lang.String ProductOrder_address = "http://localhost:8084/MaquetaProvisionador/ProductOrder";

    public java.lang.String getProductOrderAddress() {
        return ProductOrder_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProductOrderWSDDServiceName = "ProductOrder";

    public java.lang.String getProductOrderWSDDServiceName() {
        return ProductOrderWSDDServiceName;
    }

    public void setProductOrderWSDDServiceName(java.lang.String name) {
        ProductOrderWSDDServiceName = name;
    }

    public cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate getProductOrder() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProductOrder_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProductOrder(endpoint);
    }

    public cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate getProductOrder(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.movistar.midrange.provision.convergente.product.ProductOrderPortBindingStub _stub = new cl.movistar.midrange.provision.convergente.product.ProductOrderPortBindingStub(portAddress, this);
            _stub.setPortName(getProductOrderWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProductOrderEndpointAddress(java.lang.String address) {
        ProductOrder_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.movistar.midrange.provision.convergente.product.ProductOrderPortBindingStub _stub = new cl.movistar.midrange.provision.convergente.product.ProductOrderPortBindingStub(new java.net.URL(ProductOrder_address), this);
                _stub.setPortName(getProductOrderWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProductOrder".equals(inputPortName)) {
            return getProductOrder();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://product.convergente.provision.midrange.movistar.cl/", "ProductOrder");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://product.convergente.provision.midrange.movistar.cl/", "ProductOrder"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProductOrder".equals(portName)) {
            setProductOrderEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
