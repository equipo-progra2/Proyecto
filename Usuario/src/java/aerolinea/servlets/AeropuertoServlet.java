package aerolinea.servlets;

import aerolinea.logic.AeropuertoLogic;
import aerolinea.objects.VueloObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AeropuertoServlet", urlPatterns = {"/AeropuertoServlet"})
public class AeropuertoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        String strFormId = request.getParameter("formid");
        
        if(strFormId.equals("1"))
            {
                AeropuertoLogic CLogic = new AeropuertoLogic();
                ArrayList<String> CArray = CLogic.obtenerpaises();
                
                request.getSession().setAttribute("aeropuertos", CArray);
                response.sendRedirect("seleccionarvuelo.jsp");
            }
        if(strFormId.equals("2"))
            {
               String strPais1 = request.getParameter("pais1");
               String strPais2 = request.getParameter("pais2");
               
               AeropuertoLogic CLogic = new AeropuertoLogic();
               ArrayList<VueloObj> CArray = CLogic.obtenervuelosdisponibles(strPais1,strPais2);
               
               request.getSession().setAttribute("vuelos", CArray);
               response.sendRedirect("vuelosdisponibles.jsp");
            }
        if(strFormId.equals("3"))
            {
                String strid = request.getParameter("id");
                int iId = Integer.parseInt(strid);
                String strprecioadulto = request.getParameter("precioadulto");
                int iPrecioadulto = Integer.parseInt(strprecioadulto);
                String strprecionino = request.getParameter("precionino");
                int iPrecionino = Integer.parseInt(strprecionino);
                String strprecioinfante = request.getParameter("precioinfante");
                int iPrecioinfante = Integer.parseInt(strprecioinfante);
                
                request.getSession().setAttribute("idVuelo", iId);
                request.getSession().setAttribute("precioadulto", iPrecioadulto);
                request.getSession().setAttribute("precionino", iPrecionino);
                request.getSession().setAttribute("precioinfante", iPrecioinfante);
                response.sendRedirect("DatosUsuario.jsp");
            }
        if(strFormId.equals("4"))
            {
                String strNombre = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strTarjeta = request.getParameter("tarjeta");
                String strNoTarjeta = request.getParameter("notarjeta");
                int iNoTarjeta = Integer.parseInt(strNoTarjeta);
                String strTelefono = request.getParameter("telefono");
                int iTelefono = Integer.parseInt(strTelefono);
                String strEmail = request.getParameter("email");
                String strAdultos = request.getParameter("adultos");
                int iAdultos = Integer.parseInt(strAdultos);
                String strNinos = request.getParameter("ninos");
                int iNinos = Integer.parseInt(strNinos);
                String strInfantes = request.getParameter("infantes");
                int iInfantes = Integer.parseInt(strInfantes);
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                String strPrecioAdulto = request.getParameter("precioadulto");
                int iPrecioAdulto = Integer.parseInt(strPrecioAdulto);
                String strPrecioNino = request.getParameter("precionino");
                int iPrecioNino = Integer.parseInt(strPrecioNino);
                String strPrecioInfante = request.getParameter("precioinfante");
                int iPrecioInfante = Integer.parseInt(strPrecioInfante);
                
                int itotal;
                itotal = iPrecioAdulto*iAdultos+iPrecioNino*iNinos+iPrecioInfante*iInfantes;
                
                Date fecha = new Date();
                SimpleDateFormat formatofecha = new SimpleDateFormat("ddMMYYYY");
                String strFechaActual = formatofecha.format(fecha);
                String dia = strFechaActual.substring(0, 2);
                String mes = strFechaActual.substring(2, 4);
                String anio = strFechaActual.substring(4, 8);
                String strFecha = dia+"/"+mes+"/"+anio;
                
                AeropuertoLogic CLogic = new AeropuertoLogic();
                CLogic.introducirventa(strNombre,strApellido,strFecha,strTarjeta,iNoTarjeta,iTelefono,strEmail,iAdultos,iNinos,iInfantes,iId);
                
                request.getSession().setAttribute("nombre", strNombre);
                request.getSession().setAttribute("apellido", strApellido);
                request.getSession().setAttribute("fecha", strFecha);
                request.getSession().setAttribute("adultos", iAdultos);
                request.getSession().setAttribute("ninos", iNinos);
                request.getSession().setAttribute("infantes", iInfantes);
                request.getSession().setAttribute("Padultos", iPrecioAdulto);
                request.getSession().setAttribute("Pninos", iPrecioNino);
                request.getSession().setAttribute("Pinfantes", iPrecioInfante);
                request.getSession().setAttribute("total", itotal);
                response.sendRedirect("Factura.jsp");
            }
        
        if(strFormId.equals("5"))
            {
                AeropuertoLogic CLogic = new AeropuertoLogic();
                ArrayList<String> CArray = CLogic.obtenerpaises();
                
                request.getSession().setAttribute("aeropuertos", CArray);
                response.sendRedirect("EstadoDeVuelosPorRuta.jsp");
            }
        
        if(strFormId.equals("6"))
            {
               String strPais1 = request.getParameter("pais1");
               String strPais2 = request.getParameter("pais2");
               
               AeropuertoLogic CLogic = new AeropuertoLogic();
               ArrayList<VueloObj> CArray = CLogic.obtenervuelos(strPais1,strPais2);
               
               request.getSession().setAttribute("vuelos", CArray);
               response.sendRedirect("EstadoDeVuelosPorCodigo.jsp");
            }
        
        if(strFormId.equals("7"))
            {
                String strIdVuelo = request.getParameter("codigo");
                int iIdVuelo = Integer.parseInt(strIdVuelo);
                
                
                AeropuertoLogic CLogic = new AeropuertoLogic();
                ArrayList<VueloObj> CArray = CLogic.idVuelo(iIdVuelo);
                
                request.getSession().setAttribute("vuelos", CArray);
                response.sendRedirect("EstadoDeVuelosPorRuta.jsp");
                
                
                
            }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
