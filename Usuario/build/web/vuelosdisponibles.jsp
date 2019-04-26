<%@page import="java.util.Iterator"%>
<%@page import="aerolinea.objects.VueloObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vuelos disponibles</title>
        <link href="css/TableStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
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
    <br><br>
   
    <div class="container">
    <%
        ArrayList<VueloObj> CArray = 
                (ArrayList<VueloObj>)request.getSession().getAttribute("vuelos");
        Iterator<VueloObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Vuelos disponibles</h1>
        
        <br>
        
        <table>
        <tr>
            <th>Fecha de Partida</th>
            <th>Hora de Partida</th>
            <th>Ciudad de Partida</th>
            <th>Aeropuerto de Partida</th>
            <th>Fecha de Llegada</th>
            <th>Hora de Llegada</th>
            <th>Ciudad de Llegada</th>
            <th>Aeropuerto de Llegada</th>
            <th>Precio Adulto (mas de 12 años)</th>
            <th>Precio Joven (entre 12 y 2 años)</th>
            <th>Precio Infante (menos de 2 años)</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                VueloObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
        
        <tr>
                    <td><%= CTemp.getFechaPartida() %></td>
                    <td><%= CTemp.getHoraPartida() %></td>
                    <td><%= CTemp.getCiudadPartida() %></td>
                    <td><%= CTemp.getAeroPartida() %></td>
                    <td><%= CTemp.getFechaLlegada() %></td>
                    <td><%= CTemp.getHoraLlegada() %></td>
                    <td><%= CTemp.getCiudadLlegada() %></td>
                    <td><%= CTemp.getAeroLlegada() %></td>
                    <td><%= CTemp.getPrecioAdulto() %>$</td>
                    <td><%= CTemp.getPrecioNino() %>$</td>
                    <td><%= CTemp.getPrecioInfante() %>$</td>
                    <td>
                        
                        </a>
                        <a class="btn btn-primary" href="AeropuertoServlet?formid=3&id=<%= CTemp.getId() %>&precioadulto=<%= CTemp.getPrecioAdulto()%>&precionino=<%= CTemp.getPrecioNino()%>&precioinfante=<%= CTemp.getPrecioInfante()%>" role="button">Comprar</a>
                    </td>
        </tr>
        
        <%
                }
            }
        %>
        
        </table>
        <br><br>
        
     
        <br><br>
        <a class="btn btn-primary" href="index.html" role="button">Inicio</a>
        <br><br>
        
         <a class="btn btn-primary" href="AeropuertoServlet?formid=1" role="button">Buscar vuelos</a>
    </div>
        
        <br><br><br> <br><br>
        
        <div class="container-fluid"
            <footer style="background-color:  #191D26">
           <div class="container-fluid">
               <div class="row">
                   <div class="col-9">
                       <p class="colorp" style="color: white">Epsilon Airlines - Derechos Reservados</p>
                   </div>
                   <div class="col-1">
                        <ul class="list-inline text-right">
                          <li><a href="index.html">Inicio</a></li>
                       </ul>
                   </div>
                   <div class="col-1">
                        <ul class="list-inline text-right" style="color: white">
                          <li><a href="#">Registrate</a></li>
                       </ul>
                   </div>
                   <div class="col-1">
                        <ul class="list-inline text-right">
                          <li><a href="#">Contactamos</a></li>
                       </ul>
                   </div>
               </div>   
            </div> 
        </footer>
        </div>
        
        <script src="js/jquery.js" ></script>
         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
    
</html>
