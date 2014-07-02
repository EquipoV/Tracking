/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.movistar.tracking.services.altaBaja;


import cl.movistar.datoscliente.gateway.DatosClienteFacade;
import cl.movistar.midrange.provision.convergente.gateway.ProvisionConvergenteFacade;
import cl.movistar.midrange.provision.convergente.product.types.ActionType;
import cl.movistar.midrange.provision.convergente.product.types.Characteristic;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrder;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderItem;
import cl.movistar.midrange.provision.convergente.product.types.ProductOrderResponse;
import cl.movistar.midrange.provision.convergente.product.types.ProductSpecType;
import cl.movistar.ofertador.dto.ResponseDetalleOferta;
import cl.movistar.ofertador.services.gateway.OfertadorFacade;
import cl.movistar.osb.GetDetalleVO;
import cl.movistar.services.parque.ActivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoRequestDTO;
import cl.movistar.services.parque.DesactivaBolsaAbonadoResponseDTO;
import cl.movistar.services.parque.gateway.ParqueBajaFacade;
import cl.movistar.tracking.dto.AltaBajaBolsaRequest;
import cl.movistar.tracking.dto.altaBaja.OfertaBolsa;
import cl.movistar.tracking.dto.Respuesta;
import cl.movistar.tracking.dto.altaBaja.RespuestaAcciones;
import cl.movistar.tracking.dto.RespuestaServicio;
import cl.movistar.tracking.dto.TrackingResponse;
import cl.movistar.tracking.hibernate.altaBaja.AccionNegocio;
import cl.movistar.tracking.hibernate.altaBaja.AccionSistema;
import cl.movistar.tracking.hibernate.altaBaja.EventoNegocio;
import cl.movistar.tracking.hibernate.altaBaja.EventoSistema;
import cl.movistar.tracking.hibernate.altaBaja.EventosTracking;
import cl.movistar.tracking.hibernate.altaBaja.MovimientosTracking;
import cl.movistar.tracking.hibernate.altaBaja.TrackingHibernateUtil;
import com.telefonica.midrange.findproductofferingservice.gateway.CatalogoFacade;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingRequest;
import com.telefonica.midrange.findproductofferingservice.types.FindProductOfferingResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;


public class WebServicesTrackingGatewayAltaBaja {

    public static WebServicesTrackingGatewayAltaBaja getInstance() {
        return INSTANCE;
    }
    private ActivaBolsaAbonadoRequestDTO ActivaBolsaAbonadoRequestDTO;
    
    public TrackingResponse altaBajaDeBolsa(AltaBajaBolsaRequest altaBajaBolsaRequest) {
        logger.info("Entre a altaDeBolsa");
        TrackingResponse trackingResponse = new TrackingResponse();
        Respuesta respuesta = new Respuesta();
        RespuestaServicio respuestaServicio = new RespuestaServicio();
            
        //Obtengo las acciones a realizar 
        session = TrackingHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        logger.info("obtenerListadoAccionesSistema");
        List<AccionSistema> accionesSistema = obtenerListadoAccionesSistema(altaBajaBolsaRequest.getCodigoEventoSistema());
        logger.info("obtenerListadoAccionesNegocio");
        List<AccionNegocio> accionesNegocio = obtenerListadoAccionesNegocio(altaBajaBolsaRequest.getCodigoEventoSistema());
        
        RespuestaAcciones respuestaAccionesSistema = ejecutarAccionesSistemaAltaBajaBolsa(accionesSistema, altaBajaBolsaRequest);

        if(respuestaAccionesSistema.getIdTracking() !=0){
            session.getTransaction().commit();     
            session.close();
            RespuestaAcciones respuestaAccionesNegocio = ejecutarAccionesNegocioAltaBajaBolsa(accionesNegocio, altaBajaBolsaRequest, respuestaAccionesSistema.getIdTracking());
            if(respuestaAccionesNegocio.getCodigo() == 0){
                logger.info("Se ha recibido con exito la solicitud de Alta");
                respuestaServicio.setCodigoError(0);
                respuesta.setEstado("Realizado");
                respuesta.setIdSolicitud(respuestaAccionesSistema.getIdTracking());
                respuesta.setMensaje("Se ha recibido con exito la solicitud de Alta");
//                session.getTransaction().commit();     
//                session.close();
            }else{
                logger.error("Ocurrio un error al ejecutar las acciones de negocio");
                respuestaServicio.setCodigoError(52);
                respuestaServicio.setDescripcionError(respuestaAccionesNegocio.getDescripcionError());
                respuestaServicio.setMensajeError(respuestaAccionesNegocio.getMensajeError());
            }
        }else{
            logger.error("Ocurrio un error al ejecutar las acciones de sistema");
            respuestaServicio.setCodigoError(51);
            respuestaServicio.setDescripcionError(respuestaAccionesSistema.getDescripcionError());
            respuestaServicio.setMensajeError(respuestaAccionesSistema.getMensajeError());
        }
        
        trackingResponse.setRespuesta(respuesta);
        trackingResponse.setRespuestaServicio(respuestaServicio);
        logger.info("Fin altaDeBolsa");
        return trackingResponse;
    }
    
