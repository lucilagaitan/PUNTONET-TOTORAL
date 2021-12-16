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

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ReportesServlets", urlPatterns = {"/ReportesServlets"})
public class ReportesServlets extends HttpServlet {
        GestionReportes gestor = new GestionReportes();

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
            out.println("<title>Servlet ReportesServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportesServlets at " + request.getContextPath() + "</h1>");
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
        GestionReportes gestor = new GestionReportes();
        request.setAttribute("reporteUno", gestor.getReporteUno()); 
        request.setAttribute("reporteDos", gestor.getReporteDos()); 
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportes.jsp");
        rd.forward(request, response);
//        
//        double montoTotal = gestorReportes.obtenerTotalFacturasPedidosEntregados();
//        request.setAttribute("montoTotal", montoTotal);

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

        //TOP  MAS VENDIDOS
//        if (accion.equals("MasVendidos")) {
//            String boton = request.getParameter("btnGenerarGrafico");
//
//            if (boton.equals("Grafico Torta")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoTortaTop5MasVendidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//
//                } catch (Exception e) {
//                }
//            }
//            if (boton.equals("Grafico Barra")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoBarraTop5MasVendidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//                } catch (Exception e) {
//                }
//            }
//        }
//
//        //TOP 5 MENOS VENDIDOS
//        if (accion.equals("GenerarReporteTop5MenosVendidos")) {
//            String boton = request.getParameter("btnGenerarGrafico");
//
//            if (boton.equals("Grafico Torta")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoTortaTop5MenosVendidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//
//                } catch (Exception e) {
//                }
//            }
//            if (boton.equals("Grafico Barra")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoBarraTop5MenosVendidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//                } catch (Exception e) {
//                }
//            }
//        }
//

//
//        //formas de envios mas usadas
//        if (accion.equals("GenerarReporteFormasDeEnvio")) {
//            String boton = request.getParameter("btnGenerarGrafico");
//
//            if (boton.equals("Grafico Torta")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoTortaFormasDeEnvio();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//
//                } catch (Exception e) {
//                }
//            }
//            if (boton.equals("Grafico Barra")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoBarraFormasEnvio();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//                } catch (Exception e) {
//                }
//            }
//        }
//
//        //estados de los pedidos estadistica
//        if (accion.equals("GenerarReporteEstadosPedidos")) {
//            String boton = request.getParameter("btnGenerarGrafico");
//
//            if (boton.equals("Grafico Torta")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoTortaEstadosPedidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//
//                } catch (Exception e) {
//                }
//            }
//            if (boton.equals("Grafico Barra")) {
//                try {
//                    JFreeChart grafico = gestorReportes.graficoBarraEstadosPedidos();
//                    response.setContentType("image/JPEG");
//                    OutputStream sa = response.getOutputStream();
//                    ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
//                } catch (Exception e) {
//                }
//            }
//        }
//
//        RequestDispatcher rd = request.getRequestDispatcher("/seccionReportesAdmin.jsp");
//        rd.forward(request, response);

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
