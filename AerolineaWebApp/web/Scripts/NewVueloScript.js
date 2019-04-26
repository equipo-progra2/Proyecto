$(document).ready(function(){
    $("#myform").validate({
       rules:{
           idavion: "required",
           fechapartida: "required",
           horapartida:"required",
            aeropuertopartida:"required",
            fechallegada: "required",
           horallegada:"required",
           aeropuertodestino: "required",
           precioadulto: {
               required: true,
               min:0
            },
            precionino: {
               required: true,
               min:0
            },
            precioinfante: {
               required: true,
               min:0
            }
        },
        messages:{
           idavion:"Ingrese el nombre de su avion por favor",
           fechapartida:"Ingrese la fecha de partida",
           horapartida:"Ingrese la hora de partida",
           aeropuertopartida:"Ingrese el aeropuerto de partida",
           fechallegada:"Ingrese la fecha de llegada",
           horallegada:"Ingrese la hora de llegada",
           aeropuertollegada:"Ingrese el aeropuerto de llegada",
           precioadulto:{
               required: "Ingrese el precio del viaje",
               min:"Ingrese un numero mayor a 0"
           },
           precioanino:{
               required: "Ingrese el precio del viaje",
               min:"Ingrese un numero mayor a 0"
           },
           precionino:{
               required: "Ingrese el precio del viaje",
               min:"Ingrese un numero mayor a 0"
           }
        }
    });
});


