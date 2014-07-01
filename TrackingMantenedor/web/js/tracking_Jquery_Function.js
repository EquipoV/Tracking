viewManager.iniciarSesion = function() {
    var rut = $("#textoUsuario").val();
    var contrasena = $("#textoContrasena").val();
    var params = {};
    params.rut = rut;
    params.contrasena = contrasena;
    $.getJSON("inicioSesion", params, function(data) {
        if (data.login == true) {
            $(".pantallaAutentificadora").css("display", "none");
            $(".contenidoGeneralTRacking").css("display", "block");
        } else {
            alert("Usuario o contraseña incorrecto ");
        }
    });

};


viewManager.funcionesMenuMostrarOcultarEventos = function(idMenu, tipo, numTitulo) {
    var idEvento = idMenu.toString();
    var idTipoEvento = tipo.toString();
    $("div [name=ocultar]").css("display", "none");
    $(".tituloEvento" + numTitulo + "").css("display", "block");
    $("#" + idEvento + "").css("display", "block");
    $("#" + idTipoEvento + "").css("display", "block");
    if (numTitulo == 1) {
        $("#btnIngresarEvento1").val("Crear");
        $("#btnIngresarEvento" + numTitulo + "").css("display", "block");
    } else if (numTitulo == 2) {
        $("#btnIngresarEvento1").css("display", "none");
    } else if (numTitulo == 3) {
        $("#btnIngresarEvento1").val("Actualizar");
        $("#btnIngresarEvento1").css("display", "block");
    }

    //seccionAgregarEventoNegocio
    global.accion = tipo;
    if (global.accion == "seccionAgregarEventoNegocio") {
        $("#ventanaAccionesNegocioSeleccionadas").empty();
        $("#ventanaActualizarAccionesNegocioSeleccionadas").empty();
        viewManager.llamarServicioListarCombo("listaAccionNegocio", $("#listaAccionesCrearEventoNegocio"), "Seleccione una accion");
    } else if (global.accion == "contenidoListaEventoNegocio") {
        $("#ventanaAccionesNegocioSeleccionadas").empty();
        $("#ventanaActualizarAccionesNegocioSeleccionadas").empty();
        viewManager.llamarServicioListarEventos("listaEventoNegocio", "El Evento Negocio");
    } else if (global.accion == "seccionActualizarEventoNegocio") {
        viewManager.llamarServicioListarCombo("listaAccionNegocio", $("#listaAccionesActualizarEventoNegocio"), "Seleccione una accion");
    } else if (global.accion == "seccionAgregarEventoSistema") {
        $("#ventanaAccionesSistemasSeleccionadas").empty();
        $("#ventanaActualizarEventoSistemasSeleccionadas").empty();
        viewManager.llamarServicioListarCombo("listaAccionSistema", $("#listaAccionesCrearEventoSistema"), "Seleccione una accion");
    } else if (global.accion == "contenidoListaEventoSistema") {
        $("#ventanaAccionesSistemasSeleccionadas").empty();
        $("#ventanaActualizarEventoSistemasSeleccionadas").empty();
        viewManager.llamarServicioListarEventos("listaEventoSistema", "El Evento Sistema");
    } else if (global.accion == "seccionActualizarEventoSistema") {
        viewManager.llamarServicioListarCombo("listaAccionSistema", $("#listaAccionesActualizarEventoSistema"), "Seleccione una accion");
    } else if (global.accion == "seccionListarCanal") {
        viewManager.llamarServicioListar("listaCanal", "El Canal");
    } else if (global.accion == "contenidoListaAccionNegocio") {
        viewManager.llamarServicioListar("listaAccionNegocio", "La Accion Negocio");
    } else if (global.accion == "contenidoListaAccionSistema") {
        viewManager.llamarServicioListar("listaAccionSistema", "La Accion Sistema");
    } else if (global.accion == "seccionAgregarControlEventos") {

        viewManager.llamarServicioListarCombo("listaCanal", $("#listaCanalesEventosTracking"), "Seleccione un Canal");
        viewManager.llamarServicioListarComboEventos("listaEventoSistema", $("#listaEventosSistema"), "Seleccione un Evento");
        viewManager.llamarServicioListarComboEventos("listaEventoNegocio", $("#listaEventosNegocio"), "Seleccione un Evento");
    } else if (global.accion == "contenidoListaControlEventos") {
        viewManager.llamarServicioListar("listaController", "El Evento Tracking");
    }

//viewManager.llamarServicioListarCombo("listaCanal", $("#listaCanalCrearEventoSistema"), "Seleccione un canal");

};


