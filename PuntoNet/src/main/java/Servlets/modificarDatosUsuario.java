/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorBD;
import Controlador.GestorProductos;
import Modelo.DTOUsuario;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import Modelo.Sexo;
import Modelo.TiposDoc;
import Modelo.Usuaio;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "modificarDatosUsuario", urlPatterns = {"/modificarDatosUsuario"})
public class modificarDatosUsuario extends HttpServlet {

    GestorBD gestor = new GestorBD();

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
        request.setAttribute("sexo", gestor.getObtenerComboSexo());
        request.setAttribute("documento", gestor.getObtenerComboDocumento());
        request.getSession().getAttribute("modeloCliente");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/misDatos.jsp");
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

        request.setAttribute("sexo", gestor.getObtenerComboSexo());
        request.setAttribute("documento", gestor.getObtenerComboDocumento());
        request.getSession().getAttribute("modeloCliente");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/misDatos.jsp");
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

        GestorBD gestor = new GestorBD();

        int id = Integer.parseInt(request.getParameter("txtIdUsuario"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int idSexo = Integer.parseInt(request.getParameter("cboSexo"));
        Sexo s = new Sexo(idSexo, "");
        int idTipoDoc = Integer.parseInt(request.getParameter("cboDoc"));
        TiposDoc d = new TiposDoc(idTipoDoc, "");
        int documento = Integer.parseInt(request.getParameter("txtDocumento"));
        String telefono = request.getParameter("txtTelefono");
        String direccion = request.getParameter("txtDireccion");
        String localidad = request.getParameter("txtLocalidad");
        String login = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtContra");

        Usuaio u = new Usuaio(id, nombre, apellido, s, d, documento, telefono, direccion, localidad, login, contraseña);
        gestor.modificarUsuario(u);
        u = gestor.obtenerCliente(u.getIdUsuario());
        request.getSession().setAttribute("modeloCliente", u);
        request.setAttribute("sexo", gestor.getObtenerComboSexo());
        request.setAttribute("documento", gestor.getObtenerComboDocumento());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/misDatos.jsp");
        rd.forward(request, response);

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
