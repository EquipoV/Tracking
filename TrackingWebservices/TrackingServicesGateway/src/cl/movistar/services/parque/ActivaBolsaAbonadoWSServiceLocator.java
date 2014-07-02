/**
 * ActivaBolsaAbonadoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.services.parque;

public class ActivaBolsaAbonadoWSServiceLocator extends org.apache.axis.client.Service implements cl.movistar.services.parque.ActivaBolsaAbonadoWSService {

    public ActivaBolsaAbonadoWSServiceLocator() {
    }


    public ActivaBolsaAbonadoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ActivaBolsaAbonadoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ActivaBolsaAbonadoWS
    private java.lang.String ActivaBolsaAbonadoWS_address = "http://localhost:8084/MaquetaParqueAlta/ActivaBolsaAbonadoWSService";

    public java.lang.String getActivaBolsaAbonadoWSAddress() {
        return ActivaBolsaAbonadoWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ActivaBolsaAbonadoWSWSDDServiceName = "ActivaBolsaAbonadoWS";

    public java.lang.String getActivaBolsaAbonadoWSWSDDServiceName() {
        return ActivaBolsaAbonadoWSWSDDServiceName;
    }

    public void setActivaBolsaAbonadoWSWSDDServiceName(java.lang.String name) {
        ActivaBolsaAbonadoWSWSDDServiceName = name;
    }

    public cl.movistar.services.parque.ActivaBolsaAbonadoWS getActivaBolsaAbonadoWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ActivaBolsaAbonadoWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getActivaBolsaAbonadoWS(endpoint);
    }

    public cl.movistar.services.parque.ActivaBolsaAbonadoWS getActivaBolsaAbonadoWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.movistar.services.parque.ActivaBolsaAbonadoWSSoapBindingStub _stub = new cl.movistar.services.parque.ActivaBolsaAbonadoWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getActivaBolsaAbonadoWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setActivaBolsaAbonadoWSEndpointAddress(java.lang.String address) {
        ActivaBolsaAbonadoWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.movistar.services.parque.ActivaBolsaAbonadoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.movistar.services.parque.ActivaBolsaAbonadoWSSoapBindingStub _stub = new cl.movistar.services.parque.ActivaBolsaAbonadoWSSoapBindingStub(new java.net.URL(ActivaBolsaAbonadoWS_address), this);
                _stub.setPortName(getActivaBolsaAbonadoWSWSDDServiceName());
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
        if ("ActivaBolsaAbonadoWS".equals(inputPortName)) {
            return getActivaBolsaAbonadoWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.services.telefonica.com", "ActivaBolsaAbonadoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "ActivaBolsaAbonadoWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ActivaBolsaAbonadoWS".equals(portName)) {
            setActivaBolsaAbonadoWSEndpointAddress(address);
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
