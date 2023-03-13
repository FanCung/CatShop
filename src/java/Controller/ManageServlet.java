/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Model.Account;
import Model.Cat;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;


/**
 *
 * @author anh
 */
@MultipartConfig()
public class ManageServlet extends HttpServlet {

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
        DAO dao = new DAO();
        int price = 0, yob = 0, cateID = 0, gender_int;
        boolean gender;
        String error = "";
        LocalDate dt = LocalDate.now();
        int year = dt.getYear();
        String catName = request.getParameter("catName");
        String yob_raw = request.getParameter("yob");
        String gender_raw = request.getParameter("gender");
        PrintWriter out = response.getWriter();
        String description = request.getParameter("description");
        String price_raw = request.getParameter("price");
        String cateID_raw = request.getParameter("cateID");
        gender_int = Integer.parseInt(gender_raw);
        String file;
        Part filePart = request.getPart("userFile");
        String realPath = request.getServletContext().getRealPath("/images");
        String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Paths.get(realPath))) {
            Files.createDirectory(Paths.get(realPath));
        }
        filePart.write(realPath + "/" + filename);

        gender = gender_int != 0;

        if (catName == null || yob_raw == null  || filename == null|| price_raw == null) {
            error = "Cat's information can not be empty";
        }
        try {
            price = Integer.parseInt(price_raw);
            yob = Integer.parseInt(yob_raw);
            cateID = Integer.parseInt(cateID_raw);
            if (yob > year || year - yob >= 15) {
                throw new Exception();
            }
        } catch (Exception e) {
            error = "Invalid number or age too old!";
        }

        if (error.isEmpty()) {
            file ="images/" + filename;
            Cat hippy = new Cat(catName, yob, gender, file, description, price, cateID, true);
            dao.addCat(hippy);
            HttpSession session = request.getSession();
            Account a = (Account) request.getSession().getAttribute("account");
            session.setAttribute("account", a);
            request.getRequestDispatcher("home").forward(request, response);
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("manage.jsp").forward(request, response);
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
