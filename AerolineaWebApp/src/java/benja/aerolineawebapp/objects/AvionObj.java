package benja.aerolineawebapp.objects;

public class AvionObj 
{
    //Variables de intancia
    private int m_iId;
    private String m_strNombre;
    private String m_strModelo;
    private String m_strMarca;
    private int m_iCapacidad;
    
    //Método constructor

    public AvionObj(int p_iId, String p_strNombre, String p_strModelo, String p_strMarca, int p_iCapacidad) 
    {
        setId(p_iId);
        setNombre(p_strNombre);
        setModelo(p_strModelo);
        setMarca(p_strMarca);
        setCapacidad(p_iCapacidad);
    }
    
    
    //Getters and setters

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public String getNombre() 
    {
        return m_strNombre;
    }

    private void setNombre(String p_strNombre) 
    {
        m_strNombre = p_strNombre;
    }

    public String getModelo() 
    {
        return m_strModelo;
    }

    private void setModelo(String p_strModelo) 
    {
        m_strModelo = p_strModelo;
    }

    public String getMarca() 
    {
        return m_strMarca;
    }

    private void setMarca(String p_strMarca) 
    {
        m_strMarca = p_strMarca;
    }

    public int getCapacidad() 
    {
        return m_iCapacidad;
    }

    private void setCapacidad(int p_iCapacidad) 
    {
        m_iCapacidad = p_iCapacidad;
    }
}
