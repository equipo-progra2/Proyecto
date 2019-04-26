
<%@page import="benja.aerolineawebapp.objects.AvionObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="benja.aerolineawebapp.objects.AeropuertoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/NewVueloScript.js" type="text/javascript"></script>
        <title>Nuevo vuelo</title>
    </head>
    <%
        ArrayList<AeropuertoObj> AAArray = 
                (ArrayList<AeropuertoObj>)request.getSession().getAttribute("aeropuertos");
        Iterator<AeropuertoObj> iteAeropuertoArray = AAArray.iterator();
        
        ArrayList<AeropuertoObj> AAArray2 = 
                (ArrayList<AeropuertoObj>)request.getSession().getAttribute("aeropuertos");
        Iterator<AeropuertoObj> iteAeropuertoArray2 = AAArray2.iterator();
        
        ArrayList<AvionObj> AvFromArray = 
                (ArrayList<AvionObj>)request.getSession().getAttribute("aviones");
        Iterator<AvionObj> iteAvionArray = AvFromArray.iterator();

    %>    
    <body>
        <h1>Nuevo vuelo</h1>
        <p>Para agregar un nuevo vuelo, por favor, complete los siguientes campos:</p><br>

        <form id="myform" name="myform" action="VueloServlet" method="get">
            <label>IdAvion:</label><br>
            <select id="idavion" name="idavion">
                <option id="idavion0" name="idavion0" value="0"></option>                
                <%
                    if(iteAvionArray!=null)
                    {
                        AvionObj CClientTemp;
                        while(iteAvionArray.hasNext())
                        {
                            CClientTemp = iteAvionArray.next();
                %>
                            <option id="idavion<%= CClientTemp.getId() %>" 
                                    name="idavion<%= CClientTemp.getId() %>" 
                                    value="<%= CClientTemp.getId() %>">
                                <%= CClientTemp.getNombre() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>

            <label>Fecha de Partida:</label><br>
            <input type="date" id="fechapartida" name="fechapartida"/>
            <br><br>
            
            <label>Hora de Partida:</label><br>
            <input type="time" id="horapartida" name="horapartida"/>
            <br><br>
            
            <label>Id Aeropuerto de Partida:</label><br>
            <select id="aeropuertopartida" name="aeropuertopartida">
                <option id="aeropuertopartida" name="aeropuertopartida" value="0"></option>                
                <%
                    if(iteAeropuertoArray!=null)
                    {
                        AeropuertoObj CClientTemp;
                        while(iteAeropuertoArray.hasNext())
                        {
                            CClientTemp = iteAeropuertoArray.next();
                %>
                            <option id="aeropuertopartida<%= CClientTemp.getId() %>" 
                                    name="aeropuertopartida<%= CClientTemp.getId() %>" 
                                    value="<%= CClientTemp.getId() %>">
                                <%= CClientTemp.getNombre() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Fecha de Llegada:</label><br>
            <input type="date" id="fechallegada" name="fechallegada"/>
            <br><br>

            <label>Hora de Llegada:</label><br>
            <input type="time" id="horallegada" name="horallegada"/>
            <br><br>
            
            <label>Id Aeropuerto de Destino:</label><br>
            <select id="aeropuertodestino" name="aeropuertodestino">
                <option id="aeropuertodestino0" name="aeropuertodestino0" value="0"></option>                
                <%
                    if(iteAeropuertoArray2!=null)
                    {
                        AeropuertoObj CClientTemp2;
                        while(iteAeropuertoArray2.hasNext())
                        {
                            CClientTemp2 = iteAeropuertoArray2.next();
                %>
                            <option id="aeropuertodestino<%= CClientTemp2.getId() %>" 
                                    name="aeropuertodestino<%= CClientTemp2.getId() %>" 
                                    value="<%= CClientTemp2.getId() %>">
                                <%= CClientTemp2.getNombre() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Precio de Adulto:</label><br>
            <input type="number" id="precioadulto" name="precioadulto"/>
            <br><br>
            
            <label>Precio de Nino:</label><br>
            <input type="number" id="precionino" name="precionino"/>
            <br><br>
            
            <label>Precio de Infante:</label><br>
            <input type="number" id="precioinfante" name="precioinfante"/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/>
            <input type="hidden" id="formid" name="formid" value="1" />

        </form>
    </body>
</html>
