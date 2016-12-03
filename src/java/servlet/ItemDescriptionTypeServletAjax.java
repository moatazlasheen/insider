package servlet;

import com.google.gson.Gson;
import entity.MaterialType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.ItemDescriptionTypeJpaController;
import jpa.MaterialCategourtJpaController;
import model.cons;

/**
 *
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@WebServlet(name = "itemdescriptionajax", urlPatterns = {"/itemdescriptionajax"})
public class ItemDescriptionTypeServletAjax extends HttpServlet {

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
        saveData(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteItems(req, resp);
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

    private void saveData(HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            
            String param = request.getParameter("elements");
            
            if (param == null) {
                
                response.getWriter().write("none");
                
                return;
            }
            int[][] elements = gson.fromJson(param, int[][].class);
            ItemDescriptionTypeJpaController itemCtl = new ItemDescriptionTypeJpaController(emf);
            int index = itemCtl.saveItems(elements);
            response.getWriter().write(gson.toJson(index));
        } catch (IOException ex) {
            Logger.getLogger(ItemDescriptionTypeServletAjax.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            
        }
        
    }
    
    private void deleteItems(HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            
            String param = request.getParameter("elements");
            
            if (param == null) {
                response.getWriter().write("none");
                return;
            }
            Integer[] elements = gson.fromJson(param, Integer[].class);
            ItemDescriptionTypeJpaController itemCtl = new ItemDescriptionTypeJpaController(emf);
            itemCtl.deleteItems(elements);
            response.getWriter().write("done");
        } catch (IOException ex) {
            Logger.getLogger(ItemDescriptionTypeServletAjax.class.getName()).log(Level.SEVERE, null, ex);
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
