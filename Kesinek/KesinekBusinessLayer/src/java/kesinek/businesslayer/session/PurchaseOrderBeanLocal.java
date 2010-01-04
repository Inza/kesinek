/*
 * This file describes PurchaseOrder management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.PurchaseOrder;

/**
 * Handles BL for PurchaseOrder and ProductItem entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface PurchaseOrderBeanLocal {

    void savePurchaseOrder(PurchaseOrder order);

    void addProductToPurchaseOrder(ProductItem product, PurchaseOrder order);

    Collection<PurchaseOrder> getAllPurchaseOrders();
    
}
