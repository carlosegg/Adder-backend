/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwaresano.examples.calculator.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author carlosg
 */
public final class Calculator extends HttpServlet {

    private com.softwaresano.examples.calculator.Calculator component = new com.softwaresano.examples.calculator.impl.Calculator();
    private static final  Log LOG = LogFactory.getLog(Calculator.class);

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
        final PrintWriter out = response.getWriter();
        try {
            final String firstOperand = request.getParameter("firstOperand").trim();
            final String secondOperand = request.getParameter("secondOperand").trim();
            if (LOG.isDebugEnabled()){
                LOG.debug(MessageFormat.format("Calculando la suma de [{0}] + [{1}]", new Object[]{firstOperand,secondOperand}));
            }
            String result = null;
            try {
                result = component.add(firstOperand, secondOperand);
            } catch (IllegalArgumentException illegalException) {
                if (LOG.isErrorEnabled()){
                    LOG.error(MessageFormat.format("[{0}]",new Object[]{illegalException.getLocalizedMessage()}));
                }
                result = illegalException.getMessage();
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sumadora Web</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sumadora Web</h1>");
            out.println("<h2 id=\"result\">" + result + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