viewManager.realizaAccion = function() {

    if (global.accion == "seccionAgregarEventoNegocio") {
        //  alert("Evento Negocio");
        var eventoDeNegocio = {};
        eventoDeNegocio.codigo = $("#codigoCrearEventoNegocio").val();
        eventoDeNegocio.nombre = $("#nombreCrearEventoNegocio").val();
        eventoDeNegocio.descripcion = $("#descripcionCrearEventoNegocio").val();
        eventoDeNegocio.codigosAccionesNegocio = "0";
        $("#ventanaAccionesNegocioSeleccionadas label").each(function(pos, nombre) {
            var tipo = $(this).attr('id');
            //   alert(tipo.toString());
            if (pos === 0) {
                eventoDeNegocio.codigosAccionesNegocio = tipo;
            } else {
                eventoDeNegocio.codigosAccionesNegocio = eventoDeNegocio.codigosAccionesNegocio + "," + tipo;
            }
        });
        if (eventoDeNegocio.codigo == "" || eventoDeNegocio.nombre == "" || eventoDeNegocio.descripcion == "") {
            return alert("Tiene que llenar todos los campos para crear un Evento Negocio");
        } else if (eventoDeNegocio.codigosAccionesNegocio == "0") {
            return alert("Debe añadir minimo 1 accion de negocio para continuar");
        } else {
            viewManager.llamarServicioCrear("creaEventoNegocio", eventoDeNegocio, "El Evento Negocio", 'contenidoEventoNegocio', 'contenidoListaEventoNegocio');
        }

    } else if (global.accion == "seccionActualizarEventoNegocio") {
        //  alert("Evento Negocio");
        var eventoDeNegocio = {};
        eventoDeNegocio.codigo = $("#codigoActualizarEventoNegocio").val();
        eventoDeNegocio.nombre = $("#nombreActualizarEventoNegocio").val();
        eventoDeNegocio.descripcion = $("#descripcionActualizarEventoNegocio").val();
        eventoDeNegocio.codigosAccionesNegocio = "0";
        $("#ventanaActualizarAccionesNegocioSeleccionadas label").each(function(pos, nombre) {
            var tipo = $(this).attr('id');

            if (pos === 0) {
                eventoDeNegocio.codigosAccionesNegocio = tipo;
            } else {
                eventoDeNegocio.codigosAccionesNegocio = eventoDeNegocio.codigosAccionesNegocio + "," + tipo;
            }

        });

        if (eventoDeNegocio.codigo == "" || eventoDeNegocio.nombre == "" || eventoDeNegocio.descripcion == "") {
            return alert("Tiene que llenar todos los campos para crear un Evento Negocio");
        } else if (eventoDeNegocio.codigosAccionesNegocio == "0") {
            return alert("Debe añadir minimo 1 accion de negocio para continuar");
        } else {
            viewManager.llamarServicioActualizar("actualizaEventoNegocio", eventoDeNegocio, "El Evento Negocio", 'contenidoEventoNegocio', 'contenidoListaEventoNegocio');
        }
    } else if (global.accion == "seccionAgregarEventoSistema") {
        var eventoDeSistema = {};
        eventoDeSistema.codigo = $("#codigoCrearEventoSistema").val();
        eventoDeSistema.nombre = $("#nombreCrearEventoSistema").val();
        eventoDeSistema.descripcion = $("#descripcionCrearEventoSistema").val();
        eventoDeSistema.codigosAccionesSistema = "0";
        $("#ventanaAccionesSistemasSeleccionadas label").each(function(pos, nombre) {
            var tipo = $(this).attr('id');
            if (pos === 0) {
                eventoDeSistema.codigosAccionesSistema = tipo + ",";
            } else {
                eventoDeSistema.codigosAccionesSistema = eventoDeSistema.codigosAccionesSistema + tipo + ",";
            }
        });
        if (eventoDeSistema.codigo == "" || eventoDeSistema.nombre == "" || eventoDeSistema.descripcion == "") {
            return alert("Tiene que llenar todos los campos para crear una Accion de Sistema");
        } else if (eventoDeSistema.codigosAccionesSistema == "0") {
            return alert("Debe añadir minimo 1 accion de sistema para continuar");
        } else {
            viewManager.llamarServicioCrear("creaEventoSistema", eventoDeSistema, "El Evento Sistema", 'contenidoEventoSistema', 'contenidoListaEventoSistema');
        }
        $("#ventanaAccionesSistemasSeleccionadas").empty();

    } else if (global.accion == "seccionActualizarEventoSistema") {
        var eventoDeSistema = {}
        eventoDeSistema.codigo = $("#codigoActualizarEventoSistema").val();
        eventoDeSistema.nombre = $("#nombreActualizarEventoSistema").val();
        eventoDeSistema.descripcion = $("#descripcionActualizarEventoSistema").val();
        eventoDeSistema.codigosAccionesSistema = "0";
        $("#ventanaActualizarEventoSistemasSeleccionadas label").each(function(pos, nombre) {
            var tipo = $(this).attr('id');
            // alert(prueba.toString());
            if (pos === 0) {
                eventoDeSistema.codigosAccionesSistema = tipo;
            } else {
                eventoDeSistema.codigosAccionesSistema = eventoDeSistema.codigosAccionesSistema + "," + tipo;
            }
        });
        if (eventoDeSistema.codigo == "" || eventoDeSistema.nombre == "" || eventoDeSistema.descripcion == "") {
            return alert("Tiene que llenar todos los campos para actualizar una Accion de Sistema");
        } else if (eventoDeSistema.codigosAccionesSistema == "0") {
            return alert("Debe añadir minimo 1 accion de sistema para continuar");
        } else {
            viewManager.llamarServicioActualizar("actualizaEventoSistema", eventoDeSistema, "El Evento Sistema", 'contenidoEventoSistema', 'contenidoListaEventoSistema');
        }
    } else if (global.accion == "seccionAgregarCanal") {

        var codigoCanal = $("#codigoCrearCanal").val();
        var nombreCanal = $("#nombreCrearCanal").val();
        var descripcionCanal = $("#descripcionCrearCanal").val();
        if (codigoCanal == "" || nombreCanal == "" || descripcionCanal == "") {
            return alert("Tiene que llenar todos los campos para crear un canal");
        } else {
            var params = {};
            params.codigo = codigoCanal;
            params.nombre = nombreCanal;
            params.descripcion = descripcionCanal;
            viewManager.llamarServicioCrear("creaCanal", params, "El Canal", 'contenidoCanal', 'seccionListarCanal');

        }

    } else if (global.accion == "seccionActualizaCanal") {
        var codigoCanal = $("#codigoActualizaCanal").val();
        var nombreCanal = $("#nombreActualizaCanal").val();
        var descripcionCanal = $("#descripcionActualizaCanal").val();
        if (codigoCanal == "" || nombreCanal == "" || descripcionCanal == "") {
            return alert("Tiene que llenar todos los campos para actualizar un canal");
        } else {
            var params = {};
            params.codigo = codigoCanal;
            params.nombre = nombreCanal;
            params.descripcion = descripcionCanal;
            viewManager.llamarServicioActualizar("actualizaCanal", params, "El Canal", 'contenidoCanal', 'seccionListarCanal');

        }
    } else if (global.accion == "seccionAgregarAccionNegocio") {
        var codigo = $("#codigoCrearAccionNegocio").val();
        var nombre = $("#nombreCrearAccionNegocio").val();
        var descripcion = $("#descripcionCrearAccionNegocio").val();
        var tipo = $("#tipoCrearAccionNegocio").val();
        var data = $("#dataCrearAccionNegocio").val();
        if (codigo == "" || nombre == "" || descripcion == "" || tipo == "" || data == "") {
            return alert("Tiene que llenar todos los campos para crear una Accion Negocio");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.tipo = tipo;
            params.data = data;
            viewManager.llamarServicioCrear("creaAccionNegocio", params, "La Accion Negocio", 'contenidoAccionNegocio', 'contenidoListaAccionNegocio');

        }
    } else if (global.accion == "seccionActualizaAccionNegocio") {
        var codigo = $("#codigoActualizaAccionNegocio").val();
        var nombre = $("#nombreActualizaAccionNegocio").val();
        var descripcion = $("#descripcionActualizaAccionNegocio").val();
        var tipo = $("#tipoActualizaAccionNegocio").val();
        var data = $("#dataActualizarAccionNegocio").val();
        if (codigo == "" || nombre == "" || descripcion == "" || tipo == "" || data == "") {
            return alert("Tiene que llenar todos los campos para actualizar una Accion Negocio");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.tipo = tipo;
            params.data = data;
            viewManager.llamarServicioActualizar("actualizaAccionNegocio", params, "La Accion Negocio", 'contenidoAccionNegocio', 'contenidoListaAccionNegocio');

        }
    } else if (global.accion == "seccionAgregarAccionSistema") {
        var codigo = $("#codigoCrearAccionSistema").val();
        var nombre = $("#nombreCrearAccionSistema").val();
        var descripcion = $("#descripcionCrearAccionSistema").val();
        var tipo = $("#tipoCrearAccionSistema").val();
        var data = $("#dataCrearAccionSistema").val();
        if (codigo == "" || nombre == "" || descripcion == "" || tipo == "" || data == "") {
            return alert("Tiene que llenar todos los campos para crear una Accion Sistema");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.tipo = tipo;
            params.data = data;
            viewManager.llamarServicioCrear("creaAccionSistema", params, "La Accion Sistema", 'contenidoAccionSistema', 'contenidoListaAccionSistema');

        }
    } else if (global.accion == "seccionActualizarAccionSistema") {
        var codigo = $("#codigoActualizarAccionSistema").val();
        var nombre = $("#nombreActualizarAccionSistema").val();
        var descripcion = $("#descripcionActualizarAccionSistema").val();
        var tipo = $("#tipoActualizarAccionSistema").val();
        var data = $("#dataActualizarAccionSistema").val();
        if (codigo == "" || nombre == "" || descripcion == "" || tipo == "" || data == "") {
            return alert("Tiene que llenar todos los campos para actualizar una Accion Sistema");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.tipo = tipo;
            params.data = data;
            viewManager.llamarServicioActualizar("actualizaAccionSistema", params, "La Accion Sistema", 'contenidoAccionSistema', 'contenidoListaAccionSistema');

        }
    } else if (global.accion == "seccionAgregarControlEventos") {
        var codigo = $("#codigoCrearControlEventos").val();
        var nombre = $("#nombreCrearControlEventos").val();
        var descripcion = $("#descripcionCrearControlEventos").val();
        var eventoSistema = $("#listaEventosSistema").val();
        var eventoNegocio = $("#listaEventosNegocio").val();
        var canal = $("#listaCanalesEventosTracking").val();

        if (codigo == "" || nombre == "" || descripcion == "" || eventoSistema == "0" || eventoNegocio == "0" || canal == "0") {
            return alert("Tiene que llenar todos los campos para crear una Evento Tracking");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.eventoSistemaCodigo = eventoSistema;
            params.eventoNegocioCodigo = eventoNegocio;
            params.canalCodigo = canal;
            viewManager.llamarServicioCrear("creaController", params, "El Evento tracking", 'contenidoControlEventos', 'contenidoListaControlEventos');

        }

    } else if (global.accion == "seccionActualizarControlEventos") {
        var codigo = $("#codigoActualizarControlEventos").val();
        var nombre = $("#nombreActualizarControlEventos").val();
        var descripcion = $("#descripcionActualizarControlEventos").val();
        var eventoSistema = $("#listaEventosSistemaActualizar").val();
        var eventoNegocio = $("#listaEventosNegocioActualizar").val();
        var canal = $("#listaCanalesEventosTrackingActualizar").val();

        if (codigo == "" || nombre == "" || descripcion == "" || eventoSistema == "0" || eventoNegocio == "0" || canal == "0") {
            return alert("Tiene que llenar todos los campos para crear una Evento Tracking");
        } else {
            var params = {};
            params.codigo = codigo;
            params.nombre = nombre;
            params.descripcion = descripcion;
            params.eventoSistemaCodigo = eventoSistema;
            params.eventoNegocioCodigo = eventoNegocio;
            params.canalCodigo = canal;
            viewManager.llamarServicioActualizar("actualizaController", params, "El Evento tracking", 'contenidoControlEventos', 'contenidoListaControlEventos');

        }

    }




};

