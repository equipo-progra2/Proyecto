<%@page import="benja.aerolineawebapp.objects.VueloObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/NewVueloScript.js" type="text/javascript"></script>
        <link href="CSS/newcssvuelo3.css" rel="stylesheet" type="text/css"/>
        
        <title>Update Vuelo</title>
    </head>
    <%
        VueloObj VVuelo = 
                (VueloObj)request.getSession().getAttribute("vuelo");
        
    %>
    <body>
        <h1>Update Aeropuerto</h1>
        <br><br>
        
        <img src="planee.png" alt="plane" width="190" height="190" align="right"/>
        
        <form id="myform" name="myform" action="VueloServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= VVuelo.getId() %>" disabled />
            <br><br>
            
            <label>IdAvion:</label><br>
            <input type="text" id="idavion" name="idavion" value="<%= VVuelo.getIdAvion() %>" />
            <br><br>
            
            <label>Fecha de Partida:</label><br>
            <input type="text" id="fechapartida" name="fechapartida" value="<%= VVuelo.getFechaPartida() %>" />
            <br><br>
            
            <label>Hora de Partida</label><br>
            <input type="text" id="horapartida" name="horapartida" value="<%= VVuelo.getHoraPartida() %>" />
            <br><br>
            
            <label>Id Aeropuerto de Partida:</label><br>
            <input type="text" id="aeropuertopartida" name="aeropuertopartida" value="<%= VVuelo.getIdAeropuertoPartida() %>" />
            <br><br>
            
            <label>Fecha de Llegada</label><br>
            <input type="text" id="fechallegada" name="fechallegada" value="<%= VVuelo.getFechaLlegada() %>" />
            <br><br>
            
            <label>Hora de Llegada</label><br>
            <input type="text" id="horallegada" name="horallegada" value="<%= VVuelo.getHoraLlegada() %>" />
            <br><br>
            
            <label>Id Aeropuerto de Destino:</label><br>
            <input type="text" id="aeropuertodestino" name="aeropuertodestino" value="<%= VVuelo.getIdAeropuertoDestino() %>" />
            <br><br>
            
            <label>Precio de Adulto</label><br>
            <input type="text" id="precioadulto" name="precioadulto" value="<%= VVuelo.getPrecioAdulto() %>" />
            <br><br>
            
            <label>Precio de Nino</label><br>
            <input type="text" id="precionino" name="precionino" value="<%= VVuelo.getPrecioNino() %>" />
            <br><br>
            
            <label>Precio de Infante</label><br>
            <input type="text" id="precioinfante" name="precioinfante" value="<%= VVuelo.getPrecioInfante() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= VVuelo.getId() %>" />
        </form>
    </body>
</html>
