package benja.aerolineawebapp.servlets;

import benja.aerolineawebapp.logic.AvionLogic;
import benja.aerolineawebapp.objects.AvionObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AvionServlet", urlPatterns = {"/AvionServlet"})
public class AvionServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        //Configurando el Servlet
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //obteniendo parametros
                String strNombre = request.getParameter("name");
                String strModelo = request.getParameter("model");
                String strMarca = request.getParameter("mark");
                String strCapacidad = request.getParameter("capacity");
                
                int iCapacidad = Integer.parseInt(strCapacidad);
                
                //accediendo a logic
                AvionLogic CLogic = new AvionLogic();
                int iRows = CLogic.insertAvionRows(strNombre, strModelo, strMarca, iCapacidad);
                System.out.println("insert avion rows: " + iRows);
                
                //enviar a frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //accediendo a logic
                AvionLogic CLogic = new AvionLogic();
                ArrayList<AvionObj> CArray = CLogic.getAllAviones();
                
                //enviar a frontend
                request.getSession().setAttribute("aviones", CArray);
                response.sendRedirect("avionForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //Obteniendo parametros
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //accediendo a logic
                AvionLogic CLogic = new AvionLogic();
                int iRows = CLogic.deleteAvionRows(iId);
                
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
                AvionLogic CLogic = new AvionLogic();
                AvionObj AAvion = CLogic.getAvionById(iId);
                
                //enviar a frontend
                request.getSession().setAttribute("avion", AAvion);
                response.sendRedirect("avionUpdateForm.jsp");
            }
            
            if(strFormId.equals("5"))
            {
                //obteniendo parametros
                String strId = request.getParameter("id");
                String strNombre = request.getParameter("name");
                String strModelo = request.getParameter("model");
                String strMarca = request.getParameter("mark");
                String strCapacidad = request.getParameter("capacity");
                
                int iId = Integer.parseInt(strId);
                int iCapacidad = Integer.parseInt(strCapacidad);
                
                //accediendo a logic
                AvionLogic CLogic = new AvionLogic();
                int iRows = CLogic.updateAvionRows(iId,strNombre, strModelo, strMarca, iCapacidad);
                System.out.println("update avion rows: " + iRows);
                
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