viewManager.llamarServicioCrear = function(urlServicio, params, opcion, contenido, seccion) {
    $.getJSON(urlServicio, params, function(data) {
        if (data.respuestaServicio == true) {
            alert(opcion + " ha sido creado satifactoriamente");
            viewManager.funcionesMenuMostrarOcultarEventos(contenido, seccion, 2);

        } else {
            alert("Ha ocurrido un error en la creacion");
        }
    });
};

viewManager.llamarServicioActualizar = function(urlServicio, params, opcion, contenido, seccion) {

    $.getJSON(urlServicio, params, function(data) {
        if (data.actualizado == true) {
            alert(opcion + " ha sido actualizado satifactoriamente");
            viewManager.funcionesMenuMostrarOcultarEventos(contenido, seccion, 2);

        } else {
            alert("Ha ocurrido un error en la actualizacion");
        }
    });
};

viewManager.llamarServicioListar = function(urlServicio, opcion) {
     $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
    
//    $.getJSON(urlServicio, function(data) {
        var listado = data.respuestaServicio;
        if (listado != null) {
            viewManager.pintarListado(listado, opcion);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};
viewManager.llamarServicioListarEventos = function(urlServicio, opcion) {
    
    $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
//            },
//            error: function(xhr, textStatus, errorThrown) {
//                console.logger("Error en la obtención de Acciones");
//            }});
    
//    $.getJSON(urlServicio, function(data) {
        var listado = data.eventos;
        if (listado != null) {
            viewManager.pintarListado(listado, opcion);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};

viewManager.llamarServicioListarComboEventos = function(urlServicio, $idCombo, titulo) {
   
    $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
//    $.getJSON(urlServicio, function(data) {
        var listado = data.eventos;
        if (listado != null) {
            viewManager.pintarCombo(listado, $idCombo, titulo);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};

viewManager.llamarServicioListarCombo = function(urlServicio, $idCombo, titulo) {
      $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
//    $.getJSON(urlServicio, function(data) {
        var listado = data.respuestaServicio;
        if (listado != null) {
            viewManager.pintarCombo(listado, $idCombo, titulo);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};

viewManager.llamarServicioListarComboEventosAux = function(urlServicio, $idCombo, titulo, valor) {
    $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
//    $.getJSON(urlServicio, function(data) {
        var listado = data.eventos;
        if (listado != null) {
            viewManager.pintarComboAux(listado, $idCombo, titulo, urlServicio, valor);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};

viewManager.llamarServicioListarComboAux = function(urlServicio, $idCombo, titulo, valor) {
     $.ajax({
            url: urlServicio,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
//    $.getJSON(urlServicio, function(data) {
        var listado = data.respuestaServicio;
        if (listado != null) {
            viewManager.pintarComboAux(listado, $idCombo, titulo, urlServicio, valor);
        } else {
            alert("Ha ocurrido un error en la llamada al servicio");
        }
    }});
};

viewManager.pintarComboAux = function(listado, $idCombo, titulo, urlServicio, valor) {
    $idCombo.empty();
    if (!listado) {
        $idCombo.append($("<option />").val("").text("Sin datos"));
        return;
    }
    $idCombo.append($("<option />").val("0").text(titulo));
    $.each(listado, function(indice, elemento) {
        $idCombo.append($("<option />").val(elemento.id).text(elemento.nombre));
    });

    if (urlServicio == "listaCanal") {
        $("#listaCanalesEventosTrackingActualizar option[value='" + valor + "']").attr("selected", "true");
    } else if (urlServicio == "listaEventoSistema") {
        $("#listaEventosSistemaActualizar option[value='" + valor + "']").attr("selected", "true");
    } else if (urlServicio == "listaEventoNegocio") {
        $("#listaEventosNegocioActualizar option[value='" + valor + "']").attr("selected", "true");
    }

};



viewManager.pintarCombo = function(listado, $idCombo, titulo) {
    $idCombo.empty();
    if (!listado) {
        $idCombo.append($("<option />").val("").text("Sin datos"));
        return;
    }
    $idCombo.append($("<option />").val("0").text(titulo));
    $.each(listado, function(indice, elemento) {
        $idCombo.append($("<option />").val(elemento.id).text(elemento.nombre));
    });

};


viewManager.pintarListado = function(listado, opcion) {
    if (opcion == "El Canal") {
        $("#listadoCanales").empty();
        if (listado.length == 0) {
            $("#listadoCanales").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay acciones de Sistema Creadas</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
            $.each(listado, function(indice, elemento) {
                $("#listadoCanales").append(
                        "<table class='tablaEvento' cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaCanal(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaCanal" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoCanal" + "\",\"" + "seccionListarCanal" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>" +
                        "</table>" +
                        "</br>");
            });
        }


    } else if (opcion == "La Accion Negocio") {
        $("#listadoAccionNegocio").empty();
        if (listado.length == 0) {
            $("#listadoAccionNegocio").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay acciones de Negocio Creadas</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
            $.each(listado, function(indice, elemento) {
                $("#listadoAccionNegocio").append(
                        "<table class='tablaEvento'  cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Tipo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.tipo + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Data</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.data + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaAccionNegocio(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\",\"" + elemento.tipo + "\",\"" + elemento.data + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaAccionNegocio" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoAccionNegocio" + "\",\"" + "contenidoListaAccionNegocio" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>" +
                        "</table>" +
                        "</br>");
            });
        }


    } else if (opcion == "La Accion Sistema") {
        $("#listadoAccionSistema").empty();
        if (listado.length == 0) {
            $("#listadoAccionSistema").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay acciones de Sistema Creadas</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
            $.each(listado, function(indice, elemento) {
                $("#listadoAccionSistema").append(
                        "<table class='tablaEvento' cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Tipo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.tipo + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Data</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.data + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaAccionSistema(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\",\"" + elemento.tipo + "\",\"" + elemento.data + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaAccionSistema" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoAccionSistema" + "\",\"" + "contenidoListaAccionSistema" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>" +
                        "</table>" +
                        "</br>");
            });
        }


    } else if (opcion == "El Evento Negocio") {
        $("#contenedorTablaEventoNegocio").empty();
        if (listado.length == 0) {
            $("#contenedorTablaEventoNegocio").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay eventos de Negocio Creados</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
             var accionesDeNegocio = viewManager.obtenerAcciones("Negocio");
            $.each(listado, function(indice, elemento) {
                $("#contenedorTablaEventoNegocio").append(
                        "<table class='tablaEvento' id='idTablaEventoNegocio" + elemento.id + "' cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "<br/>");
                var contenidoAccionesNegocio = elemento.accionesNegocio;
                var accionesNegocioAux = "";

                $.each(contenidoAccionesNegocio, function(indice, acciones) {
                    try {
                        var accionDeNegocio = viewManager.obtenerAccionPorID(acciones,accionesDeNegocio);
                        if (typeof accionDeNegocio !== "undefined") {
                            if (indice == 0) {
                                $("#idTablaEventoNegocio" + elemento.id).append(
                                        "<tr>" +
                                        "<td class='tdTablaEvento1'>Acciones Negocio</td>" +
                                        "<td class='tdTablaEvento2'>" + accionDeNegocio.nombre + "</td>" +
                                        "</tr>"
                                        );
                            } else {
                                $("#idTablaEventoNegocio" + elemento.id).append(
                                        "<tr>" +
                                        "<td class='tdTablaEvento1'></td>" +
                                        "<td class='tdTablaEvento2'>" + accionDeNegocio.nombre + "</td>" +
                                        "</tr>"
                                        );
                            }
                            accionesNegocioAux = accionesNegocioAux + accionDeNegocio.id + ";" + accionDeNegocio.nombre + ",";
                        }
                    } catch (err) {
                        console.logger("parametro no número" + err)
                    }
                });
                accionesNegocioAux = accionesNegocioAux.substring(0, accionesNegocioAux.length - 1);
                $("#idTablaEventoNegocio" + elemento.id).append(
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaEventoNegocio(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\",\"" + accionesNegocioAux + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaEventoNegocio" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoEventoNegocio" + "\",\"" + "contenidoListaEventoNegocio" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>"
                        );
            });
        }


    } else if (opcion == "El Evento Sistema") {
        $("#contenedorListarTablaEventoSistema").empty();
        if (listado.length == 0) {
            $("#contenedorListarTablaEventoSistema").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay eventos de Sistema Creados</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
            var accionesDeSistema = viewManager.obtenerAcciones("Sistema");
            $.each(listado, function(indice, elemento) {
                $("#contenedorListarTablaEventoSistema").append(
                        "<table class='tablaEvento' id='idTablaEventoSistema" + elemento.id + "' cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "<br/>");

                var accionesSistemas = elemento.accionesSistema;
                var accionesSistemaAux = "";
                $.each(accionesSistemas, function(indice, acciones) {
                    try {
                        var accionSistema = viewManager.obtenerAccionPorID(acciones,accionesDeSistema);
                        if (typeof accionSistema !== "undefined") {
                            if (indice == 0) {
                                $("#idTablaEventoSistema" + elemento.id).append(
                                        "<tr>" +
                                        "<td class='tdTablaEvento1'>Acciones Sistema</td>" +
                                        "<td class='tdTablaEvento2'>" + accionSistema.nombre + "</td>" +
                                        "</tr>"
                                        );
                            } else {
                                $("#idTablaEventoSistema" + elemento.id).append(
                                        "<tr>" +
                                        "<td class='tdTablaEvento1'></td>" +
                                        "<td class='tdTablaEvento2'>" + accionSistema.nombre + "</td>" +
                                        "</tr>"
                                        );
                            }
                            accionesSistemaAux = accionesSistemaAux + accionSistema.id + ";" + accionSistema.nombre + ",";
                        }
                    } catch (err) {
                        console.logger("parametro no número" + err)
                    }
                });
                accionesSistemaAux = accionesSistemaAux.substring(0, accionesSistemaAux.length - 1);

                $("#idTablaEventoSistema" + elemento.id).append(
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaEventoSistema(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\",\"" + accionesSistemaAux + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaEventoSistema" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoEventoSistema" + "\",\"" + "contenidoListaEventoSistema" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>"
                        );


            });
        }

    } else if (opcion == "El Evento Tracking") {
        $("#contenidoListaControlEventos").empty();
        if (listado.length == 0) {
            $("#contenidoListaControlEventos").append(
                    "<table class='tablaEvento' id='' cellspacing='0' cellpadding='0'>" +
                    "<tr>" +
                    "<td class='tdTablaEvento1'>No hay eventos de Tracking Creados</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>");
        } else {
            $.each(listado, function(indice, elemento) {
                $("#contenidoListaControlEventos").append(
                        "<table class='tablaEvento' id='idTablaEventoTracking" + elemento.id + "' cellspacing='0' cellpadding='0'>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Codigo</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.id + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Nombre</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.nombre + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Descripcion</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.descripcion + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Canal</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.canal + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Evento Sistema</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.eventoSistema + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tdTablaEvento1'>Evento Negocio</td>" +
                        "<td class='tdTablaEvento2'>" + elemento.eventoNegocio + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "<br/>");


                $("#idTablaEventoTracking" + elemento.id).append(
                        "<tr>" +
                        "<td colspan='2' class='tdTablaEvento1'>" +
                        "<a onclick='viewManager.actualizaEventoTracking(\"" + elemento.id + "\",\"" + elemento.nombre + "\",\"" + elemento.descripcion + "\",\"" + elemento.eventoSistema + "\",\"" + elemento.eventoNegocio + "\",\"" + elemento.canal + "\");'><img src='img/update.png'></a>&nbsp;&nbsp;&nbsp;" +
                        "<a onclick='viewManager.eliminarElemento(\"" + "eliminaController" + "\",\"" + elemento.id + "\",\"" + opcion + "\",\"" + "contenidoControlEventos" + "\",\"" + "contenidoListaControlEventos" + "\");'><img src='img/delete.png'></a></td>" +
                        "</tr>"
                        );


            });
        }

    }

};


viewManager.eliminarElemento = function(urlServicio, codigo, opcion, contenido, seccion) {


    $.getJSON(urlServicio, {codigo: codigo}, function(data) {
        if (data.eliminado == true) {
            alert(opcion + " ha sido eliminado satifactoriamente");
            viewManager.funcionesMenuMostrarOcultarEventos(contenido, seccion, 2);

        } else {
            alert("Ha ocurrido un error en la eliminacion");
        }
    });

};

viewManager.actualizaCanal = function(codigo, nombre, descripcion) {
    $("#codigoActualizaCanal").val(codigo);
    $("#nombreActualizaCanal").val(nombre);
    $("#descripcionActualizaCanal").val(descripcion);
    viewManager.funcionesMenuMostrarOcultarEventos("contenidoCanal", "seccionActualizaCanal", 3);


};
viewManager.actualizaEventoNegocio = function(codigo, nombre, descripcion, accionesNegocioAux) {
    $("#codigoActualizarEventoNegocio").val(codigo);
    $("#nombreActualizarEventoNegocio").val(nombre);
    $("#descripcionActualizarEventoNegocio").val(descripcion);

    var accionesNegocio = accionesNegocioAux.split(",");
    $.each(accionesNegocio, function(indice, acciones) {
        indice++;
        var accionesAux = acciones.split(";");
        $("#ventanaActualizarAccionesNegocioSeleccionadas").append(
                "<label class='textosAcciones' id='" + accionesAux[0] + "'>" + indice + "_" + accionesAux[1] + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                );

    });
    viewManager.funcionesMenuMostrarOcultarEventos("contenidoEventoNegocio", "seccionActualizarEventoNegocio", 3);
};
viewManager.actualizaEventoSistema = function(codigo, nombre, descripcion, accionesSistemasAux) {
    $("#codigoActualizarEventoSistema").val(codigo);
    $("#nombreActualizarEventoSistema").val(nombre);
    $("#descripcionActualizarEventoSistema").val(descripcion);


    //alert(codigoCanal);
    var accionesSistemas = accionesSistemasAux.split(",");
    $.each(accionesSistemas, function(indice, acciones) {
        indice++;
        var accionesAux = acciones.split(";");
        $("#ventanaActualizarEventoSistemasSeleccionadas").append(
                "<label class='textosAcciones' id='" + accionesAux[0] + "'>" + indice + "_" + accionesAux[1] + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                );

    });

    viewManager.funcionesMenuMostrarOcultarEventos("contenidoEventoSistema", "seccionActualizarEventoSistema", 3);




};

viewManager.actualizaAccionNegocio = function(codigo, nombre, descripcion, tipo, data) {
    $("#codigoActualizaAccionNegocio").val(codigo);
    $("#nombreActualizaAccionNegocio").val(nombre);
    $("#descripcionActualizaAccionNegocio").val(descripcion);
    $("#dataActualizarAccionNegocio").val(data);
//    $("#tipoActualizaAccionNegocio").val(tipo);
    $("#tipoActualizaAccionNegocio option[value='" + tipo + "']").attr("selected", "true");

    viewManager.funcionesMenuMostrarOcultarEventos("contenidoAccionNegocio", "seccionActualizaAccionNegocio", 3);


};

viewManager.actualizaAccionSistema = function(codigo, nombre, descripcion, tipo, data) {
    $("#codigoActualizarAccionSistema").val(codigo);
    $("#nombreActualizarAccionSistema").val(nombre);
    $("#descripcionActualizarAccionSistema").val(descripcion);
    // $("#tipoActualizarAccionSistema").val(tipo);
    // $("#dataActualizarAccionSistema").val(data);

    $("#dataActualizarAccionSistema option[value='" + data + "']").attr("selected", "true");
    $("#tipoActualizarAccionSistema option[value='" + tipo + "']").attr("selected", "true");

    viewManager.funcionesMenuMostrarOcultarEventos("contenidoAccionSistema", "seccionActualizarAccionSistema", 3);


};

viewManager.actualizaEventoTracking = function(codigo, nombre, descripcion, eventoSistema, eventoNegocio, canal) {
    $("#codigoActualizarControlEventos").val(codigo);
    $("#nombreActualizarControlEventos").val(nombre);
    $("#descripcionActualizarControlEventos").val(descripcion);
    viewManager.llamarServicioListarComboAux("listaCanal", $("#listaCanalesEventosTrackingActualizar"), "Seleccione un Canal", canal);
    viewManager.llamarServicioListarComboEventosAux("listaEventoSistema", $("#listaEventosSistemaActualizar"), "Seleccione un Evento", eventoSistema);
    viewManager.llamarServicioListarComboEventosAux("listaEventoNegocio", $("#listaEventosNegocioActualizar"), "Seleccione un Evento", eventoNegocio);

    viewManager.funcionesMenuMostrarOcultarEventos("contenidoControlEventos", "seccionActualizarControlEventos", 3);


};

viewManager.agregarAcciones = function(tipoAccion) {
    if (tipoAccion.toString() === "Negocio") {
        var accionSeleccionadaNegocio = $("#listaAccionesCrearEventoNegocio option:selected").text().toString();
        var idEvento = $("#listaAccionesCrearEventoNegocio option:selected").val().toString();
//        // alert(accionSeleccionada.toString());
//        global.contadorEventosNegocio = global.contadorEventosNegocio + 1;
//        $("#ventanaAccionesNegocioSeleccionadas ").append(
//            "<label class='textosAcciones' id='" + idEvento + "'>" + global.contadorEventosNegocio + "_" + accionSeleccionadaNegocio + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionada(\"" + idEvento + "\");'/><br/></label>"
//        );

        if (idEvento == "0") {
            return alert("Debe seleccionar una accion para agregar");
        } else {

        }

        var error = "0";
        $("#ventanaAccionesNegocioSeleccionadas label").each(function(pos, nombre) {
            var idEventoIngresado = $(this).attr('id');
            if (idEvento == idEventoIngresado) {
                error = "No puede ingresar una misma accion 2 veces";
            }
        });

        if (error != "0") {
            return alert(error);
        } else {
            global.contadorEventoSistema = global.contadorEventoSistema + 1;
            $("#ventanaAccionesNegocioSeleccionadas ").append(
//                "<label class='textosAcciones' id='" + idEvento + "'>" + global.contadorEventoSistema + "_" + accionSeleccionadaNegocio + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionada(\"" + idEvento + "\");'/><br/></label>"
                    "<label class='textosAcciones' id='" + idEvento + "'>" + accionSeleccionadaNegocio + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionada(\"" + idEvento + "\");'/><br/></label>"
                    );
        }

    } else if (tipoAccion.toString() === "Sistema") {

        var accionSeleccionadaSistema = $("#listaAccionesCrearEventoSistema option:selected").text().toString();
        var idEvento = $("#listaAccionesCrearEventoSistema option:selected").val().toString();

        if (idEvento == "0") {
            return alert("Debe seleccionar una accion para agregar");
        } else {

        }


        var error = "0";
        $("#ventanaAccionesSistemasSeleccionadas label").each(function(pos, nombre) {
            var idEventoIngresado = $(this).attr('id');
            if (idEvento == idEventoIngresado) {
                error = "No puede ingresar una misma accion 2 veces";
            }
        });

        if (error != "0") {
            return alert(error);
        } else {
            global.contadorEventoSistema = global.contadorEventoSistema + 1;
            $("#ventanaAccionesSistemasSeleccionadas ").append(
//                "<label class='textosAcciones' id='" + idEvento + "'>" + global.contadorEventoSistema + "_" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionada(\"" + idEvento + "\");'/><br/></label>"
                    "<label class='textosAcciones' id='" + idEvento + "'>" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionada(\"" + idEvento + "\");'/><br/></label>"
                    );
        }


    } else if (tipoAccion.toString() === "SistemaActulizar") {

        var accionSeleccionadaSistema = $("#listaAccionesActualizarEventoSistema option:selected").text().toString();
        var idEvento = $("#listaAccionesActualizarEventoSistema option:selected").val().toString();

        if (idEvento == "0") {
            return alert("Debe seleccionar una accion para agregar");
        } else {

        }


        var error = "0";
        $("#ventanaActualizarEventoSistemasSeleccionadas label").each(function(pos, nombre) {
            var idEventoIngresado = $(this).attr('id');
            if (idEvento == idEventoIngresado) {
                error = "No puede ingresar una misma accion 2 veces";
            }
        });

        if (error != "0") {
            return alert(error);
        } else {
            global.contadorEventoSistema = 1;
            $("#ventanaActualizarEventoSistemasSeleccionadas label").each(function(pos, nombre) {
                global.contadorEventoSistema++;
            });

            $("#ventanaActualizarEventoSistemasSeleccionadas ").append(
//                "<label class='textosAcciones' id='" + idEvento + "'>" + global.contadorEventoSistema + "_" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                    "<label class='textosAcciones' id='" + idEvento + "'>" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                    );
        }


    } else if (tipoAccion.toString() === "NegocioActualizar") {

        var accionSeleccionadaSistema = $("#listaAccionesActualizarEventoNegocio option:selected").text().toString();
        var idEvento = $("#listaAccionesActualizarEventoNegocio option:selected").val().toString();

        if (idEvento == "0") {
            return alert("Debe seleccionar una accion para agregar");
        } else {

        }


        var error = "0";
        $("#ventanaActualizarAccionesNegocioSeleccionadas label").each(function(pos, nombre) {
            var idEventoIngresado = $(this).attr('id');
            if (idEvento == idEventoIngresado) {
                error = "No puede ingresar una misma accion 2 veces";
            }
        });

        if (error != "0") {
            return alert(error);
        } else {
            global.contadorEventoSistema = 1;
            $("#ventanaActualizarAccionesNegocioSeleccionadas label").each(function(pos, nombre) {
                global.contadorEventoSistema++;
            });

            $("#ventanaActualizarAccionesNegocioSeleccionadas ").append(
//                "<label class='textosAcciones' id='" + idEvento + "'>" + global.contadorEventoSistema + "_" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                    "<label class='textosAcciones' id='" + idEvento + "'>" + accionSeleccionadaSistema + "<img src='img/eliminar.png' class='imagenEliminarAccion' onclick='viewManager.eliminarAccionSeleccionadaActualizar();'/><br/></label>"
                    );
        }


    }
};
viewManager.eliminarAccionSeleccionada = function(idVariable) {
    //var idAccion = idVariable.toString();
    //$("#" + idAccion).remove();
    global.contadorEventoSistema = 0;
    $("#ventanaAccionesSistemasSeleccionadas").empty();
    $("#ventanaAccionesNegocioSeleccionadas").empty();

};

viewManager.eliminarAccionSeleccionadaActualizar = function() {
    global.contadorEventoSistema = 0;
    $("#ventanaActualizarEventoSistemasSeleccionadas").empty();
    $("#ventanaActualizarAccionesNegocioSeleccionadas").empty();

};

viewManager.obtenerAcciones = function(tipo) {
    var urlAccion = "";
    var dataAux;
    if (tipo === "negocio" || tipo === "Negocio")
        urlAccion = "listaAccionNegocio";

    if (tipo === "sistema" || tipo === "Sistema")
        urlAccion = "listaAccionSistema";

    if (urlAccion !== "") {
        $.ajax({
            url: urlAccion,
            async: false,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
                dataAux = data;
            },
            error: function(xhr, textStatus, errorThrown) {
                console.logger("Error en la obtención de Acciones");
            }});
    }
    return dataAux;
};

viewManager.obtenerAccionPorID = function(id,accionesDeNegocio) {


    try {
         for (var i = 0; i < accionesDeNegocio.respuestaServicio.length; i++) {
            if (accionesDeNegocio.respuestaServicio[i].id == id) {
                return accionesDeNegocio.respuestaServicio[i];

            }
        }
       } catch (err) {
           console.logger(err);
    }
};




