package com.telefonica.midrange.findproductofferingservice.gateway;

import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingRequest;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingResponse;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class CatalogoFacade {

    public FindProductOfferingResponse findProductOffering(FindProductOfferingRequest request) {
        return CatalogoGateway.getInstance().findProductOffering(request);
    }
    
}
