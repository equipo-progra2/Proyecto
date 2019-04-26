<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
         <link href="css/TableStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String strNombre = (String)request.getSession().getAttribute("nombre");
        String strApellido = (String)request.getSession().getAttribute("apellido");
        String strFecha = (String)request.getSession().getAttribute("fecha");
        int iAdultos = (int)request.getSession().getAttribute("adultos");
        int iNinos = (int)request.getSession().getAttribute("ninos");
        int iInfantes = (int)request.getSession().getAttribute("infantes");
        int iPrecioAdulto = (int)request.getSession().getAttribute("Padultos");
        int iPrecioNino = (int)request.getSession().getAttribute("Pninos");
        int iPrecioInfante = (int)request.getSession().getAttribute("Pinfantes");
        int itotal = (int)request.getSession().getAttribute("total");
        
    %>
    <body>
         <div class="navbar-bacground">
            <nav class="navbar  navbar-expand-md navbar-dark bg-dark" style="background-color:#808080d;" >
            <a class="navbar-brand" href="#">Epsilon Airlines</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="AeropuertoServlet?formid=1">Comprar Boletos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="EstadoDeVuelos.html">Estado de vuelos</a>
                </li>
              </ul>
              <span class="navbar-text">
                Tu vuelo al mejor precio
              </span>
            </div>
          </nav>
        </div>   
        <br>
        
        <div class="container">
            <h1>Factura</h1>
        
        <p>Comprobante de venta para <%= strNombre %> <%= strApellido %>.</p>
        <p>Fecha: <%= strFecha %></p>
        <br><br>
        <table>
            <tr>
                <th>Cantidad</th>
                <th>Tipo de boleto</th>
                <th>Precio</th>
            </tr>
            <tr>
                <td><%= iAdultos %></td>
                <td>Pasajero adulto (mayor a 12 años)</td>
                <td><%= iPrecioAdulto %>$</td>
            </tr>
            <tr>
                <td><%= iNinos %></td>
                <td>Pasajero joven (entre 12 y 2 años)</td>
                <td><%= iPrecioNino %>$</td>
            </tr>
            <tr>
                <td><%= iInfantes %></td>
                <td>Pasajero infante (menor a 2 años)</td>
                <td><%= iPrecioInfante %>$</td>
            </tr>
            <tr>
                <td></td>
                <td>Total pagado:</td>
                <td><%= itotal %>$</td>
            </tr>
            
        </table>
        <br><br>
        <a class="btn btn-primary" href="index.html" role="button">Regresar</a>
        </div>
        
        
   <script src="js/jquery.js" ></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>
