/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import cl.movistar.tracking.hibernate.altaBaja.MovimientosTracking;
import cl.movistar.tracking.services.altaBaja.WebServicesTrackingFacade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class TrackingServicesTest {
    
    public TrackingServicesTest() {
        webServicesTrackingFacade = new WebServicesTrackingFacade();
    }
    
    
    private WebServicesTrackingFacade webServicesTrackingFacade;
}