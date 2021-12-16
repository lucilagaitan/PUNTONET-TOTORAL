/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestionReportes;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ReporteCuatroServlets", urlPatterns = {"/ReporteCuatroServlets"})
public class ReporteCuatroServlets extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReporteCuatroServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReporteCuatroServlets at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/reporteCuatro.jsp");
        rd.forward(request, response);
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
        
          String accion = request.getParameter("accion");
        //FORMAS DE PAGOS MAS UTILIZADAS
if (accion.equals("FormasPago")) {
            GestionReportes gestor = new GestionReportes();
             String boton = request.getParameter("btnGenerarGrafico");

            if (boton.equals("Grafico Torta")) {
                try {
                    JFreeChart grafico = gestor.graficoFormasDePago();
                    response.setContentType("image/JPEG");
                    OutputStream sa = response.getOutputStream();
                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);

                } catch (Exception e) {
                }
            }
            if (boton.equals("Grafico Barra")) {
                try {
                    JFreeChart grafico = gestor.graficoBarraFormasPago();
                    response.setContentType("image/JPEG");
                    OutputStream sa = response.getOutputStream();
                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
                } catch (Exception e) {
                }
            } }
            
        
//        RequestDispatcher rd = request.getRequestDispatcher("/reporteCuatro.jsp");
//            rd.forward(request, response);
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
