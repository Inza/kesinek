/*
 * This file describes PurchaseOrder management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Stateless;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.PurchaseOrder;

/**
 * Handles BL for PurchaseOrder and ProductItem entity classes
 *
 * This bean will perform basic I/O operations with purchase orders (EC PurchaseOrder) in the system
 *
 * Also products (EC ProductItem) could be added to them or removed from them through this bean.
 *
 * @author Tomáš Jukin
 */
@Stateless
public class PurchaseOrderBean implements PurchaseOrderBeanLocal {

    /**
     * Performs basic CUD operations with purchase orders
     * 
     * For create operation a new PurchaseOrder instance with all required fields should be passes
     * For update operation only fields which required to be changed shoul be set in passed PurchaseOrder instance
     * For delete operation only PurchaseOrder's id should be filled
     * 
     * @param order
     */
    public void savePurchaseOrder(PurchaseOrder order) {
    }

    public void addProductToPurchaseOrder(ProductItem product, PurchaseOrder order) {
    }

    public Collection<PurchaseOrder> getAllPurchaseOrders() {
        return null;
    }
 
}
