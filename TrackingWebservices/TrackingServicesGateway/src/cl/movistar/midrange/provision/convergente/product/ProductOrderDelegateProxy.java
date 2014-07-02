package cl.movistar.midrange.provision.convergente.product;

public class ProductOrderDelegateProxy implements cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate {
  private String _endpoint = null;
  private cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate productOrderDelegate = null;
  
  public ProductOrderDelegateProxy() {
    _initProductOrderDelegateProxy();
  }
  
  public ProductOrderDelegateProxy(String endpoint) {
    _endpoint = endpoint;
    _initProductOrderDelegateProxy();
  }
  
  private void _initProductOrderDelegateProxy() {
    try {
      productOrderDelegate = (new cl.movistar.midrange.provision.convergente.product.ProductOrderLocator()).getProductOrder();
      if (productOrderDelegate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)productOrderDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)productOrderDelegate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (productOrderDelegate != null)
      ((javax.xml.rpc.Stub)productOrderDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.movistar.midrange.provision.convergente.product.ProductOrderDelegate getProductOrderDelegate() {
    if (productOrderDelegate == null)
      _initProductOrderDelegateProxy();
    return productOrderDelegate;
  }
  
  public cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse start(cl.movistar.midrange.provision.convergente.product.types.ProductOrder arg0) throws java.rmi.RemoteException{
    if (productOrderDelegate == null)
      _initProductOrderDelegateProxy();
    return productOrderDelegate.start(arg0);
  }
  
  
}