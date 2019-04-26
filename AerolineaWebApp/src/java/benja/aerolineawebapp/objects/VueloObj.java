package benja.aerolineawebapp.objects;
public class VueloObj 
{
    //Variables de instancia
    private int m_iId;
    private int m_iIdAvion;
    private String m_strFechaPartida;
    private String m_strHoraPartida;
    private int m_iIdAeropuertoPartida;
    private String m_strFechaLlegada;
    private String m_strHoraLlegada;
    private int m_iIdAeropuertoDestino;    
    private int m_iPrecioAdulto;
    private int m_iPrecioNiño;
    private int m_iPrecioInfante;
   
    //Metodo constructor

    public VueloObj(int p_iId, int p_iIdAvion, String p_strFechaPartida, 
            String p_strHoraPartida, int p_iIdAeropuertoPartida, 
            String p_strFechaLlegada, String p_strHoraLlegada, 
            int p_iIdAeropuertoDestino, int p_iPrecioAdulto, 
            int p_iPrecioNiño, int p_iPrecioInfante) 
    {
        setId(p_iId);
        setIdAvion(p_iIdAvion);
        setFechaPartida(p_strFechaPartida);
        setHoraPartida(p_strHoraPartida);
        setIdAeropuertoPartida(p_iIdAeropuertoPartida);
        setFechaLlegada(p_strFechaLlegada);
        setHoraLlegada(p_strHoraLlegada);
        setIdAeropuertoDestino(p_iIdAeropuertoDestino);
        setPrecioAdulto(p_iPrecioAdulto);
        setPrecioNiño(p_iPrecioNiño);
        setPrecioInfante(p_iPrecioInfante);
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

    public int getIdAvion() 
    {
        return m_iIdAvion;
    }

    private void setIdAvion(int p_iIdAvion) 
    {
        m_iIdAvion = p_iIdAvion;
    }

    public String getFechaPartida() 
    {
        return m_strFechaPartida;
    }

    private void setFechaPartida(String p_strFechaPartida) 
    {
        m_strFechaPartida = p_strFechaPartida;
    }

    public String getHoraPartida() 
    {
        return m_strHoraPartida;
    }

    private void setHoraPartida(String p_strHoraPartida) 
    {
        m_strHoraPartida = p_strHoraPartida;
    }

    public int getIdAeropuertoPartida() 
    {
        return m_iIdAeropuertoPartida;
    }

    private void setIdAeropuertoPartida(int p_iIdAeropuertoPartida) 
    {
        m_iIdAeropuertoPartida = p_iIdAeropuertoPartida;
    }

    public String getFechaLlegada() 
    {
        return m_strFechaLlegada;
    }

    private void setFechaLlegada(String p_strFechaLlegada) 
    {
        m_strFechaLlegada = p_strFechaLlegada;
    }

    public String getHoraLlegada() 
    {
        return m_strHoraLlegada;
    }

    private void setHoraLlegada(String p_strHoraLlegada) 
    {
        m_strHoraLlegada = p_strHoraLlegada;
    }

    public int getIdAeropuertoDestino() 
    {
        return m_iIdAeropuertoDestino;
    }

    private void setIdAeropuertoDestino(int p_iIdAeropuertoDestino) 
    {
        m_iIdAeropuertoDestino = p_iIdAeropuertoDestino;
    }

    public int getPrecioAdulto() 
    {
        return m_iPrecioAdulto;
    }

    private void setPrecioAdulto(int p_iPrecioAdulto) 
    {
        m_iPrecioAdulto = p_iPrecioAdulto;
    }

    public int getPrecioNiño() 
    {
        return m_iPrecioNiño;
    }

    private void setPrecioNiño(int p_iPrecioNiño) 
    {
        m_iPrecioNiño = p_iPrecioNiño;
    }

    public int getPrecioInfante() 
    {
        return m_iPrecioInfante;
    }

    private void setPrecioInfante(int p_iPrecioInfante) 
    {
        m_iPrecioInfante = p_iPrecioInfante;
    }
}
