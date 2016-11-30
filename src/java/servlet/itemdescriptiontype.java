/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dto.ItemDescriptionTypeWrapper;
import jpa.GenerJpaController;
import jpa.ItemDescriptionTypeJpaController;
import jpa.MaterialTypeJpaController;
import entity.Gener;
import entity.ItemDescriptionType;
import entity.MaterialCategourt;
import entity.MaterialType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.MaterialCategourtJpaController;
import model.cons;

/**
 *
 * @author ramy
 */
public class itemdescriptiontype extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            ItemDescriptionTypeJpaController controller = new ItemDescriptionTypeJpaController(emf);

            if (request.getParameter("save") != null) {
                em.getTransaction().begin();
                ItemDescriptionType idt = new ItemDescriptionType();
                idt.setMaterialCategoryId(new Integer(request.getParameter("material_desc").trim()));
                idt.setMaterialTypeId(new Integer(request.getParameter("material_desc").trim()));
                controller.create(idt);
                em.getTransaction().commit();
                response.sendRedirect("itemdesctype.jsp");
            } else if (request.getParameter("update") != null) {
                em.getTransaction().begin();
                ItemDescriptionType idt = new ItemDescriptionType();
                idt = controller.findItemDescriptionType(new Integer(request.getParameter("edit_material_id").trim()));
                idt.setMaterialCategoryId(new Integer(request.getParameter("material_desc").trim()));
                idt.setMaterialTypeId(new Integer(request.getParameter("material_desc").trim()));
                controller.edit(idt);
                em.getTransaction().commit();
                response.sendRedirect("itemdesctype.jsp");
            } else if (request.getParameter("del_material") != null) {
                if (request.getParameter("id_value_del").trim() != null) {
                    em.getTransaction().begin();
                    controller.destroy(new Integer(request.getParameter("id_value_del").trim()));
                    em.getTransaction().commit();
                    response.sendRedirect("itemdesctype.jsp");
                }
            }

//            request.setAttribute("generlist",findGenerEntities);
//            request.getRequestDispatcher("/gener.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ItemDescriptionType.class.getName()).log(Level.SEVERE, null, ex);
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
        showDropDownLists(request, response);
        showAllDataTable(request, response);
        request.getRequestDispatcher("itemdesctype.jsp").forward(request, response);
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

    private void showDropDownLists(HttpServletRequest request, HttpServletResponse response) {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            MaterialCategourtJpaController materialController = new MaterialCategourtJpaController(emf);
            List<MaterialCategourt> cats = materialController.getAllMaterials();
            List<MaterialType> materials = new MaterialTypeJpaController(emf).getAllMaterials();
            request.setAttribute("cats", cats);
            request.setAttribute("materials", materials);

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

    private void showAllDataTable(HttpServletRequest request, HttpServletResponse response) {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            ItemDescriptionTypeJpaController itemCtl = new ItemDescriptionTypeJpaController(emf);
            List<ItemDescriptionTypeWrapper> itemWrappers = itemCtl.getAllData();
            request.setAttribute("itemsWrappers", itemWrappers);

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
