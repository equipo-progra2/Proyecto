<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizado</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
      <h1>Registro realizado con exito</h1>
        <p><%= iRows %> columnas fueron afectadas</p>
        <br><br>
        <a href="index.html">Inicio</a>
    </body>
</html>
