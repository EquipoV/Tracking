helpers.sonOfertasIguales = function(oferta1, oferta2) {
    return oferta1.planTarifario.codigo === oferta2.planTarifario.codigo && oferta1.modeloCelular.codigoInterno === oferta2.modeloCelular.codigoInterno;
};

helpers.validarSoloNumeros = function(e,submitButton) {
    var key = e.keyCode || e.which;
    var tecla = String.fromCharCode(key).toLowerCase();
    var numeros = "1234567890";
    var aux = 0;
    var sum = 0;
    for (var i = 0; i < 31; i++) {
        sum = "," + (i + 1);
        aux = aux + sum;
    }
    aux = aux + "," + 255 + "," + 127;
    var tecla_especial = false;
    for (var i in aux) {
        if (key == aux[i]) {
            tecla_especial = true;
            break;
        }
    }
    if (numeros.indexOf(tecla) == -1 && !tecla_especial && key != 13) {
        alert("Ingrese Solo Números");
        return false;
    }
};

helpers.replaceAll = function(text, busca, reemplaza) {
    while (text.toString().indexOf(busca) != - 1)
        text = text.toString().replace(busca, reemplaza);
    return text;
};
helpers.validarSolocaracteresDefinidosRut = function(e) {
    var key = e.keyCode || e.which;
    var tecla = String.fromCharCode(key).toLowerCase();
    var caracteres = "0123456789-k";
    var aux = 0;
    var sum = 0;
    for (var i = 0; i < 31; i++) {
        sum = "," + (i + 1);
        aux = aux + sum;
    }
    aux = aux + "," + 255 + "," + 127;
    var tecla_especial = false;
    for (var i in aux) {
        if (key == aux[i]) {
            tecla_especial = true;
            break;
        }
    }
    if (caracteres.indexOf(tecla) == -1 && !tecla_especial) {
        alert("Ingrese Solo Numeros o digito validador correspondiente");
        return false;
    }
};

helpers.validarSoloLetras = function(e) {
    var key = e.keyCode || e.which;
    var tecla = String.fromCharCode(key).toLowerCase();
    var letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    var aux = 0;
    var sum = 0;
    for (var i = 0; i < 31; i++) {
        sum = "," + (i + 1);
        aux = aux + sum;
    }
    aux = aux + "," + 255 + "," + 127;
    var tecla_especial = false;
    for (var i in aux) {
        if (key == aux[i]) {
            tecla_especial = true;
            break;
        }
    }
    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        alert("Ingrese Datos Correspondientes");
        return false;
    }
};

helpers.validarSolocaracteresDefinidosFecha = function(e) {
    var key = e.keyCode || e.which;
    var tecla = String.fromCharCode(key).toLowerCase();
    var caracteres = "0123456789-/";
    var aux = 0;
    var sum = 0;
    for (var i = 0; i < 31; i++) {
        sum = "," + (i + 1);
        aux = aux + sum;
    }
    aux = aux + "," + 255 + "," + 127;
    var tecla_especial = false;
    for (var i in aux) {
        if (key == aux[i]) {
            tecla_especial = true;
            break;
        }
    }
    if (caracteres.indexOf(tecla) == -1 && !tecla_especial) {
        alert("Ingrese Solo Numeros o digito separador correspondiente");
        return false;
    }
};

helpers.cloneArray = function(obj) {
    var temp = jQuery.extend(true, [], obj);  
    return temp;
}

helpers.validaFechaMMAAAA = function(fecha) {
    var dtCh = "/";
    var minYear = 1900;
    var maxYear = 2100;
    function isInteger(s) {
        var i;
        for (i = 0; i < s.length; i++) {
            var c = s.charAt(i);
            if (((c < "0") || (c > "9")))
                return false;
        }
        return true;
    }
    function stripCharsInBag(s, bag) {
        var i;
        var returnString = "";
        for (i = 0; i < s.length; i++) {
            var c = s.charAt(i);
            if (bag.indexOf(c) == -1)
                returnString += c;
        }
        return returnString;
    }
    function DaysArray(n) {
        for (var i = 1; i <= n; i++) {
            this[i] = 31
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                this[i] = 30
            }
            if (i == 2) {
                this[i] = 29
            }
        }
        return this
    }
    function isDate(dtStr) {
        var daysInMonth = DaysArray(12)
        var pos1 = dtStr.indexOf(dtCh)
        //var pos2 = dtStr.indexOf(dtCh, pos1 + 1)
        var strMonth = dtStr.substring(0, pos1)
        //var strYear = dtStr.substring(pos1 + 1, pos2)
        var strYear = dtStr.substring(pos1 + 1)
        strYr = strYear
        if (strMonth.charAt(0) == "0" && strMonth.length > 1)
            strMonth = strMonth.substring(1)
        for (var i = 1; i <= 3; i++) {
            if (strYr.charAt(0) == "0" && strYr.length > 1)
                strYr = strYr.substring(1)
        }
        month = parseInt(strMonth)
        year = parseInt(strYr)
        if (pos1 == -1) {
            return false
        }
        if (strMonth.length < 1 || month < 1 || month > 12) {
            return false
        }
        if (strYear.length != 4 || year == 0 || year < minYear || year > maxYear) {
            return false
        }
        if (dtStr.indexOf(dtCh, pos1 + 1) != -1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
            return false
        }
        return true
    }
    if (isDate(fecha)) {
        return true;
    } else {
        alert("Formato de fecha incorrecto, el formato debe ser Mes/Año");
        return false;
    }
};

helpers.limitarTextArea = function() {

    $('textarea[maxlength]').keyup(function() {
        //get the limit from maxlength attribute  
        var limit = parseInt($(this).attr('maxlength'));
        //get the current text inside the textarea  
        var text = $(this).val();
        //count the number of characters in the text  
        var chars = text.length;

        //check if there are more characters then allowed  
        if (chars > limit) {
            //and if there are use substr to get the text before the limit  
            var new_text = text.substr(0, limit);

            //and change the current text with the new text  
            $(this).val(new_text);
        }
    });
};

helpers.deshabilitarFs = function(doc,cheater) {
  if(cheater != "on" ){  
  $(doc).keydown(function(e){
      
    var key = e.keyCode || e.which; 
    switch(key){
        case 115://F4
        return false;
        break;
        case 116://F5
        return false;
        break;
        case 118://F7
        return false;
        break;
        case 123://F12
        return false;
        break;
     }
});
  }
};

(function($) {
    $.fn.selected = function(fn) {
        return this.each(function() {
            var clicknum = 0;
            $(this).click(function() {
                clicknum++;
                if (clicknum == 2) {
                    clicknum = 0;
                    fn(this);
                }
            });
        });
    }
})(jQuery);

