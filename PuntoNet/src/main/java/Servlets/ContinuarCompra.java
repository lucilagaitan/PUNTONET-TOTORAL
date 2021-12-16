/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorProductos;
import Controlador.GestorVentas;
import Modelo.Carrito;
import Modelo.DTOCarrito;
import Modelo.DTODetalleVentas;
import Modelo.DTOVentas;
import Modelo.DetalleVentas;
import Modelo.TipoEntrega;
import Modelo.TipoPago;
import Modelo.Usuaio;
import Modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import static java.lang.Math.round;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ContinuarCompra", urlPatterns = {"/ContinuarCompra"})
public class ContinuarCompra extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/continuarComprar.jsp");
        rd.forward(request, response);

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

        GestorVentas gestor = new GestorVentas();
        request.setAttribute("listaFormasDePago", gestor.getObtenerComboPago());
        request.getAttribute("envioSeleccionado");
        request.getAttribute("contador");
        request.getAttribute("carrito");
        request.getAttribute("contador");
        request.getAttribute("totalPagar");
        RequestDispatcher rd = request.getRequestDispatcher("/continuarComprar.jsp");
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
        int idFormaPago = Integer.parseInt(request.getParameter("cboFormasDePago"));
        int idEntrega = (int) request.getSession().getAttribute("envioSeleccionado");

        double totalPagar = (Double) request.getSession().getAttribute("total");
        float totalAPagar = (float) totalPagar;

        Usuaio usuario = (Usuaio) request.getSession().getAttribute("modeloCliente");

        if (accion.equals("ConfirmarPedido")) {
            ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");

            if (idFormaPago == 1 || idFormaPago == 2) {
                //insertar lista carrito y datos cliente en pedidos y detalle pedidos
                int idCliente = usuario.getIdUsuario();

                //NECESITO FECHA, ID USUARIO, ID TIPO PAGO, ID ENTREGA, TOTAL
                //FACTURACION
                DTOVentas DTOv = new DTOVentas(idCliente, idFormaPago, idEntrega, totalAPagar);
                GestorVentas gestor = new GestorVentas();
                gestor.agregarVenta(DTOv);

                //DETALLE DE VENTA
                //buscar idfactura para detalle de facturacion
                int idFactura = gestor.obtenerIdFactura(DTOv);
                //insertar en detalleFactura
                for (Carrito listaC : listaCarrito) {
                    
                    DTODetalleVentas detalleV = new DTODetalleVentas();
                    GestorProductos gestorP = new GestorProductos();
                    detalleV.setIdProd(listaC.getIdProducto());
                    detalleV.setCantidad(listaC.getCantidadProducto());
                    detalleV.setMonto(listaC.getPrecioVenta() * listaC.getCantidadProducto());
                    detalleV.setVenta(idFactura);
                    //agregamos detalle de venta
                    gestor.agregarDetalleVenta(detalleV);
                    //actualizamos stock
                    gestorP.actualizarStockProducto(listaC.getCantidadProducto(), listaC.getIdProducto());
                }
                
                
                request.setAttribute("modeloFactura", gestor.getObtenerListadoVentas(idFactura));
                request.setAttribute("listaDetalleFactura", gestor.getObtenerListadoDetalleVentas(idCliente, idFactura));

                for (int i = 0; i < listaCarrito.size(); i++) {
                    listaCarrito.clear();
                }

                request.getSession().removeAttribute("envioSeleccionado");
                request.getSession().removeAttribute("contador");
                request.getSession().removeAttribute("totalPagar");
                request.getSession().removeAttribute("formaDePagoSeleccionada");
                RequestDispatcher rd = request.getRequestDispatcher("/pagoRealizadoFactura.jsp");
                rd.forward(request, response);
            }

            if (idFormaPago == 3) {
                try {
                    com.mercadopago.MercadoPago.SDK.setAccessToken("TEST-7424878086321254-111720-e72dadb2d11bb90109c73c22b2dc963d-377840055");

                    Preference preference = new Preference();

                    BackUrls backUrls = new BackUrls(
                            "http://localhost:8080/PuntoNet/MercadoPagoFacturacion", //pago exitoso
                            "http://localhost:8080/PuntoNet/ContinuarComprar", //pendiente
                            "http://localhost:8080/PuntoNet/ContinuarComprar"); //fallido

                    preference.setBackUrls(backUrls);
                    Item item = new Item();
                    item.setTitle("Punto Net Totoral Compra")
                            .setQuantity(1)
                            .setUnitPrice((float) Math.round(totalAPagar));
                    preference.appendItem(item);
                    preference.save();
                    request.setAttribute("idPreferencia", preference.getId());

                    RequestDispatcher rd = request.getRequestDispatcher("/mercadoPago.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                }

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
