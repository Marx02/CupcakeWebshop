/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConnector.DataMapper;
import DBConnector.User;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import javax.servlet.RequestDispatcher;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpSession;

/**
 * This servlet handles getting the parameters from index.jsp and processing them with the DataMapper.
 *  The User object is stored in the session for the first time here  
 * 
 * @author casper
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            DataMapper dm = new DataMapper();
            User currentUser = dm.getUserInfo(user, pass);
            dm.getBalance(currentUser);
            out.println(currentUser.getuName());
            out.println(currentUser.getBalance());
            if (currentUser.isLoggedIn()) {
                session.setAttribute("user", currentUser);
                request.getRequestDispatcher("ShopServlet").forward(request, response);
            }
            if (!currentUser.isLoggedIn()) {
                response.sendRedirect(request.getContextPath());
            }
        }
    }

//ÆNDRING
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
      //  processRequest(request, response);
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
        processRequest(request, response);
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
