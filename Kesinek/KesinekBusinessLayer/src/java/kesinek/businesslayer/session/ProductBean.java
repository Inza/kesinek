/*
 * This file describes ProductItem management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.Manufacturer;
import kesinek.businesslayer.entities.ProductAttribute;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.Warehouse;

/**
 * Handles BL for ProductItem, Category, ProductAttribute and Warehouse entity classes
 *
 * This bean will perform basic I/O operations with products (EC ProductItem), product's attributes (EC ProductAttribute) and warehouses (EC Warehouse) in the system
 *
 * One product could have many attributes, and could be stored in one storage. For simplicity purposes we do not have exemplars in the system.
 * Instead of them, we use product's amount attribute and EC Warehouse
 *
 * One product can be therefore stored only in one Warehouse. But this is for now desired behaviour
 *
 * @author Tomáš Jukin
 */
@Stateless
public class ProductBean implements ProductBeanLocal {

    @PersistenceContext
    EntityManager em;

    /**
     * Performs basic CUD operations with products
     * 
     * For create operation a new ProductItem instance with all required fields should be passes
     * For update operation only fields which required to be changed shoul be set in passed ProductItem instance
     * For delete operation only ProductItem's id should be filled
     * 
     * @param product
     */
    public void saveProduct(ProductItem product) {
    }

    public void assignProductToCategory(ProductItem product, Category category) {
    }

    public void removeProductFromCategory(ProductItem product, Category category) {
    }

    public void setProductAttribute(ProductAttribute attribute, ProductItem product) {
    }

    public void addWarehouse(Warehouse warehouse) {
    }

    public void removeWarehouse(Warehouse warehouse) {
    }

    public void addManufacturer(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public void removeManufacturer(Manufacturer manufacturer) {
        manufacturer = em.merge(manufacturer);
        em.remove(manufacturer);
    }

    public List<Manufacturer> findAllManufacturer() {
        return em.createNamedQuery("Manufacturer.findAll").getResultList();
    }

    public Manufacturer findManufacturerByID(int id) {
        return em.getReference(Manufacturer.class, id);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        em.createNativeQuery("UPDATE category SET name = '" + manufacturer.getName() + "' WHERE categoryID = " + manufacturer.getManufacturerID()).executeUpdate();
        em.merge(manufacturer);
    }

    
 
}
