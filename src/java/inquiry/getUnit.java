/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

import entity.Gener;
import entity.ItemDescription;
import entity.ItemDescriptionType;
import entity.MaterialType;
import entity.Units;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.GenerJpaController;
import jpa.ItemDescriptionJpaController;
import jpa.ItemDescriptionTypeJpaController;
import jpa.MaterialTypeJpaController;
import jpa.UnitsJpaController;
import model.cons;

/**
 *
 * @author ramy
 */
public class getUnit {

    public List<Units> getunits() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        UnitsJpaController controller = new UnitsJpaController(emf);
        List<Units> findUnitsEntities = controller.findUnitsEntities();
        return findUnitsEntities;
    }

    public List<Gener> getgener() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        GenerJpaController controller = new GenerJpaController(emf);
        List<Gener> findGenerEntities = controller.findGenerEntities();
        return findGenerEntities;
    }

    public List<MaterialType> getmaterialType() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        MaterialTypeJpaController controller = new MaterialTypeJpaController(emf);
        List<MaterialType> findUnitsEntities = controller.findMaterialTypeEntities();
        return findUnitsEntities;
    }

    public List<ItemDescriptionType> getItemDescType() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        ItemDescriptionTypeJpaController controller = new ItemDescriptionTypeJpaController(emf);
        List<ItemDescriptionType> findUnitsEntities = controller.findItemDescriptionTypeEntities();
        return findUnitsEntities;
    }

    public List<ItemDescription> getItemDesc() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
        ItemDescriptionJpaController controller = new ItemDescriptionJpaController(emf);
        List<ItemDescription> findUnitsEntities = controller.findItemDescriptionEntities();
        return findUnitsEntities;
    }
    
   

}