    private WebServicesTrackingGatewayAltaBaja() {
        
        String resourceLog = "cl/movistar/tracking/services/altaBaja/TrackingServicesAltaBajaLog4j.properties";
        InputStream isLog = this.getClass().getClassLoader().getResourceAsStream(resourceLog);
        Properties props = new Properties();
        try {
            props.load(isLog);
            PropertyConfigurator.configure(props);
            isLog.close();
        } catch (IOException ex) {
            logger.error("IOException");
            logger.error(ex);
        }
        
    }
    
 
    private Session session;
    private static final Logger logger = Logger.getLogger(WebServicesTrackingGatewayAltaBaja.class.getName());    
    private static final WebServicesTrackingGatewayAltaBaja INSTANCE = new WebServicesTrackingGatewayAltaBaja();

    private List<AccionSistema> obtenerListadoAccionesSistema(Integer codigoEventoSistema) {
        List<AccionSistema> listadoAccionessSistema = new ArrayList();
        
        //session.beginTransaction();
        String hql = "FROM cl.movistar.tracking.hibernate.altaBaja.EventosTracking eventos WHERE eventos.id =" + codigoEventoSistema;
        Query query = session.createQuery(hql);
        List<EventosTracking> eventos = query.list();
        
        String hql3 = "FROM cl.movistar.tracking.hibernate.altaBaja.EventoSistema eventos WHERE eventos.id =" + eventos.get(0).getEventoSistema();
        Query query3 = session.createQuery(hql3);
        List<EventoSistema> eventosSistema = query3.list();
        
        String accionesSistemaAux = eventosSistema.get(0).getAccionesSistema();
        String[] accionesSistema = accionesSistemaAux.split(",");
        
        for (int i = 0; i < accionesSistema.length -1 ; i++) {
            String hql2 = "FROM cl.movistar.tracking.hibernate.altaBaja.AccionSistema accion WHERE accion.id =" + accionesSistema[i];
            Query query2 = session.createQuery(hql2);
            List<AccionSistema> acccion = query2.list();
            listadoAccionessSistema.add(acccion.get(0));
        }
        
        return listadoAccionessSistema;
    }

    private List<AccionNegocio> obtenerListadoAccionesNegocio(Integer codigoEventoSistema) {
        List<AccionNegocio> listadoAccionesNegocio = new ArrayList();
        
        //session.beginTransaction();
        String hql = "FROM cl.movistar.tracking.hibernate.altaBaja.EventosTracking eventos WHERE eventos.id =" + codigoEventoSistema;
        Query query = session.createQuery(hql);
        List<EventosTracking> eventos = query.list();
        
        String hql3 = "FROM cl.movistar.tracking.hibernate.altaBaja.EventoNegocio eventos WHERE eventos.id =" + eventos.get(0).getEventoNegocio();
        Query query3 = session.createQuery(hql3);
        List<EventoNegocio> eventosNegocio = query3.list();
        
        String accionesNegocioAux = eventosNegocio.get(0).getAccionesNegocio();
        String[] accionesNegocio = accionesNegocioAux.split(",");
        
        for (int i = 0; i < accionesNegocio.length -1 ; i++) {
            String hql2 = "FROM cl.movistar.tracking.hibernate.altaBaja.AccionNegocio accion WHERE accion.id =" + accionesNegocio[i];
            Query query2 = session.createQuery(hql2);
            List<AccionNegocio> acccion = query2.list();
            listadoAccionesNegocio.add(acccion.get(0));
        }
        
        return listadoAccionesNegocio;
    }

