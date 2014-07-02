/**
 * OfertadorImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.services;

public class OfertadorImplSoapBindingStub extends org.apache.axis.client.Stub implements cl.movistar.ofertador.services.OfertadorImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("validarCompatibilidadEntreOfertas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "solicitudCompatibilidadOferta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudCompatibilidadOferta"), cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Response"));
        oper.setReturnClass(cl.movistar.ofertador.dto.Response.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "validarCompatibilidadEntreOfertasReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("validarFactibilidadVentaOtrosCanales");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "solicitudFactibilidadVentaOtrosCanales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudFactibilidadVentaOtrosCanales"), cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Response"));
        oper.setReturnClass(cl.movistar.ofertador.dto.Response.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "validarFactibilidadVentaOtrosCanalesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerOfertas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "solicitudOferta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudOferta"), cl.movistar.ofertador.dto.SolicitudOferta.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseOfertas"));
        oper.setReturnClass(cl.movistar.ofertador.dto.ResponseOfertas.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "obtenerOfertasReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerDetalleOferta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "codigoOferta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseDetalleOferta"));
        oper.setReturnClass(cl.movistar.ofertador.dto.ResponseDetalleOferta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "obtenerDetalleOfertaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public OfertadorImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public OfertadorImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public OfertadorImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Canal");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Canal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "CaracteristicaProducto");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "DetalleOferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.DetalleOferta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Precio");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Precio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Producto");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Producto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "SegmentoMercado");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Oferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.Oferta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Response");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseDetalleOferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.ResponseDetalleOferta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "ResponseOfertas");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.ResponseOfertas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "RespuestaServicio");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.RespuestaServicio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudCompatibilidadOferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudFactibilidadVentaOtrosCanales");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "SolicitudOferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.SolicitudOferta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns1_Oferta");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.Oferta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.ofertador.movistar.cl", "Oferta");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns2_Canal");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Canal[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Canal");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns2_CaracteristicaProducto");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.CaracteristicaProducto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "CaracteristicaProducto");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns2_Precio");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Precio[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Precio");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns2_Producto");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.Producto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Producto");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "ArrayOf_tns2_SegmentoMercado");
            cachedSerQNames.add(qName);
            cls = cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "SegmentoMercado");
            qName2 = new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cl.movistar.ofertador.dto.Response validarCompatibilidadEntreOfertas(cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta solicitudCompatibilidadOferta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "validarCompatibilidadEntreOfertas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {solicitudCompatibilidadOferta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.movistar.ofertador.dto.Response) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.movistar.ofertador.dto.Response) org.apache.axis.utils.JavaUtils.convert(_resp, cl.movistar.ofertador.dto.Response.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.movistar.ofertador.dto.Response validarFactibilidadVentaOtrosCanales(cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales solicitudFactibilidadVentaOtrosCanales) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "validarFactibilidadVentaOtrosCanales"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {solicitudFactibilidadVentaOtrosCanales});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.movistar.ofertador.dto.Response) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.movistar.ofertador.dto.Response) org.apache.axis.utils.JavaUtils.convert(_resp, cl.movistar.ofertador.dto.Response.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.movistar.ofertador.dto.ResponseOfertas obtenerOfertas(cl.movistar.ofertador.dto.SolicitudOferta solicitudOferta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "obtenerOfertas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {solicitudOferta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.movistar.ofertador.dto.ResponseOfertas) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.movistar.ofertador.dto.ResponseOfertas) org.apache.axis.utils.JavaUtils.convert(_resp, cl.movistar.ofertador.dto.ResponseOfertas.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.movistar.ofertador.dto.ResponseDetalleOferta obtenerDetalleOferta(java.lang.String codigoOferta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "obtenerDetalleOferta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoOferta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.movistar.ofertador.dto.ResponseDetalleOferta) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.movistar.ofertador.dto.ResponseDetalleOferta) org.apache.axis.utils.JavaUtils.convert(_resp, cl.movistar.ofertador.dto.ResponseDetalleOferta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
