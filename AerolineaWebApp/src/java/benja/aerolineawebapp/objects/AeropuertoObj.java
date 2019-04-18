package benja.aerolineawebapp.objects;

public class AeropuertoObj 
{
    //Variables de instancia
    private int m_iId;
    private String m_strNombre;
    private String m_strPais;
    private String m_strCiudad;
    
    //Metodo constructor

    public AeropuertoObj(int p_iId, String p_strNombre, 
            String p_strPais, String p_strCiudad) 
    {
        setId(p_iId);
        setNombre(p_strNombre);
        setPais(p_strPais);
        setCiudad(p_strCiudad);
    }
    
    //getters and setters
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

    public String getPais() 
    {
        return m_strPais;
    }

    private void setPais(String p_strPais) 
    {
        m_strPais = p_strPais;
    }

    public String getCiudad() 
    {
        return m_strCiudad;
    }

    private void setCiudad(String p_strCiudad) 
    {
        m_strCiudad = p_strCiudad;
    }
    
}
