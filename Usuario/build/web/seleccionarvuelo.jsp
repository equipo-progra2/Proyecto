<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleccionar Vuelo</title>
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
            <div class="row">
                <h1 class="col-md-12">Seleccionar Vuelo</h1>
                <br><br>
                <br><br>
                <form id="myform" name="myform" action="AeropuertoServlet" method="get">
              
                  
                <h3 >Pais de partida</h3><br>    
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
                <h3 >Pais de destino</h3>
                <br>
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

                <br><br>
                <br>

                <button type="submit" id="mysubmit" name="mysubmit" class="btn btn-primary">Ver opciones</button>
                
                <input type="hidden" id="formid" name="formid" value="2" />

                </form>

                <br><br>
            </div>
        </div>
         <script src="js/jquery.js" ></script>
         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>
