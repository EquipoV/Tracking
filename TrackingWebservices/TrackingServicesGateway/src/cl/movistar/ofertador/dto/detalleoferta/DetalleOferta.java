/**
 * DetalleOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.movistar.ofertador.dto.detalleoferta;

public class DetalleOferta  implements java.io.Serializable {
    private int cantidadPuntos;

    private java.lang.String codigoOferta;

    private java.lang.String codigoOfertaRed;

    private java.lang.String consumo;

    private java.lang.String descripcion;

    private java.lang.String estado;

    private java.lang.String familia;

    private java.lang.String familiaridad;

    private java.lang.String fechaInicio;

    private java.lang.String fechaTermino;

    private java.lang.String horarioVenta;

    private java.lang.String idRed;

    private int idUsuario;

    private int idValidacion;

    private java.lang.String nombre;

    private cl.movistar.ofertador.dto.detalleoferta.Precio[] precios;

    private cl.movistar.ofertador.dto.detalleoferta.Producto[] productos;

    private java.lang.String restricciones;

    private cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado[] segmentosMercado;

    private java.lang.String subFamilia;

    private java.lang.String tipoCargo;

    private java.lang.String tipoDestino;

    private java.lang.String tipoOferta;

    private java.lang.String tipoVigencia;

    private java.lang.String tipoVisualizacion;

    private java.lang.String validacionRed;

    private java.lang.String valorCliente;

    public DetalleOferta() {
    }

    public DetalleOferta(
           int cantidadPuntos,
           java.lang.String codigoOferta,
           java.lang.String codigoOfertaRed,
           java.lang.String consumo,
           java.lang.String descripcion,
           java.lang.String estado,
           java.lang.String familia,
           java.lang.String familiaridad,
           java.lang.String fechaInicio,
           java.lang.String fechaTermino,
           java.lang.String horarioVenta,
           java.lang.String idRed,
           int idUsuario,
           int idValidacion,
           java.lang.String nombre,
           cl.movistar.ofertador.dto.detalleoferta.Precio[] precios,
           cl.movistar.ofertador.dto.detalleoferta.Producto[] productos,
           java.lang.String restricciones,
           cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado[] segmentosMercado,
           java.lang.String subFamilia,
           java.lang.String tipoCargo,
           java.lang.String tipoDestino,
           java.lang.String tipoOferta,
           java.lang.String tipoVigencia,
           java.lang.String tipoVisualizacion,
           java.lang.String validacionRed,
           java.lang.String valorCliente) {
           this.cantidadPuntos = cantidadPuntos;
           this.codigoOferta = codigoOferta;
           this.codigoOfertaRed = codigoOfertaRed;
           this.consumo = consumo;
           this.descripcion = descripcion;
           this.estado = estado;
           this.familia = familia;
           this.familiaridad = familiaridad;
           this.fechaInicio = fechaInicio;
           this.fechaTermino = fechaTermino;
           this.horarioVenta = horarioVenta;
           this.idRed = idRed;
           this.idUsuario = idUsuario;
           this.idValidacion = idValidacion;
           this.nombre = nombre;
           this.precios = precios;
           this.productos = productos;
           this.restricciones = restricciones;
           this.segmentosMercado = segmentosMercado;
           this.subFamilia = subFamilia;
           this.tipoCargo = tipoCargo;
           this.tipoDestino = tipoDestino;
           this.tipoOferta = tipoOferta;
           this.tipoVigencia = tipoVigencia;
           this.tipoVisualizacion = tipoVisualizacion;
           this.validacionRed = validacionRed;
           this.valorCliente = valorCliente;
    }


    /**
     * Gets the cantidadPuntos value for this DetalleOferta.
     * 
     * @return cantidadPuntos
     */
    public int getCantidadPuntos() {
        return cantidadPuntos;
    }


    /**
     * Sets the cantidadPuntos value for this DetalleOferta.
     * 
     * @param cantidadPuntos
     */
    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }


    /**
     * Gets the codigoOferta value for this DetalleOferta.
     * 
     * @return codigoOferta
     */
    public java.lang.String getCodigoOferta() {
        return codigoOferta;
    }


    /**
     * Sets the codigoOferta value for this DetalleOferta.
     * 
     * @param codigoOferta
     */
    public void setCodigoOferta(java.lang.String codigoOferta) {
        this.codigoOferta = codigoOferta;
    }


    /**
     * Gets the codigoOfertaRed value for this DetalleOferta.
     * 
     * @return codigoOfertaRed
     */
    public java.lang.String getCodigoOfertaRed() {
        return codigoOfertaRed;
    }


    /**
     * Sets the codigoOfertaRed value for this DetalleOferta.
     * 
     * @param codigoOfertaRed
     */
    public void setCodigoOfertaRed(java.lang.String codigoOfertaRed) {
        this.codigoOfertaRed = codigoOfertaRed;
    }


    /**
     * Gets the consumo value for this DetalleOferta.
     * 
     * @return consumo
     */
    public java.lang.String getConsumo() {
        return consumo;
    }


    /**
     * Sets the consumo value for this DetalleOferta.
     * 
     * @param consumo
     */
    public void setConsumo(java.lang.String consumo) {
        this.consumo = consumo;
    }


    /**
     * Gets the descripcion value for this DetalleOferta.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DetalleOferta.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the estado value for this DetalleOferta.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this DetalleOferta.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the familia value for this DetalleOferta.
     * 
     * @return familia
     */
    public java.lang.String getFamilia() {
        return familia;
    }


    /**
     * Sets the familia value for this DetalleOferta.
     * 
     * @param familia
     */
    public void setFamilia(java.lang.String familia) {
        this.familia = familia;
    }


    /**
     * Gets the familiaridad value for this DetalleOferta.
     * 
     * @return familiaridad
     */
    public java.lang.String getFamiliaridad() {
        return familiaridad;
    }


    /**
     * Sets the familiaridad value for this DetalleOferta.
     * 
     * @param familiaridad
     */
    public void setFamiliaridad(java.lang.String familiaridad) {
        this.familiaridad = familiaridad;
    }


    /**
     * Gets the fechaInicio value for this DetalleOferta.
     * 
     * @return fechaInicio
     */
    public java.lang.String getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this DetalleOferta.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.lang.String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the fechaTermino value for this DetalleOferta.
     * 
     * @return fechaTermino
     */
    public java.lang.String getFechaTermino() {
        return fechaTermino;
    }


    /**
     * Sets the fechaTermino value for this DetalleOferta.
     * 
     * @param fechaTermino
     */
    public void setFechaTermino(java.lang.String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }


    /**
     * Gets the horarioVenta value for this DetalleOferta.
     * 
     * @return horarioVenta
     */
    public java.lang.String getHorarioVenta() {
        return horarioVenta;
    }


    /**
     * Sets the horarioVenta value for this DetalleOferta.
     * 
     * @param horarioVenta
     */
    public void setHorarioVenta(java.lang.String horarioVenta) {
        this.horarioVenta = horarioVenta;
    }


    /**
     * Gets the idRed value for this DetalleOferta.
     * 
     * @return idRed
     */
    public java.lang.String getIdRed() {
        return idRed;
    }


    /**
     * Sets the idRed value for this DetalleOferta.
     * 
     * @param idRed
     */
    public void setIdRed(java.lang.String idRed) {
        this.idRed = idRed;
    }


    /**
     * Gets the idUsuario value for this DetalleOferta.
     * 
     * @return idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this DetalleOferta.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the idValidacion value for this DetalleOferta.
     * 
     * @return idValidacion
     */
    public int getIdValidacion() {
        return idValidacion;
    }


    /**
     * Sets the idValidacion value for this DetalleOferta.
     * 
     * @param idValidacion
     */
    public void setIdValidacion(int idValidacion) {
        this.idValidacion = idValidacion;
    }


    /**
     * Gets the nombre value for this DetalleOferta.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DetalleOferta.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the precios value for this DetalleOferta.
     * 
     * @return precios
     */
    public cl.movistar.ofertador.dto.detalleoferta.Precio[] getPrecios() {
        return precios;
    }


    /**
     * Sets the precios value for this DetalleOferta.
     * 
     * @param precios
     */
    public void setPrecios(cl.movistar.ofertador.dto.detalleoferta.Precio[] precios) {
        this.precios = precios;
    }


    /**
     * Gets the productos value for this DetalleOferta.
     * 
     * @return productos
     */
    public cl.movistar.ofertador.dto.detalleoferta.Producto[] getProductos() {
        return productos;
    }


    /**
     * Sets the productos value for this DetalleOferta.
     * 
     * @param productos
     */
    public void setProductos(cl.movistar.ofertador.dto.detalleoferta.Producto[] productos) {
        this.productos = productos;
    }


    /**
     * Gets the restricciones value for this DetalleOferta.
     * 
     * @return restricciones
     */
    public java.lang.String getRestricciones() {
        return restricciones;
    }


    /**
     * Sets the restricciones value for this DetalleOferta.
     * 
     * @param restricciones
     */
    public void setRestricciones(java.lang.String restricciones) {
        this.restricciones = restricciones;
    }


    /**
     * Gets the segmentosMercado value for this DetalleOferta.
     * 
     * @return segmentosMercado
     */
    public cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado[] getSegmentosMercado() {
        return segmentosMercado;
    }


    /**
     * Sets the segmentosMercado value for this DetalleOferta.
     * 
     * @param segmentosMercado
     */
    public void setSegmentosMercado(cl.movistar.ofertador.dto.detalleoferta.SegmentoMercado[] segmentosMercado) {
        this.segmentosMercado = segmentosMercado;
    }


    /**
     * Gets the subFamilia value for this DetalleOferta.
     * 
     * @return subFamilia
     */
    public java.lang.String getSubFamilia() {
        return subFamilia;
    }


    /**
     * Sets the subFamilia value for this DetalleOferta.
     * 
     * @param subFamilia
     */
    public void setSubFamilia(java.lang.String subFamilia) {
        this.subFamilia = subFamilia;
    }


    /**
     * Gets the tipoCargo value for this DetalleOferta.
     * 
     * @return tipoCargo
     */
    public java.lang.String getTipoCargo() {
        return tipoCargo;
    }


    /**
     * Sets the tipoCargo value for this DetalleOferta.
     * 
     * @param tipoCargo
     */
    public void setTipoCargo(java.lang.String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }


    /**
     * Gets the tipoDestino value for this DetalleOferta.
     * 
     * @return tipoDestino
     */
    public java.lang.String getTipoDestino() {
        return tipoDestino;
    }


    /**
     * Sets the tipoDestino value for this DetalleOferta.
     * 
     * @param tipoDestino
     */
    public void setTipoDestino(java.lang.String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }


    /**
     * Gets the tipoOferta value for this DetalleOferta.
     * 
     * @return tipoOferta
     */
    public java.lang.String getTipoOferta() {
        return tipoOferta;
    }


    /**
     * Sets the tipoOferta value for this DetalleOferta.
     * 
     * @param tipoOferta
     */
    public void setTipoOferta(java.lang.String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }


    /**
     * Gets the tipoVigencia value for this DetalleOferta.
     * 
     * @return tipoVigencia
     */
    public java.lang.String getTipoVigencia() {
        return tipoVigencia;
    }


    /**
     * Sets the tipoVigencia value for this DetalleOferta.
     * 
     * @param tipoVigencia
     */
    public void setTipoVigencia(java.lang.String tipoVigencia) {
        this.tipoVigencia = tipoVigencia;
    }


    /**
     * Gets the tipoVisualizacion value for this DetalleOferta.
     * 
     * @return tipoVisualizacion
     */
    public java.lang.String getTipoVisualizacion() {
        return tipoVisualizacion;
    }


    /**
     * Sets the tipoVisualizacion value for this DetalleOferta.
     * 
     * @param tipoVisualizacion
     */
    public void setTipoVisualizacion(java.lang.String tipoVisualizacion) {
        this.tipoVisualizacion = tipoVisualizacion;
    }


    /**
     * Gets the validacionRed value for this DetalleOferta.
     * 
     * @return validacionRed
     */
    public java.lang.String getValidacionRed() {
        return validacionRed;
    }


    /**
     * Sets the validacionRed value for this DetalleOferta.
     * 
     * @param validacionRed
     */
    public void setValidacionRed(java.lang.String validacionRed) {
        this.validacionRed = validacionRed;
    }


    /**
     * Gets the valorCliente value for this DetalleOferta.
     * 
     * @return valorCliente
     */
    public java.lang.String getValorCliente() {
        return valorCliente;
    }


    /**
     * Sets the valorCliente value for this DetalleOferta.
     * 
     * @param valorCliente
     */
    public void setValorCliente(java.lang.String valorCliente) {
        this.valorCliente = valorCliente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalleOferta)) return false;
        DetalleOferta other = (DetalleOferta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantidadPuntos == other.getCantidadPuntos() &&
            ((this.codigoOferta==null && other.getCodigoOferta()==null) || 
             (this.codigoOferta!=null &&
              this.codigoOferta.equals(other.getCodigoOferta()))) &&
            ((this.codigoOfertaRed==null && other.getCodigoOfertaRed()==null) || 
             (this.codigoOfertaRed!=null &&
              this.codigoOfertaRed.equals(other.getCodigoOfertaRed()))) &&
            ((this.consumo==null && other.getConsumo()==null) || 
             (this.consumo!=null &&
              this.consumo.equals(other.getConsumo()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.familia==null && other.getFamilia()==null) || 
             (this.familia!=null &&
              this.familia.equals(other.getFamilia()))) &&
            ((this.familiaridad==null && other.getFamiliaridad()==null) || 
             (this.familiaridad!=null &&
              this.familiaridad.equals(other.getFamiliaridad()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.fechaTermino==null && other.getFechaTermino()==null) || 
             (this.fechaTermino!=null &&
              this.fechaTermino.equals(other.getFechaTermino()))) &&
            ((this.horarioVenta==null && other.getHorarioVenta()==null) || 
             (this.horarioVenta!=null &&
              this.horarioVenta.equals(other.getHorarioVenta()))) &&
            ((this.idRed==null && other.getIdRed()==null) || 
             (this.idRed!=null &&
              this.idRed.equals(other.getIdRed()))) &&
            this.idUsuario == other.getIdUsuario() &&
            this.idValidacion == other.getIdValidacion() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.precios==null && other.getPrecios()==null) || 
             (this.precios!=null &&
              java.util.Arrays.equals(this.precios, other.getPrecios()))) &&
            ((this.productos==null && other.getProductos()==null) || 
             (this.productos!=null &&
              java.util.Arrays.equals(this.productos, other.getProductos()))) &&
            ((this.restricciones==null && other.getRestricciones()==null) || 
             (this.restricciones!=null &&
              this.restricciones.equals(other.getRestricciones()))) &&
            ((this.segmentosMercado==null && other.getSegmentosMercado()==null) || 
             (this.segmentosMercado!=null &&
              java.util.Arrays.equals(this.segmentosMercado, other.getSegmentosMercado()))) &&
            ((this.subFamilia==null && other.getSubFamilia()==null) || 
             (this.subFamilia!=null &&
              this.subFamilia.equals(other.getSubFamilia()))) &&
            ((this.tipoCargo==null && other.getTipoCargo()==null) || 
             (this.tipoCargo!=null &&
              this.tipoCargo.equals(other.getTipoCargo()))) &&
            ((this.tipoDestino==null && other.getTipoDestino()==null) || 
             (this.tipoDestino!=null &&
              this.tipoDestino.equals(other.getTipoDestino()))) &&
            ((this.tipoOferta==null && other.getTipoOferta()==null) || 
             (this.tipoOferta!=null &&
              this.tipoOferta.equals(other.getTipoOferta()))) &&
            ((this.tipoVigencia==null && other.getTipoVigencia()==null) || 
             (this.tipoVigencia!=null &&
              this.tipoVigencia.equals(other.getTipoVigencia()))) &&
            ((this.tipoVisualizacion==null && other.getTipoVisualizacion()==null) || 
             (this.tipoVisualizacion!=null &&
              this.tipoVisualizacion.equals(other.getTipoVisualizacion()))) &&
            ((this.validacionRed==null && other.getValidacionRed()==null) || 
             (this.validacionRed!=null &&
              this.validacionRed.equals(other.getValidacionRed()))) &&
            ((this.valorCliente==null && other.getValorCliente()==null) || 
             (this.valorCliente!=null &&
              this.valorCliente.equals(other.getValorCliente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCantidadPuntos();
        if (getCodigoOferta() != null) {
            _hashCode += getCodigoOferta().hashCode();
        }
        if (getCodigoOfertaRed() != null) {
            _hashCode += getCodigoOfertaRed().hashCode();
        }
        if (getConsumo() != null) {
            _hashCode += getConsumo().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFamilia() != null) {
            _hashCode += getFamilia().hashCode();
        }
        if (getFamiliaridad() != null) {
            _hashCode += getFamiliaridad().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getFechaTermino() != null) {
            _hashCode += getFechaTermino().hashCode();
        }
        if (getHorarioVenta() != null) {
            _hashCode += getHorarioVenta().hashCode();
        }
        if (getIdRed() != null) {
            _hashCode += getIdRed().hashCode();
        }
        _hashCode += getIdUsuario();
        _hashCode += getIdValidacion();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPrecios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrecios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrecios(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProductos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRestricciones() != null) {
            _hashCode += getRestricciones().hashCode();
        }
        if (getSegmentosMercado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSegmentosMercado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSegmentosMercado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubFamilia() != null) {
            _hashCode += getSubFamilia().hashCode();
        }
        if (getTipoCargo() != null) {
            _hashCode += getTipoCargo().hashCode();
        }
        if (getTipoDestino() != null) {
            _hashCode += getTipoDestino().hashCode();
        }
        if (getTipoOferta() != null) {
            _hashCode += getTipoOferta().hashCode();
        }
        if (getTipoVigencia() != null) {
            _hashCode += getTipoVigencia().hashCode();
        }
        if (getTipoVisualizacion() != null) {
            _hashCode += getTipoVisualizacion().hashCode();
        }
        if (getValidacionRed() != null) {
            _hashCode += getValidacionRed().hashCode();
        }
        if (getValorCliente() != null) {
            _hashCode += getValorCliente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalleOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "DetalleOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadPuntos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "cantidadPuntos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOferta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoOferta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOfertaRed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "codigoOfertaRed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consumo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "consumo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "familia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familiaridad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "familiaridad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "fechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTermino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "fechaTermino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "horarioVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "idRed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idValidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "idValidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "precios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Precio"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "productos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "Producto"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restricciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "restricciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentosMercado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "segmentosMercado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "SegmentoMercado"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.ofertador.movistar.cl", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subFamilia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "subFamilia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCargo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoCargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOferta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoOferta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoVisualizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "tipoVisualizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validacionRed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "validacionRed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://detalleoferta.dto.ofertador.movistar.cl", "valorCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
