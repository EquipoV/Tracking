/**
 * OfertadorImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.services;

public interface OfertadorImpl extends java.rmi.Remote {
    public cl.movistar.ofertador.dto.Response validarCompatibilidadEntreOfertas(cl.movistar.ofertador.dto.SolicitudCompatibilidadOferta solicitudCompatibilidadOferta) throws java.rmi.RemoteException;
    public cl.movistar.ofertador.dto.Response validarFactibilidadVentaOtrosCanales(cl.movistar.ofertador.dto.SolicitudFactibilidadVentaOtrosCanales solicitudFactibilidadVentaOtrosCanales) throws java.rmi.RemoteException;
    public cl.movistar.ofertador.dto.ResponseOfertas obtenerOfertas(cl.movistar.ofertador.dto.SolicitudOferta solicitudOferta) throws java.rmi.RemoteException;
    public cl.movistar.ofertador.dto.ResponseDetalleOferta obtenerDetalleOferta(java.lang.String codigoOferta) throws java.rmi.RemoteException;
}
