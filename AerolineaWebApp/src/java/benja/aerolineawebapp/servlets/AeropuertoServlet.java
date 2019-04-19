package benja.aerolineawebapp.servlets;

import benja.aerolineawebapp.logic.AeropuertoLogic;
import benja.aerolineawebapp.objects.AeropuertoObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AeropuertoServlet", urlPatterns = {"/AeropuertoServlet"})
public class AeropuertoServlet extends HttpServlet {

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
                String strNombre = request.getParameter("nombre");
                String strPais = request.getParameter("pais");
                String strCiudad = request.getParameter("ciudad");
                
                //accediendo a logic
                AeropuertoLogic CLogic = new AeropuertoLogic();
                int iRows = CLogic.insertAeropuertoRows(strNombre, strPais, strCiudad);
                System.out.println("insert client rows: " + iRows);
                
                //enviar a frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //accediendo a logic
                AeropuertoLogic CLogic = new AeropuertoLogic();
                ArrayList<AeropuertoObj> CArray = CLogic.getAllAeropuertos();
                
                //enviar a frontend
                request.getSession().setAttribute("aeropuertos", CArray);
                response.sendRedirect("aeropuertoForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //Obteniendo parametros
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //accediendo a logic
                AeropuertoLogic CLogic = new AeropuertoLogic();
                int iRows = CLogic.deleteAeropuertoRows(iId);
                
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
                AeropuertoLogic CLogic = new AeropuertoLogic();
                AeropuertoObj AAeropuerto = CLogic.getAeropuertoById(iId);
                
                //enviar a frontend
                request.getSession().setAttribute("aeropuerto", AAeropuerto);
                response.sendRedirect("aeropuertoUpdateForm.jsp");
            }
            
            if(strFormId.equals("5"))
            {
                //obteniendo parametros
                String strId = request.getParameter("id");
                String strNombre = request.getParameter("nombre");
                String strPais = request.getParameter("pais");
                String strCiudad = request.getParameter("ciudad");
                int iId = Integer.parseInt(strId);
                
                //accediendo a logic
                AeropuertoLogic CLogic = new AeropuertoLogic();
                int iRows = CLogic.updateAeropuertoRows(iId,strNombre, strPais, strCiudad);
                System.out.println("update client rows: " + iRows);
                
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