    private RespuestaAcciones ejecutarAccionesSistemaAltaBajaBolsa(List<AccionSistema> accionesSistema, AltaBajaBolsaRequest altaBajaBolsaRequest) {
        logger.info("Entre a ejecutarAccionesSistemaAltaBolsa");
        RespuestaAcciones respuestaAccionesSistema = new RespuestaAcciones();
        respuestaAccionesSistema.setIdTracking(0);
        
        DatosClienteFacade datosClienteFacade = new DatosClienteFacade();
        GetDetalleVO consultaAbonadoSCLResponseDTO = datosClienteFacade.obtenerDatosCliente(altaBajaBolsaRequest.getNumeroCelular());
        
        if(consultaAbonadoSCLResponseDTO.getCodigoRetorno() != 0){
            logger.info("No se obtuvieron los datos del usuario");
            respuestaAccionesSistema.setMensajeError("Ocurrio un error al obtener los datos del cliente con numero: " + altaBajaBolsaRequest.getNumeroCelular());
            respuestaAccionesSistema.setDescripcionError("El servicio de consultaAbonadoSCLResponseDTO respondio: " + consultaAbonadoSCLResponseDTO.getMensajeRetorno());
            
            return respuestaAccionesSistema;
        }
        
        int idMovimiento = 0;
        try {
            
            for (AccionSistema accionSistema : accionesSistema) {
                String tipoAccion = accionSistema.getTipo();
                String data = accionSistema.getData();
                if(tipoAccion.equalsIgnoreCase("Base datos")){
                    if(data.equalsIgnoreCase("movimientos_tracking")){
                        MovimientosTracking movimientosTracking = new MovimientosTracking();
                        movimientosTracking.setAgencia(altaBajaBolsaRequest.getAgencia());
                        movimientosTracking.setCodigoVendedor(String.valueOf(altaBajaBolsaRequest.getCodigoVendedor()));
                        movimientosTracking.setSubCanal(Integer.parseInt(altaBajaBolsaRequest.getSubCanal()));
                        movimientosTracking.setUsuario(altaBajaBolsaRequest.getUsuario());
                        movimientosTracking.setCicloFacturacion(altaBajaBolsaRequest.getCiclo());
                        movimientosTracking.setCodigoCliente(consultaAbonadoSCLResponseDTO.getCodCliente());
                        movimientosTracking.setDescuento(0);
                       
                        movimientosTracking.setFechaContratacion(Calendar.getInstance().getTime());
                        movimientosTracking.setPuntosUtilizados(idMovimiento);
                        movimientosTracking.setCanal(Integer.parseInt(altaBajaBolsaRequest.getCanal()));
                        movimientosTracking.setEstado(1); // revisar el codigo de estado para iniciado
                        movimientosTracking.setIdEventoTracking(altaBajaBolsaRequest.getCodigoEventoSistema());
                        movimientosTracking.setCodigoOferta(altaBajaBolsaRequest.getBolsa().getCodigo());
                        movimientosTracking.setNombreOferta(altaBajaBolsaRequest.getBolsa().getNombre());
                        movimientosTracking.setIdTracking(0);
                        movimientosTracking.setNumeroAbonado(altaBajaBolsaRequest.getNumeroAbonado());
                        movimientosTracking.setNumeroCelular(altaBajaBolsaRequest.getNumeroCelular());
                        

                        ResponseDetalleOferta responseOferta = obtieneDetalleOfertaOfertador(altaBajaBolsaRequest.getBolsa().getCodigo());

                        if(responseOferta.getRespuestaServicio().getCodigo() == 0){
                            logger.info("Ofertador encontro la oferta");
                            logger.info("Set precio");
                            movimientosTracking.setPrecio(responseOferta.getDetalleOferta().getPrecios()[0].getPrecioOferta());
                            logger.info("Insertando movimiento");
                            session.save(movimientosTracking);
                            session.persist(movimientosTracking);
                            idMovimiento = movimientosTracking.getId();
                            respuestaAccionesSistema.setIdTracking(idMovimiento);
                        }else{
                            logger.info("La oferta no fue encontrada");
                            session.getTransaction().rollback();
                            respuestaAccionesSistema.setMensajeError("Ocurrio un error al obtener el detalle de la oferta: " + altaBajaBolsaRequest.getBolsa().getCodigo());
                            respuestaAccionesSistema.setDescripcionError("El servicio de Ofertador respondio: " + responseOferta.getRespuestaServicio().getMensaje());
                            return respuestaAccionesSistema;
                            
                        }
                        logger.info("Flujo OK");

                        
                    }else{
                        // error accion no programada
                        session.getTransaction().rollback();
                        respuestaAccionesSistema.setMensajeError("Ocurrio un error al procesar una accion de sistema");
                        respuestaAccionesSistema.setDescripcionError("La accion de sistema informada en el Tracking no esta programada para ser procesada");
                        return respuestaAccionesSistema;
                    }

                }
            }
            
            
        } catch (Exception e) {
            logger.info("Fallo la insercion del movimiento");
            session.getTransaction().rollback();
            respuestaAccionesSistema.setMensajeError("Ocurrio un error al insertar el registro");
            respuestaAccionesSistema.setDescripcionError("Se intento grabar en la tabla movimientos");
            return respuestaAccionesSistema;
            
        }
        
        return respuestaAccionesSistema;
    }

