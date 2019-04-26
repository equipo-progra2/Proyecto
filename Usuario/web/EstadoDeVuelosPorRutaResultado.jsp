<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="aerolinea.objects.VueloObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vuelos disponibles</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <%
        ArrayList<VueloObj> CArray = 
                (ArrayList<VueloObj>)request.getSession().getAttribute("vuelos");
        Iterator<VueloObj> iteArray = CArray.iterator();
        
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYYMMdd");
        String strFechaActual = formatofecha.format(fecha);
        int iFechaActual = Integer.parseInt(strFechaActual);
        
        String hora, minutos, segundos;
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        String strHoraFinal = hora + minutos + segundos;
        //int iHoraFinal = Integer.parseInt(strHoraFinal);
        
        String strHorarioActual = strFechaActual + strHoraFinal;
        double iHorarioActual = Double.parseDouble(strHorarioActual);
        System.out.println(iHorarioActual);
        
        String strEstadoDeVuelo;
        strEstadoDeVuelo = "";
        
        String strFechaPartidaVuelo;
        String strFechaLlegadaVuelo;
        String strHoraPartidaVuelo;
        String strHoraLlegadaVuelo;
       //int iFechaPartidaVuelo;
        //int iFechaLlegadaVuelo;
        //int iHoraPartidaVuelo;
        //int iHoraLlegadaVuelo;
        
        String strHorarioPartida;
        String strHorarioLlegada;
        double iHorarioPartida;
        double iHorarioLlegada;
        
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
        <h1>Vuelos disponibles</h1>
        <br><br>
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
            <th>Estado del vuelo</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                VueloObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
                    
                    strFechaPartidaVuelo = CTemp.getFechaPartida();
                    strFechaLlegadaVuelo = CTemp.getFechaLlegada();
                    strHoraPartidaVuelo = CTemp.getHoraPartida();
                    strHoraLlegadaVuelo = CTemp.getHoraLlegada();
                    
                    char[] FechaPartidaVueloCadena = strFechaPartidaVuelo.toCharArray();
                    String FechaPartidaVueloFinal;
                    FechaPartidaVueloFinal = Integer.toString(FechaPartidaVueloCadena[0]-48)+Integer.toString(FechaPartidaVueloCadena[1]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[2]-48)+Integer.toString(FechaPartidaVueloCadena[3]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[5]-48)+Integer.toString(FechaPartidaVueloCadena[6]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[8]-48)+Integer.toString(FechaPartidaVueloCadena[9]-48);
                            
                                            /*Integer.toString(FechaPartidaVueloCadena[6]-48)+Integer.toString(FechaPartidaVueloCadena[7]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[8]-48)+Integer.toString(FechaPartidaVueloCadena[9]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[3]-48)+Integer.toString(FechaPartidaVueloCadena[4]-48)+
                                             Integer.toString(FechaPartidaVueloCadena[0]-48)+Integer.toString(FechaPartidaVueloCadena[1]-48);*/
                    //System.out.println(FechaPartidaVueloFinal);
                    
                    
                    
                    char[] FechaLlegadaVueloCadena = strFechaLlegadaVuelo.toCharArray();
                    String FechaLlegadaVueloFinal;
                    FechaLlegadaVueloFinal = Integer.toString(FechaLlegadaVueloCadena[0]-48)+Integer.toString(FechaLlegadaVueloCadena[1]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[2]-48)+Integer.toString(FechaLlegadaVueloCadena[3]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[5]-48)+Integer.toString(FechaLlegadaVueloCadena[6]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[8]-48)+Integer.toString(FechaLlegadaVueloCadena[9]-48);
                                           /*Integer.toString(FechaLlegadaVueloCadena[0]-48)+Integer.toString(FechaLlegadaVueloCadena[1]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[3]-48)+Integer.toString(FechaLlegadaVueloCadena[4]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[6]-48)+Integer.toString(FechaLlegadaVueloCadena[7]-48)+
                                             Integer.toString(FechaLlegadaVueloCadena[8]-48)+Integer.toString(FechaLlegadaVueloCadena[9]-48);*/
                    //System.out.println(FechaLlegadaVueloFinal);
                    
                    char[] HoraPartidaVueloCadena = strHoraPartidaVuelo.toCharArray();
                    String HoraPartidaVueloFinal;
                    HoraPartidaVueloFinal = Integer.toString(HoraPartidaVueloCadena[0]-48)+Integer.toString(HoraPartidaVueloCadena[1]-48)+
                                            Integer.toString(HoraPartidaVueloCadena[3]-48)+Integer.toString(HoraPartidaVueloCadena[4]-48)+"0"+"0";
                    //System.out.println(HoraPartidaVueloFinal);
                    
                    char[] HoraLlegadaVueloCadena = strHoraLlegadaVuelo.toCharArray();
                    String HoraLlegadaVueloFinal;
                    HoraLlegadaVueloFinal = Integer.toString(HoraLlegadaVueloCadena[0]-48)+Integer.toString(HoraLlegadaVueloCadena[1]-48)+
                                            Integer.toString(HoraLlegadaVueloCadena[3]-48)+Integer.toString(HoraLlegadaVueloCadena[4]-48)+"0"+"0";
                    //System.out.println(HoraLlegadaVueloFinal);
                    
                    
                    //iFechaPartidaVuelo = Integer.parseInt(FechaPartidaVueloFinal);
                    //iFechaLlegadaVuelo = Integer.parseInt(FechaLlegadaVueloFinal);
                    //iHoraPartidaVuelo = Integer.parseInt(HoraPartidaVueloFinal);
                    //iHoraLlegadaVuelo = Integer.parseInt(HoraLlegadaVueloFinal);
                    
                    strHorarioPartida = FechaPartidaVueloFinal + HoraPartidaVueloFinal;
                    strHorarioLlegada = FechaLlegadaVueloFinal + HoraLlegadaVueloFinal;
                    
                    iHorarioPartida = Double.parseDouble(strHorarioPartida);
                    iHorarioLlegada = Double.parseDouble(strHorarioLlegada);
                    System.out.println(iHorarioPartida);
                    System.out.println(iHorarioLlegada);
                    
                    if(iHorarioActual<iHorarioPartida)
                        {
                            strEstadoDeVuelo = "Sin despegar";
                        }
                    else if (iHorarioActual >= iHorarioPartida && iHorarioActual <= iHorarioLlegada)
                        {
                            strEstadoDeVuelo = "En vuelo";  
                        }
                    else if (iHorarioActual > iHorarioLlegada)
                        {
                            strEstadoDeVuelo = "Aterrizo";
                        }
                     
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
                    <td><%= strEstadoDeVuelo %><td>
        </tr>
        
        <%
                }
            }
        %>
        
        </table>
        <br><br>
        <a class="btn btn-primary" href="EstadoDeVuelos.html" role="button">Realizar otra consulta</a>
     
        </div>
        
        <br><br><br>
        <br><br><br>
        <br><br><br>
        <br><br>
        
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
