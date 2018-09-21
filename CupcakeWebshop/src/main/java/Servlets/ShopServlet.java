/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caspe
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

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
            String bot = request.getParameter("bottom");
            String top = request.getParameter("topping");
            int qty = Integer.parseInt(request.getParameter("qty"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + bot+ top + qty + "</h1>"
            );
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
        processRequest(request, response);
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

        doGet(request, response);
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

    public String html() {
        String html = "<html>\n"
                + "    <head>\n"
                + "        <title>Cookie Clicker Bakeshop</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <img src=\"ccbs.png\" alt=\"\" width=\"500\" height=\"500\"/>\n"
                + "\n"
                + "\n"
                + "\n"
                + "        <form action=\"Control\" method=\"POST\">\n"
                + "            <input type=\"text\" name=\"amount\" placeholder=\"Enter amount\"/>\n"
                + "            <input type=\"hidden\" name=\"origin\" value=\"addmoney\" />\n"
                + "            <input type=\"submit\" value=\"Add money to account\" formaction=\"/updateBalance\">\n"
                + "        </form>\n"
                + "        <form action=\"Control\" method=\"POST\">\n"
                + "            <form id=\"addProduct\" action=\"Control\" method=\"POST\">\n"
                + "                <input type=\"hidden\" name=\"origin\" value=\"addProduct\">\n"
                + "                <table class=\"table table-striped\">\n"
                + "                    <thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th>Select</th><th></th></tr></thead>\n"
                + "                    <tbody>\n"
                + "                        <tr>\n"
                + "                            <td><select name=\"bottom\" id=\"bottomSelect\">\n"
                + "                                    <option value=\"0\">Choose bottom</option>\n"
                + "\n"
                + "                                    <option value=\"1\">Chocolate: 5.0</option><option value=\"2\">Vanilla: 5.0</option><option value=\"3\">Nutmeg: 5.0</option><option value=\"4\">Pistacio: 6.0</option><option value=\"5\">Almond: 7.0</option>\n"
                + "\n"
                + "                                </select></td>\n"
                + "                            <td><select name=\"topping\" id=\"toppingSelect\">\n"
                + "                                    <option value=\"0\">Choose topping</option>\n"
                + "\n"
                + "\n"
                + "                                    <option value=\"1\">Chocolate: 5.0</option><option value=\"2\">Blueberry: 5.0</option><option value=\"3\">Raspberry: 5.0</option><option value=\"4\">Crispy: 6.0</option><option value=\"5\">Strawberry: 6.0</option><option value=\"6\">Rum/Raisin: 7.0</option><option value=\"7\">Orange: 8.0</option><option value=\"8\">Lemon: 8.0</option><option value=\"9\">Blue cheese: 9.0</option>\n"
                + "                                </select></td>\n"
                + "                            <td><input type=\"text\" name=\"qty\" placeholder=\"quantity\" id=\"qtyInput\"></td>\n"
                + "                            <td><input type=\"submit\" name=\"submit\" value=\"Add to cart\"></td><td><span id=\"errorContainer\"></span></td>\n"
                + "                        </tr>\n"
                + "                    </tbody>\n"
                + "                </table>\n"
                + "            </form>\n"
                + "\n"
                + "    </body>\n"
                + "</html>";
        return html;
    }

}
