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

    /**
     * Will add desired product to the system
     *
     * @param product
     */
    public void addProduct(ProductItem product);

    /**
     * Will remove desired product from the system
     *
     * @param product
     */
    public void removeProduct(ProductItem product);

    /**
     * Will add desired product to desired category
     *
     * @param product
     * @param category
     */
    public void assignProductToCategory(ProductItem product, Category category);

    /**
     * Will remove desired product from the desired category
     *
     * @param product
     * @param category
     */
    public void removeProductFromCategory(ProductItem product, Category category);

    /**
     * Will set desired product attribute to desired product
     *
     * @param attribute
     * @param product
     */
    public void setProductAttribute(ProductAttribute attribute, ProductItem product);

    /**
     * Will add desired warehouse to the system
     *
     * @param warehouse 
     */
    public void addWarehouse(Warehouse warehouse);

    /**
     * Will remove desired warehouse from the system
     *
     * @param warehouse 
     */
    public void removeWarehouse(Warehouse warehouse);

    /**
     * Will add desired manufacturer to the system
     *
     * @param manufacturer 
     */
    public void addManufacturer(Manufacturer manufacturer);

    /**
     * Will remove desired manufacturer to the system
     *
     * @param manufacturer 
     */
    public void removeManufacturer(Manufacturer manufacturer);

    /**
     * Will find all manufacturers in the system
     *
     * @return List<Manufacturer>
     */
    public List<Manufacturer> findAllManufacturer();

    /**
     * Will find all products in the system by category
     *
     * @param category
     * @return List<ProductItem>
     */
    public List<ProductItem> findProductsByCategory(Category category);

    /**
     * Will find all products in the system by name
     *
     * @param name
     * @return List<ProductItem>
     */
    public List<ProductItem> findProductsByName(String name);

    /**
     * Will find one product in the system by name
     *
     * @param name
     * @return ProductItem
     */
    public ProductItem findProductByName(String name);

    /**
     * Will find all products in the system
     *
     * @return List<ProductItem>
     */
    public List<ProductItem> findAllProducts();

    /**
     * Will find a manufacturer in the system by id
     *
     * @param id 
     * @return Manufacturer
     */
    public Manufacturer findManufacturerByID(int id);

    /**
     * Will find a warehouse in the system by id
     *
     * @param id
     * @return Warehouse
     */
    public Warehouse findWarehouseByID(int id);

    /**
     * Will find a product in the system by id
     *
     * @param id
     * @return ProductItem
     */
    public ProductItem findProductByID(int id);

    /**
     * Will update a manufacturer in the system
     *
     * @param manufacturer
     */
    public void updateManufacturer(Manufacturer manufacturer);

    /**
     * Will update a warehouse in the system
     *
     * @param warehouse
     */
    public void updateWarehouse(Warehouse warehouse);

    /**
     * Will find all warehouses in the system
     *
     * @return List<Warehouse>
     */
    public List<Warehouse> findAllWarehouses();

    /**
     * Will find all attributes of product detail
     *
     * @param product 
     * @return List<ProductAttribute>
     */
    public List<ProductAttribute> productDetail(ProductItem product);
}
