/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


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
import dump.jpa.MaterialCategourtJpaController;
import model.cons;

/**
 *
 * @author ramy
 */
public class materialcategoury extends HttpServlet {

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
            MaterialCategourtJpaController controller=new MaterialCategourtJpaController(emf);

            if (request.getParameter("save") != null) {
                em.getTransaction().begin();
                MaterialCategourt mc=new MaterialCategourt();
                mc.setMaterialCategouryDesc(request.getParameter("material_desc").trim());
                controller.create(mc);
                em.getTransaction().commit();
                response.sendRedirect("materialcat.jsp");
            }else if(request.getParameter("update")!=null) {               
                em.getTransaction().begin();
                MaterialCategourt mc=new MaterialCategourt();
                mc=controller.findMaterialCategourt(new Integer(request.getParameter("edit_material_id").trim()));
                mc.setMaterialCategouryDesc(request.getParameter("editevalue").trim());
                controller.edit(mc);
                em.getTransaction().commit();
                response.sendRedirect("materialcat.jsp");
            }else if(request.getParameter("del_material")!=null) {
                if (request.getParameter("id_value_del").trim()!=null) {
                em.getTransaction().begin();
                controller.destroy(new Integer(request.getParameter("id_value_del").trim()));
                em.getTransaction().commit();
                response.sendRedirect("materialcat.jsp");
                }
            }
          
//            request.setAttribute("generlist",findGenerEntities);
//            request.getRequestDispatcher("/gener.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(MaterialCategourt.class.getName()).log(Level.SEVERE, null, ex);
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