    private RespuestaAcciones ejecutarAccionesNegocioAltaBajaBolsa(List<AccionNegocio> accionesNegocio, AltaBajaBolsaRequest altaBolsaRequest, int idTracking) {
        logger.info("Entre a ejecutar las acciones de negocio");
        RespuestaAcciones respuestaAccionesNegocio = new RespuestaAcciones();
        
        for (AccionNegocio accionNegocio : accionesNegocio) {
            String tipo = accionNegocio.getTipo();
            if(tipo.equalsIgnoreCase("FIN")){
                respuestaAccionesNegocio.setCodigo(0);
            }else if(tipo.equalsIgnoreCase("WebServices Provision con confirmacion")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));

                String mensajeSms = accionNegocio.getData();
                mensajeSms = mensajeSms.replace("&", altaBolsaRequest.getBolsa().getNombre());
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue(mensajeSms);
                
                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("SI");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(altaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.A);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(altaBolsaRequest.getBolsa().getDescripcion());
                productSpecType.setProductName(altaBolsaRequest.getBolsa().getNombre());
                productSpecType.setProductNumber(altaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    respuestaAccionesNegocio.setCodigo(0);
                }else{
                    respuestaAccionesNegocio.setMensajeError("Ocurrio un error al llamar al provisionador");
                    respuestaAccionesNegocio.setDescripcionError("El provisionador respondio: " +  productOrderResponse.getInteractionDescription());
                    return respuestaAccionesNegocio;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Provision sin confirmacion")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue("");

                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("NO");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(altaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.A);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(String.valueOf(altaBolsaRequest.getBolsa().getDescripcion()));
                productSpecType.setProductName(String.valueOf(altaBolsaRequest.getBolsa().getNombre()));
                productSpecType.setProductNumber(altaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    respuestaAccionesNegocio.setCodigo(0);
                }else{
                    respuestaAccionesNegocio.setMensajeError("Ocurrio un error al llamar al provisionador");
                    respuestaAccionesNegocio.setDescripcionError("El provisionador respondio: " +  productOrderResponse.getInteractionDescription());
                    return respuestaAccionesNegocio;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Provision Baja")){
                // Llamar a parque
                ProvisionConvergenteFacade provisionConvergenteFacade = new ProvisionConvergenteFacade();
                ProductOrder productOrder = new ProductOrder();
                productOrder.setBusinessId(String.valueOf(idTracking));
                
                Characteristic characteristic = new Characteristic();
                characteristic.setKey("NUMMOVIL");
                characteristic.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic2 = new Characteristic();
                characteristic2.setKey("NUMMOVILDESTINO");
                characteristic2.setValue(String.valueOf(altaBolsaRequest.getNumeroCelular()));
                
                Characteristic characteristic3 = new Characteristic();
                characteristic3.setKey("MSJCLIENTE");
                characteristic3.setValue("");

                Characteristic characteristic4 = new Characteristic();
                characteristic4.setKey("REQUIERE_CONFIRMACION");
                characteristic4.setValue("NO");
                
                Characteristic characteristic5 = new Characteristic();
                characteristic5.setKey("ID_RED");
                characteristic5.setValue(altaBolsaRequest.getBolsa().getIdRed());
                
                Characteristic characteristic6 = new Characteristic();
                characteristic6.setKey("PRIMER_COBRO");
                characteristic6.setValue("TOTAL");
                
                Characteristic[] characteristics = new Characteristic[]{characteristic,characteristic2,characteristic3,characteristic4,characteristic5,characteristic6};
                productOrder.setCharacteristic(characteristics);
                
                ProductOrderItem productOrderItem = new ProductOrderItem();
                productOrderItem.setAction(ActionType.B);
                
                ProductSpecType productSpecType = new ProductSpecType(); 
                productSpecType.setProductDescription(altaBolsaRequest.getBolsa().getDescripcion());
                productSpecType.setProductName(altaBolsaRequest.getBolsa().getNombre());
                productSpecType.setProductNumber(altaBolsaRequest.getBolsa().getCodigo());
                productOrderItem.setProductoSpec(productSpecType);
                productOrderItem.setQuantiyt("1");
                
                ProductOrderItem[] productOrderItems = new ProductOrderItem[]{productOrderItem};
                
                productOrder.setProductOrdenItem(productOrderItems);
                
                ProductOrderResponse productOrderResponse = provisionConvergenteFacade.llamarProvisionadorConvergente(productOrder);

                if(productOrderResponse.getInteractionStatus().equalsIgnoreCase("0000")){
                    respuestaAccionesNegocio.setCodigo(0);
                }else{
                    respuestaAccionesNegocio.setMensajeError("Ocurrio un error al llamar al provisionador");
                    respuestaAccionesNegocio.setDescripcionError("El provisionador respondio: " +  productOrderResponse.getInteractionDescription());
                    return respuestaAccionesNegocio;
                }

            }else if(tipo.equalsIgnoreCase("WebServices Parque Alta")){
                // Llamar a parque
                respuestaAccionesNegocio.setCodigo(0);

            }else if(tipo.equalsIgnoreCase("WebServices Parque Baja")){
                // Llamar a parque
                OfertaBolsa oferta = obtieneCodigoServicioSuplementario(altaBolsaRequest.getBolsa().getCodigo());
                if(oferta.getNombre().equalsIgnoreCase("ERROR")){
                    respuestaAccionesNegocio.setMensajeError("Ocurrio un error al llamar a FindProductOfferingResponse");
                    respuestaAccionesNegocio.setDescripcionError("El servicio FindProductOfferingResponse respondio: " +  oferta.getCodigo());
                    return respuestaAccionesNegocio;
                }
                ParqueBajaFacade parqueBajaFacade = new ParqueBajaFacade();
                ActivaBolsaAbonadoRequestDTO activaBolsaAbonadoRequestDTO = new ActivaBolsaAbonadoRequestDTO();
                
                DesactivaBolsaAbonadoRequestDTO desactivaBolsaAbonadoRequestDTO = new DesactivaBolsaAbonadoRequestDTO();
                desactivaBolsaAbonadoRequestDTO.setCodServicio(altaBolsaRequest.getBolsa().getCodigo());
                desactivaBolsaAbonadoRequestDTO.setNomUsuario(altaBolsaRequest.getUsuario());
                desactivaBolsaAbonadoRequestDTO.setNumAbonado(String.valueOf(altaBolsaRequest.getNumeroAbonado()));
                
                DesactivaBolsaAbonadoResponseDTO desactivaBolsaAbonadoResponseDTO = parqueBajaFacade.informarParqueBaja(desactivaBolsaAbonadoRequestDTO);
                if(desactivaBolsaAbonadoResponseDTO.getCodigoRetorno().equalsIgnoreCase("0")){
                    respuestaAccionesNegocio.setCodigo(0);
                }else{
                    respuestaAccionesNegocio.setMensajeError("Ocurrio un error al llamar a Parque");
                    respuestaAccionesNegocio.setDescripcionError("El servicio DesactivaBolsaAbonado respondio: " +  desactivaBolsaAbonadoResponseDTO.getDescripcionRetorno());
                    return respuestaAccionesNegocio;
                }

            }else{
                // error accion no programada
                respuestaAccionesNegocio.setMensajeError("Ocurrio un error al procesar una accion de sistema");
                respuestaAccionesNegocio.setDescripcionError("La accion de sistema informada en el Tracking no esta programada para ser procesada");
                return respuestaAccionesNegocio;

            }
        }
        
        return respuestaAccionesNegocio;
    }
    
