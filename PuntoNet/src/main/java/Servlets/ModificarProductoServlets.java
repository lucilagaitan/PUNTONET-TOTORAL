/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorProductos;
import Modelo.DTOModificarProducto;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import static com.google.common.io.ByteStreams.toByteArray;
import java.io.ByteArrayOutputStream;
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
@MultipartConfig(maxFileSize = 2190000)

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ModificarProductoServlets", urlPatterns = {"/ModificarProductoServlets"})
public class ModificarProductoServlets extends HttpServlet {

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
            out.println("<title>Servlet ModificarProductoServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarProductoServlets at " + request.getContextPath() + "</h1>");
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
        String idModificar = (String) request.getParameter("id_Producto");
        int id = Integer.parseInt(idModificar);

        Producto p = new Producto();

        p = gestor.obtenerProductoPorId(id);
        request.setAttribute("marca", gestor.getObtenerComboMarca());
        request.setAttribute("rubro", gestor.getObtenerComboRubro());

        request.setAttribute("p", p);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarProducto.jsp");

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
        GestorProductos gestor = new GestorProductos();

        if (accion.equals("editar")) {
            int id = Integer.parseInt((String) request.getParameter("txtId"));
            String descripcion = request.getParameter("txtDescripcion");
            int idMarca = Integer.parseInt(request.getParameter("cboMarca"));
            Marca m = new Marca(idMarca, "");
            int idRubro = Integer.parseInt(request.getParameter("cboRubro"));
            Rubro r = new Rubro(idRubro, "");
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            double costo = Double.parseDouble(request.getParameter("txtCosto"));
            double utilidad = Double.parseDouble(request.getParameter("txtUtilidad"));

            if (!descripcion.equals("") && costo > 0 && cantidad > 0 && cantidad > 0) {
                Producto p = new Producto(id, descripcion, m, r, cantidad, costo, utilidad);
                gestor.modificarProducto(p);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp");
                rd.forward(request, response);

            }
        }

        if (accion.equals("foto")) 
        {
            String idModificar = (String) request.getParameter("id_Producto");
            int id = Integer.parseInt(idModificar);
            Producto p = new Producto();
            p = gestor.obtenerProductoPorId(id);
            request.setAttribute("p", p);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarFoto.jsp");
            rd.forward(request, response);
        }
        
       
        
        if(accion.equals("fotoEditada"))
        {
             int idProducto = Integer.parseInt(request.getParameter("txtId"));
            Part filePart = request.getPart("fileImagen");
            InputStream inputStream = null;

                long fileSize = filePart.getSize();
                String fileContent = filePart.getContentType();
                inputStream = filePart.getInputStream();
                byte[] foto = toByteArray(inputStream);
                Producto p = new Producto(foto);
                gestor.modificarFoto(idProducto, p);
                request.getAttribute("contador");

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp");
            rd.forward(request, response);
        }

    }

    private static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
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
