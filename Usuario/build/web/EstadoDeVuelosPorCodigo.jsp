<%-- 
    Document   : EstadoDeVuelosPorCodigo
    Created on : 04-19-2019, 11:22:04 PM
    Author     : SamuelG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Codigo Vuelo</title>
    </head>
    <body>
        <h1>Codigo del vuelo</h1>
        <br><br>
        
        <form id="myform" name="myform" action="AeropuertoServlet" method="get">
            <label>Codigo:</label><br>
            <input type="text" id="codigo" name="codigo" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Buscar"/>
            <input type="hidden" id="formid" name="formid" value="6" />
        </form>
        
        <br><br>
        <a href="index.html">Inicio</a>
        <br><br>
        <a href="EstadoDeVuelos.html">Estado de vuelos</a>
        
    </body>
</html>
