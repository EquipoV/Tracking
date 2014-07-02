package cl.movistar.services.parque;

public class ActivaBolsaAbonadoWSProxy implements cl.movistar.services.parque.ActivaBolsaAbonadoWS {
  private String _endpoint = null;
  private cl.movistar.services.parque.ActivaBolsaAbonadoWS activaBolsaAbonadoWS = null;
  
  public ActivaBolsaAbonadoWSProxy() {
    _initActivaBolsaAbonadoWSProxy();
  }
  
  public ActivaBolsaAbonadoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initActivaBolsaAbonadoWSProxy();
  }
  
  private void _initActivaBolsaAbonadoWSProxy() {
    try {
      activaBolsaAbonadoWS = (new cl.movistar.services.parque.ActivaBolsaAbonadoWSServiceLocator()).getActivaBolsaAbonadoWS();
      if (activaBolsaAbonadoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)activaBolsaAbonadoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)activaBolsaAbonadoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (activaBolsaAbonadoWS != null)
      ((javax.xml.rpc.Stub)activaBolsaAbonadoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.movistar.services.parque.ActivaBolsaAbonadoWS getActivaBolsaAbonadoWS() {
    if (activaBolsaAbonadoWS == null)
      _initActivaBolsaAbonadoWSProxy();
    return activaBolsaAbonadoWS;
  }
  
  public cl.movistar.services.parque.ActivaBolsaAbonadoResponseDTO activaBolsa(cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO entrada) throws java.rmi.RemoteException{
    if (activaBolsaAbonadoWS == null)
      _initActivaBolsaAbonadoWSProxy();
    return activaBolsaAbonadoWS.activaBolsa(entrada);
  }
  
  
}