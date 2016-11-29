/*
 * Copyright (C) 2016 mrnull <ahmadmoawad3@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 */
package servlet;

import com.google.gson.Gson;
import entity.MaterialType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dump.jpa.MaterialCategourtJpaController;
import model.cons;

/**
 *
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@WebServlet(name = "materialajax", urlPatterns = {"/materialajax"})
public class materialajax extends HttpServlet {

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
        EntityManager em = null;
        EntityManagerFactory emf = null;

        String catStr = request.getParameter("catID");
        if (catStr == null) {
            response.getWriter().write("none");
        } else {
            try {

                Integer catID = Integer.parseInt(catStr);

                emf = Persistence.createEntityManagerFactory(cons.entityName);
                em = emf.createEntityManager();
                List<MaterialType> materials = new MaterialCategourtJpaController(emf).getAllMaterialsByCat(catID);
                Gson gson = new Gson();
                String json = gson.toJson(materials);
                System.out.println(json);
                response.getWriter().write(json);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                if (em != null) {
                    em.close();
                }
                if (emf != null) {
                    emf.close();
                }

            }
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
