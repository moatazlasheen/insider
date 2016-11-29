/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import entity.MaterialCategourt;
import entity.MaterialType;
import inquiry.getUnit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.MaterialTypeJpaController;
import model.cons;

/**
 *
 * @author abdelmoa
 */
public class Class1 {
    public static void main ( String []a){
       materialTypeExistsTest("BRICK WORK");
    }
    static void materialTypeExistsTest ( String desc) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        MaterialTypeJpaController controller = new MaterialTypeJpaController(emf);
        boolean b = controller.materialTypeExists(desc);
        System.err.println("b : " + b);
    }
    static void loadSpecifcMaterialtypeCategory( String desc ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        EntityManager  em = emf.createEntityManager();
        MaterialCategourt a = (MaterialCategourt) em.createQuery("SELECT m FROM MaterialCategourt m WHERE m.materialCategouryDesc = :materialCategouryDesc").setParameter("materialCategouryDesc", desc).getSingleResult();
        System.err.println(a.getMaterailCategouryId());
    }
    public static void loadAllMatCattest(){
        getUnit getUnit1 = new getUnit();
        List<MaterialCategourt> list1 = getUnit1.getMaterialCat();
        for ( MaterialCategourt matCat : list1 ) {
            System.out.println(matCat.getMaterialCategouryDesc());
        }
    }
    
    public static void testloadCatFromMatType(){
        getUnit getUnit1 = new getUnit();
        List<MaterialType> list1 = getUnit1.getmaterialType();
        for ( MaterialType matType : list1 ) {
            if ( matType.getMaterialTypeId() == 2 ) {
                System.out.println(matType.getMaterialCategory().getMaterialCategouryDesc());
            }
        }
    }
}
