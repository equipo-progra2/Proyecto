package benja.aerolineawebapp.servlets;

import benja.aerolineawebapp.logic.VueloLogic;
import benja.aerolineawebapp.objects.VueloObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VueloServlet", urlPatterns = {"/VueloServlet"})
public class VueloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        //Configurando el Servlet
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //obteniendo parametros
                String strIdAvion = request.getParameter("idavion");
                String strFechaPartida = request.getParameter("fechapartida");
                String strHoraPartida = request.getParameter("horapartida");
                String strIdAeropuertoPartida = request.getParameter("aeropuertopartida");
                String strFechaLlegada = request.getParameter("fechallegada");
                String strHoraLlegada = request.getParameter("horallegada");
                String strIdAeropuertoDestino = request.getParameter("aeropuertodestino");
                String strPrecioAdulto = request.getParameter("precioadulto");
                String strPrecioNino = request.getParameter("precionino");
                String strPrecioInfante = request.getParameter("precioinfante");
                
                int iIdAvion = Integer.parseInt(strIdAvion);
                int iIdAeropuertoPartida = Integer.parseInt(strIdAeropuertoPartida);
                int iIdAeropuertoDestino = Integer.parseInt (strIdAeropuertoDestino);
                int iPrecioAdulto = Integer.parseInt(strPrecioAdulto);
                int iPrecioNino = Integer.parseInt(strPrecioNino);
                int iPrecioInfante = Integer.parseInt(strPrecioInfante);
                
                //accediendo a logic
                VueloLogic CLogic = new VueloLogic();
                int iRows = CLogic.insertVueloRows(iIdAvion, strFechaPartida, strHoraPartida, iIdAeropuertoPartida,
                        strFechaLlegada, strHoraLlegada, iIdAeropuertoDestino, iPrecioAdulto, iPrecioNino,
                            iPrecioInfante);
                   System.out.println("insert vuelos rows: " + iRows);

                //enviar a frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //accediendo a logic
                VueloLogic CLogic = new VueloLogic();
                ArrayList<VueloObj> CArray = CLogic.getAllVuelos();
                
                //enviar a frontend
                request.getSession().setAttribute("vuelos", CArray);
                response.sendRedirect("vueloForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //Obteniendo parametros
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //accediendo a logic
                VueloLogic CLogic = new VueloLogic();
                int iRows = CLogic.deleteVueloRows(iId);
                
                //enviar a frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //obteniendo parametros
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //accediendo a logic
                VueloLogic CLogic = new VueloLogic();
                VueloObj VVuelos = CLogic.getVuelosById(iId);
                
                //enviar a frontend
                request.getSession().setAttribute("vuelo", VVuelos);
                response.sendRedirect("vueloUpdateForm.jsp");
            }
            
            if(strFormId.equals("5"))
            {
                //obteniendo parametros
                String strId = request.getParameter("id");
                String strIdAvion = request.getParameter("idavion");
                String strFechaPartida = request.getParameter("fechapartida");
                String strHoraPartida = request.getParameter("horapartida");
                String strIdAeropuertoPartida = request.getParameter("aeropuertopartida");
                String strFechaLlegada = request.getParameter("fechallegada");
                String strHoraLlegada = request.getParameter("horallegada");
                String strIdAeropuertoDestino = request.getParameter("aeropuertodestino");
                String strPrecioAdulto = request.getParameter("precioadulto");
                String strPrecioNino = request.getParameter("precionino");
                String strPrecioInfante = request.getParameter("precioinfante");
                
                int iId = Integer.parseInt(strId);
                int iIdAvion = Integer.parseInt(strIdAvion);
                int iIdAeropuertoPartida = Integer.parseInt(strIdAeropuertoPartida);
                int iIdAeropuertoDestino = Integer.parseInt (strIdAeropuertoDestino);
                int iPrecioAdulto = Integer.parseInt(strPrecioAdulto);
                int iPrecioNino = Integer.parseInt(strPrecioNino);
                int iPrecioInfante = Integer.parseInt(strPrecioInfante);
                
                //accediendo a logic
                VueloLogic CLogic = new VueloLogic();
                int iRows = CLogic.updateVueloRows(iId, iIdAvion, strFechaPartida, strHoraPartida, iIdAeropuertoPartida,
                        strFechaLlegada, strHoraLlegada, iIdAeropuertoDestino, iPrecioAdulto, iPrecioNino, iPrecioInfante);
                System.out.println("update vuelos rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
                
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
