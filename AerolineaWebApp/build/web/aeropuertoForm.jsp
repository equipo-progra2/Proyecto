<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="benja.aerolineawebapp.objects.AeropuertoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aeropuerto</title>
    </head>
     <%
        ArrayList<AeropuertoObj> CArray = 
                (ArrayList<AeropuertoObj>)request.getSession().getAttribute("aeropuertos");
        Iterator<AeropuertoObj> iteArray = CArray.iterator();
    %>
    
    <body>
         <h1>Aeropuerto</h1>
        <br>
        <a href="aeropuertoNew.html">Agregar Aeropuerto</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Pais</th>
            <th>Ciudad</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                AeropuertoObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombre() %></td>
                    <td><%= CTemp.getPais() %></td>
                    <td><%= CTemp.getCiudad() %></td>
                    <td>
                        <a href="AeropuertoServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="AeropuertoServlet?formid=3&id=<%= CTemp.getId() %>">
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
