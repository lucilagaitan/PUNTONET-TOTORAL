///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import Controlador.GestorCliente;
//import Controlador.GestorInicioSesion;
//import Controlador.GestorPedido;
//import Modelo.Barrio;
//import Modelo.Ciudad;
//import Modelo.Cliente;
//import Modelo.DTOCliente;
//import Modelo.DTODetalleCompra;
//import Modelo.DTOPedido;
//import Modelo.Domicilio;
//import Modelo.Usuario;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author David
// */
//@WebServlet(name = "GestionCliente", urlPatterns = {"/GestionCliente"})
//public class GestionCliente extends HttpServlet {
//
//    GestorCliente gestorCliente = new GestorCliente();
//    GestorInicioSesion gestor = new GestorInicioSesion();
//    GestorPedido gestorPedido = new GestorPedido();
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setAttribute("listaCiudades", gestor.obtenerCiudades());
//        request.setAttribute("listaBarrios", gestor.obtenerBarrios());
//
//        RequestDispatcher rd = request.getRequestDispatcher("/usuarioClienteSesion.jsp");
//        rd.forward(request, response);
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setAttribute("listaCiudades", gestor.obtenerCiudades());
//        request.setAttribute("listaBarrios", gestor.obtenerBarrios());
//        request.getAttribute("contador");
//        request.getAttribute("modeloCliente");
//        request.getSession().getAttribute("listaPedidosRegistrado");
//        DTOCliente listaClienteRegistrado = (DTOCliente) request.getSession().getAttribute("modeloCliente");
//        ArrayList<DTOPedido> listaPedidos = gestorPedido.obtenerPedidosRegistrados(listaClienteRegistrado.getIdCliente());
//        request.getSession().setAttribute("listaPedidosRegistrado", listaPedidos);
//        
//        
//        for (DTOPedido listaPedido : listaPedidos) {
//            int id = listaPedido.getnPedido();
//            ArrayList<DTODetalleCompra> dtoDetalle = gestorPedido.obtenerDetalleDePedido(id);
//            request.setAttribute("DetallePedido", dtoDetalle);
//        }
//        
//        RequestDispatcher rd = request.getRequestDispatcher("/usuarioClienteSesion.jsp");
//        rd.forward(request, response);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String accion = request.getParameter("accion");
//        String correo = request.getParameter("txtCorreo");
//        if (accion.equals("EditarCliente")) {
//
//            int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
//            String nombre = request.getParameter("txtNombre");
//            String apellido = request.getParameter("txtApellido");
//            long telefono = Long.parseLong(request.getParameter("txtTel"));
//
//            if (!nombre.equals("") && !apellido.equals("") && telefono > 0) {
//                Cliente c = new Cliente(idCliente, nombre, apellido, telefono);
//                gestorCliente.modificarTablaClientes(c);
//            }
//
//            String contra1 = request.getParameter("txtContrasenia");
//            String contra2 = request.getParameter("txtRepetirContrasenia");
//
//            if (contra1.equals(contra2) && !contra1.equals("") && !contra2.equals("") && !correo.equals("")) {
//                Usuario u = new Usuario(0, correo, contra1);
//                gestorCliente.modificarTablaLoginUsers(u);
//            }
//
//            String direccion = request.getParameter("txtDireccion");
//            String altura = request.getParameter("txtAltura");
//            int piso = Integer.parseInt(request.getParameter("txtPiso"));
//            int ciudad = Integer.parseInt(request.getParameter("cboCiudad"));
//            int barrio = Integer.parseInt(request.getParameter("cboBarrio"));
//
//            if (!direccion.equals("") && !altura.equals("") && piso >= 0 && ciudad > 0 && barrio >= 0) {
//                Ciudad ciu = new Ciudad(ciudad, "");
//                Barrio b = new Barrio(barrio, "");
//                Domicilio d = new Domicilio(0, ciu, b, direccion, Integer.parseInt(altura), piso);
//                gestorCliente.modificarTablaDomicilios(d, idCliente);
//            } else {
//                request.getAttribute("contador");
//                RequestDispatcher rd = request.getRequestDispatcher("/usuarioClienteSesion.jsp");
//                rd.forward(request, response);
//            }
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("/usuarioClienteSesion.jsp");
//            rd.forward(request, response);
//        }
//        request.setAttribute("datosClienteModificadosCorrectamente", "OK");
//        request.setAttribute("listaCiudades", gestor.obtenerCiudades());
//        request.setAttribute("listaBarrios", gestor.obtenerBarrios());
//        DTOCliente cliente = gestor.obtenerClientesUpdate(correo);
//        request.getSession().setAttribute("modeloCliente", cliente);
//        RequestDispatcher rd = request.getRequestDispatcher("/usuarioClienteSesion.jsp");
//        rd.forward(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
