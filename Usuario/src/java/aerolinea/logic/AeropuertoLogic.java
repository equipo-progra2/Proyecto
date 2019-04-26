package aerolinea.logic;

import aerolinea.database.DatabaseX;
import aerolinea.objects.VueloObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeropuertoLogic extends Logic{

    public ArrayList<String> obtenerpaises() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select pais from aerolinea.aeropuerto ";
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<String> CArray = null;
        
        if(CResult!=null)
        {   
            String strPais;
            CArray = new ArrayList<>();
            try {
                while(CResult.next())
                {
                    strPais = CResult.getString("pais");
                    CArray.add(strPais);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return CArray; 
    }

    public ArrayList<VueloObj> obtenervuelos(String strPais1, String strPais2) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select av.id, idAvion, fechaPartida, horaPartida, aa1.nombre as Aero1, fechaLlegada, horaLlegada, aa2.nombre as Aero2, PrecioAdulto, PrecioNiño, PrecioInfante, aa1.ciudad as CiudadPartida, aa2.ciudad as CiudadLlegada \n" +
                        "from aerolinea.vuelo av inner join aerolinea.aeropuerto aa1\n" +
                        "inner join aerolinea.aeropuerto aa2 on av.idAeropuertoPartida = aa1.id  \n" +
                        "and av.idAeropuertoDestino = aa2.id \n" +
                        "where aa1.pais = '"+strPais1+"' and aa2.pais = '"+strPais2+"'";
        
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<VueloObj> CArray = null;
        
        if(CResult!=null)
        {   
            int iId;
            int iIdAvion;
            String strFechaPartida;
            String strHoraPartida;
            String strAeroPartida;
            String strFechaLlegada;
            String strHoraLlegada;
            String strAeroLlegada;
            int iPrecioAdulto;
            int iPrecioNino;
            int iPrecioInfante;
            String strCiudadPartida;
            String strCiudadLlegada;
            
            CArray = new ArrayList<>();
            VueloObj CTemp;
            
            try {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdAvion = CResult.getInt("idAvion");
                    strFechaPartida = CResult.getString("fechaPartida");
                    strHoraPartida = CResult.getString("horaPartida");
                    strAeroPartida = CResult.getString("Aero1");
                    strFechaLlegada = CResult.getString("fechaLlegada");
                    strHoraLlegada = CResult.getString("horaLlegada");
                    strAeroLlegada = CResult.getString("Aero2");
                    iPrecioAdulto = CResult.getInt("PrecioAdulto");
                    iPrecioNino = CResult.getInt("PrecioNiño");
                    iPrecioInfante = CResult.getInt("PrecioInfante");
                    strCiudadPartida = CResult.getString("CiudadPartida");
                    strCiudadLlegada = CResult.getString("CiudadLlegada");
                    
                    
                    CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                    CArray.add(CTemp);
                            
                }
            } catch (SQLException ex) {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return CArray;
    }
    
    public ArrayList<VueloObj> obtenervuelosdisponibles(String strPais1, String strPais2) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select av.id, idAvion, fechaPartida, horaPartida, aa1.nombre as Aero1, fechaLlegada, horaLlegada, aa2.nombre as Aero2, PrecioAdulto, PrecioNiño, PrecioInfante, aa1.ciudad as CiudadPartida, aa2.ciudad as CiudadLlegada \n" +
                        "from aerolinea.vuelo av inner join aerolinea.aeropuerto aa1\n" +
                        "inner join aerolinea.aeropuerto aa2 on av.idAeropuertoPartida = aa1.id  \n" +
                        "and av.idAeropuertoDestino = aa2.id \n" +
                        "where aa1.pais = '"+strPais1+"' and aa2.pais = '"+strPais2+"'";
        
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<VueloObj> CArray = null;
        
        if(CResult!=null)
        {   
            int iId;
            int iIdAvion;
            String strFechaPartida;
            String strHoraPartida;
            String strAeroPartida;
            String strFechaLlegada;
            String strHoraLlegada;
            String strAeroLlegada;
            int iPrecioAdulto;
            int iPrecioNino;
            int iPrecioInfante;
            String strCiudadPartida;
            String strCiudadLlegada;
            
            CArray = new ArrayList<>();
            VueloObj CTemp;
            
            try {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdAvion = CResult.getInt("idAvion");
                    strFechaPartida = CResult.getString("fechaPartida");
                    strHoraPartida = CResult.getString("horaPartida");
                    strAeroPartida = CResult.getString("Aero1");
                    strFechaLlegada = CResult.getString("fechaLlegada");
                    strHoraLlegada = CResult.getString("horaLlegada");
                    strAeroLlegada = CResult.getString("Aero2");
                    iPrecioAdulto = CResult.getInt("PrecioAdulto");
                    iPrecioNino = CResult.getInt("PrecioNiño");
                    iPrecioInfante = CResult.getInt("PrecioInfante");
                    strCiudadPartida = CResult.getString("CiudadPartida");
                    strCiudadLlegada = CResult.getString("CiudadLlegada");
                    
                    String strDiaVuelo = strFechaPartida.substring(8, 10);
                    int iDiaVuelo = Integer.parseInt(strDiaVuelo);
                    String strMesVuelo = strFechaPartida.substring(5, 7);
                    int iMesVuelo = Integer.parseInt(strMesVuelo);
                    String strAnioVuelo = strFechaPartida.substring(0, 4);
                    int iAnioVuelo = Integer.parseInt(strAnioVuelo);
                    
                    Date fecha = new Date();
                    SimpleDateFormat formatofecha = new SimpleDateFormat("ddMMYYYY");
                    String strFechaActual = formatofecha.format(fecha);
                    String strDiaActual = strFechaActual.substring(0, 2);
                    int iDiaActual = Integer.parseInt(strDiaActual);
                    String strMesActual = strFechaActual.substring(2, 4);
                    int iMesActual = Integer.parseInt(strMesActual);
                    String strAnioActual = strFechaActual.substring(4, 8);
                    int iAnioActual = Integer.parseInt(strAnioActual);
                    
                    String hora, minutos;
                    Calendar calendario = new GregorianCalendar();
                    Date horaActual = new Date();
                    calendario.setTime(horaActual);
                    hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
                    int iHoraActual = Integer.parseInt(hora);
                    minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
                    int iMinutoActual = Integer.parseInt(minutos);
                    
                    String strHoraVuelo = strHoraPartida.substring(0,2);
                    int iHoraVuelo = Integer.parseInt(strHoraVuelo);
                    String strMinutoVuelo = strHoraPartida.substring(3,5);
                    int iMinutoVuelo = Integer.parseInt(strMinutoVuelo);
                    
                    if(iAnioVuelo>iAnioActual)
                    {
                        CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                        CArray.add(CTemp);
                    }
                    else if(iAnioVuelo==iAnioActual)
                    {
                        if(iMesVuelo>iMesActual)
                        {   
                            CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                            CArray.add(CTemp);
                        }
                        else if(iMesVuelo==iMesActual)
                        {
                            if(iDiaVuelo>iDiaActual)
                            {
                                CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                                CArray.add(CTemp);
                            }
                            else if(iDiaVuelo==iDiaActual)
                            {
                                if(iHoraVuelo>iHoraActual)
                                {
                                    CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                                    CArray.add(CTemp);
                                }
                                else if(iHoraVuelo==iHoraActual)
                                {
                                    if(iMinutoVuelo>iMinutoActual)
                                    {
                                        CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                                        CArray.add(CTemp);
                                    }
                                }
                            }
                        }
                    }       
                }
            } catch (SQLException ex) {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return CArray;
    }

    public void introducirventa(String strNombre, String strApellido, String strFecha, String strTarjeta, int iNoTarjeta, int iTelefono, String strEmail, int iAdultos, int iNinos, int iInfantes, int iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `aerolinea`.`compra`(`id`,`fecha`,`nombre`,`apellido`,`tarjeta`,`numero de tarjeta`,`telefono`,`email`,`adulto`,`niño`,`infante`,`vuelo`)VALUES (0, '"+strFecha+"', '"+strNombre+"', '"+strApellido+"', '"+strTarjeta+"', "+iNoTarjeta+", "+iTelefono+", '"+strEmail+"', "+iAdultos+", "+iNinos+", "+iInfantes+", "+iId+")";
        database.executeNonQueryBool(strSql);
    }

    public ArrayList<VueloObj> idVuelo(int idVuelo) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select av.id, idAvion, fechaPartida, horaPartida, aa1.nombre as Aero1, fechaLlegada, horaLlegada, aa2.nombre as Aero2, PrecioAdulto, PrecioNiño, PrecioInfante, aa1.ciudad as CiudadPartida, aa2.ciudad as CiudadLlegada \n" +
                        "from aerolinea.vuelo av inner join aerolinea.aeropuerto aa1\n" +
                        "inner join aerolinea.aeropuerto aa2 on av.idAeropuertoPartida = aa1.id  \n" +
                        "and av.idAeropuertoDestino = aa2.id \n" +
                        "where av.id = "+idVuelo;
                
                
                /*"select * from aerolinea.vuelo where id = " +idVuelo;*/
        
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<VueloObj> CArray = null;
        
        if(CResult!=null)
        {   
            int iId;
            int iIdAvion;
            String strFechaPartida;
            String strHoraPartida;
            String strAeroPartida;
            String strFechaLlegada;
            String strHoraLlegada;
            String strAeroLlegada;
            int iPrecioAdulto;
            int iPrecioNino;
            int iPrecioInfante;
            String strCiudadPartida;
            String strCiudadLlegada;
            
            CArray = new ArrayList<>();
            VueloObj CTemp;
            
            try {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdAvion = CResult.getInt("idAvion");
                    strFechaPartida = CResult.getString("fechaPartida");
                    strHoraPartida = CResult.getString("horaPartida");
                    strAeroPartida = CResult.getString("Aero1");
                    strFechaLlegada = CResult.getString("fechaLlegada");
                    strHoraLlegada = CResult.getString("horaLlegada");
                    strAeroLlegada = CResult.getString("Aero2");
                    iPrecioAdulto = CResult.getInt("PrecioAdulto");
                    iPrecioNino = CResult.getInt("PrecioNiño");
                    iPrecioInfante = CResult.getInt("PrecioInfante");
                    strCiudadPartida = CResult.getString("CiudadPartida");
                    strCiudadLlegada = CResult.getString("CiudadLlegada");
                    
                    CTemp = new VueloObj(iId,iIdAvion,strFechaPartida,strHoraPartida,strAeroPartida,strFechaLlegada,strHoraLlegada,strAeroLlegada,iPrecioAdulto,iPrecioNino,iPrecioInfante,strCiudadPartida,strCiudadLlegada);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return CArray;
    }
    
}
