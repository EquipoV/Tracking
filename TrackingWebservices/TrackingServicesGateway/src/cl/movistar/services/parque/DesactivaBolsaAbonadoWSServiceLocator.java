/**
 * DesactivaBolsaAbonadoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.services.parque;

public class DesactivaBolsaAbonadoWSServiceLocator extends org.apache.axis.client.Service implements cl.movistar.services.parque.DesactivaBolsaAbonadoWSService {

    public DesactivaBolsaAbonadoWSServiceLocator() {
    }


    public DesactivaBolsaAbonadoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DesactivaBolsaAbonadoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DesactivaBolsaAbonadoWS
    private java.lang.String DesactivaBolsaAbonadoWS_address = "http://localhost:8084/MaquetaParqueBaja/DesactivaBolsaAbonadoWSService";

    public java.lang.String getDesactivaBolsaAbonadoWSAddress() {
        return DesactivaBolsaAbonadoWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DesactivaBolsaAbonadoWSWSDDServiceName = "DesactivaBolsaAbonadoWS";

    public java.lang.String getDesactivaBolsaAbonadoWSWSDDServiceName() {
        return DesactivaBolsaAbonadoWSWSDDServiceName;
    }

    public void setDesactivaBolsaAbonadoWSWSDDServiceName(java.lang.String name) {
        DesactivaBolsaAbonadoWSWSDDServiceName = name;
    }

    public cl.movistar.services.parque.DesactivaBolsaAbonadoWS getDesactivaBolsaAbonadoWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DesactivaBolsaAbonadoWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDesactivaBolsaAbonadoWS(endpoint);
    }

    public cl.movistar.services.parque.DesactivaBolsaAbonadoWS getDesactivaBolsaAbonadoWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.movistar.services.parque.DesactivaBolsaAbonadoWSSoapBindingStub _stub = new cl.movistar.services.parque.DesactivaBolsaAbonadoWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getDesactivaBolsaAbonadoWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDesactivaBolsaAbonadoWSEndpointAddress(java.lang.String address) {
        DesactivaBolsaAbonadoWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.movistar.services.parque.DesactivaBolsaAbonadoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.movistar.services.parque.DesactivaBolsaAbonadoWSSoapBindingStub _stub = new cl.movistar.services.parque.DesactivaBolsaAbonadoWSSoapBindingStub(new java.net.URL(DesactivaBolsaAbonadoWS_address), this);
                _stub.setPortName(getDesactivaBolsaAbonadoWSWSDDServiceName());
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
        if ("DesactivaBolsaAbonadoWS".equals(inputPortName)) {
            return getDesactivaBolsaAbonadoWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.services.telefonica.com", "DesactivaBolsaAbonadoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.services.telefonica.com", "DesactivaBolsaAbonadoWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DesactivaBolsaAbonadoWS".equals(portName)) {
            setDesactivaBolsaAbonadoWSEndpointAddress(address);
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
