/*
 * This file describes ProductItem management session bean class.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.CategoryAttribute;
import kesinek.businesslayer.entities.IsInCategory;
import kesinek.businesslayer.entities.Manufacturer;
import kesinek.businesslayer.entities.ProductAttribute;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.Warehouse;

@Stateless
public class ProductBean implements ProductBeanLocal {

    @PersistenceContext
    EntityManager em;

    public void assignProductToCategory(ProductItem product, Category category) {
        IsInCategory relation = new IsInCategory();
        relation.setCategoryID(category);
        relation.setProductItemID(product);
        em.persist(relation);
    }

    public void removeProductFromCategory(ProductItem product, Category category) {
        IsInCategory relation = new IsInCategory();
        relation.setCategoryID(category);
        relation.setProductItemID(product);
        relation = em.merge(relation);
        em.remove(relation);
    }

    public void setProductAttribute(ProductAttribute attribute, ProductItem product) {
        attribute.setProductItemID(product.getProductItemID());
        em.persist(attribute);
    }

    public void addWarehouse(Warehouse warehouse) {
        em.persist(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouse = em.merge(warehouse);
        em.remove(warehouse);
    }

    public void addManufacturer(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public void removeManufacturer(Manufacturer manufacturer) {
        manufacturer = em.merge(manufacturer);
        em.remove(manufacturer);
    }

    @SuppressWarnings("unchecked")
    public List<Manufacturer> findAllManufacturer() {
        return em.createNamedQuery("Manufacturer.findAll").getResultList();
    }

    public Manufacturer findManufacturerByID(int id) {
        return em.getReference(Manufacturer.class, id);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        em.createNamedQuery("Manufacturer.update")
                .setParameter("name", manufacturer.getName())
                .setParameter("manufacturerID", manufacturer.getManufacturerID())
        .executeUpdate();
        em.merge(manufacturer);
    }

    public void addProduct(ProductItem product) {
        em.persist(product);
    }

    public void removeProduct(ProductItem product) {
        product = em.merge(product);
        em.remove(product);
    }

    @SuppressWarnings("unchecked")
    public List<ProductItem> findProductsByCategory(Category category) {
        return em.createNamedQuery("ProductItem.findByCategory")
                .setParameter("categoryID", category.getCategoryID())
        .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<ProductItem> findProductsByName(String name) {
        return em.createNamedQuery("ProductItem.findAllByName")
                .setParameter("name", "%" + name + "%")
        .getResultList();
    }

    public Warehouse findWarehouseByID(int id) {
        return em.getReference(Warehouse.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ProductItem> findAllProducts() {
        return em.createNamedQuery("ProductItem.findAll").getResultList();
    }

    public ProductItem findProductByID(int id) {
        return em.getReference(ProductItem.class, id);
    }

    public ProductItem findProductByName(String name) {
        return (ProductItem) em.createNamedQuery("ProductItem.findByName")
                .setParameter("name", name)
        .getSingleResult();
    }

    public void updateWarehouse(Warehouse warehouse) {
        em.createNamedQuery("Warehouse.update")
                .setParameter("description", warehouse.getDescription())
                .setParameter("warehouseID", warehouse.getWarehouseID())
        .executeUpdate();
        em.merge(warehouse);
    }

    @SuppressWarnings("unchecked")
    public List<Warehouse> findAllWarehouses() {
        return em.createNamedQuery("Warehouse.findAll").getResultList();
    }

    public List<ProductAttribute> productDetail(ProductItem product) {
        @SuppressWarnings("unchecked")
        ArrayList<Category> categories = (ArrayList<Category>) em.createNamedQuery("ProductItem.findCategories").setParameter("productItemID", product).getResultList();

        ArrayList<CategoryAttribute> attrs = new ArrayList<CategoryAttribute>();

        for(Category c : categories) {
            attrs.addAll(c.getCategoryAttributeCollection());
        }

        ArrayList<ProductAttribute> candidates = new ArrayList<ProductAttribute>();

        for(CategoryAttribute a : attrs) {
            candidates.add((ProductAttribute) new CategoryBean().findAllProductAttributes(a.getCategoryAttributeID()));
        }

        ArrayList<ProductAttribute> result = new ArrayList<ProductAttribute>();

        for(ProductAttribute pr : candidates) {
            if(pr.getProductItemID() == product.getProductItemID()) {
                result.add(pr);
            }
        }

        return result;
    }
 
}
