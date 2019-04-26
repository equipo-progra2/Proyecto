$(document).ready(function(){
    $("#myform").validate({
       rules:{
           nombre: "required",
           pais: "required",
           ciudad:"required"

        },
        messages:{
            nombre:"Ingrese el nombre de su aeropuerto por favor",
           pais:"Ingrese el pais",
           ciudad:"Ingrese la ciudad"
        }
    });
});

