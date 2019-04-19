<%@page import="benja.aerolineawebapp.objects.AeropuertoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Aeropuerto</title>
    </head>
    <%
        AeropuertoObj AAeropuerto = 
                (AeropuertoObj)request.getSession().getAttribute("aeropuerto");
        
    %>
    <body>
        <h1>Update Aeropuerto</h1>
        <br><br>
        
        <form id="myform" name="myform" action="AeropuertoServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= AAeropuerto.getId() %>" disabled/>
            <br><br>
            
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= AAeropuerto.getNombre() %>" />
            <br><br>
            
            <label>Pais:</label><br>
            <input type="text" id="pais" name="pais" value="<%= AAeropuerto.getPais() %>" />
            <br><br>
            
            <label>Ciudad:</label><br>
            <input type="text" id="ciudad" name="ciudad" value="<%= AAeropuerto.getCiudad() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= AAeropuerto.getId() %>" />
        </form>
    </body>
</html>