    private OfertaBolsa obtieneOfertaByIdRed(String idRed) {
        
        CatalogoFacade catalogoFacade = new CatalogoFacade();
        
        FindProductOfferingRequest request = new FindProductOfferingRequest();
        request.setIdNetwork(idRed);
        request.setProductOfferingEndDateTime("01-01-9999");
        request.setVisualizacionType(0);
        request.setProductOfferingStatus(0);
        request.setSalesChannelId(0);
        request.setProductSpecificationStatus(0);
        request.setProductSpecificationFamily(0);
        request.setProductSpecificationSubFamily(0);
        request.setProductSpecificationUnitType(0);
        request.setTypeDestination(0);
        long numeroAux = 0;
        request.setPriceLowerValue(numeroAux);
        request.setPriceUpperValue(numeroAux);
        request.setMarketSegmentId(0);
        request.setCustomerValue(0);
        request.setFamiliarityType(0);
        
        
        FindProductOfferingResponse response = catalogoFacade.findProductOffering(request);        
        OfertaBolsa oferta = new OfertaBolsa();
        if(response.getReturnCode().equalsIgnoreCase("000")){
            // llamar al ws de catalogo para obtener los datos de la bolsa segun el id de red
            oferta.setCodigo(response.getProductOffering(0).getCodOffering());
            oferta.setNombre(response.getProductOffering(0).getName());
            ResponseDetalleOferta responseOfertador = obtieneDetalleOfertaOfertador(response.getProductOffering(0).getCodOffering());
            oferta.setPrecio(responseOfertador.getDetalleOferta().getPrecios()[0].getPrecioOferta());
        }else{
            oferta.setNombre("ERROR");
            logger.info("Error en llamar a Catalogo");
            logger.info("Codigo de error: " + response.getReturnCode());
            logger.info("Codigo de error: " + response.getReturnDescription());
            
        }
        
        return oferta;
    }
    
