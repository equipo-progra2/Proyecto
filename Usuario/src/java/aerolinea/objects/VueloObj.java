package aerolinea.objects;

public class VueloObj {
    
    private int m_iId;
    private int m_iIdAvion;
    private String m_strFechaPartida;
    private String m_strHoraPartida;
    private String m_strAeroPartida;
    private String m_strFechaLlegada;
    private String m_strHoraLlegada;
    private String m_strAeroLlegada;
    private int m_iPrecioAdulto;
    private int m_iPrecioNino;
    private int m_iPrecioInfante;
    private String m_strCiudadPartida;
    private String m_strCiudadLlegada;

    public VueloObj(int p_iId, int p_iIdAvion, String p_strFechaPartida, String p_strHoraPartida, 
            String p_strAeroPartida, String p_strFechaLlegada, String p_strHoraLlegada, 
            String p_strAeroLlegada, int p_iPrecioAdulto, int p_iPrecioNino, int p_iPrecioInfante,
            String p_strCiudadPartida, String p_strCiudadLlegada) {
        setId(p_iId);
        setIdAvion(p_iIdAvion);
        setFechaPartida(p_strFechaPartida);
        setHoraPartida(p_strHoraPartida);
        setAeroPartida(p_strAeroPartida);
        setFechaLlegada(p_strFechaLlegada);
        setHoraLlegada(p_strHoraLlegada);
        setAeroLlegada(p_strAeroLlegada);
        setPrecioAdulto(p_iPrecioAdulto);
        setPrecioNino(p_iPrecioNino);
        setPrecioInfante(p_iPrecioInfante);
        setCiudadPartida(p_strCiudadPartida);
        setCiudadLlegada(p_strCiudadLlegada);
    }
    
    
    
    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getIdAvion() {
        return m_iIdAvion;
    }

    private void setIdAvion(int p_iIdAvion) {
        m_iIdAvion = p_iIdAvion;
    }

    public String getFechaPartida() {
        return m_strFechaPartida;
    }

    private void setFechaPartida(String p_strFechaPartida) {
        m_strFechaPartida = p_strFechaPartida;
    }

    public String getHoraPartida() {
        return m_strHoraPartida;
    }

    private void setHoraPartida(String p_strHoraPartida) {
        m_strHoraPartida = p_strHoraPartida;
    }

    public String getAeroPartida() {
        return m_strAeroPartida;
    }

    private void setAeroPartida(String p_iIdAeroPartida) {
        m_strAeroPartida = p_iIdAeroPartida;
    }

    public String getFechaLlegada() {
        return m_strFechaLlegada;
    }

    private void setFechaLlegada(String p_strFechaLlegada) {
        m_strFechaLlegada = p_strFechaLlegada;
    }

    public String getHoraLlegada() {
        return m_strHoraLlegada;
    }

    private void setHoraLlegada(String p_strHoraLlegada) {
        m_strHoraLlegada = p_strHoraLlegada;
    }

    public String getAeroLlegada() {
        return m_strAeroLlegada;
    }

    private void setAeroLlegada(String p_strAeroLlegada) {
        m_strAeroLlegada = p_strAeroLlegada;
    }

    public int getPrecioAdulto() {
        return m_iPrecioAdulto;
    }

    private void setPrecioAdulto(int p_iPrecioAdulto) {
        m_iPrecioAdulto = p_iPrecioAdulto;
    }
    
    public int getPrecioNino() {
        return m_iPrecioNino;
    }

    private void setPrecioNino(int p_iPrecioNino) {
        m_iPrecioNino = p_iPrecioNino;
    }
    
    public int getPrecioInfante() {
        return m_iPrecioInfante;
    }

    private void setPrecioInfante(int p_iPrecioInfante) {
        m_iPrecioInfante = p_iPrecioInfante;
    }
    
    public String getCiudadPartida() {
        return m_strCiudadPartida;
    }

    private void setCiudadPartida(String p_strCiudadPartida) {
        m_strCiudadPartida = p_strCiudadPartida;
    }
    
    public String getCiudadLlegada() {
        return m_strCiudadLlegada;
    }

    private void setCiudadLlegada(String p_strCiudadLlegada) {
        m_strCiudadLlegada = p_strCiudadLlegada;
    }
}
