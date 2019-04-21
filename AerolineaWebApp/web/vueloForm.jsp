<%@page import="java.util.Iterator"%>
<%@page import="benja.aerolineawebapp.objects.VueloObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vuelo</title>
    </head>
    
    <%
        ArrayList<VueloObj> CArray = 
                (ArrayList<VueloObj>)request.getSession().getAttribute("vuelos");
        Iterator<VueloObj> iteArray = CArray.iterator();
    %>
    
    <body>
       <h1>Vuelo</h1>
        <br>
        <a href="vueloNew.html">Agregar Vuelo</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Id Avion</th>
            <th>Fecha Partida</th>
            <th>Hora Partida</th>
            <th>Id Aeropuerto Partida</th>
            <th>Fecha Llegada</th>
            <th>Hora Llegada</th>
            <th>Id Aeropuerto Destino</th>
            <th>Precio Adulto</th>
            <th>Precio Nino</th>
            <th>Precio Infante</th>
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
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getIdAvion() %></td>
                    <td><%= CTemp.getFechaPartida() %></td>
                    <td><%= CTemp.getHoraPartida() %></td>
                    <td><%= CTemp.getIdAeropuertoPartida() %></td>
                    <td><%= CTemp.getFechaLlegada() %></td>
                    <td><%= CTemp.getHoraLlegada() %></td>
                    <td><%= CTemp.getIdAeropuertoDestino() %></td>
                    <td><%= CTemp.getPrecioAdulto() %></td>
                    <td><%= CTemp.getPrecioNino() %></td>
                    <td><%= CTemp.getPrecioInfante() %></td>
                    
                    <td>
                        <a href="VueloServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="VueloServlet?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
