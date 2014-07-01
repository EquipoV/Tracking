<%@ taglib prefix="s" uri="/struts-tags"%>
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
        <link rel="stylesheet" type="text/css" href="css/style_css_Tracking.css"/>
        <link rel="stylesheet" type="text/css" href="css/cssJQueryUI_-v1.10.css"/>
        <script type="text/javascript">
            $.ajaxSetup({cache: false});
            var viewManager = viewManager || {};
            var interfazServicios = interfazServicios || {};
            var global = global || {};
            var helpers = helpers || {};
            $(document).ready(function() {
                alert("hola");
                
            });
        </script>
<!--        <script type="text/javascript" src="js/variablesGlobal.js"></script>
        <script type="text/javascript" src="js/tracking_Jquery_Function.js"></script>-->
    </head>
    <!--        <body class="body" oncontextmenu="return false">-->
    <body class="body"> 
        <img src="img/logo_unifica.jpg" class="imagen_telefonica"/>
        <div class="titulo_cabecera_DV">
            Tracking
        </div>
        <div class="pantallaAutentificadora">
            <div class="tituloPantallaInicio">
                <label class="tituloInicioSesion">INICIO SESIÓN</label>
            </div>
            <div class="contenidoPantallaIdentificacion">
                <label>Rut usuario: <s:property value="rut" /></label><input type="text" class="textoUsuario" id="textoUsuario"/><br/>
                <label>Contraseña: </label><input type="password" class="textoContrasena" id="textoContrasena"/>
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
                    <label>CONTROL EVENTOS</label>
                </div>
                <div class="tituloMenuIzquierdoGrisAncho" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoControlEventos', 'seccionAgregarControlEventos', 1);">
                    <div class="separacionTextoLargo1"><label name="seleccionDeEventoMenu">Crear nuevo Trigger Evento</label></div>
                    <div class="separacionTextoLargo2"><label name="seleccionDeEventoMenu">Sistema</label></div>
                </div>
                <div class="tituloMenuIzquierdoGris">
                    <label name="seleccionDeEventoMenu" onclick="viewManager.funcionesMenuMostrarOcultarEventos('contenidoControlEventos', 'contenidoListaControlEventos', 2);">Listar Trigger Evento Sistemas</label>
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
                            <label class="labelCodigoEventoNegocio">Codigo</label><input id="codigoCrearEventoNegocio" class="codigoCrearEventoNegocio" type="text"/><br/>
                            <label class="labelDescripcionEventoNegocio">Descripcion</label><input id="descripcionCrearEventoNegocio" class="descripcionCrearEventoNegocio" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreEventoNegocio">Nombre</label><input id="nombreCrearEventoNegocio" class="nombreCrearEventoNegocio" type="text"/><br/>
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
                            <label class="labelDescripcionEventoNegocio">Descripcion</label><input id="descripcionActualizarEventoNegocio" class="descripcionCrearEventoNegocio" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreEventoNegocio">Nombre</label><input id="nombreActualizarEventoNegocio" class="nombreCrearEventoNegocio" type="text"/><br/>
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
                            <label class="labelCodigoEventoSistema">Codigo</label><input id="codigoCrearEventoSistema" class="codigoCrearEventoSistema" type="text"/><br/> 
                            <label class="labelDescripcionEventoSistema">Descripcion</label><input id="descripcionCrearEventoSistema" class="descripcionCrearEventoSistema" type="text"/><br/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreEventoSistema">Nombre</label><input id="nombreCrearEventoSistema" class="nombreCrearEventoSistema" type="text"/><br/>
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
                            <label class="labelDescripcionEventoSistema">Descripcion</label><input id="descripcionActualizarEventoSistema" class="descripcionCrearEventoSistema" type="text"/><br/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreEventoSistema">Nombre</label><input id="nombreActualizarEventoSistema" class="nombreCrearEventoSistema" type="text"/><br/>
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
                            <label class="labelCodigoCanal">Codigo</label><input id="codigoCrearCanal" class="codigoCrearCanal" type="text"/>
                            <label class="labelDescripcionCanal">Descripcion</label><input id="descripcionCrearCanal" class="descripcionCrearCanal" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreCanal">Nombre</label><input id="nombreCrearCanal" class="nombreCrearCanal" type="text"/>
                        </div>
                    </div>
                    <div class="seccionActualizaCanal" id="seccionActualizaCanal" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoCanal">Codigo</label><input id="codigoActualizaCanal" class="codigoCrearCanal" type="text" readonly/>
                            <label class="labelDescripcionCanal">Descripcion</label><input id="descripcionActualizaCanal" class="descripcionCrearCanal" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreCanal">Nombre</label><input id="nombreActualizaCanal" class="nombreCrearCanal" type="text"/>
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
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreAccionNegocio">Nombre</label><input id="nombreCrearAccionNegocio" class="nombreCrearAccionNegocio" type="text"/>
                            <label class="labelTipoAccionNegocio">Tipo</label><input id="tipoCrearAccionNegocio" class="tipoCrearAccionNegocio" type="text"/>
                        </div>
                    </div>
                    <div class="seccionActualizaAccionNegocio" id="seccionActualizaAccionNegocio" name="ocultar">
                        <div class="divisionSeccionCrearEventoIzquierdo">
                            <label class="labelCodigoAccionNegocio">Codigo</label><input id="codigoActualizaAccionNegocio" class="codigoCrearAccionNegocio" type="text" readonly/> 
                            <label class="labelDescripcionAccionNegocio">Descripcion</label><input id="descripcionActualizaAccionNegocio" class="descripcionCrearAccionNegocio" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoDerecho">
                            <label class="labelNombreAccionNegocio">Nombre</label><input id="nombreActualizaAccionNegocio" class="nombreCrearAccionNegocio" type="text"/>
                            <label class="labelTipoAccionNegocio">Tipo</label><input id="tipoActualizaAccionNegocio" class="tipoCrearAccionNegocio" type="text"/>
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
                            <label class="labelCodigoAccionSistema">Codigo</label><input id="codigoCrearAccionSistema" class="codigoCrearAccionSistema" type="text"/>
                            <label class="labelDescripcionAccionSistema">Descripcion</label><input id="descripcionCrearAccionSistema" class="descripcionCrearAccionSistema" type="text"/>
                            <label class="labelDataAccionSistema">Data</label><input id="dataCrearAccionSistema" class="dataCrearAccionSistema" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreAccionSistema">Nombre</label><input id="nombreCrearAccionSistema" class="nombreCrearAccionSistema" type="text"/>
                            <label class="labelTipoAccionSistema">Tipo</label><input id="tipoCrearAccionSistema" class="tipoCrearAccionSistema" type="text"/> 
                        </div>
                    </div>
                    <div class="seccionActualizarAccionSistema" id="seccionActualizarAccionSistema" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoAccionSistema">Codigo</label><input id="codigoActualizarAccionSistema" class="codigoCrearAccionSistema" type="text" readonly/>
                            <label class="labelDescripcionAccionSistema">Descripcion</label><input id="descripcionActualizarAccionSistema" class="descripcionCrearAccionSistema" type="text"/>
                            <label class="labelDataAccionSistema">Data</label><input id="dataActualizarAccionSistema" class="dataCrearAccionSistema" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearEventoSisDerecho">
                            <label class="labelNombreAccionSistema">Nombre</label><input id="nombreActualizarAccionSistema" class="nombreCrearAccionSistema" type="text"/>
                            <label class="labelTipoAccionSistema">Tipo</label><input id="tipoActualizarAccionSistema" class="tipoCrearAccionSistema" type="text"/> 
                        </div>
                    </div>
                    <div class="contenidoListaAccionSistema" id="contenidoListaAccionSistema" name="ocultar">
                        <!--                        <div class="contenidoBuscarEvento">
                                                    <input type="text" class="textoBuscarCodigoTabEvento"/><input type="button" class="btnBuscarCodEvento" value="Buscar Codigo Evento"/>
                                                </div>-->
                        <div class="contenedorTablaEvento" id="listadoAccionSistema">
                            <!--                            <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="tdTablaEvento1">Codigo</td>
                                                                <td class="tdTablaEvento2">23425</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Nombre</td>
                                                                <td class="tdTablaEvento2">fsdfsfs</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Descripcion</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Tipo</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Data</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                        </table> 
                                                        <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="tdTablaEvento1">Codigo</td>
                                                                <td class="tdTablaEvento2">23425</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Nombre</td>
                                                                <td class="tdTablaEvento2">fsdfsfs</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Descripcion</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Tipo</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Data</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                        </table>
                                                        <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="tdTablaEvento1">Codigo</td>
                                                                <td class="tdTablaEvento2">23425</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Nombre</td>
                                                                <td class="tdTablaEvento2">fsdfsfs</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Descripcion</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Tipo</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tdTablaEvento1">Data</td>
                                                                <td class="tdTablaEvento2">wrgergergergergerger</td>
                                                            </tr>
                                                        </table>-->
                        </div>
                    </div>
                </div>
                <div class="contenidoControlEventos" id="contenidoControlEventos" name="ocultar">
                    <div class="tituloEvento1" name="ocultar"><label>CREAR NUEVO CONTROL DE EVENTO</label></div>
                    <div class="tituloEvento2" name="ocultar"><label>LISTAR CONTROL DE EVENTO SISTEMA</label></div>
                    <div class="seccionAgregarControlEventos" id="seccionAgregarControlEventos" name="ocultar">
                        <div class="divisionSeccionCrearEventoSisIzquierdo">
                            <label class="labelCodigoControlEventos">Codigo</label><input id="codigoCrearControlEventos" class="codigoCrearControlEventos" type="text"/>
                            <label class="labelDescripcionControlEventos">Descripcion</label><input id="descripcionCrearControlEventos" class="descripcionCrearControlEventos" type="text"/>
                            <label class="labelControlEventosSistema">Evento Sistema</label><input id="eventoSistemaControlEventos" class="eventoSistemaControlEventos" type="text"/>
                        </div>
                        <div class="divisionSeccionCrearControlEventos">
                            <label class="labelNombreControlEventos">Nombre</label><input id="nombreCrearControlEventos" class="nombreCrearControlEventos" type="text"/>
                            <label class="labelEventoNegocioControlEventos">Evento Negocio</label><input id="eventoNegocioControlEventos" class="eventoNegocioControlEventos" type="text"/> 
                        </div>
                    </div>
                    <div class="contenidoListaControlEventos" id="contenidoListaControlEventos" name="ocultar">
                        <div class="contenidoBuscarEvento">
                            <input type="text" class="textoBuscarCodigoTabEvento"/><input type="button" class="btnBuscarCodEvento" value="Buscar Codigo Evento"/>
                        </div>
                        <div class="contenedorTablaEvento">
                            <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td class="tdTablaEvento1">Codigo</td>
                                    <td class="tdTablaEvento2">23425</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Nombre</td>
                                    <td class="tdTablaEvento2">fsdfsfs</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Descripcion</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Sistema</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Negocio</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                            </table> 
                            <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td class="tdTablaEvento1">Codigo</td>
                                    <td class="tdTablaEvento2">23425</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Nombre</td>
                                    <td class="tdTablaEvento2">fsdfsfs</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Descripcion</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Sistema</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Negocio</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                            </table> 
                            <table class="tablaEvento" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td class="tdTablaEvento1">Codigo</td>
                                    <td class="tdTablaEvento2">23425</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Nombre</td>
                                    <td class="tdTablaEvento2">fsdfsfs</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Descripcion</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Sistema</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                                <tr>
                                    <td class="tdTablaEvento1">Evento Negocio</td>
                                    <td class="tdTablaEvento2">wrgergergergergerger</td>
                                </tr>
                            </table> 
                        </div>
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
