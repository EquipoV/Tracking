/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.midrange.provision.convergente.gateway;

import cl.movistar.midrange.provision.convergente.product.types.ProductOrder;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse;

/**
 *
 * @author Christian
 */
public class ProvisionConvergenteFacade {

    public ProductOrderResponse llamarProvisionadorConvergente(ProductOrder request) {
        return ProvisionConvergenteGateway.getInstance().llamarProvisionadorConvergente(request);
    }
    
}
