/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.MaterialCategourt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        MaterialCategourtJpaController materialCategourtJpaController = new MaterialCategourtJpaController(emf);
        String operation = request.getParameter("operation");
        if (operation != null && !operation.isEmpty()) {
            if (operation.equalsIgnoreCase("addCategory")) {
                String categoryDescription = request.getParameter("material_desc");
                MaterialCategourt category = new MaterialCategourt();
                category.setMaterialCategouryDesc(categoryDescription);
                materialCategourtJpaController.create(category);
                response.sendRedirect("materialcat.jsp");

            } else if (operation.equalsIgnoreCase("editCategory")) {
                try {
                    String categoryId = request.getParameter("edit_material_id");
                    String categoryDescription = request.getParameter("editevalue");
                    MaterialCategourt category = new MaterialCategourt(new Integer(categoryId.trim()));
                    category.setMaterialCategouryDesc(categoryDescription);
                    materialCategourtJpaController.edit(category);
                    response.sendRedirect("materialcat.jsp");
                } catch (Exception ex) {
                    Logger.getLogger(materialcategoury.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (operation.equalsIgnoreCase("deleteCategory")) {
                try {
                    String categoryId = request.getParameter("deletionId");
                    System.out.println("DELETIONID: "+categoryId);
                    materialCategourtJpaController.destroy(new Integer(categoryId.trim()));
                    response.sendRedirect("materialcat.jsp");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.sendRedirect("materialcat.jsp");
        }
//        PrintWriter out = response.getWriter();
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory(cons.entityName);
//            em = emf.createEntityManager();
//            MaterialCategourtJpaController controller=new MaterialCategourtJpaController(emf);
//
//            if (request.getParameter("save") != null) {
//                em.getTransaction().begin();
//                GenerMaterialsJpaController mc=new GenerMaterialsJpaController(emf);
//                mc.(request.getParameter("material_desc").trim());
//                controller.create(mc);
//                em.getTransaction().commit();
//                response.sendRedirect("materialcat.jsp");
//            }else if(request.getParameter("update")!=null) {               
//                em.getTransaction().begin();
//                MaterialCategourt mc=new MaterialCategourt();
//                mc=controller.findMaterialCategourt(new Integer(request.getParameter("edit_material_id").trim()));
//                mc.setMaterialCategouryDesc(request.getParameter("editevalue").trim());
//                controller.edit(mc);
//                em.getTransaction().commit();
//                response.sendRedirect("materialcat.jsp");
//            }else if(request.getParameter("del_material")!=null) {
//                if (request.getParameter("id_value_del").trim()!=null) {
//                em.getTransaction().begin();
//                controller.destroy(new Integer(request.getParameter("id_value_del").trim()));
//                em.getTransaction().commit();
//                response.sendRedirect("materialcat.jsp");
//                }
//            }
//          
////            request.setAttribute("generlist",findGenerEntities);
////            request.getRequestDispatcher("/gener.jsp").forward(request, response);
//
//        } catch (Exception ex) {
//            Logger.getLogger(MaterialCategourt.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            out.close();
//            em.close();
//            emf.close();
//
//        }
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
