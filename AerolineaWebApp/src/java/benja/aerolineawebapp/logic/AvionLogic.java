package benja.aerolineawebapp.logic;

import benja.aerolineawebapp.database.DatabaseX;
import benja.aerolineawebapp.objects.AvionObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvionLogic extends Logic
{
    //Metodo 1
     public boolean insertAvionBool(String p_strNombre, String p_strModelo, String p_strMarca, int p_iCapacidad)
    {
        //INSERT INTO aerolinea.avion(id,nombre,modelo,marca,capacidad)
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.avion(id,nombre,modelo,marca,capacidad)"
                + " VALUES(0,'"+p_strNombre+"','"+p_strModelo+"','"+p_strMarca+"',"+p_iCapacidad+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //Metodo 2
    public int insertAvionRows(String p_strNombre, String p_strModelo, String p_strMarca, int p_iCapacidad)
    {
        //INSERT INTO aerolinea.avion(id,nombre,modelo,marca,capacidad)
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO aerolinea.avion(id,nombre,modelo,marca,capacidad)"
                + " VALUES(0,'"+p_strNombre+"','"+p_strModelo+"','"+p_strMarca+"',"+p_iCapacidad+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    //Metodo 3
    public ArrayList<AvionObj> getAllAviones() 
    {
        //SELECT * FROM aerolinea.avion;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM aerolinea.avion ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<AvionObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strModelo;
            String strMarca;
            int iCapacidad;

            
            AvionObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strModelo = CResult.getString("modelo");
                    strMarca = CResult.getString("marca");
                    iCapacidad = CResult.getInt("capacidad");
                    
                    
                    CTemp = new AvionObj(iId, strNombre, strModelo, strMarca, iCapacidad);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AvionLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    //Metodo 4
    public int deleteAvionRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "avion");
        return iRows;
    }
    
    //Metodo 5
    public AvionObj getAvionById(int p_iId) 
    {
        //SELECT * FROM aerolinea.avion;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM aerolinea.avion WHERE id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        AvionObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strModelo;
            String strMarca;
            int iCapacidad;
            
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strModelo = CResult.getString("modelo");
                    strMarca = CResult.getString("marca");
                    iCapacidad = CResult.getInt("capacidad");

                    
                    CTemp = new AvionObj(iId, strNombre, strModelo, strMarca, iCapacidad);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AvionLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
    
    //Metodo 6
    public int updateAvionRows(int p_iId, String p_strNombre, String p_strModelo, String p_strMarca, int p_iCapacidad) 
    {
        //update aerolinea.aeropuerto set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        
        String strSql = "UPDATE aerolinea.avion SET nombre = '"+p_strNombre+"',modelo = '"+p_strModelo+"'," +
                        "marca = '"+p_strMarca+"',capacidad = "+p_iCapacidad+"" +
                        " WHERE id = "+p_iId+";";
        
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
