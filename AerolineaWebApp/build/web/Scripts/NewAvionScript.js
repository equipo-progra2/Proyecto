$(document).ready(function(){
    $("#myform").validate({
       rules:{
           name: "required",
           model: "required",
           mark:"required",
           capacity: {
               required: true,
               min:0
            }
        },
        messages:{
            name:"Ingrese el nombre de su avion por favor",
           model:"Ingrese el modelo de su avion",
           mark:"Ingrese a marca de su avion",
           capacity:{
               required: "Ingrese la capacidad de su avion",
               min:"Ingrese un numero mayor a 0"
           }
        }
    });
});

