/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorProductos;
import java.io.IOException;
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
@WebServlet(name = "GestionTienda", urlPatterns = {"/GestionTienda"})
public class GestionTienda extends HttpServlet {

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
            out.println("<title>Servlet GestionTienda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionTienda at " + request.getContextPath() + "</h1>");
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

        GestorProductos gestor = new GestorProductos();
        request.setAttribute("listaProductos", gestor.getObtenerProductosParaTienda());
        request.getAttribute("listaProductos");
        
        request.setAttribute("listaRubros", gestor.getObtenerComboRubro());
        RequestDispatcher rd = request.getRequestDispatcher("/productosHome.jsp");
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
        GestorProductos gestor = new GestorProductos();
        String accion = request.getParameter("accionBuscar");

//        if (accion.equals("BuscarProductosDesdeNavBar")) {
//            String producto = request.getParameter("txtBuscarProductosNvr");
//            if (!producto.equals("")) {
//                request.setAttribute("listaProductos", gestorProducto.obtenerProductosPorBusquedaDeNombre(producto));
//                request.setAttribute("listaCategorias", gestorCat.obtenerCategoriasListado());
//                request.getAttribute("contador");
//                RequestDispatcher rd = request.getRequestDispatcher("/tienda.jsp");
//                rd.forward(request, response);
//            } else {
//
//                request.setAttribute("infoErrorBusquedaProducto", "Info");
//                request.setAttribute("listaProductos", gestorProducto.obtenerProductosParaTienda());
//                request.setAttribute("listaCategorias", gestorCat.obtenerCategoriasListado());
//                request.getAttribute("contador");
//                RequestDispatcher rd = request.getRequestDispatcher("/tienda.jsp");
//                rd.forward(request, response);
//            }
//        }
        if (accion.equals("BuscarProductosPorCategoria")) {
            int idCatego = Integer.parseInt(request.getParameter("cboRubro"));
            if (idCatego > 0) {
                request.setAttribute("listaProductos", gestor.obtenerProductosPorCategoria(idCatego));
                request.setAttribute("listaRubros", gestor.getObtenerComboRubro());
                RequestDispatcher rd = request.getRequestDispatcher("/productosHome.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/productosHome.jsp");
                rd.forward(request, response);
            }
        }

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
