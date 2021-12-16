/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorProductos;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import static com.google.common.io.ByteStreams.toByteArray;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize = 219000)

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "AltaProductoServlets", urlPatterns = {"/AltaProductoServlets"})
public class AltaProductoServlets extends HttpServlet {

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
            out.println("<title>Servlet AltaProductoServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaProductoServlets at " + request.getContextPath() + "</h1>");
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
  
        request.setAttribute("listaMarcas", gestor.getObtenerComboMarca()); 
        request.setAttribute("listaRubros", gestor.getObtenerComboRubro()); 
        RequestDispatcher rd = request.getRequestDispatcher("/altaProducto.jsp");
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
        
        GestorProductos gestor =new GestorProductos();
        
        String nombre = request.getParameter("txtDescripcion");
        int idMarca =Integer.parseInt(request.getParameter("cboMarca"));
        Marca m = new Marca(idMarca, "");
        int idRubro =Integer.parseInt(request.getParameter("cboRubro"));
        Rubro r = new Rubro (idRubro, "");
        int cantidad =Integer.parseInt(request.getParameter("txtCantidad"));
        double costo =Double.parseDouble(request.getParameter("txtCosto"));
        double utilidad =Double.parseDouble(request.getParameter("txtUtilidad"));
        Part filePart = request.getPart("fileImagen");
                InputStream inputStream = null;
                if (filePart != null) {
                    long fileSize = filePart.getSize();
                    String fileContent = filePart.getContentType();
                    inputStream = filePart.getInputStream();
                }

                byte[] foto = toByteArray(inputStream);

        
        Producto p = new Producto(nombre, m, r, cantidad, costo, utilidad,foto);
                    
           
        gestor.agregarProducto(p);
        RequestDispatcher rd = request.getRequestDispatcher("/productos.jsp");
        rd.forward(request, response);
        
        request.setAttribute("p", gestor.getObtenerListadoProductos());
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
