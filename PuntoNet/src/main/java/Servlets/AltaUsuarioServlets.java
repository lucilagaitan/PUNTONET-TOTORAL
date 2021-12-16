/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorBD;
import Modelo.Sexo;
import Modelo.TiposDoc;
import Modelo.Usuaio;
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
@WebServlet(name = "AltaUsuarioServlets", urlPatterns = {"/AltaUsuarioServlets"})
public class AltaUsuarioServlets extends HttpServlet {

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
            out.println("<title>Servlet AltaUsuarioServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaUsuarioServlets at " + request.getContextPath() + "</h1>");
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
        GestorBD gestor = new GestorBD();
  
        request.setAttribute("listaSexo", gestor.getObtenerComboSexo()); 
        request.setAttribute("listaDoc", gestor.getObtenerComboDocumento()); 
        RequestDispatcher rd = request.getRequestDispatcher("/altaUsuario.jsp");
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
        
        GestorBD gestor =new GestorBD();
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int idSexo =Integer.parseInt(request.getParameter("cboSexo"));
        Sexo s = new Sexo(idSexo, "");
        int idTipoDoc =Integer.parseInt(request.getParameter("cboDoc"));
        TiposDoc d = new TiposDoc (idTipoDoc, "");
        int documento =Integer.parseInt(request.getParameter("txtDocumento"));
        String telefono =request.getParameter("txtTelefono");
        String direccion = request.getParameter("txtDireccion");
        String localidad = request.getParameter("txtLocalidad");
        String login = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtContra");

        
        Usuaio u = new Usuaio(apellido, nombre, s, d, documento, telefono, direccion, localidad, login, contraseña);
                    
           
        gestor.agregarUsuario(u);        
        request.setAttribute("registroExitoso", "RegistroExitoso");
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
