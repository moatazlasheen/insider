/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.ItemDescription;
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
import jpa.ItemDescriptionJpaController;
import model.cons;

/**
 *
 * @author ramy
 */
public class itemdescription extends HttpServlet {

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
            ItemDescriptionJpaController controller=new ItemDescriptionJpaController(emf);

            if (request.getParameter("save") != null) {
                em.getTransaction().begin();
                ItemDescription id=new ItemDescription();
                
                id.setItemCode(new Integer(request.getParameter("item_code")));
                id.setItemDesc(request.getParameter("item_desc"));
                id.setItemTypeId(new Integer(request.getParameter("item_type_id")));
                id.setUnitId(new Integer(request.getParameter("unit_id")));
                id.setGenerId(new Integer(request.getParameter("gener_id")));
                id.setUpload(request.getParameter("file").getBytes());
                
                controller.create(id);
                em.getTransaction().commit();
                response.sendRedirect("itemdesc.jsp");
            }else if(request.getParameter("update")!=null) {               
                em.getTransaction().begin();
                ItemDescription id=new ItemDescription();
                id=controller.findItemDescription(new Integer(request.getParameter("edit_material_id").trim()));
                
                id.setItemCode(new Integer(request.getParameter("item_code")));
                id.setItemDesc(request.getParameter("item_desc"));
                id.setItemTypeId(new Integer(request.getParameter("item_type_id")));
                id.setUnitId(new Integer(request.getParameter("unit_id")));
                id.setGenerId(new Integer(request.getParameter("gener_id")));
                id.setUpload(request.getParameter("file").getBytes());
                
                controller.edit(id);
                em.getTransaction().commit();
                response.sendRedirect("itemdesc.jsp");
            }else if(request.getParameter("del_item")!=null) {
                if (request.getParameter("id_value_del").trim()!=null) {
                em.getTransaction().begin();
                controller.destroy(new Integer(request.getParameter("id_value_del").trim()));
                em.getTransaction().commit();
                response.sendRedirect("itemdesc.jsp");
                }
            }
          
//            request.setAttribute("generlist",findGenerEntities);
//            request.getRequestDispatcher("/gener.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(itemdescription.class.getName()).log(Level.SEVERE, null, ex);
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
