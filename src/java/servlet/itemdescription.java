/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.ItemDescription;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
import dump.jpa.ItemDescriptionJpaController;
import model.cons;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // location to store file uploaded
        final String UPLOAD_DIRECTORY = "upload";
        // upload settings
        final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
        final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
        final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
        //----------------------------------------------------------------------
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {

            emf = Persistence.createEntityManagerFactory(cons.entityName);
            em = emf.createEntityManager();
            ItemDescriptionJpaController controller = new ItemDescriptionJpaController(emf);

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

            if (isMultipart) {
                String id = "";
                String code = "";
                String description = "";
                String itemType = "";
                String fileName = "";
                String unitId = "";
                String generId = "";

                //-------------------------------------------------------------------------------------------------------------------------------------
                // File upload
                try {
                    // Create a factory for disk-based file items
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    // Create a new file upload handler
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    upload.setFileSizeMax(MAX_FILE_SIZE);

                    // sets maximum size of request (include file + form data)
                    upload.setSizeMax(MAX_REQUEST_SIZE);

                    // constructs the directory path to store upload file
                    // this path is relative to application's directory
//                    String uploadPath = getServletContext().getRealPath("")
//                            + File.separator + UPLOAD_DIRECTORY;
                    String uploadPath = "F:\\insideUpload";
                    // creates the directory if it does not exist
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
                    // Parse the request
                    List<FileItem> items = upload.parseRequest(request);
                    Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) {
                        FileItem item = iter.next();
                        if (item.isFormField()) { //These are form fields
                            String fieldName = item.getFieldName();
                            String fieldValue = item.getString();
                            if (fieldName.equalsIgnoreCase("id")) {
                                id = request.getParameter("id");
                                System.out.println("id " + id);
                            } else if (fieldName.equalsIgnoreCase("code")) {
                                code = fieldValue;
                                System.out.println("code " + code);
                            } else if (fieldName.equalsIgnoreCase("description")) {
                                description = fieldValue;
                                System.out.println("description: " + description);
                            } else if (fieldName.equalsIgnoreCase("item_type")) {
                                itemType = fieldValue;
                                System.out.println("item_type: " + itemType);
                            } else if (fieldName.equalsIgnoreCase("unit_id")) {
                                unitId = fieldValue;
                                System.out.println("unit_id: " + itemType);
                            }
                            if (fieldName.equalsIgnoreCase("gener_id")) {
                                generId = fieldValue;
                                System.out.println("Genre: " + generId);
                            }
                        } else // This is a file
                        {
                            fileName = item.getName();

                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);

                            // saves the file on disk
                            item.write(storeFile);
                            request.setAttribute("message", "Upload has been done successfully!");
                            out.println("File Name: " + fileName);
                        }

                    }
                    // add the item to the database
                    em.getTransaction().begin();
                    ItemDescription itemDescription = new ItemDescription();

                    itemDescription.setItemCode(new Integer(code));
                    itemDescription.setItemDesc(description);
                    itemDescription.setItemTypeId(new Integer(itemType));
                    itemDescription.setUnitId(new Integer(unitId));
                    itemDescription.setGenerId(new Integer(generId));
//                    itemDescription.setUpload(request.getParameter("file").getBytes());
                    itemDescription.setUploadFileName(fileName);
                    controller.create(itemDescription);
                    em.getTransaction().commit();
                    response.sendRedirect("itemdesc.jsp");

                } catch (FileUploadException ex) {
                    Logger.getLogger(itemdescription.class.getName()).log(Level.SEVERE, null, ex);
                }
                //-------------------------------------------------------------------------------------------------------------------------------------

            } else if (request.getParameter("save") != null) {
                em.getTransaction().begin();
                ItemDescription id = new ItemDescription();

                id.setItemCode(new Integer(request.getParameter("item_code")));
                id.setItemDesc(request.getParameter("item_desc"));
                id.setItemTypeId(new Integer(request.getParameter("item_type_id")));
                id.setUnitId(new Integer(request.getParameter("unit_id")));
                id.setGenerId(new Integer(request.getParameter("gener_id")));
                id.setUpload(request.getParameter("file").getBytes());

                controller.create(id);
                em.getTransaction().commit();
                response.sendRedirect("itemdesc.jsp");
            } else if (request.getParameter("update") != null) {
                em.getTransaction().begin();
                ItemDescription id = new ItemDescription();
                id = controller.findItemDescription(new Integer(request.getParameter("edit_material_id").trim()));

                id.setItemCode(new Integer(request.getParameter("item_code")));
                id.setItemDesc(request.getParameter("item_desc"));
                id.setItemTypeId(new Integer(request.getParameter("item_type_id")));
                id.setUnitId(new Integer(request.getParameter("unit_id")));
                id.setGenerId(new Integer(request.getParameter("gener_id")));
                id.setUpload(request.getParameter("file").getBytes());

                controller.edit(id);
                em.getTransaction().commit();
                response.sendRedirect("itemdesc.jsp");
            } else if (request.getParameter("del_item") != null) {
                if (request.getParameter("id_value_del").trim() != null) {
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
