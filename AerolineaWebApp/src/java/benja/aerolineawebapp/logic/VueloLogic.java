
package benja.aerolineawebapp.logic;


import benja.aerolineawebapp.database.DatabaseX;
import benja.aerolineawebapp.objects.VueloObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VueloLogic extends Logic
{
    //Metodo 1
     public boolean insertVuelosBool(int p_iId, int p_iIdAvion, String p_strFechaPartida, String p_strHoraPartida,
             int p_iIdAeropuertoPartida, String p_strFechaLlegada, String p_strHoraLlegada,
             int p_iIdAeropuertoDestino, int p_iPrecioAdulto, int p_iPrecioNino, int p_iPrecioInfante)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.vuelo (id,idAvion,fechaPartida,"
                + "horaPartida,idAeropuertoPartida,"
                + "fechaLlegada,horaLlegada,idAeropuertoDestino,"
                + "PrecioAdulto,PrecioNino,PrecioInfante)" 
                + "VALUES (0,"+p_iIdAvion+",'"+p_strFechaPartida+"',"
                + "'"+p_strHoraPartida+"',"+p_iIdAeropuertoPartida+",'"+p_strFechaLlegada+"',"
                + "'"+p_strHoraLlegada+"',"+p_iIdAeropuertoDestino+","+p_iPrecioAdulto+","+p_iPrecioNino+","+p_iPrecioInfante+"); ";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    //Metodo 2
    public int insertVueloRows(int p_iIdAvion, String p_strFechaPartida, String p_strHoraPartida,
             int p_iIdAeropuertoPartida, String p_strFechaLlegada, String p_strHoraLlegada,
             int p_iIdAeropuertoDestino, int p_iPrecioAdulto, int p_iPrecioNino, int p_iPrecioInfante) 
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.vuelo (id,idAvion,fechaPartida,"
                + "horaPartida,idAeropuertoPartida,"
                + "fechaLlegada,horaLlegada,idAeropuertoDestino,"
                + "PrecioAdulto,PrecioNino,PrecioInfante)" 
                + "VALUES (0,"+p_iIdAvion+",'"+p_strFechaPartida+"',"
                + "'"+p_strHoraPartida+"',"+p_iIdAeropuertoPartida+",'"+p_strFechaLlegada+"',"
                + "'"+p_strHoraLlegada+"',"+p_iIdAeropuertoDestino+","+p_iPrecioAdulto+","+p_iPrecioNino+","+p_iPrecioInfante+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    //Metodo 3
    public ArrayList<VueloObj> getAllVuelos() 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM aerolinea.vuelo ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<VueloObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iIdAvion;
            String strFechaPartida;
            String strHoraPartida;
            int iIdAeropuertoPartida;
            String strFechaLlegada;
            String strHoraLlegada;
            int iIdAeropuertoDestino;
            int iPrecioAdulto;
            int iPrecioNino;
            int iPrecioInfante;
         
            VueloObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdAvion = CResult.getInt("idAvion");
                    strFechaPartida = CResult.getString("fechaPartida");
                    strHoraPartida= CResult.getString("horaPartida");
                    iIdAeropuertoPartida = CResult.getInt("idAeropuertoPartida");
                    strFechaLlegada = CResult.getString("fechaLlegada");
                    strHoraLlegada= CResult.getString("horaLlegada");
                    iIdAeropuertoDestino = CResult.getInt("idAeropuertoDestino");
                    iPrecioAdulto = CResult.getInt("PrecioAdulto");
                    iPrecioNino = CResult.getInt("PrecioNino");
                    iPrecioInfante = CResult.getInt("PrecioInfante");
                    
                    CTemp = new VueloObj(iId, iIdAvion, strFechaPartida, strHoraPartida,
                            iIdAeropuertoPartida, strFechaLlegada, strHoraLlegada,
                            iIdAeropuertoDestino, iPrecioAdulto, iPrecioNino, iPrecioInfante);
                    
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(VueloLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    //Metodo 4
    public int deleteVueloRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "vuelo");
        return iRows;
    }
    //Metodo 5
    public VueloObj getVuelosById(int p_iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from aerolinea.vuelo where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        VueloObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iIdAvion;
            String strFechaPartida;
            String strHoraPartida;
            int iIdAeropuertoPartida;
            String strFechaLlegada;
            String strHoraLlegada;
            int iIdAeropuertoDestino;
            int iPrecioAdulto;
            int iPrecioNino;
            int iPrecioInfante;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdAvion = CResult.getInt("idAvion");
                    strFechaPartida = CResult.getString("fechaPartida");
                    strHoraPartida = CResult.getString("horaPartida");
                    iIdAeropuertoPartida = CResult.getInt("idAeropuertoPartida");
                    strFechaLlegada = CResult.getString("fechaLlegada");
                    strHoraLlegada = CResult.getString("horaLlegada");
                    iIdAeropuertoDestino = CResult.getInt("idAeropuertoDestino");
                    iPrecioAdulto = CResult.getInt("PrecioAdulto");
                    iPrecioNino = CResult.getInt("PrecioNino");
                    iPrecioInfante = CResult.getInt("PrecioInfante");
                    
                    CTemp = new VueloObj(iId, iIdAvion, strFechaPartida, strHoraPartida, iIdAeropuertoPartida,
                    strFechaLlegada, strHoraLlegada, iIdAeropuertoDestino,iPrecioAdulto, iPrecioNino,
                    iPrecioInfante);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(VueloLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
    
    //Metodo 6
    public int updateVueloRows(int p_iId, int p_iIdAvion, String p_strFechaPartida, String p_strHoraPartida,
            int p_iIdAeropuertoPartida, String p_strFechaLlegada, String p_strHoraLlegada, int p_iIdAeropuertoDestino, 
            int p_iPrecioAdulto, int p_iPrecioNino, int p_iPrecioInfante) 
    {

        DatabaseX database = getDatabase();
        String strSql = "UPDATE aerolinea.vuelo " +
                        "SET idAvion = "+p_iIdAvion+",fechaPartida = '"+p_strFechaPartida+"'," +
                        "horaPartida = '"+p_strHoraPartida+"',idAeropuertoPartida = "+p_iIdAeropuertoPartida+"," +
                        "fechaLlegada = '"+p_strFechaLlegada+"',horaLlegada = '"+p_strHoraLlegada+"',"
                        + "idAeropuertoDestino = "+p_iIdAeropuertoDestino+"," +
                        "PrecioAdulto = "+p_iPrecioAdulto+",PrecioNino = "+p_iPrecioNino+",PrecioInfante = "+p_iPrecioInfante+"" +
                        " WHERE id = "+p_iId+"; ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
 }