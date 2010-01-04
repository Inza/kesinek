/*
 * This file describes ProductItem management session bean local interface.
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
 * @author Tomáš Jukin
 */
@Local
public interface ProductBeanLocal {

    void saveProduct(ProductItem product);

    void assignProductToCategory(ProductItem product, Category category);

    void removeProductFromCategory(ProductItem product, Category category);

    void setProductAttribute(ProductAttribute attribute, ProductItem product);

    void addWarehouse(Warehouse warehouse);

    void removeWarehouse(Warehouse warehouse);

    void addManufacturer(Manufacturer manufacturer);

    void removeManufacturer(Manufacturer manufacturer);

    public List<Manufacturer> findAllManufacturer();

    public Manufacturer findManufacturerByID(int id);

    public void updateManufacturer(Manufacturer manufacturer);
}
