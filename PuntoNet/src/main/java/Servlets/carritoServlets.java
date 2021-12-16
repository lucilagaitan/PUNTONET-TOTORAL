/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorProductos;
import Controlador.GestorVentas;
import Modelo.Carrito;
import Modelo.DTOproducto;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "carritoServlets", urlPatterns = {"/carritoServlets"})
public class carritoServlets extends HttpServlet {

    ArrayList<Carrito> listaCarrito = new ArrayList<>();
    int item = 0;
    double totalPagar = 0;
    int cantidad = 0;

    GestorProductos gestor = new GestorProductos();
    Producto p = new Producto();
    ArrayList<DTOproducto> productos = new ArrayList<>();

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
            out.println("<title>Servlet carritoServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet carritoServlets at " + request.getContextPath() + "</h1>");
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

        GestorVentas gestorV = new GestorVentas();
        request.setAttribute("listaFormasDePago", gestorV.getObtenerComboPago());
        request.setAttribute("listaFormasDeEnvio", gestorV.getObtenerComboEntrega());

        totalPagar = 0;

        request.getSession().setAttribute("carrito", listaCarrito);
        for (int i = 0; i < listaCarrito.size(); i++) {
            totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();

        }

        request.getSession().setAttribute("total", totalPagar);
        request.getSession().setAttribute("contador", listaCarrito.size());

        request.getRequestDispatcher("/carritoCompras.jsp").forward(request, response);

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
        GestorVentas gestorV = new GestorVentas();
        String accion = request.getParameter("accion");

        if (accion.equals("AgregarCarrito")) {
            int id_Producto = Integer.parseInt(request.getParameter("id_Producto"));
            p = gestor.obtenerProductoPorId(id_Producto);
            item = 0;
            cantidad = 1;

            if (listaCarrito.size() > 0) {
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (id_Producto == listaCarrito.get(i).getIdProducto()) {
                        item = i;
                    }
                }

                if (id_Producto == listaCarrito.get(item).getIdProducto()) {
                    cantidad = listaCarrito.get(item).getCantidadProducto() + cantidad;
                    double subtotal = listaCarrito.get(item).getPrecioVenta() * cantidad;
                    listaCarrito.get(item).setCantidadProducto(cantidad);
                    listaCarrito.get(item).setSubTotal(subtotal);
                } else {
                    item = item + 1;
                    Carrito carrito = new Carrito();
                    carrito.setItem(item);
                    carrito.setIdProducto(p.getIdProducto());
                    carrito.setDescripcionProducto(p.getDescripcionProducto());
                    carrito.setMarcaProducto(p.getMarcaProducto());
                    carrito.setRubroProducto(p.getRubroProducto());
                    carrito.setPrecioVenta((p.getCostoProducto() * p.getUtilidadProducto()) / 100 + p.getCostoProducto());
                    carrito.setCantidadProducto(cantidad);
                    carrito.setSubTotal(cantidad * carrito.getPrecioVenta());

                    listaCarrito.add(carrito);
                }

            } else {
                Carrito carrito = new Carrito();
                carrito.setItem(item);
                carrito.setIdProducto(p.getIdProducto());
                carrito.setDescripcionProducto(p.getDescripcionProducto());
                carrito.setMarcaProducto(p.getMarcaProducto());
                carrito.setRubroProducto(p.getRubroProducto());
                carrito.setPrecioVenta((p.getCostoProducto() * p.getUtilidadProducto()) / 100 + p.getCostoProducto());
                carrito.setCantidadProducto(cantidad);
                carrito.setSubTotal(cantidad * carrito.getPrecioVenta());

                listaCarrito.add(carrito);
            }

            request.getSession().setAttribute("contador", listaCarrito.size());
            request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);

        }

        if (accion.equals("VerCarrito")) {

            totalPagar = 0;
            request.getSession().setAttribute("carrito", listaCarrito);
            for (int i = 0; i < listaCarrito.size(); i++) {
                totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
            }

            request.getSession().setAttribute("totalPagar", totalPagar);
            request.getAttribute("contador");
            request.setAttribute("listaFormasDePago", gestorV.getObtenerComboPago());
            RequestDispatcher rd = request.getRequestDispatcher("/carritoCompras.jsp");
            rd.forward(request, response);
        }

        if (accion.equals("Eliminar")) {
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            for (int i = 0; i < listaCarrito.size(); i++) {
                if (listaCarrito.get(i).getIdProducto() == idProducto) {
                    listaCarrito.remove(i);
                    break;
                }
            }

            request.setAttribute("Eliminado", "OK");
            request.setAttribute("listaFormasDePago", gestorV.getObtenerComboPago());
            request.getSession().setAttribute("contador", listaCarrito.size());
            RequestDispatcher rd = request.getRequestDispatcher("/carritoServlets?accion=VerCarrito");
            rd.forward(request, response);
        }

        if (accion.equals("ActualizarCantidad")) {
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

            for (int i = 0; i < listaCarrito.size(); i++) {
                if (listaCarrito.get(i).getIdProducto() == idProducto) {
                    listaCarrito.get(i).setCantidadProducto(cantidad);
                    double SubTot = listaCarrito.get(i).getPrecioVenta() * cantidad;
                    listaCarrito.get(i).setSubTotal(SubTot);
                }
            }
            response.sendRedirect(getServletContext().getContextPath() + "/carritoServlets?accion=VerCarrito");
        }

        if (accion.equals("ProseguirCompra")) {
            GestorVentas gestorVentas = new GestorVentas();
            //forma de envio seleccionada
            int envioSeleccionado = Integer.parseInt(request.getParameter("cboFormasDeEnvio"));
            //metodo para que me traiga el monto de ese tipo de envio            
            request.getSession().setAttribute("envioSeleccionado", envioSeleccionado);
            request.setAttribute("listaFormasDePago", gestorVentas.getObtenerComboPago());
            request.getAttribute("listaCarrito");
            request.getAttribute("contador");
            RequestDispatcher rd = request.getRequestDispatcher("/continuarComprar.jsp");
            rd.forward(request, response);

        }

//         
//         request.setAttribute("listaFormasDePago", gestorV.getObtenerComboPago());
//         request.setAttribute("listaFormasDeEnvio", gestorV.getObtenerComboEntrega());
//        
//        response.sendRedirect(getServletContext().getContextPath() + "/ContinuarCompra");
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
