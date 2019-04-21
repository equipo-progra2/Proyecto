package benja.aerolineawebapp.logic;

import benja.aerolineawebapp.database.DatabaseX;
import benja.aerolineawebapp.objects.AeropuertoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeropuertoLogic extends Logic
{
    //Metodo 1
     public boolean insertAeropuertoBool(String p_strNombre, String p_strPais, String p_strCiudad)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.aeropuerto(id,nombre,pais,ciudad)"
                + " VALUES(0,'"+p_strNombre+"','"+p_strPais+"','"+p_strCiudad+"');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
     //Metodo 2
    public int insertAeropuertoRows(String p_strNombre,String p_strPais,String p_strCiudad)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.aeropuerto(id,nombre,pais,ciudad)"
                + " VALUES(0,'"+p_strNombre+"','"+p_strPais+"','"+p_strCiudad+"');";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    //Metodo 3
    public ArrayList<AeropuertoObj> getAllAeropuertos() 
    {
        //select * from aerolinea.aeeropuerto;
        DatabaseX database = getDatabase();
        String strSql = "select * from aerolinea.aeropuerto ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<AeropuertoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strPais;
            String strCiudad;

            
            AeropuertoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strPais = CResult.getString("pais");
                    strCiudad = CResult.getString("ciudad");
                    
                    
                    CTemp = new AeropuertoObj(iId, strNombre, strPais, strCiudad);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    //Metodo 4
    public int deleteAeropuertoRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "aeropuerto");
        return iRows;
    }
    
    //Metodo 5
    public AeropuertoObj getAeropuertoById(int p_iId) 
    {
        //select * from aerolinea.aeropuerto;
        DatabaseX database = getDatabase();
        String strSql = "select * from aerolinea.aeropuerto where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        AeropuertoObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strPais;
            String strCiudad;
            
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strPais = CResult.getString("pais");
                    strCiudad = CResult.getString("ciudad");

                    
                    CTemp = new AeropuertoObj(iId, strNombre, strPais, strCiudad);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AeropuertoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
    
    //Metodo 6
    public int updateAeropuertoRows(int p_iId, String p_strNombre, String p_strPais, String p_strCiudad) 
    {
        
        DatabaseX database = getDatabase();
        String strSql = "UPDATE aerolinea.aeropuerto "
                + "SET nombre = '"+p_strNombre+"',pais = '"+p_strPais+"',ciudad = '"+p_strCiudad+"'"
                + "WHERE id = "+p_iId+"; ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
