<%@page import="benja.aerolineawebapp.objects.AvionObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/NewAeropuertoScript.js" type="text/javascript"></script>
        <link href="CSS/newcssvuelo3.css" rel="stylesheet" type="text/css"/>
        
        <title>Actualizar Avion</title>
    </head>
    <%
        AvionObj AAvion = 
                (AvionObj)request.getSession().getAttribute("avion");
        
    %>
    <body>
        <h1>Actualizar Avion</h1>
        <br><br>
        
        <img src="planee.png" alt="plane" width="190" height="190" align="right"/>
        
        <form id="myform" name="myform" action="AvionServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= AAvion.getId() %>" disabled/>
            <br><br>
            
            <label>Nombre:</label><br>
            <input type="text" id="name" name="name" value="<%= AAvion.getNombre() %>" />
            <br><br>
            
            <label>Modelo:</label><br>
            <input type="text" id="model" name="model" value="<%= AAvion.getModelo() %>" />
            <br><br>
            
            <label>Marca:</label><br>
            <input type="text" id="mark" name="mark" value="<%= AAvion.getMarca() %>" />
            <br><br>
            
            <label>Capacidad:</label><br>
            <input type="number" id="capacity" name="capacity" value="<%= AAvion.getCapacidad() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= AAvion.getId() %>" />
        </form>
    </body>
</html>
