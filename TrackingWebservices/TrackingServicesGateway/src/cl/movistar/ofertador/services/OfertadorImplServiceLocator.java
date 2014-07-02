/**
 * OfertadorImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.services;

public class OfertadorImplServiceLocator extends org.apache.axis.client.Service implements cl.movistar.ofertador.services.OfertadorImplService {

    public OfertadorImplServiceLocator() {
    }


    public OfertadorImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OfertadorImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OfertadorImpl
    private java.lang.String OfertadorImpl_address = "http://localhost:8080/Ofertador/services/OfertadorImpl";

    public java.lang.String getOfertadorImplAddress() {
        return OfertadorImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OfertadorImplWSDDServiceName = "OfertadorImpl";

    public java.lang.String getOfertadorImplWSDDServiceName() {
        return OfertadorImplWSDDServiceName;
    }

    public void setOfertadorImplWSDDServiceName(java.lang.String name) {
        OfertadorImplWSDDServiceName = name;
    }

    public cl.movistar.ofertador.services.OfertadorImpl getOfertadorImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OfertadorImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOfertadorImpl(endpoint);
    }

    public cl.movistar.ofertador.services.OfertadorImpl getOfertadorImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.movistar.ofertador.services.OfertadorImplSoapBindingStub _stub = new cl.movistar.ofertador.services.OfertadorImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getOfertadorImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOfertadorImplEndpointAddress(java.lang.String address) {
        OfertadorImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.movistar.ofertador.services.OfertadorImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.movistar.ofertador.services.OfertadorImplSoapBindingStub _stub = new cl.movistar.ofertador.services.OfertadorImplSoapBindingStub(new java.net.URL(OfertadorImpl_address), this);
                _stub.setPortName(getOfertadorImplWSDDServiceName());
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
        if ("OfertadorImpl".equals(inputPortName)) {
            return getOfertadorImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "OfertadorImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "OfertadorImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OfertadorImpl".equals(portName)) {
            setOfertadorImplEndpointAddress(address);
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
