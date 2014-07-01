/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
viewManager.variablesGlobales = function() {
    global = {
        accion:null,
        contadorEventosNegocio: 0,
        contadorEventoSistema: 0
                };
    viewManager.llamarServicioListarCombo("listaCanal", $("#listaCanalActualizarEventoSistema"), "Seleccione un canal");
};
viewManager.eventosClickFunctions= function() {
     $("#btnAgregarAccionDeNegocio").click(function(){
        viewManager.agregarAcciones('Negocio');
    });
    
    $("#btnAgregarAccionDeSistema").click(function(){
        viewManager.agregarAcciones('Sistema');
    });
    $("#btnActualizarAccionDeSistema").click(function(){
        viewManager.agregarAcciones('SistemaActulizar');
    });
    $("#btnActualizarAccionDeNegocio").click(function(){
        viewManager.agregarAcciones('NegocioActualizar');
    });
    $("#btnIngresarSesion").click(function(){
        viewManager.iniciarSesion();
    });
    
    
};

