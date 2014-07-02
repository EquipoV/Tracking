
import cl.movistar.midrange.provision.convergente.gateway.ProvisionConvergenteFacade;
import cl.movistar.midrange.provision.convergente.product.types.ActionType;
import cl.movistar.midrange.provision.convergente.product.types.Characteristic;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse;
import cl.movistar.midrange.provision.convergente.product.types.ProductSpecType;
import cl.movistar.ofertador.dto.ResponseDetalleOferta;
import cl.movistar.ofertador.services.gateway.OfertadorFacade;
import cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.ActivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.gateway.ParqueAltaFacade;
import cl.movistar.services.parque.gateway.ParqueBajaFacade;
import com.telefonica.midrange.findproductofferingservice.gateway.CatalogoFacade;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingRequest;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingResponse;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class WebservicesClientTest {
   
    public WebservicesClientTest() {
        provisionConvergenteFacade = new ProvisionConvergenteFacade();
        parqueAltaFacade = new ParqueAltaFacade();
        parqueBajaFacade = new ParqueBajaFacade();
        catalogoFacade = new CatalogoFacade();
        ofertadorFacade = new OfertadorFacade();
    }
    
    @Test    
    public void deberiaLlamarProvisionadorConvergente(){
        cl.movistar.midrange.provision.convergente.product.types.ProductOrder request = new cl.movistar.midrange.provision.convergente.product.types.ProductOrder();
        request.setBusinessId("589024220239");
        
        Characteristic characteristic = new Characteristic();
        characteristic.setKey("NUMMOVIL");
        characteristic.setValue("56985962278");
        
        Characteristic characteristic2 = new Characteristic();
        characteristic2.setKey("NUMMOVILDESTINO");
        characteristic2.setValue("56985962278");
        
        Characteristic characteristic3 = new Characteristic();
        characteristic3.setKey("MSJCLIENTE");
        characteristic3.setValue("Estimado cliente lalalal");
        
        Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3};

        request.setCharacteristic(characteristics);
        
        ProductOrderItem productOrderItem = new ProductOrderItem();
        productOrderItem.setAction(ActionType.A);

        ProductSpecType productSpecType = new ProductSpecType(); 
        productSpecType.setProductDescription("BA BOLSA con confirmacion");
        productSpecType.setProductName("CODBABOLSA");
        productSpecType.setProductNumber("8766");

        productOrderItem.setProductoSpec(productSpecType);
        productOrderItem.setQuantiyt("1");
        
        ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
        request.setProductOrdenItem(productOrderItems);
        
        
        ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(request);
        assertNotNull("No se pudo comunicar con provision convergente.", productOrderResponse.getBusinessId());
    }
    
    @Test    
    public void deberiaInformarParqueAlta(){
        ActivaBolsaAbonadoRequestDTO request = new ActivaBolsaAbonadoRequestDTO();
        request.setCodServicio("1231");
        request.setNomUsuario("nombreras");
        request.setNumAbonado("123123123");
        ActivaBolsaAbonadoResponseDTO response = parqueAltaFacade.informarParqueAlta(request);
        assertNotNull("No se pudo comunicar con provision convergente.", response.getCodigoRetorno());
    }
    
    @Test    
    public void deberiaInformarParqueBaja(){
        DesactivaBolsaAbonadoRequestDTO request = new DesactivaBolsaAbonadoRequestDTO();
        request.setCodServicio("1231");
        request.setNomUsuario("nombreras");
        request.setNumAbonado("123123123");
        DesactivaBolsaAbonadoResponseDTO response = parqueBajaFacade.informarParqueBaja(request);
        assertNotNull("No se pudo comunicar con provision convergente.", response.getCodigoRetorno());
    }
    
    @Test    
    public void deberiaFindProductOffering(){
        FindProductOfferingRequest request = new FindProductOfferingRequest();
        request.setIdNetwork("h234");
        FindProductOfferingResponse response = catalogoFacade.findProductOffering(request);
        assertNotNull("No es una entrada valida.", response.getReturnCode());
    }
    
    @Test    
    public void deberiaObtenerDetalleOferta(){
        String codigoOferta = "OFE004";
        ResponseDetalleOferta response = ofertadorFacade.obtenerDetalleOferta(codigoOferta);
        assertNotNull("No es una entrada valida.", response.getDetalleOferta());
    }
    
    private ParqueAltaFacade parqueAltaFacade;
    private ParqueBajaFacade parqueBajaFacade;
    private ProvisionConvergenteFacade provisionConvergenteFacade;
    private CatalogoFacade catalogoFacade;
    private OfertadorFacade ofertadorFacade;
}
