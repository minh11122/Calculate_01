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
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 *
 * @author letua
 */
@WebServlet(urlPatterns={"/index"})
public class index extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet index</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet index at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String length_raw = request.getParameter("length");
        String width_raw = request.getParameter("width");
        //String Area_raw = request.getParameter("Area");
        //String Perimeter_raw = request.getParameter("Perimeter");
        String[] d = request.getParameterValues("d");
        PrintWriter out = response.getWriter();
        String ms = "";
        double a,b;
        try {
            a = Double.parseDouble(length_raw);
            b = Double.parseDouble(width_raw);
            if(d==null){
                ms="You have not selected yet !";
            } else if(d.length==2){
                ms="Perimeter : " +(a+b)*2 +"Area : " +(a*b);
            } else if(d[0].equals("0")){
                ms="Perimeter : " +(a+b)*2;
            } else {
                ms="Area : " +(a*b);
            }
            out.print(ms);
            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