    private ResponseDetalleOferta obtieneDetalleOfertaOfertador(String codigoOferta){
        OfertadorFacade ofertadorFacade = new OfertadorFacade();
        ResponseDetalleOferta responseOfertador = ofertadorFacade.obtenerDetalleOferta(codigoOferta);
        return responseOfertador;
    }
    
    private OfertaBolsa obtieneCodigoServicioSuplementario(String codigoOferta) {
        
        CatalogoFacade catalogoFacade = new CatalogoFacade();
        
        FindProductOfferingRequest request = new FindProductOfferingRequest();
        request.setCodOffering(codigoOferta);
        request.setProductOfferingEndDateTime("01-01-9999");
        request.setVisualizacionType(0);
        request.setProductOfferingStatus(0);
        request.setSalesChannelId(0);
        request.setProductSpecificationStatus(0);
        request.setProductSpecificationFamily(0);
        request.setProductSpecificationSubFamily(0);
        request.setProductSpecificationUnitType(0);
        request.setTypeDestination(0);
        long numeroAux = 0;
        request.setPriceLowerValue(numeroAux);
        request.setPriceUpperValue(numeroAux);
        request.setMarketSegmentId(0);
        request.setCustomerValue(0);
        request.setFamiliarityType(0);
        
        
        FindProductOfferingResponse response = catalogoFacade.findProductOffering(request);        
        OfertaBolsa oferta = new OfertaBolsa();
        if(response.getReturnCode().equalsIgnoreCase("000")){
            // llamar al ws de catalogo para obtener los datos de la bolsa segun el id de red
            oferta.setCodigo(response.getProductOffering(0).getSupplementaryService());
            
        }else{
            oferta.setNombre("ERROR");
            oferta.setCodigo(response.getReturnDescription());
            logger.info("Error en llamar a Catalogo FindProductOfferingResponse");
            logger.info("Codigo de error: " + response.getReturnCode());
            logger.info("Codigo de descripcion: " + response.getReturnDescription());
            
        }
        
        //000
        
        return oferta;
    }

}
