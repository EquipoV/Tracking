package cl.movistar.services.parque;

public class DesactivaBolsaAbonadoWSProxy implements cl.movistar.services.parque.DesactivaBolsaAbonadoWS {
  private String _endpoint = null;
  private cl.movistar.services.parque.DesactivaBolsaAbonadoWS desactivaBolsaAbonadoWS = null;
  
  public DesactivaBolsaAbonadoWSProxy() {
    _initDesactivaBolsaAbonadoWSProxy();
  }
  
  public DesactivaBolsaAbonadoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initDesactivaBolsaAbonadoWSProxy();
  }
  
  private void _initDesactivaBolsaAbonadoWSProxy() {
    try {
      desactivaBolsaAbonadoWS = (new cl.movistar.services.parque.DesactivaBolsaAbonadoWSServiceLocator()).getDesactivaBolsaAbonadoWS();
      if (desactivaBolsaAbonadoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)desactivaBolsaAbonadoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)desactivaBolsaAbonadoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (desactivaBolsaAbonadoWS != null)
      ((javax.xml.rpc.Stub)desactivaBolsaAbonadoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.movistar.services.parque.DesactivaBolsaAbonadoWS getDesactivaBolsaAbonadoWS() {
    if (desactivaBolsaAbonadoWS == null)
      _initDesactivaBolsaAbonadoWSProxy();
    return desactivaBolsaAbonadoWS;
  }
  
  public cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO desactivaBolsa(cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO entrada) throws java.rmi.RemoteException{
    if (desactivaBolsaAbonadoWS == null)
      _initDesactivaBolsaAbonadoWSProxy();
    return desactivaBolsaAbonadoWS.desactivaBolsa(entrada);
  }
  
  
}