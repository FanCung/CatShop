/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author anh
 */
public class UpdateAccountServlet extends HttpServlet {

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
        DAO dao = new DAO();
        String error = "";
        List<Account> acc, acc2;
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String address = request.getParameter("address");
        Account account = (Account) request.getSession().getAttribute("account");
        if (!phone.matches("[0-9]{10}")) {
            error = "Invalid phone number!";
        }
        acc = dao.getAllUser();
        
        if (address == null || question == null || answer == null) {
            error = "Input can not be empty!";
        }
        for(Account a: acc){
            if(a.getPhone().equals(phone)){
                error="Phone number already in use!";
            }
        }
        if(phone.equals(account.getPhone())){
            error="";
        }
        if (error.isEmpty()) {
            dao.update(account.getAccID(), name, phone, question, answer, address);
            HttpSession session = request.getSession();
            acc2=dao.getAllUser();
            for(Account ac: acc2){
                if(ac.getAccID()==account.getAccID()){
                    session.setAttribute("account", ac);
                }
            }
            
            request.getRequestDispatcher("home").forward(request, response);
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
