package cl.movistar.ofertador.services;

public class OfertadorImplProxy implements cl.movistar.ofertador.services.OfertadorImpl {
  private String _endpoint = null;
  private cl.movistar.ofertador.services.OfertadorImpl ofertadorImpl = null;
  
  public OfertadorImplProxy() {
    _initOfertadorImplProxy();
  }
  
  public OfertadorImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initOfertadorImplProxy();
  }
  
  private void _initOfertadorImplProxy() {
    try {
      ofertadorImpl = (new cl.movistar.ofertador.services.OfertadorImplServiceLocator()).getOfertadorImpl();
      if (ofertadorImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ofertadorImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ofertadorImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ofertadorImpl != null)
      ((javax.xml.rpc.Stub)ofertadorImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.movistar.ofertador.services.OfertadorImpl getOfertadorImpl() {
    if (ofertadorImpl == null)
      _initOfertadorImplProxy();
    return ofertadorImpl;
  }
  
  public cl.movistar.ofertador.dto.Response validarCompatibilidadEntreOfertas(cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta solicitudCompatibilidadOferta) throws java.rmi.RemoteException{
    if (ofertadorImpl == null)
      _initOfertadorImplProxy();
    return ofertadorImpl.validarCompatibilidadEntreOfertas(solicitudCompatibilidadOferta);
  }
  
  public cl.movistar.ofertador.dto.Response validarFactibilidadVentaOtrosCanales(cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales solicitudFactibilidadVentaOtrosCanales) throws java.rmi.RemoteException{
    if (ofertadorImpl == null)
      _initOfertadorImplProxy();
    return ofertadorImpl.validarFactibilidadVentaOtrosCanales(solicitudFactibilidadVentaOtrosCanales);
  }
  
  public cl.movistar.ofertador.dto.ResponseOfertas obtenerOfertas(cl.movistar.ofertador.dto.SolicitudOferta solicitudOferta) throws java.rmi.RemoteException{
    if (ofertadorImpl == null)
      _initOfertadorImplProxy();
    return ofertadorImpl.obtenerOfertas(solicitudOferta);
  }
  
  public cl.movistar.ofertador.dto.ResponseDetalleOferta obtenerDetalleOferta(java.lang.String codigoOferta) throws java.rmi.RemoteException{
    if (ofertadorImpl == null)
      _initOfertadorImplProxy();
    return ofertadorImpl.obtenerDetalleOferta(codigoOferta);
  }
  
  
}