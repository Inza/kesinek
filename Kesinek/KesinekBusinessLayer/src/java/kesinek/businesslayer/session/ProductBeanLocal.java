/*
 * This file describes ProductItem management session bean local interface.
 *
 * @author Tomáš Jukin
 */
package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Local;
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
@Local
public interface ProductBeanLocal {

    void addProduct(ProductItem product);

    void removeProduct(ProductItem product);

    void assignProductToCategory(ProductItem product, Category category);

    void removeProductFromCategory(ProductItem product, Category category);

    void setProductAttribute(ProductAttribute attribute, ProductItem product);

    void addWarehouse(Warehouse warehouse);

    void removeWarehouse(Warehouse warehouse);

    void addManufacturer(Manufacturer manufacturer);

    void removeManufacturer(Manufacturer manufacturer);

    public List<Manufacturer> findAllManufacturer();

    public List<ProductItem> findProductsByCategory(Category category);

    public List<ProductItem> findProductsByName(String name);

    public List<ProductItem> findAllProducts();

    public Manufacturer findManufacturerByID(int id);

    public Warehouse findWarehouseByID(int id);

    public void updateManufacturer(Manufacturer manufacturer);
}
