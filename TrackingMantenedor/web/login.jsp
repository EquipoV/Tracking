<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <!--versión: 31-05-2013-->
        <meta http-equiv="Expires" content="Mon, 26 Jul 1997 05:00:00 GMT"/>
        <meta http-equiv="Last-Modified" content="Sun, 25 Jul 2004 16:12:09 GMT"/>
        <meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
        <meta http-equiv="Pragma" content="nocache"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Tracking</title>
        <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>        
        <script type="text/javascript" src="js/accounting.min.js"></script>
        <script type="text/javascript" src="js/handlebars-1.0.rc.1.min.js"></script>
        <link rel="stylesheet"  type="text/css" href="css/style_css_Tracking.css"/>
        <link rel="stylesheet" type="text/css" href="css/cssJQueryUI_-v1.10.css"/>
        <script type="text/javascript">
            $.ajaxSetup({cache: false});
            var viewManager = viewManager || {};
            var interfazServicios = interfazServicios || {};
            var global = global || {};
            var helpers = helpers || {};
            $(document).ready(function() {
                viewManager.variablesGlobales();
                viewManager.eventosClickFunctions();
            });
        </script>
        <script type="text/javascript" charset="UTF-8" src="js/variablesGlobal.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/tracking_Jquery_Function.js"></script>
    </head>
    <!--        <body class="body" oncontextmenu="return false">-->
    <body class="body"> 
        <img src="img/logo_unifica.jpg" class="imagen_telefonica"/>
        <div style="text-align: right; color: white; font-size: 12px;">v. (0207.1)</div>
        <div class="titulo_cabecera_DV">
            Tracking
        </div>
        <div class="pantallaAutentificadora">
            <div class="tituloPantallaInicio">
                <label class="tituloInicioSesion">INICIO SESIÓN</label>
            </div>
            <div class="contenidoPantallaIdentificacion">
                <label>Rut usuario:</label><input type="text" class="textoUsuario" id="textoUsuario"/><br/>
                <label>Contraseña:</label><input type="password" class="textoContrasena" id="textoContrasena"/>
            </div>
            <input type="button" class="btnIngresarSesion" id="btnIngresarSesion" value="Ingresar"/>
        </div>
        <div class="contenidoGeneralTRacking">
            <div class="contenidoMenuIzquierdo">
                <div class="tituloMenuIzquierdoVerde">
                    <label>EVENTO NEGOCIO</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoEventoNegocio', 'seccionAgregarEventoNegocio', 1);">Crear nuevo Evento Negocio</label>
                </div>
                <div class="tituloMenuIzquierdoGris" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoEventoNegocio', 'contenidoListaEventoNegocio', 2);">
                    <label name="seleccionDeEventoMenu">Listar Evento Negocios</label>
                </div>
                <div class="tituloMenuIzquierdoVerde">
                    <label>EVENTO SISTEMA</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoEventoSistema', 'seccionAgregarEventoSistema', 1);">Crear nuevo Evento Sistema</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoEventoSistema', 'contenidoListaEventoSistema', 2);">Listar Evento Sistemas</label>
                </div>
                <div class="tituloMenuIzquierdoVerde">
                    <label>CANAL</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoCanal', 'seccionAgregarCanal', 1);">Crear nuevo Canal</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoCanal', 'seccionListarCanal', 2);">Listar Canales</label>
                </div>
                <div class="tituloMenuIzquierdoVerde">
                    <label>ACCION NEGOCIO</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoAccionNegocio', 'seccionAgregarAccionNegocio', 1);">Crear nuevo Accion Negocio</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoAccionNegocio', 'contenidoListaAccionNegocio', 2);">Listar Accion Negocios</label>
                </div>
                <div class="tituloMenuIzquierdoVerde">
                    <label>ACCION SISTEMA</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoAccionSistema', 'seccionAgregarAccionSistema', 1);">Crear nuevo Accion Sistema</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoAccionSistema', 'contenidoListaAccionSistema', 2);">Listar Accion Sistemas</label>
                </div>
                <div class="tituloMenuIzquierdoVerde">
                    <label>EVENTOS TRACKING</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoControlEventos', 'seccionAgregarControlEventos', 1);">Crear nuevo Evento Tracking</label>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoControlEventos', 'contenidoListaControlEventos', 2);">Listar Eventos Tracking</label>
                </div>
             
            </div>
            <div class="contenidoMantenedorTracking">
                <div class="inicioContenidoTracking" id="inicioContenidoTracking" name="ocultar">
                    <div class="tituloInicioContenidoTracking">
                        Bienvenido a Tracking
                    </div>
                    <div>
                        Bienvenido a Tracking
                        Sistema de manejo de acciones de negocio por eventos de sistema
                    </div>
                </div>
                <div class="contenidoEventoNegocio" id="contenidoEventoNegocio" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR EVENTO NEGOCIO</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR EVENTO NEGOCIO</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>MODIFICAR EVENTO NEGOCIO</label></div>
                    <div class="seccionAgregarEventoNegocio" id="seccionAgregarEventoNegocio" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoEventoNegocio">Codigo</label><input id="codigoCrearEventoNegocio" class="codigoCrearEventoNegocio" type="text" maxlength="5"/><br/>
                            <label class="labelDescripcionEventoNegocio">Descripcion</label><input id="descripcionCrearEventoNegocio" class="descripcionCrearEventoNegocio" maxlength="100" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreEventoNegocio">Nombre</label><input id="nombreCrearEventoNegocio" maxlength="100" class="nombreCrearEventoNegocio" type="text"/><br/>
                            <label class="labelAccionNegocio">Acciones Negocio</label>
                            <select id="listaAccionesCrearEventoNegocio" class="listaAccionesCrearEventoNegocio" type="text">
                            </select>
                            <input type="button" class="btnAgregarAccionDeNegocio" id="btnAgregarAccionDeNegocio" value="Agregar Accion"/>
                        </div>
                        <div class="ventanaAccionesNegocioSeleccionadas" id="ventanaAccionesNegocioSeleccionadas">
                        </div>
                    </div>
                    <div class="seccionAgregarEventoNegocio" id="seccionActualizarEventoNegocio" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoEventoNegocio">Codigo</label><input id="codigoActualizarEventoNegocio" class="codigoCrearEventoNegocio" type="text" readonly/><br/>
                            <label class="labelDescripcionEventoNegocio">Descripcion</label><input id="descripcionActualizarEventoNegocio" maxlength="100" class="descripcionCrearEventoNegocio" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreEventoNegocio">Nombre</label><input id="nombreActualizarEventoNegocio" maxlength="100" class="nombreCrearEventoNegocio" type="text"/><br/>
                            <label class="labelAccionNegocio">Acciones Negocio</label>
                            <select id="listaAccionesActualizarEventoNegocio" class="listaAccionesCrearEventoNegocio" type="text">
                            </select>
                            <input type="button" class="btnAgregarAccionDeNegocio" id="btnActualizarAccionDeNegocio" value="Agregar Accion"/>
                        </div>
                        <div class="ventanaAccionesNegocioSeleccionadas" id="ventanaActualizarAccionesNegocioSeleccionadas">
                        </div>
                    </div>
                    <div class="contenidoListaEventoNegocio" id="contenidoListaEventoNegocio" name="ocultar">
                        <div class="contenedorTablaEvento" id="contenedorTablaEventoNegocio">
                        </div>
                    </div>
                </div>
                <div class="contenidoEventoSistema" id="contenidoEventoSistema" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR EVENTO SISTEMA</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR EVENTO SISTEMA</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>MODIFICAR EVENTO SISTEMA</label></div>
                    <div class="seccionAgregarEventoSistema" id="seccionAgregarEventoSistema" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoEventoSistema">Codigo</label><input id="codigoCrearEventoSistema" class="codigoCrearEventoSistema" type="text" maxlength="5"/><br/> 
                            <label class="labelDescripcionEventoSistema">Descripcion</label><input id="descripcionCrearEventoSistema" maxlength="100" class="descripcionCrearEventoSistema" type="text"/><br/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreEventoSistema">Nombre</label><input id="nombreCrearEventoSistema" maxlength="100" class="nombreCrearEventoSistema" type="text"/><br/>
                            <label class="labelAccionNegosioEventoSistema">Acciones Sistema</label>
                            <select id="listaAccionesCrearEventoSistema" class="listaAccionesCrearEventoSistema" type="text">                       
                            </select>
                            <input type="button" class="btnAgregarAccionDeSistema" id="btnAgregarAccionDeSistema" value="Agregar Accion"/>
                        </div>
                        <div class="ventanaAccionesSistemasSeleccionadas" id="ventanaAccionesSistemasSeleccionadas">

                        </div>
                    </div>
                    <div class="seccionAgregarEventoSistema" id="seccionActualizarEventoSistema" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoEventoSistema">Codigo</label><input id="codigoActualizarEventoSistema" class="codigoCrearEventoSistema" type="text" readonly/><br/> 
                            <label class="labelDescripcionEventoSistema">Descripcion</label><input maxlength="100" id="descripcionActualizarEventoSistema" class="descripcionCrearEventoSistema" type="text"/><br/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreEventoSistema">Nombre</label><input maxlength="100" id="nombreActualizarEventoSistema" class="nombreCrearEventoSistema" type="text"/><br/>
                            <!--<select id="listaCanalActualizarEventoSistema" class="listaCanalCrearEventoSistema" type="text"></select><br/>-->
                            <label class="labelAccionNegosioEventoSistema">Acciones Sistema</label>
                            <select id="listaAccionesActualizarEventoSistema" class="listaAccionesCrearEventoSistema" type="text">
                            </select>
                            <input type="button" class="btnAgregarAccionDeSistema" id="btnActualizarAccionDeSistema" value="Agregar Accion"/>
                        </div>
                        <div class="ventanaAccionesSistemasSeleccionadas" id="ventanaActualizarEventoSistemasSeleccionadas">
                            
                        </div>
                    </div>
                    <div class="contenidoListaEventoSistema" id="contenidoListaEventoSistema" name="ocultar">
                        <div class="contenedorTablaEvento" id="contenedorListarTablaEventoSistema">
                        </div>
                    </div>
                </div>
                <div class="contenidoCanal" id="contenidoCanal" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR NUEVO CANAL</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR CANALES</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>ACTUALIZAR CANAL</label></div>
                    <div class="seccionAgregarCanal" id="seccionAgregarCanal" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoCanal">Codigo</label><input id="codigoCrearCanal" class="codigoCrearCanal" type="text" maxlength="5" />
                            <label class="labelDescripcionCanal">Descripcion</label><input id="descripcionCrearCanal" class="descripcionCrearCanal" maxlength="100" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreCanal">Nombre</label><input id="nombreCrearCanal" maxlength="100" class="nombreCrearCanal" type="text"/>
                        </div>
                    </div>
                    <div class="seccionActualizaCanal" id="seccionActualizaCanal" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoCanal">Codigo</label><input id="codigoActualizaCanal" class="codigoCrearCanal" type="text" readonly/>
                            <label class="labelDescripcionCanal">Descripcion</label><input id="descripcionActualizaCanal" class="descripcionCrearCanal" maxlength="100" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreCanal">Nombre</label><input id="nombreActualizaCanal" class="nombreCrearCanal" maxlength="100" type="text"/>
                        </div>
                    </div>
                    <div class="seccionListarCanal" id="seccionListarCanal" name="ocultar">
                        <div class="contenedorTablaEvento" id="listadoCanales">
                            <!--<table class="tablaEvento"  id="listadoCanales" cellspacing="0" cellpadding="0"></table>-->
                        </div>
                    </div>
                </div>
                <div class="contenidoAccionNegocio" id="contenidoAccionNegocio" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR NUEVA ACCION NEGOCIO</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR ACCION NEGOCIO</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>ACTUALIZAR ACCION NEGOCIO</label></div>
                    <div class="seccionAgregarAccionNegocio" id="seccionAgregarAccionNegocio" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoAccionNegocio">Codigo</label><input id="codigoCrearAccionNegocio" class="codigoCrearAccionNegocio" type="text"/> 
                            <label class="labelDescripcionAccionNegocio">Descripcion</label><input id="descripcionCrearAccionNegocio" class="descripcionCrearAccionNegocio" type="text"/>
                            <label class="labelDataAccionSistema">Data</label>
                            <input id="dataCrearAccionNegocio" class="dataCrearAccionSistema" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreAccionNegocio">Nombre</label><input id="nombreCrearAccionNegocio" class="nombreCrearAccionNegocio" type="text"/>
                            <label class="labelTipoAccionNegocio">Tipo</label>
                            <!--<input id="tipoCrearAccionNegocio" class="tipoCrearAccionNegocio" type="text"/>-->
                            <select id="tipoCrearAccionNegocio" class="tipoCrearAccionNegocio" type="text">
                                <option value="0">Seleccione Tipo</option>
                                <option value="FIN">Fin</option>
                                <option value="WebServices Provision Baja">Baja</option>
                                <option value="WebServices Provision con confirmacion">Alta c/confirmacion</option>
                                <option value="WebServices Provision sin confirmacion">Alta s/confirmacion</option>
                                <option value="WebServices Parque Alta">Alta Parque Cliente</option>
                                <option value="WebServices Parque Baja">Baja Parque Cliente</option>
                            </select>   
                        </div>
                    </div>
                    <div class="seccionActualizaAccionNegocio" id="seccionActualizaAccionNegocio" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoAccionNegocio">Codigo</label><input id="codigoActualizaAccionNegocio" class="codigoCrearAccionNegocio" type="text" readonly/> 
                            <label class="labelDescripcionAccionNegocio">Descripcion</label><input id="descripcionActualizaAccionNegocio" class="descripcionCrearAccionNegocio" type="text"/>
                            <label class="labelDataAccionSistema">Data</label>
                            <input id="dataActualizarAccionNegocio" class="dataCrearAccionSistema" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreAccionNegocio">Nombre</label><input id="nombreActualizaAccionNegocio" class="nombreCrearAccionNegocio" type="text"/>
                            <label class="labelTipoAccionNegocio">Tipo</label>
                            <!--<input id="tipoActualizaAccionNegocio" class="tipoCrearAccionNegocio" type="text"/>-->
                            <select id="tipoActualizaAccionNegocio" class="tipoCrearAccionNegocio" type="text">
                                <option value="0">Seleccione Tipo</option>
                                <option value="FIN">Fin</option>
                                <option value="WebServices Provision">Provisionador</option>
                                <option value="WebServices Parque">Parque Cliente</option>
                                <option value="WebServices Provision con confirmacion">Provisionador c/confirmacion</option>
                                <option value="WebServices Provision sin confirmacion">Provisionador s/confirmacion</option>
                            </select>   
                        </div>
                    </div>
                    <div class="contenidoListaAccionNegocio" id="contenidoListaAccionNegocio" name="ocultar">
                        <div class="contenedorTablaEvento" id="listadoAccionNegocio"></div>
                    </div>
                </div>
                <div class="contenidoAccionSistema" id="contenidoAccionSistema" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR NUEVO ACCION DE SISTEMA</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR ACCION SISTEMA</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>ACTUALIZAR ACCION SISTEMA</label></div>
                    <div class="seccionAgregarAccionSistema" id="seccionAgregarAccionSistema" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoAccionSistema">Codigo</label><input id="codigoCrearAccionSistema" class="codigoCrearAccionSistema" type="text" maxlength="5"/>
                            <label class="labelDescripcionAccionSistema">Descripcion</label><input id="descripcionCrearAccionSistema" class="descripcionCrearAccionSistema" maxlength="100" type="text"/>
                            <label class="labelDataAccionSistema">Data</label>
                            <!--<input id="dataCrearAccionSistema" class="dataCrearAccionSistema" type="text"/>-->
                            <select id="dataCrearAccionSistema" class="dataCrearAccionSistema" type="text">
                                <option value="0">Seleccione Data</option>
                                <option value="movimientos_tracking">Movimientos Tracking</option>
                                <option value="cambio_umbral">Cambio Umbral</option>
                                <option value="bitacora_recurrencia">Bitacora Recurrencia</option>
                                <option value="venta_bolsa">Venta Bolsa</option>
                                
                            </select>   
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreAccionSistema">Nombre</label><input id="nombreCrearAccionSistema" maxlength="100" class="nombreCrearAccionSistema" type="text" maxlength="5"/>
                            <label class="labelTipoAccionSistema">Tipo</label>
                            <!--<input id="tipoCrearAccionSistema" class="tipoCrearAccionSistema" type="text"/>--> 
                            <select id="tipoCrearAccionSistema" class="tipoCrearAccionSistema" type="text">
                                <option value="0">Seleccione Tipo</option>
                                <option value="Base datos">Base datos</option>
                            </select>   
                        </div>
                    </div>
                    <div class="seccionActualizarAccionSistema" id="seccionActualizarAccionSistema" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoAccionSistema">Codigo</label><input id="codigoActualizarAccionSistema" class="codigoCrearAccionSistema" type="text" readonly/>
                            <label class="labelDescripcionAccionSistema">Descripcion</label><input id="descripcionActualizarAccionSistema" class="descripcionCrearAccionSistema" type="text" maxlength="100"/>
                            <label class="labelDataAccionSistema">Data</label>
                            <!--<input id="dataActualizarAccionSistema" class="dataCrearAccionSistema" type="text"/>-->
                            <select id="dataActualizarAccionSistema" class="dataCrearAccionSistema" type="text">
                                <option value="0">Seleccione Data</option>
                                <option value="movimientos_tracking">Movimientos Tracking</option>
                                <option value="cambio_umbral">Cambio Umbral</option>
                                <option value="bitacora_recurrencia">Bitacora Recurrencia</option>
                                <option value="venta_bolsa">Venta Bolsa</option>
                            </select>   
                            
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreAccionSistema">Nombre</label><input id="nombreActualizarAccionSistema" class="nombreCrearAccionSistema" type="text" maxlength="100"/>
                            <label class="labelTipoAccionSistema">Tipo</label>
                            <!--<input id="tipoActualizarAccionSistema" class="tipoCrearAccionSistema" type="text"/>--> 
                            <select id="tipoActualizarAccionSistema" class="tipoCrearAccionSistema" type="text">
                                <option value="0">Seleccione Tipo</option>
                                <option value="Base datos">Base datos</option>
                                
                            </select>   
                        </div>
                    </div>
                    <div class="contenidoListaAccionSistema" id="contenidoListaAccionSistema" name="ocultar">
                        <div class="contenedorTablaEvento" id="listadoAccionSistema">
                       
                        </div>
                    </div>
                </div>
                <div class="contenidoControlEventos" id="contenidoControlEventos" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR NUEVO EVENTO TRACKING</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR EVENTOS TRACKING</label></div>
                    <div class="tituloEvento3" name="ocultar"><label>ACTUALIZAR EVENTO TRACKING</label></div>
                    <div class="seccionAgregarControlEventos" id="seccionAgregarControlEventos" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoControlEventos">Codigo</label><input id="codigoCrearControlEventos" class="codigoCrearControlEventos" type="text" maxlength="5"/>
                            <label class="labelDescripcionControlEventos">Nombre</label><input id="nombreCrearControlEventos" class="descripcionCrearControlEventos" type="text" maxlength="100"/>
                            <label class="labelControlEventosSistema">Descripcion</label><input id="descripcionCrearControlEventos" class="eventoSistemaControlEventos" type="text" maxlength="100"/>
                            
                        </div>
                        <div class="divisionSeccionCrearControlEventos">
                            <label class="labelNombreControlEventos">Evento Sistema</label><!--<label class="labelControlEventosSistema">Evento Sistema</label><input id="eventoSistemaControlEventos" class="eventoSistemaControlEventos" type="text"/>-->
                            <select id="listaEventosSistema" class="nombreCrearControlEventos" type="text"></select>                       
                            <label class="labelEventoNegocioControlEventos">Evento Negocio</label><!--<label class="labelEventoNegocioControlEventos">Evento Negocio</label><input id="eventoNegocioControlEventos" class="eventoNegocioControlEventos" type="text"/>--> 
                            <select id="listaEventosNegocio" class="eventoNegocioControlEventos" type="text"></select>
                            <label class="labelCanalControlEventos">Canal</label><!--<label class="labelEventoNegocioControlEventos">Evento Negocio</label><input id="eventoNegocioControlEventos" class="eventoNegocioControlEventos" type="text"/>--> 
                            <select id="listaCanalesEventosTracking" class="canalControlEventos" type="text"></select>
                        </div>
                    </div>
                    <div class="seccionAgregarControlEventos" id="seccionActualizarControlEventos" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoControlEventos">Codigo</label><input id="codigoActualizarControlEventos" class="codigoCrearControlEventos" type="text" readonly/>
                            <label class="labelDescripcionControlEventos">Nombre</label><input id="nombreActualizarControlEventos" class="descripcionCrearControlEventos" maxlength="100" type="text"/>
                            <label class="labelControlEventosSistema">Descripcion</label><input id="descripcionActualizarControlEventos" class="eventoSistemaControlEventos" maxlength="100"type="text"/>
                            
                        </div>
                        <div class="divisionSeccionCrearControlEventos">
                            <label class="labelNombreControlEventos">Evento Sistema</label><!--<label class="labelControlEventosSistema">Evento Sistema</label><input id="eventoSistemaControlEventos" class="eventoSistemaControlEventos" type="text"/>-->
                            <select id="listaEventosSistemaActualizar" class="nombreCrearControlEventos" type="text"></select>                       
                            <label class="labelEventoNegocioControlEventos">Evento Negocio</label><!--<label class="labelEventoNegocioControlEventos">Evento Negocio</label><input id="eventoNegocioControlEventos" class="eventoNegocioControlEventos" type="text"/>--> 
                            <select id="listaEventosNegocioActualizar" class="eventoNegocioControlEventos" type="text"></select>
                            <label class="labelCanalControlEventos">Canal</label><!--<label class="labelEventoNegocioControlEventos">Evento Negocio</label><input id="eventoNegocioControlEventos" class="eventoNegocioControlEventos" type="text"/>--> 
                            <select id="listaCanalesEventosTrackingActualizar" class="canalControlEventos" type="text"></select>
                        </div>
                    </div>
                    <div class="contenidoListaControlEventos" id="contenidoListaControlEventos" name="ocultar">
                       
<!--                        <div class="contenedorTablaEvento">
                       
                        </div>-->
                    </div>
                </div>
                <input type="button" value="Ingresar Evento" id="btnIngresarEvento1" class="btnIngresarEvento" name="btnIngresarEvento1" onclick="viewManager.realizaAccion();"/>
                <div class="contenidoTriggerEventoNegocio">
                    <div>

                    </div>
                    <div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
