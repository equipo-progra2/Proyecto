<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion de Cliente</title>
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
    <%
        int iId = (int)request.getSession().getAttribute("idVuelo");
        int iPrecioadulto = (int)request.getSession().getAttribute("precioadulto");
        int iPrecionino = (int)request.getSession().getAttribute("precionino");
        int iPrecioinfante = (int)request.getSession().getAttribute("precioinfante");
    %>
    <body>
       
        <div class="container">
        <h1>Informacion de Cliente</h1>
        
        <br>
     <!--   <div class="container">
            <h1>Informacion de Cliente</h1>
            <br><br>

            <form id="myform" name="myform" action="AeropuertoServlet" method="get">

                <label>Primer Nombre:</label><br>
                <input type="text" id="nombre" name="nombre"/>
                <br><br>

                <label>Primer Apellido:</label><br>
                <input type="text" id="apellido" name="apellido"/>
                <br><br>

                <label>Tarjeta:</label><br>
                <select id="tarjeta" name="tarjeta" type="text" >
                    <option value="Visa">Visa</option>
                    <option value="MasterCard">MasterCard</option>
                </select>
                <br><br>

                <label>Numero de tarjeta:</label><br>
                <input type="number" id="notarjeta" name="notarjeta"/>
                <br><br>

                <label>Telefono:</label><br>
                <input type="number" id="telefono" name="telefono"/>
                <br><br>

                <label>Email:</label><br>
                <input type="text" id="email" name="email"/>
                <br><br>

                <label>Cantidad de adultos (+12 años)</label><br>
                <input type="number" id="adultos" name="adultos"/>
                <br><br>

                <label>Cantidad de niños (12-2 años)</label><br>
                <input type="number" id="ninos" name="ninos"/>
                <br><br>

                <label>Cantidad de infantes (-2 años)</label><br>
                <input type="number" id="infantes" name="infantes"/>
                <br><br>


                <input type="submit" id="mysubmit" name="mysubmit" value="Comprar"/>
                <input type="hidden" id="formid" name="formid" value="4" />
                <input type="hidden" id="id" name="id" value="<%= iId %>" />
                <input type="hidden" id="precioadulto" name="precioadulto" value="<%= iPrecioadulto %>" />
                <input type="hidden" id="precionino" name="precionino" value="<%= iPrecionino %>" />
                <input type="hidden" id="precioinfante" name="precioinfante" value="<%= iPrecioinfante %>" />

                
                <br><br>
                <a href="AeropuertoServlet?formid=1">Buscar vuelos</a>
                  
            </form>
       -->
        <div class="container">    
            <form id="myform" name="myform" action="AeropuertoServlet" method="get">
                <div class="form-group">
                  <label for="exampleInputEmail1">Primer nombre</label>
                  <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Insertar nombre">
                  <small id="snombre" name="snombre" class="form-text text-muted">Tus datos no seran comartidos con alguien mas</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Primer apellido</label>
                  <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Interte su primer apellido">
                </div>
                <div class="form-group">
                  <label for="exampleInputTarjeta">Tarjeta</label>
                   <select class="form-control" id="tarjeta" name="tarjeta" type="text" >
                    <option value="Visa">Visa</option>
                    <option value="MasterCard">MasterCard</option>
                    </select>
                </div>
                <div class="form-group">
                  <label for="exampleInputNoTarjeta">Numero de tarjeta</label>
                  <input type="number" class="form-control" id="notarjeta" name="notarjeta" placeholder="Inserte su numero de tarjeta de credito o debito">
                </div>
                <div class="form-group">
                  <label for="exampleInputTelefono">Telefono</label>
                  <input type="number" class="form-control" id="telefono" name="telefono" placeholder="Inserte su numero de telefono">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail">Email</label>
                  <input type="text" class="form-control" id="email" name="email" placeholder="Inserte su direccion de correo electronico">
                </div>
                <div class="form-group">
                  <label for="exampleInputAdulto">Cantidad de adultos (+12 años)</label>
                  <input type="number" class="form-control" id="adultos" name="adultos" placeholder="Inserte la cantidad de adultos">
                </div>
                <div class="form-group">
                  <label for="exampleInputNiño">Cantidad de niños (12-2 años)</label>
                  <input type="number" class="form-control" id="ninos" name="ninos" placeholder="Inserte la cantidad de niños">
                </div>
                <div class="form-group">
                  <label for="exampleInputInfante">Cantidad de adultos (+12 años)</label>
                  <input type="number" class="form-control" id="infantes" name="infantes" placeholder="Inserte la cantidad de infantes">
                </div>
               
                <button type="submit" id="mysubmit" name="mysubmit" Value="Comprar" class="btn btn-primary">Comprar</button>
                <input type="hidden" id="formid" name="formid" value="4" />
                <input type="hidden" id="id" name="id" value="<%= iId %>" />
                <input type="hidden" id="precioadulto" name="precioadulto" value="<%= iPrecioadulto %>" />
                <input type="hidden" id="precionino" name="precionino" value="<%= iPrecionino %>" />
                <input type="hidden" id="precioinfante" name="precioinfante" value="<%= iPrecioinfante %>" />
                
                <br><br>
                  <a class="btn btn-primary" href="AeropuertoServlet?formid=1" role="button">Buscar vuelos</a>
          </form>
          <br>
        
        
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
        </div>
        </div>
        </footer>
        <script src="js/jquery.js" ></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>
