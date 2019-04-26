<%-- 
    Document   : EstadoDeVuelosPorRuta
    Created on : 04-19-2019, 05:46:12 AM
    Author     : SamuelG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aerolinea.objects.AeropuertoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ruta de vuelo</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    
    <%
        ArrayList<String> CArray = 
                (ArrayList<String>)request.getSession().getAttribute("aeropuertos");
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
        <br><br>
        
        <div class="container">
        <h1>Seleccione la ruta del vuelo</h1>
        <br><br>
       <form id="myform" name="myform" action="AeropuertoServlet" method="get">
       <h2>Pais de partida</h2><br>  
       <select id="pais1" name="pais1">
        <%
            if(CArray!=null)
            {
                int counter = 0;
                int size=CArray.size();
                for(int i=0;i<size;i++)
                {
                    for(int j=0;j<i;j++)
                    {
                        if (CArray.get(i).equals(CArray.get(j))){
                            counter = counter + 1;
                        }
                    }
                    if(counter==0)
                    {
        %>
                    <option value="<%=CArray.get(i)%>"><%=CArray.get(i)%></option>        
        <%          }
                    counter = 0;
                }
            }
            
        %>
        </select>
        
        <br><br>
        <h2>Pais de destino</h2> <br>
        <select id="pais2" name="pais2">
        <%
            if(CArray!=null)
            {
                int counter = 0;
                int size=CArray.size();
                for(int i=0;i<size;i++)
                {
                    for(int j=0;j<i;j++)
                    {
                        if (CArray.get(i).equals(CArray.get(j))){
                            counter = counter + 1;
                        }
                    }
                    if(counter==0)
                    {
        %>
                    <option value="<%=CArray.get(i)%>"><%=CArray.get(i)%></option>        
        <%          }
                    counter = 0;
                }
            }
            
        %>
        </select>
        
        <br><br><br>
        
        <button type="submit" class="btn btn-primary" id="mysubmit" name="mysubmit">Continuar</button>
        <input type="hidden" id="formid" name="formid" value="6" />
        </form>
        <br><br>
        
        <a class="btn btn-primary" href="EstadoDeVuelos.html" role="button">Volver a estado de vuelos</a>
        </div>
        
        <br>
        
        
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

        
    <script src="js/jquery.js" ></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>
