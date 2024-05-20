/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
import java.util.logging.Level;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author letua
 */
@WebServlet(urlPatterns = {"/newhtml"})
public class NewHtml extends HttpServlet {

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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet newhtml</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newhtml at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("newhtml.html").forward(request, response);
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
        String number1_raw = request.getParameter("number1");
        String number2_raw = request.getParameter("number2");
        String op_raw = request.getParameter("op");
        double n1, n2;
        
        PrintWriter out = response.getWriter();
        try {
            n1 = Double.parseDouble(number1_raw);
            n2 = Double.parseDouble(number2_raw);
            out.print("<h1>" + math(n1, n2, op_raw) + "<h1>");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Number format exception occurred", e);
        }
    }

    private static final Logger LOGGER = Logger.getLogger(NewHtml.class.getName());

    private String math(double a, double b, String op) {
        String ms = "";
        switch (op) {
            case "+":
                ms = "Add : " + (a + b);
                break;
            case "-":
                ms = "Dev : " + (a - b);
                break;
            default:
                ms = "Invalid operation";
                break;
        }
        return ms;
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
