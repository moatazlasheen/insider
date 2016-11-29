/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Units;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dump.jpa.UnitsJpaController;
import model.cons;

/**
 *
 * @author ramy
 */
public class unit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)     throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            UnitsJpaController controller = new UnitsJpaController(emf);

            if (request.getParameter("saveunit") != null) {
                em.getTransaction().begin();
                Units units = new Units();
                units.setUnitDesc(request.getParameter("unit1").trim());
                controller.create(units);
                em.getTransaction().commit();
                response.sendRedirect("unit.jsp");
            }else if(request.getParameter("update_unit")!=null) {                             
                em.getTransaction().begin();
                Units units=new Units();
                units=controller.findUnits(new Integer(request.getParameter("edit_unit_id").trim()));
                units.setUnitDesc(request.getParameter("editevalue").trim());
                controller.edit(units);
                em.getTransaction().commit();
                response.sendRedirect("unit.jsp");
            }else if(request.getParameter("del_unit")!=null) {
                if (request.getParameter("id_value_del").trim()!=null) {
                em.getTransaction().begin();
                controller.destroy(new Integer(request.getParameter("id_value_del").trim()));
                em.getTransaction().commit();
                response.sendRedirect("unit.jsp");
                }
            }
          
//            request.setAttribute("unitlist",findUnitsEntities);
//            request.getRequestDispatcher("/unit.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(unit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
            em.close();
            emf.close();

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
