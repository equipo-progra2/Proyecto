<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="benja.aerolineawebapp.objects.AvionObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Avion</title>
    </head>
    <%
        ArrayList<AvionObj> CArray = 
                (ArrayList<AvionObj>)request.getSession().getAttribute("aviones");
        Iterator<AvionObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Avion</h1>
        <br>
        <a href="NewAvion.html">Agregar Aviones</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Capacidad</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                AvionObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombre() %></td>
                    <td><%= CTemp.getModelo() %></td>
                    <td><%= CTemp.getMarca() %></td>
                    <td><%= CTemp.getCapacidad() %></td>
                    <td>
                        <a href="AvionServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="AvionServlet?formid=3&id=<%= CTemp.getId() %>">
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
