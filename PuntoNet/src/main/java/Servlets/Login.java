/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorBD;
import Modelo.Usuaio;
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
 * @author desi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        String accion = request.getParameter("accion");

        if (accion.equals("Cerrar Sesion")) {

            request.getSession().removeAttribute("cliente");
            request.getSession().removeAttribute("admin");
            request.setAttribute("infoSesionCerradaCorrecto", "Info");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
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

        String usuario = request.getParameter("txtUsuario");
        String pass = request.getParameter("txtPass");

        Usuaio u = new Usuaio(0, usuario, pass);

        int r2 = gestor.validarInicioSesionCliente(u);

        if (!usuario.equals("") && !pass.equals("")) {
            u = gestor.getObtenerUsuario(usuario);
            if (usuario.equals("admin") && pass.equals("admin")) {
                request.getSession().setAttribute("admin", usuario);

                RequestDispatcher rd = request.getRequestDispatcher("menuAdmin.jsp");
                rd.forward(request, response);

            } 
            
            else if (r2 == 2) {
                u = gestor.obtenerCliente(u.getIdUsuario());
                request.getSession().setAttribute("modeloCliente", u);
                RequestDispatcher rd = request.getRequestDispatcher("/menuCliente.jsp");
                rd.forward(request, response);
            }

        } else {
            request.setAttribute("mensajeError", "Por favor, completar ambos campos para poder Loguearse");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        request.setAttribute("mensajeError", "Usuario y/o Contraseña incorrectos, verifique los datos ingresados");
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
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
